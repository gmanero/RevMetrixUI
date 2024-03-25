package revMetrix.controller;

public class GameController {
	public static void addShot() {
		return;
	}
	public static void findScore() {
		return;
	}
	public static void incrementShot() {
		return;
	}
	public static void deincrementShot() {
		return;
	}
	
	public static boolean[] getPins(String numbers) {
        boolean[] pins = {false, false, false, false, false, false, false, false, false, false};
        if (numbers != null && !numbers.equals("") && !numbers.equals("G,") && !numbers.equals("F,")) {
            String[] values = numbers.split(",");
            for (String s : values) {
                try {
                    pins[Integer.parseInt(s.trim()) - 1] = true;
                } catch (NumberFormatException e) {
                    System.out.println("ERROR: Invalid integer");
                }
            }
        } else {
        	System.out.println("ERROR: Invalid input");
        }
        
        return pins;
	}
	
	public static int getScore(boolean[] pins) {
		int score = 0;
		 for (boolean pin : pins) {
	           	if (pin) {
	           		score++;
	         }
	      }
		return score;
	}
}