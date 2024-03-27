package revMetrix.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import revMetrix.model.RevMetrix;
import java.util.ArrayList; 

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
			
			RevMetrix revMetrix = new RevMetrix(); 
			
			ArrayList<RevMetrix.Account> Accounts = revMetrix.getAccountsList();
			
			
			// decode POSTed form parameters and dispatch to controller
			try {
				String Username = req.getParameter("user");
				String Password = req.getParameter("pass");

				
				
				
				// check for errors in the form data 
				if (Username == null || Password == null) {
					errorMessage = "Missing Required Data";
					
				}else {
					
					// PUT IN CONTROLLER
					boolean found = false;
					for(RevMetrix.Account accounts : Accounts)
					{
						if (Username.equals(accounts.getUsername()))
		    			{
							if (Password.equals(accounts.getPassword()))
			   				{
								System.out.println("RedirectServlet");
								req.getSession().setAttribute("username", Username);
								req.getSession().setAttribute("password", Password);
								found = true;
								break;
			   				}else{
			    				errorMessage = "Incorrect Password";
			   					break;
			   				}
		    			}
						if(!found)
						{
		    				errorMessage = "Username not Registered";
							
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