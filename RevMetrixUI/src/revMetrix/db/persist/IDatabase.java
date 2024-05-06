package revMetrix.db.persist;

import java.util.ArrayList;
import java.util.List;


import revMetrix.db.model.*;

public interface IDatabase {
	public List<Account> findAllAccounts();
	public Integer insertAccountIntoAccountsTable(String email, String password, String lastName, String firstName);
	public Integer insertEventWithEstablishmentNameAndType(final String establishmentName, final String eventName, final String description, final String eventType);
	public List<Event> findAllEvents();
	public Establishment findEstablishmentById(int establishmentId);
	public List<Establishment> findAllEstablishments();
	public List<Ball> findAllBalls();
	public ArrayList<Shot> GetShotsByGame(int id);
	public ArrayList<Frame> GetFrameByGame(int id);
	public ArrayList<Game> GetGamesBySession(int id);
	public Boolean updateFrameScore(int frameId, int newScore);
	public Boolean updateGameScore(int gameId, int newScore);
	public Boolean updateSessionScore(int sessionId, int newScore);
	public Integer addGame(Game game);
	public Integer addFrame(Frame frame);
	public Integer addShot(int gameId, int FrameId, Shot shot, int sessionID);
	public Integer removeShot(int shotID);
	public Integer removeFrame(int frameID);
	public List<Game> findAllGames();
	public List<Frame> findAllFrames();
	public List<Shot> findAllShots();
	public Integer insertEstablishmentIntoEstablishmentsTable(final String name);
	public List<Junction> findAllJunctions();
	public List<Session> findAllSessions();
	public Integer insertBallIntoBallsTable(final int weight, final String color, final String name);
	public List<Event> findAllTournaments();
	public List<Event> findAllPracticeEvents();
	public List<Event> findAllLeagueEvents();
	public Boolean logInAccount(String email, String password);
	public Boolean logOutAllAccounts();
	public Boolean isLoggedInAccount();
	public String findLoggedInUser();
	public List<Event> findEventById(final int eventId);
	public Integer insertSessionIntoSessionsTable(final int sessionScore, final int eventId, final String lanes, final String date, final int userId);
	public int findEventIdByInfo(final String name, final String description);
	
	public ArrayList<Session> getSessionByEvent(int id);
	public Boolean updateSessionDate(int Id);
		
}

