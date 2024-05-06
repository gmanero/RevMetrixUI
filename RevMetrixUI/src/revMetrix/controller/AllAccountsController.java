package revMetrix.controller;

import revMetrix.db.model.Account;
import revMetrix.db.model.Ball;
import revMetrix.db.persist.DatabaseProvider;
import revMetrix.db.persist.DerbyDatabase;
import revMetrix.db.persist.IDatabase;

import java.util.ArrayList;
import java.util.List;

public class AllAccountsController {
   

    private IDatabase db = null;

    public AllAccountsController() {
        // Creating DB instance here
        DatabaseProvider.setInstance(new DerbyDatabase());
        db = DatabaseProvider.getInstance();
    }

    public List<Account> getAllAccounts() {
        List<Account> accountList = db.findAllAccounts();
        ArrayList<Account> accounts = null;

        if (accountList.isEmpty()) {
            System.out.println("No accounts found");
            return null;
        } else {
            accounts = new ArrayList<>();
            for (Account account : accountList) {
                accounts.add(account);
                System.out.println(account.getEmail() + ", " + account.getPassword() + ", " + account.getFirstname() + ", " + account.getLastname() + ", " + account.isLoggedIn());
            }
        }

        return accounts;
    }
    
    public void logInAccount(String email, String password) {
        db.logInAccount(email, password);
        System.out.println("Account logged in: " + email);
    }

    public void logOutAllAccounts() {
        db.logOutAllAccounts();
        System.out.println("All accounts logged out");
    }
    
    public boolean isLoggedInAccount() {
    	System.out.println("Accounts logged in found");
        return db.isLoggedInAccount();
    }
    

    public List<Ball> findAllBalls() {
    	List<Ball> ballList = db.findAllBalls();
    	ArrayList<Ball> balls = null;
    	
    	if(ballList.isEmpty()) {
    		 System.out.println("No Balls found");
             return null;
    	}else {
    		balls = new ArrayList<>();
    		for (Ball ball : ballList) {
    			balls.add(ball);
    			System.out.println(ball.getColor()+" "+ball.getName()+" "+ ball.getWeight());
    		}
    	}
        return balls;
    }

    public Integer insertBallIntoBallsTable(int weight, String color, String name) {
        Integer ballId = db.insertBallIntoBallsTable(weight, color, name);

        if (ballId > 0) {
            System.out.println("New ball inserted into Balls table with ID: " + ballId);
        } else {
            System.out.println("Error inserting ball into Balls table");
        }

        return ballId;
    }
    
    public String findLoggedInUser() {
        return db.findLoggedInUser();
    }
    
    public boolean authenticate(String email, String password) {
        // Implement authentication logic using your existing methods
        // For example:
        List<Account> accounts = getAllAccounts();
        for (Account account : accounts) {
            if (account.getEmail().equals(email) && account.getPassword().equals(password)) {
                // Update isLoggedIn to true
                // This part is not implemented in the provided code. You need to add logic to update isLoggedIn in the database.
                return true;
            }
            
            
        }
        return false;
    }
}
