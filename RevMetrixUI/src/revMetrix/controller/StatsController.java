package revMetrix.controller;

import revMetrix.db.persist.DatabaseProvider;
import revMetrix.db.persist.DerbyDatabase;
import revMetrix.db.persist.IDatabase;
import revMetrix.db.model.Account;
import revMetrix.db.model.Ball;
import revMetrix.db.model.Frame;
import revMetrix.db.model.Game;
import revMetrix.db.model.Pair;
import revMetrix.db.model.Shot;

import java.util.ArrayList;
import java.util.List;
import java.text.DecimalFormat;

import revMetrix.controller.GameController;

public class StatsController {
	private IDatabase db = null;
	
	public StatsController()
	{
		DatabaseProvider.setInstance(new DerbyDatabase());
		db = DatabaseProvider.getInstance();
	}
	
	public List<Game> getAllGames() 
	{
		List<Game> gameList = db.findAllGames();
		if (gameList.isEmpty())
		{
			return null;
		}else {
			return gameList;
		}
	}
	
	public double getLastThreeGameScore() 
	{
	    List<Game> gameList = db.findAllGames();
	    double averageGameScore = 0;

	    if (gameList.isEmpty()) 
	    {
	        System.out.print("Game list is empty");
	        return 0;
	    } else {
	        for (Game game : gameList) 
	        {
	            if (game.getGameId() == gameList.size() || game.getGameId() == gameList.size() - 1 || game.getGameId() == gameList.size() - 2) 
	            {
	                averageGameScore += game.getGameScore();
	            }
	        }
	        averageGameScore = averageGameScore / 3;

	        String formattedScore = String.format("%.2f", averageGameScore);

	        return Double.parseDouble(formattedScore);
	    }
	}
	
	public double getTotalGameScore() 
	{
	    List<Game> gameList = db.findAllGames();
	    int aveGameCount = gameList.size();
	    double totalGameScore = 0;

	    if (aveGameCount == 0) 
	    {
	        System.out.println("Game list is empty.");
	        return 0;
	    } else {
	        for (Game game : gameList) 
	        {
	            totalGameScore += game.getGameScore();
	        }
	        double averageGameScore = totalGameScore / aveGameCount;

	        DecimalFormat df = new DecimalFormat("#.##");
	        String formattedResult = df.format(averageGameScore);

	        return Double.parseDouble(formattedResult);
	    }
	}
	
	
	public int getTotalStrikes()
	{
		List<Shot> shotList = db.findAllShots();
		int StrikesInGame = 0;
		
		if (shotList.isEmpty())
		{
			System.out.print("shot list is empty");
			return 0;
		}else {
			for(Shot shot: shotList)
			{
				if(shot.getShotScore().equals("X"))
				{
					StrikesInGame++;
				}
			}
			return StrikesInGame;
		}
	}
	
	public int highestGameScore()
	{
		List<Game> gameList = db.findAllGames();
		int highScore = -1;
		
		for (Game game: gameList)
		{
			if(highScore == - 1)
			{
				highScore = game.getGameScore();
			}else if(highScore < game.getGameScore())
			{
				highScore = game.getGameScore();
			}
		}
		return highScore;
	}
	
	public int lowestGameScore() 
	{
		List<Game> gameList = db.findAllGames();
		int lowScore = -1;
		
		for (Game game: gameList)
		{
			if(lowScore == - 1)
			{
				lowScore = game.getGameScore();
			}else if(lowScore > game.getGameScore())
			{
				lowScore = game.getGameScore();
			}
		}
		return lowScore;
	}
	
	/*public int highestInSession()
	{
		List<Game> gameList = db.findAllGames();
		int highScore = -1;
		
		for (Game game: gameList)
		{
			if(highScore == - 1)
			{
				highScore = game.getGameScore();
			}else if(highScore < game.getGameScore())
			{
				highScore = game.getGameScore();
			}
		}
		return highScore;
	}
	
	public int lowestInSession()
	{
		List<Game> gameList = db.findAllGames();
		int lowScore = -1;
		
		for (Game game: gameList)
		{
			if(lowScore == - 1)
			{
				lowScore = game.getGameScore();
			}else if(lowScore > game.getGameScore())
			{
				lowScore = game.getGameScore();
			}
		}
		return lowScore;
	}*/
	
	public int getTotalSpares()
	{
		List<Shot> shotList = db.findAllShots();
		int StrikesInGame = 0;
		
		if (shotList.isEmpty())
		{
			System.out.print("game list is empty");
			return 0;
		}else {
			for(Shot shot: shotList)
			{
				if(shot.getShotScore().equals("/"))
				{
					StrikesInGame++;
				}
			}
			return StrikesInGame;
		}
	}
	
	public double getStrikesPercentage() {
	    List<Frame> frameList = db.findAllFrames();
	    List<Shot> shotList = db.findAllShots();
	    int strikesInGame = 0;
	    int aveGameCount = 0;

	    if (frameList.isEmpty() || shotList.isEmpty()) 
	    {
	        System.out.println("Game list or shot list is empty.");
	        return 0;
	    } else {
	        aveGameCount = frameList.size();

	        for (Shot shot : shotList) 
	        {
	            if (shot.getShotScore().equals("X")) 
	            {
	                strikesInGame++;
	            }
	        }
	        double strikesPercentage = (double) strikesInGame / aveGameCount * 100;

	        DecimalFormat df = new DecimalFormat("#.##");
	        String formattedResult = df.format(strikesPercentage);

	        return Double.parseDouble(formattedResult);
	    }
	}

	public double getSparesPercentage() {
	    List<Frame> frameList = db.findAllFrames();
	    List<Shot> shotList = db.findAllShots();
	    int sparesInGame = 0;
	    int aveGameCount = 0;

	    if (frameList.isEmpty() || shotList.isEmpty()) 
	    {
	        System.out.println("Game list or shot list is empty.");
	        return 0;
	    } else {
	        aveGameCount = frameList.size();

	        for (Shot shot : shotList) {
	            if (shot.getShotScore().equals("/")) {
	                sparesInGame++;
	            }
	        }
	        double sparesPercentage = (double) sparesInGame / aveGameCount * 100;

	        DecimalFormat df = new DecimalFormat("#.##");
	        String formattedResult = df.format(sparesPercentage);

	        return Double.parseDouble(formattedResult);
	    }
	}
	
	/*public int overPercentage()
	{
		List<Game> gameList = db.findAllGames();
		List<Shot> shotList = db.findAllShots();
		List<Frame> frameList = db.findAllFrames();
		
		if (gameList.isEmpty() || shotList.isEmpty() || frameList.isEmpty())
		{
			System.out.print("game list is empty");
			return 0;
		}else {
			for (Frame frame : frameList)
			{
				if(frame.getFrameId() == 0 && frame.getFrameScore() == "X")
				{
					
				}
			}
		}
		
		
		return 0;
	}
	public int getTotalStrikesForSetGames()
	{
		List<Game> gameList = db.findAllGames();
		List<Shot> shotList = db.findAllShots();
		int StrikesInGame = 0;
		int aveGameCount = 0;
		
		if (gameList.isEmpty() || shotList.isEmpty())
		{
			System.out.print("game list is empty");
			return 0;
		}else {
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
				if(shot.getShotScore().equals("X"))
				{
					StrikesInGame++;
				}
			}
			return StrikesInGame /= aveGameCount;
		}
		
	}
	
	public int getTotalSparesForSetGames(List<Game> gameList, List<Shot> shotList, int num)
	{
		List<Game> gameList_ = gameList;
		List<Shot> shotList_ = shotList;
		int SparesInGame = 0;
		int aveGameCount = 0;
		
		if (gameList_.isEmpty() || shotList_.isEmpty())
		{
			System.out.print("game list is empty");
			return 0;
		}else {
			for (Game game : gameList_) 
			{
				aveGameCount++;
				if(aveGameCount == num || aveGameCount == gameList_.size())
				{
					break;
				}
			}
			for(Shot shot: shotList_)
			{
				if(shot.getShotScore().equals("/"))
				{
					SparesInGame++;
				}
			}
			return SparesInGame /= aveGameCount;
		}
	}*/
	
	public int[] getGraphData()
	{
		List<Game> gameList = db.findAllGames();
		int count = 0;
		int[] arr = new int[5];
		
		if(gameList.isEmpty())
		{
			return null;
		}else {
			for(Game game : gameList)
			{
				if (game.getGameId() == gameList.size() || game.getGameId() == gameList.size() - 1 || game.getGameId() == gameList.size() - 2 || game.getGameId() == gameList.size() - 3 || game.getGameId() == gameList.size() - 4) 
	            {
	                arr[count] = game.getGameScore();
	                count++;
	            }
			}
			return arr;
		}
	}
	
	public double twoDec(Double convert) 
	{
		String FV = String.format("%.2f", convert);
		return Double.parseDouble(FV);
	}
}
