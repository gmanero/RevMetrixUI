package revMetrix.db.persist;

import java.io.IOException;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import revMetrix.db.persist.DBUtil;
import revMetrix.db.model.Account;
import revMetrix.db.model.Ball;
import revMetrix.db.model.Establishment;
import revMetrix.db.model.Event;
import revMetrix.db.model.Frame;
import revMetrix.db.model.Game;
import revMetrix.db.model.Session;
import revMetrix.db.model.Pair;
import revMetrix.db.model.Junction;
import revMetrix.db.model.Shot;

public class DerbyDatabase implements IDatabase {
	static {
		try {
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
		} catch (Exception e) {
			throw new IllegalStateException("Could not load Derby driver");
		}
	}
	
	private interface Transaction<ResultType> {
		public ResultType execute(Connection conn) throws SQLException;
	}

	private static final int MAX_ATTEMPTS = 10;
	
	
	public List<Account> findAllAccounts() {
		return executeTransaction(new Transaction<List<Account>>() {
			@Override
			public List<Account> execute(Connection conn) throws SQLException {
				PreparedStatement stmt = null;
				ResultSet resultSet = null;
				
				try {
					stmt = conn.prepareStatement(
							"select * from accounts " 
					);
					
					List<Account> result = new ArrayList<Account>();
					
					resultSet = stmt.executeQuery();
					
					// for testing that a result was returned
					Boolean found = false;
					
					while (resultSet.next()) {
						found = true;
						
						Account account = new Account();
						loadAccount(account, resultSet, 1);
						
						result.add(account);
					}
					
					// check if any authors were found
					if (!found) {
						System.out.println("No accounts were found in the database");
					}
					
					return result;
				} finally {
					DBUtil.closeQuietly(resultSet);
					DBUtil.closeQuietly(stmt);
				}
			}
		});
	}
	
	public Integer insertAccountIntoAccountsTable(final String email, final String password, final String lastName, final String firstName) {
		return executeTransaction(new Transaction<Integer>() {
			@Override
			public Integer execute(Connection conn) throws SQLException {
				Boolean isLoggedIn = false;
				PreparedStatement stmt1 = null;
				PreparedStatement stmt2 = null;
				PreparedStatement stmt3 = null;			
				
				ResultSet resultSet1 = null;
				ResultSet resultSet3 = null;				
				
				// for saving author ID and book ID
				Integer account_id = -1;

				// try to retrieve author_id (if it exists) from DB, for Author's full name, passed into query
				try {
					stmt1 = conn.prepareStatement(
							"select account_id from accounts " +
							"  where email = ? and password = ? "
					);
					stmt1.setString(1, email);
					stmt1.setString(2, password);
					
					// execute the query, get the result
					resultSet1 = stmt1.executeQuery();

					
					// if Author was found then save author_id					
					if (resultSet1.next())
					{
						account_id = resultSet1.getInt(1);
						System.out.println("Account <" + email + ", " + password + "> found with ID: " + account_id);						
					}
					else
					{
						System.out.println("Account <" + email + ", " + password + "> not found");
				
						// if the Author is new, insert new Author into Authors table
						if (account_id <= 0) {
							// prepare SQL insert statement to add Author to Authors table
							stmt2 = conn.prepareStatement(
									"insert into accounts (email, password, firstname, lastname, isLoggedIn)" +
									"  values(?, ?, ?, ?, ?) "
							);
							stmt2.setString(1, email);
							stmt2.setString(2, password);
							stmt2.setString(3, firstName);
							stmt2.setString(4, lastName);
							stmt2.setBoolean(5, isLoggedIn);
							
							// execute the update
							stmt2.executeUpdate();
							
							System.out.println("New account <" + email + ", " + password + "> inserted into Accounts table");						
						
							// try to retrieve author_id for new Author - DB auto-generates author_id
							stmt3 = conn.prepareStatement(
									"select account_id from accounts " +
									"  where email = ? and password = ? "
							);
							stmt3.setString(1, email);
							stmt3.setString(2, password);
							
							// execute the query							
							resultSet3 = stmt3.executeQuery();
							
							// get the result - there had better be one							
							if (resultSet3.next())
							{
								account_id = resultSet3.getInt(1);
								System.out.println("New account <" + email + ", " + password + "> ID: " + account_id);						
							}
							else	// really should throw an exception here - the new author should have been inserted, but we didn't find them
							{
								System.out.println("New account <" + email + ", " + password + "> not found in Account table (ID: " + account_id);
							}
						}
					}
					return account_id;
				} finally {
					DBUtil.closeQuietly(resultSet1);
					DBUtil.closeQuietly(stmt1);
					DBUtil.closeQuietly(stmt2);					
					DBUtil.closeQuietly(resultSet3);
					DBUtil.closeQuietly(stmt3);					
				}
			}
		});
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	// wrapper SQL transaction function that calls actual transaction function (which has retries)
	public<ResultType> ResultType executeTransaction(Transaction<ResultType> txn) {
		try {
			return doExecuteTransaction(txn);
		} catch (SQLException e) {
			throw new PersistenceException("Transaction failed", e);
		}
	}
	
	// SQL transaction function which retries the transaction MAX_ATTEMPTS times before failing
	public<ResultType> ResultType doExecuteTransaction(Transaction<ResultType> txn) throws SQLException {
		Connection conn = connect();
		
		try {
			int numAttempts = 0;
			boolean success = false;
			ResultType result = null;
			
			while (!success && numAttempts < MAX_ATTEMPTS) {
				try {
					result = txn.execute(conn);
					conn.commit();
					success = true;
				} catch (SQLException e) {
					if (e.getSQLState() != null && e.getSQLState().equals("41000")) {
						// Deadlock: retry (unless max retry count has been reached)
						numAttempts++;
					} else {
						// Some other kind of SQLException
						throw e;
					}
				}
			}
			
			if (!success) {
				throw new SQLException("Transaction failed (too many retries)");
			}
			
			// Success!
			return result;
		} finally {
			DBUtil.closeQuietly(conn);
		}
	}

	
	private Connection connect() throws SQLException {
		Connection conn = DriverManager.getConnection("jdbc:derby:test.db;create=true");		
		
		// Set autocommit() to false to allow the execution of
		// multiple queries/statements as part of the same transaction.
		conn.setAutoCommit(false);
		
		return conn;
	}
	
	// retrieves Author information from query result set
	private void loadAccount(Account account, ResultSet resultSet, int index) throws SQLException {
		account.setAccountId(resultSet.getInt(index++));
		account.setEmail(resultSet.getString(index++));
		account.setPassword(resultSet.getString(index++));
		account.setFirstname(resultSet.getString(index++));
		account.setLastname(resultSet.getString(index++));
		account.setIsLoggedIn(resultSet.getBoolean(index++));
	}
	
	// retrieves Book information from query result set
	private void loadBall(Ball ball, ResultSet resultSet, int index) throws SQLException {
		ball.setBallId(resultSet.getInt(index++));
		ball.setWeight(resultSet.getInt(index++));
		ball.setColor(resultSet.getString(index++));
		ball.setName(resultSet.getString(index++));
	}
	
	// retrieves WrittenBy information from query result set
	private void loadEstablishment(Establishment establishment, ResultSet resultSet, int index) throws SQLException {
		establishment.setEstablishmentId(resultSet.getInt(index++));
		establishment.setName(resultSet.getString(index++));
		establishment.setAddress(resultSet.getString(index++));
		establishment.setPhoneNumber(resultSet.getString(index++));
		establishment.setLanes(resultSet.getInt(index++));
	}
	
	private void loadEvent(Event event, ResultSet resultSet, int index) throws SQLException {
		event.setEventId(resultSet.getInt(index++));
		event.setType(resultSet.getInt(index++));
		event.setEstablishmentId(resultSet.getInt(index++));
		event.setName(resultSet.getString(index++));
		event.setDescription(resultSet.getString(index++));
	}
	
	private void loadFrame(Frame frame, ResultSet resultSet, int index) throws SQLException {
		frame.setFrameId(resultSet.getInt(index++));
		frame.setFrameScore(resultSet.getInt(index++));
		frame.setLane(resultSet.getInt(index++));
	}
	
	private void loadGame(Game game, ResultSet resultSet, int index) throws SQLException {
		game.setGameId(resultSet.getInt(index++));
		game.setGameScore(resultSet.getInt(index++));
		game.setStartingLane(resultSet.getInt(index++));
		game.setOpponent(resultSet.getString(index++));
		game.setHandicap(resultSet.getInt(index++));
	}
	
	private void loadSession(Session session, ResultSet resultSet, int index) throws SQLException {
		session.setSessionId(resultSet.getInt(index++));
		session.setSessionScore(resultSet.getInt(index++));
		session.setEventId(resultSet.getInt(index++));
		session.setLanes(resultSet.getString(index++));
		session.setDate(resultSet.getString(index++));
		session.setUserId(resultSet.getInt(index++));
	}
	
	private void loadShot(Shot shot, ResultSet resultSet, int index) throws SQLException {
		shot.setShotId(resultSet.getInt(index++));
		shot.setShotNumber(resultSet.getInt(index++));
		shot.setPins(resultSet.getString(index++));
		shot.setBallId(resultSet.getInt(index++));
		shot.setSplit(resultSet.getBoolean(index++));
		shot.setWashout(resultSet.getBoolean(index++));
		shot.setShotScore(resultSet.getString(index++));
	}
	
	private void loadJunction(Junction junction, ResultSet resultSet, int index) throws SQLException {
		junction.setSessionId(resultSet.getInt(index++));
		junction.setGameId(resultSet.getInt(index++));
		junction.setFrameId(resultSet.getInt(index++));
		junction.setShotId(resultSet.getInt(index++));
	}
	
	
	
	
	//  creates the tables
	public void createTables() {
		executeTransaction(new Transaction<Boolean>() {
			@Override
			public Boolean execute(Connection conn) throws SQLException {
				PreparedStatement stmt1 = null;
				PreparedStatement stmt2 = null;
				PreparedStatement stmt3 = null;
				PreparedStatement stmt4 = null;	
				PreparedStatement stmt5 = null;		
				PreparedStatement stmt6 = null;		
				PreparedStatement stmt7 = null;		
				PreparedStatement stmt8 = null;
				PreparedStatement stmt9 = null;		
			
				try {
					stmt1 = conn.prepareStatement(
						"create table accounts (" +
						"	account_id integer primary key " +
						"		generated always as identity (start with 1, increment by 1), " +									
						"	email varchar(40)," +
						"	password varchar(40)," +
						"   firstname varchar(40)," +
						"   lastname varchar(40)," +
						"   isLoggedIn boolean" +
						")"
					);	
					stmt1.executeUpdate();
					
					System.out.println("Accounts table created");
					
					stmt2 = conn.prepareStatement(
							"create table balls (" +
							"	ball_id integer primary key " +
							"		generated always as identity (start with 1, increment by 1), " +
							"	weight integer," +
							"	color varchar(40)," +
							"   name varchar(40)" +
							")"
					);
					stmt2.executeUpdate();
					
					System.out.println("Balls table created");
					
					stmt3 = conn.prepareStatement(
							"create table establishments (" +
							"	establishment_id integer primary key " +
							"		generated always as identity (start with 1, increment by 1), " +
							"	name varchar(40)," +
							"	address varchar(40)," +
							"   phoneNumber varchar(15)," +
							"   lanes integer" +
							")"
					);
					stmt3.executeUpdate();
					
					System.out.println("Establishments table created");
					
					stmt4 = conn.prepareStatement(
							"create table events (" +
							"	event_id integer primary key " +
							"		generated always as identity (start with 1, increment by 1), " +
							"	type integer," +
							"	establishment_id integer constraint establishment_id references establishments," +
							"   name varchar(40)," +
							"   description varchar(300)" +
							")"
					);
					stmt4.executeUpdate();
					
					System.out.println("Events table created");
					
					stmt5 = conn.prepareStatement(
							"create table frames (" +
							"	frame_id integer primary key " +
							"		generated always as identity (start with 1, increment by 1), " +
							"	frameScore integer," +
							"	lane integer"+
							")"
					);
					stmt5.executeUpdate();
					
					System.out.println("Frames table created");
					
					stmt6 = conn.prepareStatement(
							"create table games (" +
							"	game_id integer primary key " +
							"		generated always as identity (start with 1, increment by 1), " +
							"	gameScore integer," +
							"	startingLane integer," +
							"   opponent varchar(40)," +
							"   handicap integer" +
							")"
					);
					stmt6.executeUpdate();
					
					System.out.println("Games table created");
					
					stmt7 = conn.prepareStatement(
							"create table sessions (" +
							"	session_id integer primary key " +
							"		generated always as identity (start with 1, increment by 1), " +
							"	sessionScore integer," +
							"	event_id integer constraint event_id references events," +
							"   lanes varchar(40)," +
							"   date varchar(40)," +
							"   userId integer" +
							")"
					);
					stmt7.executeUpdate();
					
					System.out.println("Sessions table created");
					
					stmt8 = conn.prepareStatement(
							"create table shots (" +
							"	shot_id integer primary key " +
							"		generated always as identity (start with 1, increment by 1), " +
							"	shotNumber integer," +
							"	pins varchar(40)," +
							"	ball_id integer constraint ball_id references balls," +
							"   split boolean," +
							"   washout boolean," +
							"   shotScore varchar(40)" +
							")"
					);
					stmt8.executeUpdate();
					
					System.out.println("Shots table created");
					
					stmt9 = conn.prepareStatement(
							"create table junction (" +
							"	session_id integer constraint session_id references sessions, " +
							"	game_id integer constraint game_id references games," +
							"	frame_id integer constraint frame_id references frames," +
							"	shot_id integer constraint shot_id references shots" +
							")"
					);
					stmt9.executeUpdate();
					
					System.out.println("Junction table created");					
										
					return true;
				} finally {
					DBUtil.closeQuietly(stmt1);
					DBUtil.closeQuietly(stmt2);
					DBUtil.closeQuietly(stmt3);
					DBUtil.closeQuietly(stmt4);
					DBUtil.closeQuietly(stmt5);
					DBUtil.closeQuietly(stmt6);
					DBUtil.closeQuietly(stmt7);
					DBUtil.closeQuietly(stmt8);
					DBUtil.closeQuietly(stmt9);
				}
			}
		});
	}
	
	// loads data retrieved from CSV files into DB tables in batch mode
	public void loadInitialData() {
		executeTransaction(new Transaction<Boolean>() {
			@Override
			public Boolean execute(Connection conn) throws SQLException {
				List<Account> accountList;
				List<Ball> ballList;
				List<Establishment> establishmentList;
				List<Event> eventList;
				List<Frame> frameList;
				List<Game> gameList;
				List<Session> sessionList;
				List<Shot> shotList;
				List<Junction> junctionList;
				
				try {
					accountList    = InitialData.getAccounts();
					ballList       = InitialData.getBalls();
					establishmentList = InitialData.getEstablishments();
					eventList       = InitialData.getEvents();
					frameList       = InitialData.getFrames();
					gameList       = InitialData.getGames();
					sessionList       = InitialData.getSessions();
					shotList       = InitialData.getShots();
					junctionList       = InitialData.getJunction();
				} catch (IOException e) {
					throw new SQLException("Couldn't read initial data", e);
				}

				PreparedStatement insertAccount     = null;
				PreparedStatement insertBall       = null;
				PreparedStatement insertEstablishment = null;
				PreparedStatement insertEvent       = null;
				PreparedStatement insertFrame       = null;
				PreparedStatement insertGame       = null;
				PreparedStatement insertSession     = null;
				PreparedStatement insertShot       = null;
				PreparedStatement insertJunction       = null;

				try {
					// must completely populate Authors table before populating BookAuthors table because of primary keys
					insertAccount = conn.prepareStatement("insert into accounts (email, password, firstname, lastname, isLoggedIn) values (?, ?, ?, ?, ?)");
					for (Account account : accountList) {
						insertAccount.setString(1, account.getEmail());
						insertAccount.setString(2, account.getPassword());
						insertAccount.setString(3, account.getFirstname());
						insertAccount.setString(4, account.getLastname());
						insertAccount.setBoolean(5, account.isLoggedIn());
						insertAccount.addBatch();
					}
					insertAccount.executeBatch();
					
					System.out.println("Accounts table populated");
					
					// must completely populate Books table before populating BookAuthors table because of primary keys
					insertBall = conn.prepareStatement("insert into balls (weight, color, name) values (?, ?, ?)");
					for (Ball ball : ballList) {
						insertBall.setInt(1, ball.getWeight());
						insertBall.setString(2, ball.getColor());
						insertBall.setString(3, ball.getName());
						insertBall.addBatch();
					}
					insertBall.executeBatch();
					
					System.out.println("Balls table populated");	
					
					insertEstablishment = conn.prepareStatement("insert into establishments (name, address, phoneNumber, lanes) VALUES (?, ?, ?, ?)");
					for (Establishment establishment : establishmentList) {
					    insertEstablishment.setString(1, establishment.getName());
					    insertEstablishment.setString(2, establishment.getAddress());
					    insertEstablishment.setString(3, establishment.getPhoneNumber());
					    insertEstablishment.setInt(4, establishment.getLanes());
					    insertEstablishment.addBatch();
					}
					insertEstablishment.executeBatch();

					System.out.println("Establishments table populated");
					
					insertEvent = conn.prepareStatement("insert into events (type, establishment_id, name, description) VALUES (?, ?, ?, ?)");
					for (Event event : eventList) {
					    insertEvent.setInt(1, event.getType());
					    insertEvent.setInt(2, event.getEstablishmentId());
					    insertEvent.setString(3, event.getName());
					    insertEvent.setString(4, event.getDescription());
					    insertEvent.addBatch();
					}
					insertEvent.executeBatch();

					System.out.println("Events table populated");
					
					insertFrame = conn.prepareStatement("insert into frames (frameScore, lane) VALUES (?, ?)");
					for (Frame frame : frameList) {
					    insertFrame.setInt(1, frame.getFrameScore());
					    insertFrame.setInt(2, frame.getLane());
					    insertFrame.addBatch();
					}
					insertFrame.executeBatch();

					System.out.println("Frames table populated");

					insertGame = conn.prepareStatement("insert into games (gameScore, startingLane, opponent, handicap) VALUES (?, ?, ?, ?)");
					for (Game game : gameList) {
					    insertGame.setInt(1, game.getGameScore());
					    insertGame.setInt(2, game.getStartingLane());
					    insertGame.setString(3, game.getOpponent());
					    insertGame.setInt(4, game.getHandicap());
					    insertGame.addBatch();
					}
					insertGame.executeBatch();

					System.out.println("Games table populated");
					
					insertSession = conn.prepareStatement("insert into sessions (sessionScore, event_id, lanes, date, userId) VALUES (?, ?, ?, ?, ?)");
					for (Session session : sessionList) {
					    insertSession.setInt(1, session.getSessionScore());
					    insertSession.setInt(2, session.getEventId());
					    insertSession.setString(3, session.getLanes());
					    insertSession.setString(4, session.getDate());
					    insertSession.setInt(5, session.getUserId());
					    insertSession.addBatch();
					}
					insertSession.executeBatch();

					System.out.println("Sessions table populated");

					insertShot = conn.prepareStatement("insert into shots (shotNumber, pins, ball_id, split, washout, shotScore) VALUES (?, ?, ?, ?, ?, ?)");
					for (Shot shot : shotList) {
					    insertShot.setInt(1, shot.getShotNumber());
					    insertShot.setString(2, shot.getPins());
					    insertShot.setInt(3, shot.getBallId());
					    insertShot.setBoolean(4, shot.getSplit());
					    insertShot.setBoolean(5, shot.getWashout());
					    insertShot.setString(6, shot.getShotScore());
					    insertShot.addBatch();
					}
					insertShot.executeBatch();

					System.out.println("Shots table populated");

					// must wait until all Books and all Authors are inserted into tables before creating BookAuthor table
					// since this table consists entirely of foreign keys, with constraints applied
					insertJunction = conn.prepareStatement("insert into junction (session_id, game_id, frame_id, shot_id) values (?, ?, ?, ?)");
					for (Junction junction : junctionList) {
						insertJunction.setInt(1, junction.getSessionId());
						insertJunction.setInt(2, junction.getGameId());
						insertJunction.setInt(3, junction.getFrameId());
						insertJunction.setInt(4, junction.getShotId());
						insertJunction.addBatch();
					}
					insertJunction.executeBatch();	
					
					System.out.println("Junction table populated");					
					
					return true;
				} finally {
					DBUtil.closeQuietly(insertAccount);
					DBUtil.closeQuietly(insertBall);
					DBUtil.closeQuietly(insertEstablishment);
					DBUtil.closeQuietly(insertEvent);
					DBUtil.closeQuietly(insertFrame);
					DBUtil.closeQuietly(insertGame);
					DBUtil.closeQuietly(insertSession);
					DBUtil.closeQuietly(insertShot);
					DBUtil.closeQuietly(insertJunction);
				}
			}
		});
	}
	
	// The main method creates the database tables and loads the initial data.
	public static void main(String[] args) throws IOException {
		System.out.println("Creating tables...");
		DerbyDatabase db = new DerbyDatabase();
		db.createTables();
		
		System.out.println("Loading initial data...");
		db.loadInitialData();
		
		System.out.println("RevMetrix DB successfully initialized!");
	}
}
