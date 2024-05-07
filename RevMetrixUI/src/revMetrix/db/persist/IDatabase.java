package revMetrix.db.persist;

import java.util.ArrayList;
import java.util.List;


import revMetrix.db.model.*;

public interface IDatabase {
	//Account
	public List<Account> findAllAccounts();
	public Integer insertAccountIntoAccountsTable(String email, String password, String lastName, String firstName);
	public Boolean logInAccount(String email, String password);
	public Boolean logOutAllAccounts();
	public Boolean isLoggedInAccount();
	public String findLoggedInUser();
	//Event
	public Integer insertEventWithEstablishmentNameAndType(final String establishmentName, final String eventName, final String description, final String eventType);
	public List<Event> findAllEvents();
	public List<Event> findAllTournaments();
	public List<Event> findAllPracticeEvents();
	public List<Event> findAllLeagueEvents();
	public List<Event> findEventById(final int eventId);
	public int findEventIdByInfo(final String name, final String description);
	//Establishments
	public Establishment findEstablishmentById(int establishmentId);
	public List<Establishment> findAllEstablishments();
	public Integer insertEstablishmentIntoEstablishmentsTable(final String name);
	//Balls
	public List<Ball> findAllBalls();
	public Integer insertBallIntoBallsTable(final int weight, final String color, final String name);
	public List<Ball> findBallById(final int ballId);
	//Game
	public ArrayList<Shot> GetShotsByGame(int id);
	public ArrayList<Game> GetGamesBySession(int id);
	public Boolean updateGameScore(int gameId, int newScore);
	public Integer addGame(Game game);
	public List<Game> findAllGames();
	public boolean updateGameDone(int gameId, boolean isdone);
	//Frame
	public ArrayList<Frame> GetFrameByGame(int id);
	public Boolean updateFrameScore(int frameId, int newScore);
	public Integer addFrame(Frame frame);
	public Integer removeFrame(int frameID);
	public List<Frame> findAllFrames();
	//Shot
	public Integer addShot(int gameId, int FrameId, Shot shot, int sessionID);
	public Integer removeShot(int shotID);
	public List<Shot> findAllShots();
	//Session
	public Boolean updateSessionScore(int sessionId, int newScore);
	public List<Session> findAllSessions();
	public Integer insertSessionIntoSessionsTable(final int sessionScore, final int eventId, final String lanes, final String date, final int userId);
	public ArrayList<Session> getSessionByEvent(int id);
	public Boolean updateSessionDate(int Id);
	public Session getSession(int id);
	public Boolean RemoveSession(int id);
	//Junction
	public List<Junction> findAllJunctions();
}

