package revMetrix.db.model;

public class Frame {
    private int frameId;
    private int frameScore;
    private int lane;
    
    
    public Frame() {
    	
    }
    
    public void setFrameId(int frameId) {
        this.frameId = frameId;
    }
    
    public int getFrameId() {
        return frameId;
    }
    
    public void setFrameScore(int frameScore) {
        this.frameScore = frameScore;
    }
    
    public int getFrameScore() {
        return frameScore;
    }
    
    public void setLane(int lane) {
        this.lane = lane;
    }
    
    public int getLane() {
        return lane;
    }
}
