package revMetrix.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import revMetrix.db.model.Ball;
import revMetrix.db.model.Frame;
import revMetrix.db.model.Game;
import revMetrix.db.model.Pair;
import revMetrix.db.model.Shot;
import revMetrix.db.persist.DatabaseProvider;
import revMetrix.db.persist.DerbyDatabase;
import revMetrix.db.persist.IDatabase;

public class GameController {
	private IDatabase db = null;
	
	
	public GameController() {
		DatabaseProvider.setInstance(new DerbyDatabase());
		db = DatabaseProvider.getInstance();
	}
	public static boolean isOver(String[] shots) {
		if (shots == null) {
			return false;
		}
		else {
			System.out.println("Not null");
		}
		if(shots[18]==null||shots[19]==null) {
			return false;
		}
		else {
			System.out.println("Not 1");
		}
		if(!(shots[20]==null)) {
			return true;
		}
		else {
			System.out.println("Not 2");
		}
		if(shots[18].equals("X")) {
			return false;
		}
		else {
			System.out.println("Not 3");
		}
		if(!shots[19].equals("X")&&!shots[19].equals("/")) {
			return true;
		}
		else {
			System.out.println("Not 4");
		}
		
		return false;
	}
	public boolean updateGameScore(int gameId, int score) {
		return db.updateGameScore(gameId, score);
	}
	public static Shot addShot(int num, String pins,String previous, String foul, int ballId) {
		Shot output = new Shot();
		output.setShotNumber(num);
		output.setPins(pins);
		output.setBallId(ballId);
		output.setShotScore(getShotScore(num,pins, previous ,foul));
		output.setSplit(isSplit(num,pins));
		output.setWashout(isWashout(num,pins));
		return output;
	}
	public static Shot addShot(ArrayList<Shot> shots, String pins, String foul, int ballId) {
		Shot output = new Shot();
		int num = 1;
		String previous = null;
		if(shots.size() != 0) {
			Shot prev = shots.get(shots.size()-1);
			
			if(prev.getShotNumber()==1 && !prev.getShotScore().equals("X")) {
				num = 2;
				previous = prev.getPins();
			}
		}
		output.setShotNumber(num);
		if(previous !=null && previous.length()<pins.length()) {
			output.setPins(previous);
		}
		else {
			output.setPins(pins);
		}
		
		output.setBallId(ballId);
		output.setShotScore(getShotScore(num,pins, previous ,foul));
		output.setSplit(isSplit(num,pins));
		output.setWashout(isWashout(num,pins));
		return output;
	}
	public static int frameScore(Shot first, Shot second){
		System.out.println("starting frame Score");
		
		String one = first.getShotScore();
		String two = "-";
		if(second !=null) {
			two = second.getShotScore();
		}
		
		System.out.println(one+"    "+two);
		if (one.equals("X")||two.equals("/")) {
			System.out.println("10");
			return 10;
		}
		int firstScore = 0;
		int secondScore = 0;
		if(!one.equals("-")&&!one.equals("F")) {
			firstScore= Integer.parseInt(one);
			System.out.println(firstScore);
		}
		if(!two.equals("-")&& !two.equals("F")) { 
			secondScore= Integer.parseInt(two);
			System.out.println(secondScore);
		}
		
		return firstScore+secondScore;
	}
	
	public static boolean isStrike(Shot shot) {
		return shot.getShotScore().equals("X");
	}
	public static boolean isSpare(Shot shot) {
		return shot.getShotScore().equals("/");
	}
	
	public static int addScoreStrike(Shot first, Shot second) {
		//System.out.println("Starting ScoreStrike");
		if (first == null) {
			//System.out.println("null");
			return 0;
			
		}
		int out = 0;
		
		String firstShot = first.getShotScore();
		if(firstShot.equals("X")||firstShot.equals("/")) {
			out = 10;
		}
		else if(firstShot.equals("-")||firstShot.equals("F")) {
			out = 0;
		}
		else {
			out = Integer.parseInt(firstShot);
		}
		if(second == null) {
			
			//System.out.println(out);
			return out;
		}
		String secondShot = second.getShotScore();
		if(secondShot.equals("X")) {
			out += 10;
		}
		else if (secondShot.equals("/")) {
			out = 10;
		}
		else if(secondShot.equals("-")||secondShot.equals("F")) {
			out += 0; 
		}
		else {
			out += Integer.parseInt(secondShot);
		}
		//System.out.println(out);
		return out;
	}
	public static int addScoreSpare(Shot first) {
		if (first== null) {
			return 0;
		}
		
		String firstShot = first.getShotScore();
		if(firstShot.equals("X")||firstShot.equals("/")) {
			return 20;
		}
		else if(firstShot.equals("-")||firstShot.equals("F")) {
			return 10;
		}
		
		return 10+Integer.parseInt(firstShot);
	
	
	}
	public void removeShot(Shot shot) {
		db.removeShot(shot.getShotId());
	}
	public void removeFrame(Frame frame) {
		db.removeFrame(frame.getFrameId());
	}
	
	public static String getShotScore(int num, String pins, String previous, String foul) {
		if (!foul.equals("")) {
			return "F";
		}
		String[] standing = pins.split(",");
		if(pins.equals("")) {
			if(num == 1) {
				return "X";
			}
			return "/";
		}
		if (num == 2) {
			int prev = 0;
			if(previous!=null) {
				String[] len = previous.split(",");
				prev = len.length;
				
			}
			
			if(prev - standing.length <= 0) {
				return "-";
			}
			
			
			return (prev - standing.length )  + "";
		}
		if(standing.length == 10) {
			return "-";
		}
		return 10 - standing.length  + "";
	}
	
	public static boolean isSplit(int shotNum, String pins) {
		if(shotNum ==2) {
			return false;
		}
		if(pins.equals("")) {
			return false;
		}
		if (pins.contains("1")){
			return false;
		}
		if(pins.length()==1) {
			return false;
		}
		//String str = "Geeks";
		String[] strSplit = pins.split(","); 
		  
        // Now convert string into ArrayList 
        ArrayList<String> pinList = new ArrayList<String>(Arrays.asList(strSplit)); 
        PinsRemove(pinList.get(0),pinList);
        System.out.println("Split:" + (pinList.size()!=0));
		return pinList.size()!=0;
	}
	public static boolean isWashout(int shotNum, String pins) {
		if(shotNum ==2) {
			return false;
		}
		if (!pins.contains("1")){
			return false;
		}
		if(pins.equals("")) {
			return false;
		}
		if(pins.length()==1) {
			return false;
		}
		
		String[] strSplit = pins.split(","); 
		  
        // Now convert string into ArrayList 
        ArrayList<String> pinList = new ArrayList<String>(Arrays.asList(strSplit)); 
        //System.out.println(pinList);
        PinsRemove("1",pinList);
       //System.out.println(pinList);
		return pinList.size()!=0;
	}
	public static void PinsRemove(String pin, ArrayList<String> List) {
		int i = -1;
		switch(pin) {
		case "1":
			i = List.indexOf("1");
			if(i!=-1) {
				List.remove(i);
				PinsRemove("2",List);
				PinsRemove("3",List);
				PinsRemove("5",List);
			}
			break;
		case "2":
			i = List.indexOf("2");
			if(i!=-1) {
				List.remove(i);
				PinsRemove("1",List);
				PinsRemove("3",List);
				PinsRemove("4",List);
				PinsRemove("5",List);
				PinsRemove("8",List);
			}
			break;
		case "3":
			i = List.indexOf("3");
			if(i!=-1) {
				List.remove(i);
				PinsRemove("1",List);
				PinsRemove("2",List);
				PinsRemove("5",List);
				PinsRemove("6",List);
				PinsRemove("9",List);
			}
			break;
		case "4":
			i = List.indexOf("4");
			if(i!=-1) {
				List.remove(i);
				PinsRemove("2",List);
				PinsRemove("5",List);
				PinsRemove("7",List);
				PinsRemove("8",List);
			}
			break;
		case "5":
			i = List.indexOf("5");
			if(i!=-1) {
				List.remove(i);
				PinsRemove("1",List);
				PinsRemove("2",List);
				PinsRemove("3",List);
				PinsRemove("4",List);
				PinsRemove("6",List);
				PinsRemove("8",List);
				PinsRemove("9",List);
			}
			break;
		case "6":
			i = List.indexOf("6");
			if(i!=-1) {
				List.remove(i);
				PinsRemove("3",List);
				PinsRemove("5",List);
				PinsRemove("9",List);
				PinsRemove("0",List);
			}
			break;
		case "7":
			i = List.indexOf("7");
			if(i!=-1) {
				List.remove(i);
				PinsRemove("4",List);
				PinsRemove("8",List);
			}
			break;
		case "8":
			i = List.indexOf("8");
			if(i!=-1) {
				List.remove(i);
				PinsRemove("2",List);
				PinsRemove("4",List);
				PinsRemove("5",List);
				PinsRemove("7",List);
				PinsRemove("9",List);
				
			}
			break;
		case "9":
			i = List.indexOf("9");
			if(i!=-1) {
				List.remove(i);
				PinsRemove("3",List);
				PinsRemove("5",List);
				PinsRemove("6",List);
				PinsRemove("8",List);
				PinsRemove("0",List);
				
			}
			break;
		case "0":
			i = List.indexOf("0");
			if(i!=-1) {
				List.remove(i);
				PinsRemove("9",List);
				PinsRemove("6",List);
				
			}
			break;
		default:
	
			break;
	
		}
	}
	
	public static String[] parseShots(List<Shot> shots){
		String [] output = new String[26];
		int index = 0;
		for (Shot shot:shots) {
			output[index]=shot.getShotScore();
			if(output[index].equals("X") && index<18) {
				index++;
			}
			index++;
		}
		return output;
 	}
	public void updateframeScores(ArrayList<Frame> frames, ArrayList<Shot> shots) {
		int shotIndex = 0;
		int FrameIndex = 0;
		
		while (FrameIndex< frames.size()) {
			//System.out.println(shotIndex+" "+FrameIndex);
			if(shotIndex<shots.size() && isStrike(shots.get(shotIndex))) {
				Shot first = null;
				Shot second = null;
				if(shotIndex+1<shots.size()) {
					first = shots.get(shotIndex+1);
				}
				if(shotIndex+2<shots.size()) {
					second = shots.get(shotIndex+2);
				}
				frames.get(FrameIndex).setFrameScore(10+ addScoreStrike(first,second));
				updateFrameScore(frames.get(FrameIndex).getFrameId(),frames.get(FrameIndex).getFrameScore());
				shotIndex --;
			}
			else if(shotIndex+1<shots.size() && isSpare(shots.get(shotIndex+1))) {
				Shot first = null;
				
				if(shotIndex+2<shots.size()) {
					first = shots.get(shotIndex+2);
					//System.out.println("spare "+first.getShotScore());
					frames.get(FrameIndex).setFrameScore(addScoreSpare(first));
				}
				
				
			}
			FrameIndex++;
			shotIndex+=2;
		}
		
	}
	public static Integer[] parseScores(ArrayList<Frame> frames, ArrayList<Shot> shots) {
		Integer[] output = new Integer[11];
		int i = 0;
		int total = 0;
		for(Frame frame:frames) {
			if(i<10) {
			total += frame.getFrameScore();
			output[i] = total;
			//System.out.println("Score: "+frame.getFrameScore());
			i++;
			}
		}
		output[10] = total;
		return output;
		
	}
	
	public static Frame addFrame(Shot first, Shot second, String lanes) {
		Frame output = new Frame();
		output.setFrameScore(frameScore(first,second));
		return output;
	}
	
	public static boolean checkError(String first, String second) {
		return first.length()>=second.length();
	}
	public List<Ball> getAllBalls(){
		
		return db.findAllBalls();
		
	}
	public ArrayList<Shot> GetShotsByGame(int id){
		
		return db.GetShotsByGame(id);
	}
	public ArrayList<Frame> GetFramesByGame(int id){
		return db.GetFrameByGame(id);
	}
	public void updateFrameScore(int frameId, int newScore) {
		db.updateFrameScore(frameId, newScore);
	}
	public ArrayList<Game> GetGamesBySession(int id){
		return db.GetGamesBySession(id);
	}
	public int newGame() {
		Game game = new Game();
		game.setGameScore(0);
		game.setHandicap(0);
		game.setOpponent("");
		game.setStartingLane(0);
		return db.addGame(game);
	}
	public int storeFrame(Frame frame) {
		return db.addFrame(frame);
	}
	public int storeShot(int gameId, int frameId, Shot shot,int sessionID) {
		return db.addShot(gameId, frameId, shot, sessionID);
	}
	public static String[] getWashouts(ArrayList<Shot> shots) {
		ArrayList<Shot> firstShots = new ArrayList<Shot>();
		for(Shot shot:shots) {
			if(shot.getShotNumber()==1) {
				firstShots.add(shot);
			}
		}
		
		String[] output = new String[9];
		for(int i = 0; i<=9&&i<firstShots.size(); i++) {
			if(firstShots.get(i).getWashout()) {
				output[i]="w";
			}
		}
		return output;
	}
	public static boolean[] getSplits(ArrayList<Shot> shots) {
		ArrayList<Shot> firstShots = new ArrayList<Shot>();
		for(Shot shot:shots) {
			if(shot.getShotNumber()==1) {
				firstShots.add(shot);
			}
		}
		
		boolean[] output = new boolean[11];
		for(int i = 0; i<=11&&i<firstShots.size(); i++) {
			if(firstShots.get(i).getSplit()) {
				output[i]=true;
			}
		}
		return output;
	}
	public static boolean[] getLockout(String pins) {
		boolean[] output = {true,true,true,true,true,true,true,true,true,true};
		if(pins.length()==0) {
			return output;
		}
		String[] strSplit = pins.split(","); 
        for(String s: strSplit) {
        	output[Integer.parseInt(s)]= false;
        }
		
		return output;
	}
	
	
	
	
}