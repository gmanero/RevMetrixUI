package revMetrix.controller;

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
		String one = first.getShotScore();
		String two = second.getShotScore();
		System.out.println(one+"    "+two);
		if (one.equals("X") || two.equals("/")) {
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
	public static int frameScore(Shot first){
		return 10;
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
	
	
	
	
	
}