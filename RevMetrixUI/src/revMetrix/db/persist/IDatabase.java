package revMetrix.db.persist;

import java.util.ArrayList;
import java.util.List;


import revMetrix.db.model.*;

public interface IDatabase {
	public List<Account> findAllAccounts();
	public Integer insertAccountIntoAccountsTable(String email, String password, String lastName, String firstName);
	public Integer insertEventWithEstablishmentNameAndType(final String establishmentName, final String eventName, final String description, final String eventType);
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
	
	

}
