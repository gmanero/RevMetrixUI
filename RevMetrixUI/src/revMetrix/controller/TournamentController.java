package revMetrix.controller;

public class TournamentController {
	private static int lastGeneratedId = 0;

    // Method to generate a new tournament ID
    public static int generateNewId() {
        return lastGeneratedId++;
    }

    // Method to get the last generated ID
    public static int getLastGeneratedId() {
        return lastGeneratedId;
    }

}