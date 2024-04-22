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
import revMetrix.controller.InsertAccountController;

import revMetrix.model.RevMetrix;

import revMetrix.model.RevMetrix.Account; 


public class AccountCreationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private InsertAccountController controller =null;
	
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
		String successMessage = null;
		
		// decode POSTed form parameters and dispatch to controller
		try {
			String Email = req.getParameter("email");
			String FirstName = req.getParameter("firstname");
			String LastName = req.getParameter("lastname");
			String Password = req.getParameter("password2");
			
			System.out.println("TEST: " + Email + FirstName + LastName + Password);
			
			// Check for null values
	        if (Email == null || FirstName == null || LastName == null || Password == null) {
	            System.out.println("Missing Required Data");
	        } else {
	        	System.out.println("PASS");
	        	InsertAccountController controller = new InsertAccountController();

	            // Call the insertAccount method
	            controller.insertAccount(Email, Password, LastName, FirstName);
	            System.out.println("ADDED INTO DATABASE");

	            // Set success message if needed
	            successMessage = "Account added successfully";
	            
	        }
			
		} catch (Exception e) {
			errorMessage = "Type Error - Needs fixing";
		}
		req.setAttribute("errorMessage", errorMessage);
		
		req.getRequestDispatcher("/_view/account.jsp").forward(req, resp);
	}
}
