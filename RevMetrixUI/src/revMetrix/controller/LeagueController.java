package revMetrix.controller;

public class LeagueController {
	private static int lastGeneratedLeagueId = 0;

    // Method to generate a new tournament ID
    public static int generateNewId() {
        return lastGeneratedLeagueId++;
    }

    // Method to get the last generated ID
    public static int getLastGeneratedId() {
        return lastGeneratedLeagueId;
    }

}