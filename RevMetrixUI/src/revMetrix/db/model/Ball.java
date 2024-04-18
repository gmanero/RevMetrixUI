package revMetrix.db.model;

public class Ball{
    private int ballId;
    private int weight;
    private String color;
    private String name; 
    
    
    public Ball() {
    	
    }
    
    public void setBallId(int ballId){
        this.ballId = ballId;
    }
    
    public int getBallId(){
        return ballId;
    }
    
    public void setWeight(int weight){
        this.weight = weight;
    }
    
    public int getWeight(){
        return weight;
    }
    
    public void setColor(String color){
        this.color = color;
    }
    
    public String getColor(){
        return color;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public String getName(){
        return name;
    }
}
