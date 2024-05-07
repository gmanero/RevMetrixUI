package revMetrix.controller;

import revMetrix.db.model.Shot;
import revMetrix.db.model.Frame;
import revMetrix.db.model.Game;
import revMetrix.db.model.Session;
import revMetrix.db.model.Junction;
import revMetrix.db.model.Event;
import revMetrix.db.model.LeagueSheet;
import revMetrix.db.persist.DatabaseProvider;
import revMetrix.db.persist.DerbyDatabase;
import revMetrix.db.persist.IDatabase;

import java.util.ArrayList;
import java.util.List;

public class LeagueSheetController {

    private IDatabase db = null;
    public LeagueSheetController() {
        // Creating DB instance here
        DatabaseProvider.setInstance(new DerbyDatabase());
        db = DatabaseProvider.getInstance();
    }
    
    public ArrayList<LeagueSheet> getLeagueSheet() {
        List<Session> sessionList = db.findAllSessions();
        List<Junction> junctionList = db.findAllJunctions();

        ArrayList<LeagueSheet> leagueSheetFinal = new ArrayList<>();

        if (sessionList.isEmpty() ) {
            System.out.println("ERROR: SessionList is empty");
            return leagueSheetFinal;
        } else {
            int sessionNum = 1;
            int totGames = 3;
            int totStrike = 0;
            int totFrame = 0;
            int totSpare = 0;
            int totSecShot = 0;

            for (Session session : sessionList) { //iterate through each session
                if (session.getEventId()!=6) {
                    List<Game> gameList = db.GetGamesBySession(sessionNum);

                    if (!gameList.isEmpty()) {
                        LeagueSheet leagueSheet = new LeagueSheet("","","",0,0,0,0,0,0,"","",0,"","",0);
                        List<Event> eventList = db.findAllEvents();

                        leagueSheet.setDate(session.getDate());    //DATE
                        //============================================
                        int eventTempCount = 1;
                        for (Event event : eventList) {
                            if (event.getEventId() == eventTempCount) {
                                leagueSheet.setLge(generateAbbreviation(event.getName())); //LGE
                                break;
                            }
                        }
                        //===============================================
                        leagueSheet.setLanes(session.getLanes()); //LANES
                        //===============================================
                        int game1Score = 0;
                        Game game1 = gameList.get(0);
                        game1Score = game1.getGameScore();
                        leagueSheet.setGame1(game1Score); //GAME 1
                        //========================================
                        int game2Score = 0;
                        Game game2 = gameList.get(1);
                        game2Score = game2.getGameScore();
                        leagueSheet.setGame2(game2Score); //GAME 2
                        //========================================
                        int game3Score = 0;
                        Game game3 = gameList.get(2);
                        game3Score = game3.getGameScore();
                        leagueSheet.setGame3(game3Score); //GAME 3
                        //========================================
                        leagueSheet.setSeries(game1Score+game2Score+game3Score); //SERIES
                        //===============================================================
                        leagueSheet.setTotalGames(totGames); //GAMES
                        totGames += 3;
                        //==========================================
                        leagueSheet.setAverage((game1Score+game2Score+game3Score)/3); //AVERAGE
                        //=====================================================================
                        int tempStrikeTot = 0;
                        int tempFrameTot = 0;
                        int tempSpareTot = 0;
                        int tempSecShotTot = 0;
                        List<Shot> shot1List = db.GetShotsByGame(game1.getGameId());
                        for (Shot shot : shot1List) {
                            if (shot.getShotScore().equals("X")) { //for strike
                                tempStrikeTot++;
                            }
                            if (shot.getShotScore().equals("/")) { //for spare
                                tempSpareTot++;
                            }
                            if (shot.getShotNumber()==1 && shot.getWashout()==false && shot.getSplit()==false && !shot.getShotScore().equals("X")) {
                                tempSecShotTot++;
                            }
                            tempFrameTot++;
                        }
                        List<Shot> shot2List = db.GetShotsByGame(game2.getGameId());
                        for (Shot shot : shot2List) {
                            if (shot.getShotScore().equals("X")) { //for strike
                                tempStrikeTot++;
                            }
                            if (shot.getShotScore().equals("/")) { //for spare
                                tempSpareTot++;
                            }
                            if (shot.getShotNumber()==1 && shot.getWashout()==false && shot.getSplit()==false && !shot.getShotScore().equals("X")) {
                                tempSecShotTot++;
                            }
                            tempFrameTot++;
                        }
                        List<Shot> shot3List = db.GetShotsByGame(game3.getGameId());
                        for (Shot shot : shot3List) {
                            if (shot.getShotScore().equals("X")) { //for strike
                                tempStrikeTot++;
                            }
                            if (shot.getShotScore().equals("/")) { //for spare
                                tempSpareTot++;
                            }
                            if (shot.getShotNumber()==1 && shot.getWashout()==false && shot.getSplit()==false && !shot.getShotScore().equals("X")) {
                                tempSecShotTot++;
                            }
                            tempFrameTot++;
                        }
                        leagueSheet.setStrikes(String.valueOf(tempStrikeTot)+"-"+String.valueOf(tempFrameTot)); //STRIKES
                        totStrike += tempStrikeTot;
                        totFrame += tempFrameTot;
                        //================================================================================================
                        leagueSheet.setStrikeTotal(String.valueOf(totStrike)+"-"+String.valueOf(totFrame)); //STRIKE TOTAL
                        //================================================================================================
                        leagueSheet.setStrikeAverage((double) totStrike / totFrame); //STRIKE AVG
                        //=================================================================================
                        leagueSheet.setSpares(String.valueOf(tempSpareTot)+"-"+String.valueOf(tempSecShotTot)); //SPARE
                        totSpare += tempSpareTot;
                        totSecShot += tempSecShotTot;
                        //=============================================================================================
                        leagueSheet.setSpareTotal(String.valueOf(totSpare)+"-"+String.valueOf(totSecShot)); //SPARE TOTAL
                        //===================================================================================================
                        leagueSheet.setSpareAverage((double) totSpare / totSecShot); //SPARE AVG
                        //======================================================================

                        leagueSheetFinal.add(leagueSheet);
                    } else {
                        System.out.println("Skipping session " + sessionNum + " because gameList is empty.");
                    }

                    sessionNum++;
                }
            }
        }
        return leagueSheetFinal;
    }
    
    
    //find first letter of each word; for league abbreviation in sheet
    public static String generateAbbreviation(String input) {
        if (input == null || input.isEmpty()) {
            return "";
        }

        StringBuilder abbreviation = new StringBuilder();

        // Split the input string into words
        String[] words = input.split("[\\s-]+");

        // Iterate over each word and append the first letter to the abbreviation
        for (String word : words) {
            if (!word.isEmpty()) {
                abbreviation.append(Character.toUpperCase(word.charAt(0)));
            }
        }

        return abbreviation.toString();
    }

}
