package revMetrix.db.model;

public class Account{
    private int accountId;
    private String email;
    private String password;
    private String firstname;
    private String lastname; 
    private boolean isLoggedIn;
    
    
    public Account(){
    }
    
    public void setAccountId(int accountId){
        this.accountId = accountId;
    }
    
    public int getAccountId(){
        return accountId;
    }
    
    public void setEmail(String email){
        this.email = email;
    }
    
    public String getEmail(){
        return email;
    }
    
    public void setPassword(String password){
        this.password = password;
    }
    
    public String getPassword(){
        return password;
    }
    
    public void setFirstname(String firstname){
        this.firstname = firstname;
    }
    
    public String getFirstname(){
        return firstname;
    }
    
    public void setLastname(String lastname){
        this.lastname = lastname;
    }
    
    public String getLastname(){
        return lastname;
    }
    
    public void setIsLoggedIn(boolean isLoggedIn) {
    	this.isLoggedIn = isLoggedIn;
    }
    
    public boolean isLoggedIn() {
    	return isLoggedIn;
    }
}


