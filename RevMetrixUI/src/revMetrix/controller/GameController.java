package revMetrix.controller;

import revMetrix.db.model.Shot;

public class GameController {
	public static Shot addShot(int num, String pins, String foul, int ballId) {
		Shot output = new Shot();
		output.setShotNumber(num);
		output.setPins(pins);
		output.setBallId(ballId);
		output.setShotScore(getShotScore(num,pins,foul));
		output.setSplit(isSplit(pins));
		output.setWashout(isWashout(pins));
		return output;
	}
	public static void findScore() {
		
	}
	public static void incrementShot() {
		
	}
	public static void deincrementShot() {
		
	}
	public static String getShotScore(int num, String pins, String foul) {
		if (!foul.equals("")) {
			return "F";
		}
		String[] standing = pins.split(",");
		if(standing.length == 0) {
			if(num == 1) {
				return "X";
			}
			return "/";
		}
		if(standing.length == 10) {
			return "-";
		}
		return 10 - standing.length + "";
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