package revMetrix.controller;

public class PracticeController {
	private static int lastGeneratedPracticeId = 0;

    // Method to generate a new tournament ID
    public static int generateNewId() {
        return lastGeneratedPracticeId++;
    }

    // Method to get the last generated ID
    public static int getLastGeneratedId() {
        return lastGeneratedPracticeId;
    }

}