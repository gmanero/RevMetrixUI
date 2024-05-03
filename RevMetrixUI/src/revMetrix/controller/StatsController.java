package revMetrix.controller;

import revMetrix.db.persist.DatabaseProvider;
import revMetrix.db.persist.DerbyDatabase;
import revMetrix.db.persist.IDatabase;
import revMetrix.db.model.Ball;
import revMetrix.db.model.Frame;
import revMetrix.db.model.Game;
import revMetrix.db.model.Pair;
import revMetrix.db.model.Shot;

import java.util.List;

import revMetrix.controller.GameController;

public class StatsController {
	private IDatabase db = null;
	
	public StatsController() {
		
		DatabaseProvider.setInstance(new DerbyDatabase());
		db = DatabaseProvider.getInstance();
	}
	
	public static double getTotalGameScore(List<Game> gameList)
	{
		int aveGameCount = 0;
		double averageGameScore = 0;
		
		for (Game game : gameList) {
			aveGameCount++;
			averageGameScore += game.getGameScore();
		}
		
		averageGameScore = averageGameScore / aveGameCount;
		
		return averageGameScore;
	}
	
	
	public static int getTotalStrikes(List<Shot> shotList)
	{
		int StrikesInGame = 0;
		
		for(Shot shot: shotList)
		{
			if(shot.getShotScore().equals("X"))
			{
				StrikesInGame++;
			}
		}
		return StrikesInGame;
	}
	
	public static int getTotalSpares(List<Shot> shotList)
	{
		int StrikesInGame = 0;
		
		for(Shot shot: shotList)
		{
			if(shot.getShotScore().equals("/"))
			{
				StrikesInGame++;
			}
		}
		return StrikesInGame;
	}
	
	public static int getStrikesPerGame(List<Game> gameList, List<Shot> shotList)
	{
		int StrikesInGame = 0;
		int aveGameCount = 0;
		
		for (Game game : gameList) 
		{
			aveGameCount++;
		}
		
		for(Shot shot: shotList)
		{
			if(shot.getShotScore().equals("X"))
			{
				StrikesInGame++;
			}
		}
		
		return StrikesInGame /= aveGameCount;
	}

	public static int getSparesPerGame(List<Game> gameList, List<Shot> shotList)
	{
		int SparesInGame = 0;
		int aveGameCount = 0;
		
		for (Game game : gameList) 
		{
			aveGameCount++;
		}
		
		for(Shot shot: shotList)
		{
			if(shot.getShotScore().equals("/"))
			{
				SparesInGame++;
			}
		}
		
		return SparesInGame/aveGameCount;
	}
	
	public static int getTotalStrikesForSetGames(List<Game> gameList, List<Shot> shotList, int num)
	{
		List<Shot> shotList_ = shotList;
		int StrikesInGame = 0;
		int aveGameCount = 0;
		
		for (Game game : gameList) 
		{
			aveGameCount++;
			if(aveGameCount == num || aveGameCount == gameList.size())
			{
				break;
			}
		}
		
		for(Shot shot: shotList_)
		{
			if(shot.getShotScore().equals("X"))
			{
				StrikesInGame++;
			}
		}
		return StrikesInGame /= aveGameCount;
	}
	
	public static int getTotalSparesForSetGames(List<Game> gameList, List<Shot> shotList, int num)
	{
		int SparesInGame = 0;
		int aveGameCount = 0;
		
		for (Game game : gameList) 
		{
			aveGameCount++;
			if(aveGameCount == num || aveGameCount == gameList.size())
			{
				break;
			}
		}
		
		for(Shot shot: shotList)
		{
			if(shot.getShotScore().equals("/"))
			{
				SparesInGame++;
			}
		}
		return SparesInGame /= aveGameCount;
	}
	
}
