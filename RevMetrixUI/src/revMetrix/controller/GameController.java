package revMetrix.controller;

import java.util.ArrayList;

import revMetrix.db.model.Frame;
import revMetrix.db.model.Pair;
import revMetrix.db.model.Shot;

public class GameController {
	public static Shot addShot(int num, String pins,String previous, String foul, int ballId) {
		Shot output = new Shot();
		output.setShotNumber(num);
		output.setPins(pins);
		output.setBallId(ballId);
		output.setShotScore(getShotScore(num,pins, previous ,foul));
		output.setSplit(isSplit(pins));
		output.setWashout(isWashout(pins));
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
	
	public static boolean isSplit(String pins) {
		//to do implement
		return false;
	}
	public static boolean isWashout(String pins) {
		//to do implement
			return false;
	}
	
	public static String[] parseShots(ArrayList<Shot> shots){
		String [] output = new String[22];
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
	public static void updateframeScores(ArrayList<Frame> frames, ArrayList<Shot> shots) {
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
				frames.get(frames.size()-2).setFrameScore(10+addScoreSpare(shots.get(last[0])));
				
			}
		}
	
		if(last[2]!=null) {
			if(isStrike(shots.get(last[2]))){
				
				frames.get(frames.size()-3).setFrameScore(10+addScoreStrike(shots.get(last[1]),shots.get(last[0])));
			}
		}
		
	}
	public static int[] parseScores(ArrayList<Frame> frames, ArrayList<Shot> shots) {
		int[] output = new int[11];
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
	
	
	
	
	
}