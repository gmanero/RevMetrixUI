package revMetrix.db.model;

public class Event {
    private int eventId;
    private int type; 
    private int establishmentId;
    private String name;
    private String description;
    
  //1 = practice, 2= league, 3= tourney
    
    public Event() {
    	
    }
    
    public void setEventId(int eventId) {
        this.eventId = eventId;
    }
    
    public int getEventId() {
        return eventId;
    }
    
    public void setType(int type) {
        this.type = type;
    }
    
    public int getType() {
        return type;
    }
    
    public void setEstablishmentId(int establishmentId) {
        this.establishmentId = establishmentId;
    }
    
    public int getEstablishmentId() {
        return establishmentId;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getName() {
        return name;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    public String getDescription() {
        return description;
    }
}
