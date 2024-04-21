package revMetrix.db.model;

public class Shot {
    private int shotId;
    private int shotNumber;
    private String pins;
    private int ballId;
    private boolean split;
    private boolean washout;
    private String shotScore;
    
    public Shot() {
    	
    }
    
    public void setShotId(int shotId) {
        this.shotId = shotId;
    }
    
    public int getShotId() {
        return shotId;
    }
    
    public void setShotNumber(int shotNumber) {
        this.shotNumber = shotNumber;
    }
    
    public int getShotNumber() {
        return shotNumber;
    }
    
    public void setPins(String pins) {
        this.pins = pins;
    }
    
    public String getPins() {
        return pins;
    }
    
    public void setBallId(int ballId) {
        this.ballId = ballId;
    }
    
    public int getBallId() {
        return ballId;
    }
    
    public void setSplit(boolean split) {
        this.split = split;
    }
    
    public boolean getSplit() {
        return split; 
    }
    
    public void setWashout(boolean washout) {
        this.washout = washout;
    }
    
    public boolean getWashout() {
        return washout;
    }
    
    public void setShotScore(String shotScore) {
        this.shotScore = shotScore;
    }
    
    public String getShotScore() {
        return shotScore;
    }
}
 