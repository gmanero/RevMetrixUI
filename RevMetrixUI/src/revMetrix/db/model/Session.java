package revMetrix.db.model;

public class Session {
    private int sessionId;
    private int sessionScore;
    private int eventId;
    private String lanes;
    private String date;
    private int userId;
    
    public Session() {
    	
    }
    
    public void setSessionId(int sessionId) {
        this.sessionId = sessionId;
    }
    
    public int getSessionId() {
        return sessionId;
    }
    
    public void setSessionScore(int sessionScore) {
        this.sessionScore = sessionScore;
    }
    
    public int getSessionScore() {
        return sessionScore;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }
    
    public int getEventId() {
        return eventId;
    }
    
    public void setLanes(String lanes) {
        this.lanes = lanes;
    }
    
    public String getLanes() {
        return lanes;
    }
    
    public void setDate(String date) {
        this.date = date;
    }
    
    public String getDate() {
        return date;
    }
    
    public void setUserId(int userId) {
        this.userId = userId;
    }
    
    public int getUserId() {
        return userId;
    }
}
