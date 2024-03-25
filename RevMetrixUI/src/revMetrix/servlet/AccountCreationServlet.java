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
		
		// holds the error message text, if there is any
		String errorMessage = null;

		// decode POSTed form parameters and dispatch to controller
		try {
			
			String Email = req.getParameter("email");
			String Username = req.getParameter("user");
			String Password = req.getParameter("pass");
			
			
			
			// check for errors in the form data 
			if (Email == null || Username == null || Password == null) {
				errorMessage = "Missing Required Data";
			}else {
				
				// PUT IN CONTROLLER
				for(RevMetrix.Account account : RevMetrix.AccountsList)
				{
					if (Email.equals(Account.getEmail()))
	    			{
						errorMessage = "Email Already In Uses";
						break;
	    			}else{
	    				if (Username.equals(Account.getUsername()) )
		   				{
		   					errorMessage = "Username Already Taken";
		   					break;
		   				}else{
		    				RevMetrix.Account Account = new Account(Email, Username, Password, false);
		    				RevMetrix.AccountsList.add(Account);
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
