package revMetrix.controller;

public class TournamentController {
	private static int lastGeneratedTournamentId = 0;

    // Method to generate a new tournament ID
    public static int generateNewId() {
        return lastGeneratedTournamentId++;
    }

    // Method to get the last generated ID
    public static int getLastGeneratedId() {
        return lastGeneratedTournamentId;
    }

}