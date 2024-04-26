package revMetrix.db;

import java.util.ArrayList;
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

public class StatsQuery {
	public static void main(String[] args) throws Exception {
		
		Scanner keyboard = new Scanner(System.in);

		// Create the default IDatabase instance
		InitDatabase.init(keyboard);
		
		int aveGameCount = 0;
		int StrikesPerGame = 0;
		int SparesPerGame = 0;
		double averageGameScore = 0;
		
		// get the DB instance and execute transaction
		IDatabase db = DatabaseProvider.getInstance();
		List<Game> gameList = db.findAllGames();
		List<Shot> shotList = db.findAllShots();
		//ArrayList<Shot> ShotByGame = db.GetShotsByGame(aveGameCount);
		
		//List<Frame> frameList = db.findAllFrames();
		//List<Shot> shotList = db;
		//ArrayList<Pair<Game, Shot>> shotByGame = db.GetShotsByGame(game));
		//List<Shot> shots = db.findShotsByGameId(0);
		
		// check if anything was returned and output the list
		if (gameList.isEmpty()) {
			System.out.println("There are no games listed in the database");
		}
		else {
			for (Game game : gameList) {
				aveGameCount++;
				
				averageGameScore += game.getGameScore();
			}
			
			for (Shot shot : shotList) 
				{	
					if(shot.getShotScore().equals("X"))
					{
						StrikesPerGame++;
					}else if (shot.getShotScore().equals("/"))
					{
						SparesPerGame++;
					}
					//System.out.println(shot.getShotScore());
				}
			
			/*for (Shot shot : ShotByGame) {
			   
			    System.out.println(shot.getShotId());
			}*/
			
			averageGameScore /= aveGameCount;
			
			System.out.print("\nAverage Score Per Game: ");
			twoDecimals(averageGameScore);
			
			System.out.printf("\nStrikes per Game: %d\n", StrikesPerGame);
			
			System.out.printf("Spares per Game: %d\n", SparesPerGame);
			
			System.out.println("\nOut of Games: ");
			System.out.print(aveGameCount);
			
			
			/*for (Frame frame : frameList) 
			{
				//System.out.println(frame.getFrameScore());
				//System.out.println(frame.getFrameId());
			}*/
			
			
		}
	}
	
	public static void twoDecimals(Double convert) 
	{
        System.out.print(new java.text.DecimalFormat("0.00").format(convert));
    }
}