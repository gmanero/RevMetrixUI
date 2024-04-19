package revMetrix.db.model;

public class Junction {
    private int sessionId;
    private int frameId;
    private int gameId;
    private int shotId;
    
    public Junction() {
        
    }
    
    public void setSessionId(int sessionId) {
        this.sessionId = sessionId;
    }
    
    public int getSessionId() {
        return sessionId;
    }
    
    public void setFrameId(int frameId) {
        this.frameId = frameId;
    }
    
    public int getFrameId() {
        return frameId;
    }
    
    public void setGameId(int gameId) {
        this.gameId = gameId;
    }
    
    public int getGameId() {
        return gameId;
    }
    
    public void setShotId(int shotId) {
        this.shotId = shotId;
    }
    
    public int getShotId() {
        return shotId;
    }
}
