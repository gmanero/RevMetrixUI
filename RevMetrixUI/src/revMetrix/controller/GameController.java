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
	public static int frameScore(Shot first, Shot second){
		System.out.println("starting frame Score");
		if(second== null) {
			return 10;
		}
		String one = first.getShotScore();
		String two = second.getShotScore();
		System.out.println(one+"    "+two);
		if (two.equals("/")) {
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
		System.out.println("Starting ScoreStrike");
		if (first == null) {
			System.out.println("null");
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
			
			System.out.println(out);
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
		System.out.println(out);
		return out;
	}
	public static int addScoreSpare(Shot first) {
		if (first== null) {
			return 0;
		}
		
		String firstShot = first.getShotScore();
		if(firstShot.equals("X")||firstShot.equals("/")) {
			return 10;
		}
		else if(firstShot.equals("-")||firstShot.equals("F")) {
			return 0;
		}
		
		return Integer.parseInt(firstShot);
	
	
	}
	public static void incrementShot() {
		
	}
	public static void deincrementShot() {
		
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
			
			if(prev - standing.length == 0) {
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
        PinsRemove(pinList.get(0),pinList);
       
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
				PinsRemove("5",List);
				PinsRemove("6",List);
				PinsRemove("9",List);
			}
			break;
		case "4":
			i = List.indexOf("4");
			if(i!=-1) {
				List.remove(i);
				PinsRemove("5",List);
				PinsRemove("7",List);
				PinsRemove("8",List);
			}
			break;
		case "5":
			i = List.indexOf("5");
			if(i!=-1) {
				List.remove(i);
				PinsRemove("6",List);
				PinsRemove("8",List);
				PinsRemove("9",List);
			}
			break;
		case "6":
			i = List.indexOf("6");
			if(i!=-1) {
				List.remove(i);
				PinsRemove("9",List);
				PinsRemove("0",List);
			}
			break;
		case "7":
			i = List.indexOf("7");
			if(i!=-1) {
				List.remove(i);
				PinsRemove("8",List);
			}
			break;
		case "8":
			i = List.indexOf("8");
			if(i!=-1) {
				List.remove(i);
				PinsRemove("9",List);
				
			}
			break;
		case "9":
			i = List.indexOf("9");
			if(i!=-1) {
				List.remove(i);
				PinsRemove("0",List);
				
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
		int index = shots.size()-1;
		Integer last[]= new Integer[3];
		int i = 0;
		while(index>=0&&i<3) {
			if(shots.get(index).getShotNumber()==2) {
				last[i] = index -1;
				index -=2;
			}
			else {
				last[i] = index;
				index --;
			}
			i++;
		}
		if(last[1]!=null) {
			
			if(last[1]+1<shots.size()&&isSpare(shots.get(last[1]+1))){
				Frame updated =frames.get(frames.size()-2);
				updated.setFrameScore(10+addScoreSpare(shots.get(last[0])));
				updateFrameScore(updated.getFrameId(),10+addScoreSpare(shots.get(last[0])));
				
			}
			
		}
	
		if(last[2]!=null) {
			if(isStrike(shots.get(last[2]))){
				Frame updated =frames.get(frames.size()-3);
				updated.setFrameScore(10+addScoreStrike(shots.get(last[1]),shots.get(last[0])));
				updateFrameScore(updated.getFrameId(),updated.getFrameScore());
			}
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
	public int storeShot(int gameId, int frameId, Shot shot) {
		return db.addShot(gameId, frameId, shot);
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
	
	
	
	
}