package revMetrix.db.model;

public class Establishment{
    private int establishmentId;
    private String name; 
    private String address;
    private String phoneNumber;
    private int lanes;
    
    
    public Establishment() {
    	
    }
    
    public void setEstablishmentId(int establishmentId){
        this.establishmentId = establishmentId;
    }
    
    public int getEstablishmentId(){
        return establishmentId;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public String getName(){
        return name;
    }
    
    public void setAddress(String address){
        this.address = address;
    }
    
    public String getAddress(){
        return address;
    }
    
    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }
    
    public String getPhoneNumber(){
        return phoneNumber;
    }
    
    public void setLanes(int lanes){
        this.lanes = lanes;
    }
    
    public int getLanes(){
        return lanes;
    }
}
