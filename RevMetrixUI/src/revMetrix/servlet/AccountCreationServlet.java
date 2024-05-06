package revMetrix.servlet;

import java.io.IOException;

import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import revMetrix.db.persist.DatabaseProvider;
import revMetrix.db.persist.DerbyDatabase;
import revMetrix.db.persist.IDatabase;
import revMetrix.controller.AllAccountsController;
import revMetrix.controller.InsertAccountController;

import revMetrix.model.RevMetrix;

import revMetrix.model.RevMetrix.Account; 


public class AccountCreationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private InsertAccountController controller =null;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		 String loggedInName = "";
	        boolean loggedIn = false; // Initialize loggedIn to false

	        AllAccountsController controller = new AllAccountsController();
	        loggedIn = controller.isLoggedInAccount();
	        System.out.println("Look here + "+ loggedIn);

	        if (loggedIn) {
	            loggedInName = controller.findLoggedInUser();
	            System.out.println("Logged in name: " + loggedInName);
	        }
	        
		
		
		System.out.println("Event Servlet: doGet");
		req.setAttribute("loggedInName", loggedInName);
        req.setAttribute("loggedIn", loggedIn);
		req.getRequestDispatcher("/_view/accountCreation.jsp").forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String loggedInName = "";
        boolean loggedIn = false; // Initialize loggedIn to false

        AllAccountsController Mcontroller = new AllAccountsController();
        loggedIn = Mcontroller.isLoggedInAccount();
        System.out.println("Look here + "+ loggedIn);

        if (loggedIn) {
            loggedInName = Mcontroller.findLoggedInUser();
            System.out.println("Logged in name: " + loggedInName);
        }
		System.out.println("AccountCreation Servlet: doPost");
		
		// holds the error message text, if there is any
		String errorMessage = null;
		String successMessage = null;
		boolean added = false;
		
		// decode POSTed form parameters and dispatch to controller
		try {
			String Email = req.getParameter("email");
			String FirstName = req.getParameter("firstname");
			String LastName = req.getParameter("lastname");
			String Password = req.getParameter("password2");
			System.out.println(Email + FirstName + LastName + Password);
			
			
			// Check for null values
	        if ((Email == null || Email == "")  || (FirstName == null || FirstName == "") || (LastName == null || LastName == "") || (Password == null || Password == "")) {
	            System.out.println("Missing Required Data");
	            //handle error message
	        } else {
	        	InsertAccountController controller = new InsertAccountController();
	        	System.out.println("PASS");

	            // Call the insertAccount method
	        	controller.insertAccount(Email, Password, LastName, FirstName);
	            System.out.println("ADDED INTO DATABASE");

	            // Set success message if needed
	            successMessage = "Account added successfully";
	            resp.sendRedirect("/revMetrix/index?destination=account");
	            
	        }
			
		} catch (Exception e) {
			//type error if this shows
			errorMessage = "Something Went Wrong";
		}
		req.setAttribute("errorMessage", errorMessage);
		req.setAttribute("loggedInName", loggedInName);
        req.setAttribute("loggedIn", loggedIn);
		
		
		req.getRequestDispatcher("/_view/account.jsp").forward(req, resp);
	}
}
