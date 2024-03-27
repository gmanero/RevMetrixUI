package revMetrix.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import revMetrix.model.RevMetrix;

import revMetrix.model.RevMetrix.Account; 

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		System.out.println("Login Servlet: doGet");
		
		req.getRequestDispatcher("/_view/login.jsp").forward(req, resp);
	}
		
		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp)
				throws ServletException, IOException {
			
			System.out.println("LoginServlet Servlet: doPost");
			
			// holds the error message text, if there is any
			String errorMessage = null;
			
			

			// decode POSTed form parameters and dispatch to controller
			try {
				
				String Username = req.getParameter("user");
				String Password = req.getParameter("pass");
				
				
				
				
				
				// check for errors in the form data 
				if (Username == null || Password == null) {
					errorMessage = "Missing Required Data";
				}else {
					
					// PUT IN CONTROLLER
					for(Account Account : RevMetrix.AccountsList)
					{
						if (Username.equals(RevMetrix.Account.getUsername()))
		    			{
							if (Password.equals(RevMetrix.Account.getPassword()))
			   				{
								System.out.println("RedirectServlet");
								req.setAttribute("username", req.getParameter("username"));
								req.setAttribute("password", req.getParameter("password"));
			   				}else{
			    				errorMessage = "Incorrect Password";
			   					break;
			   				}
		    			}else{
		    				errorMessage = "Username not Registered";
							break;
		    			}
					}
					
					
				}
			} catch (Exception e) {
				errorMessage = "Type Error - Needs fixing";
			}
			req.setAttribute("errorMessage", errorMessage);
			
			req.getRequestDispatcher("/_view/addNumbers.jsp").forward(req, resp);
		}
	
}

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
