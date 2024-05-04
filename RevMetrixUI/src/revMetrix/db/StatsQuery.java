package revMetrix.db;

import java.util.List;

import java.util.Scanner;

import java.text.*;
import revMetrix.model.RevMetrix;
import revMetrix.controller.GameController;
import revMetrix.db.model.Game;
import revMetrix.db.model.Frame;
import revMetrix.db.model.Shot;
import revMetrix.db.model.Pair;
import revMetrix.db.persist.DatabaseProvider;
import revMetrix.db.persist.IDatabase;

import revMetrix.controller.StatsController;

public class StatsQuery { 
	public static double gamesTotal()
	{
		IDatabase db = DatabaseProvider.getInstance();
		List<Game> gameList = db.findAllGames();
		
		if (gameList.isEmpty())
		{
			System.out.println("There are no games listed in the database");
			return 0;
		}else{
			System.out.println(StatsController.getTotalGameScore(gameList));
			return StatsController.getTotalGameScore(gameList);
			
		}
	}
	

public static int strikeTotal() 
	{
		IDatabase db = DatabaseProvider.getInstance();
		List<Game> gameList = db.findAllGames();
		List<Shot> shotList = db.findAllShots();
		
		if (gameList.isEmpty())
		{
			System.out.println("There are no games listed in the database");
			return 0;
		}else{
			
			return StatsController.getTotalStrikes(shotList);
		}
	}
	
	public static int spareTotal()
	{
		IDatabase db = DatabaseProvider.getInstance();
		List<Game> gameList = db.findAllGames();
		List<Shot> shotList = db.findAllShots();
		
		if (gameList.isEmpty()) {
			System.out.println("There are no games listed in the database");
			return 0;
		}else{

			return StatsController.getTotalSpares(shotList);
		}
	}
	public static void setStrikeTotal(int num)
	{
		IDatabase db = DatabaseProvider.getInstance();
		List<Game> gameList = db.findAllGames();
		List<Shot> shotList = db.findAllShots();
		
		if (gameList.isEmpty()) 
		{
			System.out.println("There are no games listed in the database");
		}else{

			System.out.println(StatsController.getTotalStrikesForSetGames(gameList, shotList, num));
		}
	}
	public static void setSpareTotal(int num)
	{
		IDatabase db = DatabaseProvider.getInstance();
		List<Game> gameList = db.findAllGames();
		List<Shot> shotList = db.findAllShots();
		
		if (gameList.isEmpty())
		{
			System.out.println("There are no games listed in the database");
		}else{

			System.out.println(StatsController.getTotalSparesForSetGames(gameList, shotList, num));
		}
	}
	
	public static double twoDecimals(Double convert) 
	{
		String conversion = new java.text.DecimalFormat("0.00").format(convert);
		
        return Double.parseDouble(conversion);
	}
}
/*public static void main(String[] args) throws Exception {
		Scanner keyboard = new Scanner(System.in);
			
		
		InitDatabase.init(keyboard);
			
		IDatabase db = DatabaseProvider.getInstance();
		List<Game> gameList = db.findAllGames();
		
		//StatsController sc = new StatsController();
		
		if (gameList.isEmpty())
		{
			System.out.println("There are no games listed in the database");
			
		}else{
			System.out.println(StatsController.getTotalGameScore(gameList));
		}
	}*/
 