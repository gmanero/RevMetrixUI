package revMetrix.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import revMetrix.controller.AllAccountsController;
import revMetrix.model.RevMetrix;
import java.util.ArrayList; 

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Login Servlet:  doPost");
	    String email = request.getParameter("username");
	    String password = request.getParameter("password");
	    System.out.println(email + password);

	    // Create an instance of AllAccountsController
	    AllAccountsController controller = new AllAccountsController();

	    // Check if the email and password are valid
	    if (controller.authenticate(email, password)) {
	        // If authentication succeeds, redirect to account.jsp
	    	controller.logInAccount(email, password);
	    	System.out.println("LOGGED IN");
	        response.sendRedirect("/revMetrix/index?destination=account");
	    } else {
	        // If authentication fails, redirect back to the login page with an error message
	    	System.out.println("INVALID LOGIN");
	        response.sendRedirect("/revMetrix/index?destination=login");
	    }
    }
}
	