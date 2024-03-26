package revMetrix.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import revMetrix.model.RevMetrix;

import revMetrix.model.RevMetrix.Account; 


public class AccountCreationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		System.out.println("Event Servlet: doGet");
		
		req.getRequestDispatcher("/_view/accountCreation.jsp").forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		System.out.println("AccountCreation Servlet: doPost");
		
		
		  String destIn = req.getParameter("destination");
	        String destOut = null;
	        
	        
	        // Forward based on the action parameter
	        if ("revMetrix".equals(destIn)) {
	           destOut = "/_view/index.jsp";
	        } 
	        else if ("login".equals(destIn)) {
	        	 destOut = "/_view/login.jsp";
	        } 
	        else if ("event".equals(destIn)) {
	        	 destOut = "/_view/event.jsp";
	        } 
	        else if ("register".equals(destIn)) {
	        	destOut = "/_view/registration.jsp";
	        } 
	        else if ("account".equals(destIn)) {
	        	destOut = "/_view/account.jsp";
	        }  
	        else if ("game".equals(destIn)) {
	        	destOut = "/_view/game.jsp";
	        } 
	        else if ("stats".equals(destIn)) {
	        	destOut = "/_view/stats.jsp";	
	        } 
	        else if ("create".equals(destIn)) {
	        	destOut = "/_view/create.jsp";
	        } 
	        else if ("createLeague".equals(destIn)) {
	        	destOut = "/_view/createLeague.jsp";
	        }
	       	else if ("createPractice".equals(destIn)) {
	        	destOut = "/_view/createPractice.jsp";
	        }
	        else if ("createTournament".equals(destIn)) {
	        	destOut = "/_view/createTournament.jsp";
	        }
	        else if ("leagues".equals(destIn)) {
	        	destOut = "/_view/leagues.jsp";
	        }
	        else if ("practices".equals(destIn)) {
	        	destOut = "/_view/practices.jsp";
	        }
	        else if ("tournaments".equals(destIn)) {
	        	destOut = "/_view/tournaments.jsp";
	        }
	        else if ("yourGames".equals(destIn)) {
	        	destOut = "/_view/yourGames.jsp";
	        }
	        else if ("accountCreation".equals(destIn)) {
	        	destOut = "/_view/accountCreation.jsp";
	        }
	        else {
	           destOut = "/_view/accountCreation.jsp";
	        }
	        req.getRequestDispatcher(destOut).forward(req, resp);
		
		
		
		// holds the error message text, if there is any
		String errorMessage = null;
		
		

		// decode POSTed form parameters and dispatch to controller
		try {
			RevMetrix.Account Account = new Account("djhake2@ycp.edu", "Don", "Hake", false);
			RevMetrix.AccountsList.add(Account);
			
			String Email = req.getParameter("email");
			String Username = req.getParameter("user");
			String Password = req.getParameter("pass");
			
			
			
			// check for errors in the form data 
			if (Email == null || Username == null || Password == null) {
				errorMessage = "Missing Required Data";
			}else {
				
				// PUT IN CONTROLLER
				for(RevMetrix.Account Account1 : RevMetrix.AccountsList)
				{
					if (Email.equals(RevMetrix.Account.getEmail()))
	    			{
						errorMessage = "Email Already In Uses";
						break;
	    			}else{
	    				if (Username.equals(RevMetrix.Account.getUsername()) )
		   				{
		   					errorMessage = "Username Already Taken";
		   					break;
		   				}else{
		    				Account1 = new Account(Email, Username, Password, false);
		    				RevMetrix.AccountsList.add(Account1);
		   				}
	    			}
				}
				
				if (errorMessage.isEmpty())
				{
					RevMetrix.Account account = new RevMetrix.Account(Email, Username, Password, false);
					RevMetrix.AccountsList.add(account);
				}
				
				
			}
		} catch (Exception e) {
			errorMessage = "Type Error - Needs fixing";
		}
		req.setAttribute("errorMessage", errorMessage);
		
		req.getRequestDispatcher("/_view/addNumbers.jsp").forward(req, resp);
	}
}
