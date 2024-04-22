package revMetrix.db.persist;

import java.io.IOException;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//import edu.ycp.cs320.booksdb.model.Author;
//import edu.ycp.cs320.booksdb.model.Book;
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
	
	//ACCOUNT QUERYS
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
				Boolean isLoggedIn = true;
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
	
	
	public List<Ball> findAllBalls() {
	    return executeTransaction(new Transaction<List<Ball>>() {
	        @Override
	        public List<Ball> execute(Connection conn) throws SQLException {
	            PreparedStatement stmt = null;
	            ResultSet resultSet = null;
	            
	            try {
	                stmt = conn.prepareStatement("SELECT * FROM balls");
	                
	                List<Ball> result = new ArrayList<Ball>();
	                
	                resultSet = stmt.executeQuery();
	                
	                Boolean found = false;
	                
	                while (resultSet.next()) {
	                    found = true;
	                    
	                    Ball ball = new Ball();
	                    loadBall(ball, resultSet, 1);
	                    
	                    result.add(ball);
	                }
	                
	                if (!found) {
	                    System.out.println("No balls were found in the database");
	                }
	                
	                return result;
	            } finally {
	                DBUtil.closeQuietly(resultSet);
	                DBUtil.closeQuietly(stmt);
	            }
	        }
	    });
	}
	
	public Integer insertBallIntoBallsTable(final int weight, final String color, final String name) {
	    return executeTransaction(new Transaction<Integer>() {
	        @Override
	        public Integer execute(Connection conn) throws SQLException {
	            PreparedStatement stmt1 = null;
	            PreparedStatement stmt2 = null;
	            PreparedStatement stmt3 = null;            
	            
	            ResultSet resultSet1 = null;
	            ResultSet resultSet3 = null;            
	                       
	            Integer ball_Id = -1;

	            try {
	                stmt1 = conn.prepareStatement(
	                        "SELECT ball_id FROM balls " +
	                        "WHERE weight = ? AND color = ? AND name = ?"
	                );
	                stmt1.setInt(1, weight);
	                stmt1.setString(2, color);
	                stmt1.setString(3, name);
	                
	                resultSet1 = stmt1.executeQuery();

	                if (resultSet1.next()) {
	                    ball_Id = resultSet1.getInt(1);
	                    System.out.println("Ball with weight: " + weight + ", color: " + color + ", name: " + name + " already exists with ID: " + ball_Id);
	                } else {
	                    System.out.println("Ball with weight: " + weight + ", color: " + color + ", name: " + name + " not found");
	                if(ball_Id <=0) {
	                    stmt2 = conn.prepareStatement(
	                            "INSERT INTO balls (weight, color, name) " +
	                            "VALUES (?, ?, ?)"
	                    );
	                    stmt2.setInt(1, weight);
	                    stmt2.setString(2, color);
	                    stmt2.setString(3, name);
	                    
	                    stmt2.executeUpdate();
	                    
	                    System.out.println("New ball inserted into Balls table");
	                
	                    stmt3 = conn.prepareStatement(
	                            "SELECT ball_id FROM balls " +
	                            "WHERE weight = ? AND color = ? AND name = ?"
	                    );
	                    stmt3.setInt(1, weight);
	                    stmt3.setString(2, color);
	                    stmt3.setString(3, name);
	                    
	                    resultSet3 = stmt3.executeQuery();
	                    
	                    if (resultSet3.next()) {
	                        ball_Id = resultSet3.getInt(1);
	                        System.out.println("New ball ID: " + ball_Id);
	                    } else {
	                        System.out.println("New ball not found in Balls table");
	                    }
	                }
	            } 
	                return ball_Id;
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

	
	//ESTABLISHMENTS QUERYS
	public List<Establishment> findAllEstablishments() {
	    return executeTransaction(new Transaction<List<Establishment>>() {
	        @Override
	        public List<Establishment> execute(Connection conn) throws SQLException {
	            PreparedStatement stmt = null;
	            ResultSet resultSet = null;
	            
	            try {
	                stmt = conn.prepareStatement("SELECT * FROM establishments");
	                
	                List<Establishment> result = new ArrayList<Establishment>();
	                
	                resultSet = stmt.executeQuery();
	                
	                Boolean found = false;
	                
	                while (resultSet.next()) {
	                    found = true;
	                    
	                    Establishment establishment = new Establishment();
	                    loadEstablishment(establishment, resultSet, 1);
	                    
	                    result.add(establishment);
	                }
	                
	                if (!found) {
	                    System.out.println("No establishments were found in the database");
	                }
	                
	                return result;
	            } finally {
	                DBUtil.closeQuietly(resultSet);
	                DBUtil.closeQuietly(stmt);
	            }
	        }
	    });
	}
	
	public Integer insertEstablishmentIntoEstablishmentsTable(final String name) {
	    return executeTransaction(new Transaction<Integer>() {
	        @Override
	        public Integer execute(Connection conn) throws SQLException {
	            PreparedStatement stmt1 = null;
	            PreparedStatement stmt2 = null;
	            PreparedStatement stmt3 = null;            
	            
	            ResultSet resultSet1 = null;
	            ResultSet resultSet3 = null;            
	                       
	            Integer establishmentId = -1;

	            try {
	                stmt1 = conn.prepareStatement(
	                        "SELECT establishment_id FROM establishments " +
	                        "WHERE name = ? "
	                );
	                stmt1.setString(1, name);
	             
	                
	                resultSet1 = stmt1.executeQuery();

	                if (resultSet1.next()) {
	                    establishmentId = resultSet1.getInt(1);
	                    System.out.println("Establishment with name: " + name + ", address: " + " already exists with ID: " + establishmentId);
	                } else {
	                    System.out.println("Establishment with name: " + name + ", address: " +" not found");
	                
	                    if (establishmentId <= 0) {
	                        stmt2 = conn.prepareStatement(
	                                "INSERT INTO establishments (name) " +
	                                "VALUES (?)"
	                        );
	                        stmt2.setString(1, name);
	                        
	                        
	                        stmt2.executeUpdate();
	                        
	                        System.out.println("New establishment inserted into Establishments table");
	                    
	                        stmt3 = conn.prepareStatement(
	                                "SELECT establishment_id FROM establishments " +
	                                "WHERE name = ? "
	                        );
	                        stmt3.setString(1, name);
	                        
	                        resultSet3 = stmt3.executeQuery();
	                        
	                        if (resultSet3.next()) {
	                            establishmentId = resultSet3.getInt(1);
	                            System.out.println("New establishment ID: " + establishmentId);
	                        } else {
	                            System.out.println("New establishment not found in Establishments table");
	                        }
	                    }
	                }
	                
	                return establishmentId;
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
	public Establishment findEstablishmentById(int establishmentId) {
        return executeTransaction(new Transaction<Establishment>() {
            @Override
            public Establishment execute(Connection conn) throws SQLException {
                PreparedStatement stmt = null;
                ResultSet resultSet = null;
                
                Integer establishmentId = -1;

                try {
                    stmt = conn.prepareStatement(
                    		"SELECT name FROM establishments"+
                    		"WHERE establishment_Id = ?"
                    				);
                    stmt.setInt(1, establishmentId);

                    resultSet = stmt.executeQuery();

                    if (resultSet.next()) {
                        Establishment establishment = new Establishment();
                        establishment.setEstablishmentId(resultSet.getInt("establishment_Id"));
                        establishment.setName(resultSet.getString("name"));
                        return establishment;
                    } else {
                        System.out.println("Establishment with ID " + establishmentId + " not found.");
                        return null;
                    }
                } finally {
                    DBUtil.closeQuietly(resultSet);
                    DBUtil.closeQuietly(stmt);
                }
            }
        });
    }


	//EVENTS QUERYS
	public List<Event> findAllEvents() {
	    return executeTransaction(new Transaction<List<Event>>() {
	        @Override
	        public List<Event> execute(Connection conn) throws SQLException {
	            PreparedStatement stmt = null;
	            ResultSet resultSet = null;
	            
	            try {
	                stmt = conn.prepareStatement("SELECT * FROM events");
	                
	                List<Event> result = new ArrayList<Event>();
	                
	                resultSet = stmt.executeQuery();
	                
	                Boolean found = false;
	                
	                while (resultSet.next()) {
	                    found = true;
	                    
	                    Event event = new Event();
	                    loadEvent(event, resultSet, 1);
	                    
	                    result.add(event);
	                }
	                
	                if (!found) {
	                    System.out.println("No events were found in the database");
	                }
	                
	                return result;
	            } finally {
	                DBUtil.closeQuietly(resultSet);
	                DBUtil.closeQuietly(stmt);
	            }
	        }
	    });
	}
	
	public Integer insertEventWithEstablishmentNameAndType(final String establishmentName, final String eventName, final String description, final String eventType) {
	    return executeTransaction(new Transaction<Integer>() {
	        @Override
	        public Integer execute(Connection conn) throws SQLException {
	            PreparedStatement stmt1 = null;
	            PreparedStatement stmt2 = null;
	            PreparedStatement stmt3 = null;
	            PreparedStatement stmt4 = null;
	            PreparedStatement stmt5 = null;
	            
	            ResultSet resultSet1 = null;
	            ResultSet resultSet3 = null;
	            ResultSet resultSet5 = null;
	                       
	            Integer eventId = -1;

	            try {
	                // Step 1: Check if establishment exists in the database
	                stmt1 = conn.prepareStatement(
	                        "SELECT establishment_id FROM establishments " +
	                        "WHERE name = ?"
	                );
	                stmt1.setString(1, establishmentName);
	                
	                resultSet1 = stmt1.executeQuery();

	                int establishmentId;
	                if (resultSet1.next()) {
	                    establishmentId = resultSet1.getInt(1);
	                    System.out.println("Establishment with name: " + establishmentName + " found with ID: " + establishmentId);
	                } else {
	                    // Step 2: Insert new establishment
	                    System.out.println("Establishment with name: " + establishmentName + " not found, adding new establishment...");
	                    
	                    stmt2 = conn.prepareStatement(
	                            "INSERT INTO establishments (name) " +
	                            "VALUES (?)"
	                    );
	                    stmt2.setString(1, establishmentName);
	                    
	                    stmt2.executeUpdate();
	                    
	                    System.out.println("New establishment inserted into Establishments table");
	                
	                    // Step 3: Retrieve establishment ID
	                    stmt3 = conn.prepareStatement(
	                            "SELECT establishment_id FROM establishments " +
	                            "WHERE name = ?"
	                    );
	                    stmt3.setString(1, establishmentName);
	                    
	                    resultSet3 = stmt3.executeQuery();
	                    
	                    if (resultSet3.next()) {
	                        establishmentId = resultSet3.getInt(1);
	                        System.out.println("New establishment ID: " + establishmentId);
	                    } else {
	                        System.out.println("New establishment not found in Establishments table");
	                        return -1; // Return -1 if establishment ID not found
	                    }
	                }
	                
	                // Step 4: Convert eventType to corresponding type integer value
	                int type = 0;
	                if (eventType.equalsIgnoreCase("practice")) {
	                    type = 1;
	                } else if (eventType.equalsIgnoreCase("league")) {
	                    type = 2;
	                } else if (eventType.equalsIgnoreCase("tournament")) {
	                    type = 3;
	                } else {
	                    System.out.println("Invalid event type");
	                    return -1; // Return -1 if the event type is invalid
	                }
	                
	                // Step 5: Insert new event with establishment ID and type
	                stmt4 = conn.prepareStatement(
	                        "INSERT INTO events (type, establishment_id, name, description) " +
	                        "VALUES (?, ?, ?, ?)"
	                );
	                stmt4.setInt(1, type);
	                stmt4.setInt(2, establishmentId);
	                stmt4.setString(3, eventName);
	                stmt4.setString(4, description);
	                
	                stmt4.executeUpdate();
	                
	                System.out.println("New event inserted into Events table");
	            
	                // Step 6: Retrieve event ID
	                stmt5 = conn.prepareStatement(
	                        "SELECT event_id FROM events " +
	                        "WHERE establishment_id = ? AND name = ? AND description = ?"
	                );
	                stmt5.setInt(1, establishmentId);
	                stmt5.setString(2, eventName);
	                stmt5.setString(3, description);
	                
	                resultSet5 = stmt5.executeQuery();
	                
	                if (resultSet5.next()) {
	                    eventId = resultSet5.getInt(1);
	                    System.out.println("New event ID: " + eventId);
	                } else {
	                    System.out.println("New event not found in Events table");
	                }
	                
	                return eventId;
	            } finally {
	                DBUtil.closeQuietly(resultSet1);
	                DBUtil.closeQuietly(stmt1);
	                DBUtil.closeQuietly(stmt2);                    
	                DBUtil.closeQuietly(resultSet3);
	                DBUtil.closeQuietly(stmt3);
	                DBUtil.closeQuietly(stmt4);
	                DBUtil.closeQuietly(resultSet5);
	                DBUtil.closeQuietly(stmt5);                    
	            }
	        }
	    });
	}


	
	//FRAMES QUERYS
	public List<Frame> findAllFrames() {
	    return executeTransaction(new Transaction<List<Frame>>() {
	        @Override
	        public List<Frame> execute(Connection conn) throws SQLException {
	            PreparedStatement stmt = null;
	            ResultSet resultSet = null;
	            
	            try {
	                stmt = conn.prepareStatement("SELECT * FROM frames");
	                
	                List<Frame> result = new ArrayList<Frame>();
	                
	                resultSet = stmt.executeQuery();
	                
	                Boolean found = false;
	                
	                while (resultSet.next()) {
	                    found = true;
	                    
	                    Frame frame = new Frame();
	                    loadFrame(frame, resultSet, 1);
	                    
	                    result.add(frame);
	                }
	                
	                if (!found) {
	                    System.out.println("No frames were found in the database");
	                }
	                
	                return result;
	            } finally {
	                DBUtil.closeQuietly(resultSet);
	                DBUtil.closeQuietly(stmt);
	            }
	        }
	    });
	}
	
	public ArrayList<Frame> GetFrameByGame(int id){
		return executeTransaction(new Transaction<ArrayList<Frame>>() {
	        @Override
	        public ArrayList<Frame> execute(Connection conn) throws SQLException {
	            PreparedStatement stmt = null;
	            ResultSet resultSet = null;
	            
	            
	            try {
	            	stmt = conn.prepareStatement("select frames.* from junction, frames where Junction.Game_Id = ? and Junction.frame_id=frames.frame_Id");
	                stmt.setInt(1,id);
	                ArrayList<Frame> results = new ArrayList<Frame>();
	                
	                resultSet = stmt.executeQuery();
	                
	                Boolean found = false;
	                
	                while (resultSet.next()) {
	                    found = true;
	                    
	                    Frame frame = new Frame();
	                    loadFrame(frame, resultSet, 1);
	                    boolean unique = true;
	                    for(Frame current:results ) {
	                    	if (current.getFrameId()==frame.getFrameId()) {
	                    		unique = false;
	                    	}
	                    }
	                    if(unique) {
	                    	results.add(frame);
	                    }
	                    
	                }
	                
	                if (!found) {
	                    System.out.println("No junctions were found in the database");
	                }
	                return results;
	            	
	            } finally {
	                DBUtil.closeQuietly(resultSet);
	                DBUtil.closeQuietly(stmt);
	            }
	        }
	    });
	}
	public Boolean updateFrameScore(int frameId, int newScore) {
		return executeTransaction(new Transaction<Boolean>() {
	        @Override
	        public Boolean execute(Connection conn) throws SQLException {
	            PreparedStatement stmt = null;
	            ResultSet resultSet = null;
	            
	            try {
	                stmt = conn.prepareStatement("UPDATE frames SET frameScore = ? WHERE frame_id = ?");
	                
	                Boolean result = true;
	                stmt.setInt(1, newScore);
	                stmt.setInt(2, frameId);
	                int rowsUpdated =stmt.executeUpdate();
	                System.out.println(rowsUpdated);
	                return result;
	               
	            } finally {
	                DBUtil.closeQuietly(resultSet);
	                DBUtil.closeQuietly(stmt);
	            }
	        }
	    });
	}
	//GAMES QUERYS
	public ArrayList<Shot> GetShotsByGame(int id){
		return executeTransaction(new Transaction<ArrayList<Shot>>() {
	        @Override
	        public ArrayList<Shot> execute(Connection conn) throws SQLException {
	            PreparedStatement stmt = null;
	            ResultSet resultSet = null;
	            
	            
	            try {
	            	stmt = conn.prepareStatement("select shots.* from junction, shots where Junction.Game_Id = ? and Junction.shot_id=Shots.shot_Id");
	                stmt.setInt(1,id);
	                ArrayList<Shot> results = new ArrayList<Shot>();
	                
	                resultSet = stmt.executeQuery();
	                
	                Boolean found = false;
	                
	                while (resultSet.next()) {
	                    found = true;
	                    
	                   Shot shot = new Shot();
	                   loadShot(shot, resultSet, 1);
	                    
	                    results.add(shot);
	                }
	                
	                if (!found) {
	                    System.out.println("No junctions were found in the database");
	                }
	                return results;
	            	
	            } finally {
	                DBUtil.closeQuietly(resultSet);
	                DBUtil.closeQuietly(stmt);
	            }
	        }
	    });
	}
	
	public Integer addGame(Game game) {
		return executeTransaction(new Transaction<Integer>() {
			public Integer execute(Connection conn) throws SQLException {
				PreparedStatement insertGame = conn.prepareStatement("insert into games (gameScore, startingLane, opponent, handicap) VALUES (?, ?, ?, ?)",PreparedStatement.RETURN_GENERATED_KEYS);
				insertGame.setInt(1, game.getGameScore());
			   	insertGame.setInt(2, game.getStartingLane());
			   	insertGame.setString(3, game.getOpponent());
			   	insertGame.setInt(4, game.getHandicap());
				insertGame.executeUpdate();
				ResultSet rs = insertGame.getGeneratedKeys();
				if(rs.next()) {
					return rs.getInt(1);
				}
				return -1;
			
			}
			
		});
	}
	public Integer addFrame(Frame frame) {
		return executeTransaction(new Transaction<Integer>() {
			public Integer execute(Connection conn) throws SQLException {
				PreparedStatement insertFrame = conn.prepareStatement("insert into frames (frameScore, lane) VALUES (?, ?)",PreparedStatement.RETURN_GENERATED_KEYS);
				insertFrame.setInt(1, frame.getFrameScore());
				insertFrame.setInt(2, frame.getLane());
				int key = insertFrame.executeUpdate();
				ResultSet rs = insertFrame.getGeneratedKeys();
				if(rs.next()) {
					return rs.getInt(1);
				}
				return -1;
			}
			
		});
	}
	public Integer addShot(int gameId, int FrameId, Shot shot) {
		return executeTransaction(new Transaction<Integer>() {
			public Integer execute(Connection conn) throws SQLException {
				PreparedStatement insertShot = conn.prepareStatement("insert into shots (shotNumber, pins, ball_id, split, washout, shotScore) VALUES (?, ?, ?, ?, ?, ?)",PreparedStatement.RETURN_GENERATED_KEYS);
				insertShot.setInt(1, shot.getShotNumber());
				 	insertShot.setString(2, shot.getPins());
				 	insertShot.setInt(3, shot.getBallId());
				 	insertShot.setBoolean(4, shot.getSplit());
				 	insertShot.setBoolean(5, shot.getWashout());
				 	insertShot.setString(6, shot.getShotScore());

				insertShot.executeUpdate();
				ResultSet rs = insertShot.getGeneratedKeys();
				int key = 0;
				if(rs.next()) {
					key = rs.getInt(1);
				}
				
				PreparedStatement insertJunction = conn.prepareStatement("insert into junction (session_id, game_id, frame_id, shot_id) values (?, ?, ?, ?)",PreparedStatement.RETURN_GENERATED_KEYS);
				 insertJunction.setInt(1, 1);
					 insertJunction.setInt(2, gameId);
					 insertJunction.setInt(3, FrameId);
					 insertJunction.setInt(4, key);
				insertJunction.executeUpdate();

				return key;
			
			}
			
		});
	}
	public List<Game> findAllGames() {
	    return executeTransaction(new Transaction<List<Game>>() {
	        @Override
	        public List<Game> execute(Connection conn) throws SQLException {
	            PreparedStatement stmt = null;
	            ResultSet resultSet = null;
	            
	            try {
	                stmt = conn.prepareStatement("SELECT * FROM games");
	                
	                List<Game> result = new ArrayList<Game>();
	                
	                resultSet = stmt.executeQuery();
	                
	                Boolean found = false;
	                
	                while (resultSet.next()) {
	                    found = true;
	                    
	                    Game game = new Game();
	                    loadGame(game, resultSet, 1);
	                    
	                    result.add(game);
	                }
	                
	                if (!found) {
	                    System.out.println("No games were found in the database");
	                }
	                
	                return result;
	            } finally {
	                DBUtil.closeQuietly(resultSet);
	                DBUtil.closeQuietly(stmt);
	            }
	        }
	    });
	}
	
	//SESSIONS QUERYS
	public List<Session> findAllSessions() {
	    return executeTransaction(new Transaction<List<Session>>() {
	        @Override
	        public List<Session> execute(Connection conn) throws SQLException {
	            PreparedStatement stmt = null;
	            ResultSet resultSet = null;
	            
	            try {
	                stmt = conn.prepareStatement("SELECT * FROM sessions");
	                
	                List<Session> result = new ArrayList<Session>();
	                
	                resultSet = stmt.executeQuery();
	                
	                Boolean found = false;
	                
	                while (resultSet.next()) {
	                    found = true;
	                    
	                    Session session = new Session();
	                    loadSession(session, resultSet, 1);
	                    
	                    result.add(session);
	                }
	                
	                if (!found) {
	                    System.out.println("No sessions were found in the database");
	                }
	                
	                return result;
	            } finally {
	                DBUtil.closeQuietly(resultSet);
	                DBUtil.closeQuietly(stmt);
	            }
	        }
	    });
	}
	
	//SHOTS QUERYS
	public List<Shot> findAllShots() {
	    return executeTransaction(new Transaction<List<Shot>>() {
	        @Override
	        public List<Shot> execute(Connection conn) throws SQLException {
	            PreparedStatement stmt = null;
	            ResultSet resultSet = null;
	            
	            try {
	                stmt = conn.prepareStatement("SELECT * FROM shots");
	                
	                List<Shot> result = new ArrayList<Shot>();
	                
	                resultSet = stmt.executeQuery();
	                
	                Boolean found = false;
	                
	                while (resultSet.next()) {
	                    found = true;
	                    
	                    Shot shot = new Shot();
	                    loadShot(shot, resultSet, 1);
	                    
	                    result.add(shot);
	                }
	                
	                if (!found) {
	                    System.out.println("No shots were found in the database");
	                }
	                
	                return result;
	            } finally {
	                DBUtil.closeQuietly(resultSet);
	                DBUtil.closeQuietly(stmt);
	            }
	        }
	    });
	}
	
	//JUNCTIONS QUERYS
	public List<Junction> findAllJunctions() {
	    return executeTransaction(new Transaction<List<Junction>>() {
	        @Override
	        public List<Junction> execute(Connection conn) throws SQLException {
	            PreparedStatement stmt = null;
	            ResultSet resultSet = null;
	            
	            try {
	                stmt = conn.prepareStatement("SELECT * FROM junction");
	                
	                List<Junction> result = new ArrayList<Junction>();
	                
	                resultSet = stmt.executeQuery();
	                
	                Boolean found = false;
	                
	                while (resultSet.next()) {
	                    found = true;
	                    
	                    Junction junction = new Junction();
	                    loadJunction(junction, resultSet, 1);
	                    
	                    result.add(junction);
	                }
	                
	                if (!found) {
	                    System.out.println("No junctions were found in the database");
	                }
	                
	                return result;
	            } finally {
	                DBUtil.closeQuietly(resultSet);
	                DBUtil.closeQuietly(stmt);
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
							"	name varchar(40)"+
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
					
					insertEstablishment = conn.prepareStatement("insert into establishments (name) VALUES (?)");
					for (Establishment establishment : establishmentList) {
					    insertEstablishment.setString(1, establishment.getName());
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
