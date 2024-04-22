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
	public Boolean updateFrameScore(int frameId, int newScore);
	public List<Game> findAllGames();
	public List<Frame> findAllFrames();
	public List<Shot> findAllShots();
}
