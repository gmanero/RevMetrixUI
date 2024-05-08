package revMetrix.db.model;

public class Game {
    private int gameId;
    private int gameScore;
    private int startingLane;
    private String opponent;
    private int handicap;
    private boolean done;
    
    public Game() {
    	
    }
    
    public void setGameId(int gameId) {
        this.gameId = gameId;
    }
    
    public int getGameId() {
        return gameId;
    }
    
    public void setGameScore(int gameScore) {
        this.gameScore = gameScore;
    }
    
    public int getGameScore() {
        return gameScore;
    }
    
    public void setStartingLane(int startingLane) {
        this.startingLane = startingLane;
    }
    
    public int getStartingLane() {
        return startingLane;
    }
    
    public void setOpponent(String opponent) {
        this.opponent = opponent;
    }
    
    public String getOpponent() {
        return opponent;
    }
    
    public void setHandicap(int handicap) {
        this.handicap = handicap;
    }
    
    public int getHandicap() {
        return handicap;
    }
    public void setdone(boolean done) {
    	this.done=done;
    }
    
    public boolean getdone() {
    	return done;
    }
    public String getdoneBox() {
    	if(done) {
    		return "\u2713";
    	}
    	return"";
    }
}
