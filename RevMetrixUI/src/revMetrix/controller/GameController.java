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
	    boolean[] pins = {false,false,false,false,false,false,false,false,false,false};
	    if (numbers != null && !numbers.equals("") && !numbers.equals("G,") && !numbers.equals("F,")) {
	        String[] values = numbers.split(",");
	        for (String s : values) {
	            try {
	                int index = Integer.parseInt(s.trim()) - 1;
	                if (index >= 0 && index < pins.length) {
	                    pins[index] = true;
	                } else {
	                	System.out.println("ERROR: Invalid index");
	                }
	            } catch (NumberFormatException e) {
	            	System.out.println("ERROR: Invalid integer");
	            }
	        }
	    }
	    System.out.println(pins);
	    return pins;
	}

}