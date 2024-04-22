package revMetrix.servlet;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import revMetrix.controller.InsertAccountController;
import revMetrix.controller.InsertEventController;

import revMetrix.model.RevMetrix;


public class CreateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private InsertEventController controller = null;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		System.out.println("Create Servlet: doGet");
		
		req.getRequestDispatcher("/_view/create.jsp").forward(req, resp);
	}
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		System.out.println("Create Servlet: doPost");
		
		// holds the error message text, if there is any
				String errorMessage = null;
				String successMessage = null;
				
				// decode POSTed form parameters and dispatch to controller
				try {
					String eventName = req.getParameter("eventName");
					String establishmentName = req.getParameter("establishmentName");
					String description = req.getParameter("description");
					String type = req.getParameter("eventType");
					
					System.out.println("TEST: " + eventName + establishmentName + description + type);
					
					// Check for null values
			        if (eventName == null || establishmentName == null || description == null || type == null) {
			            System.out.println("Missing Required Data");
			        } else {
			        	System.out.println("PASS");
			        	InsertEventController controller = new InsertEventController();

			            // Call the insertAccount method
			            controller.insertEvent(establishmentName, eventName, description, type);
			            System.out.println("ADDED INTO DATABASE");

			            // Set success message if needed
			            successMessage = "Event added successfully";
			            
			        }
					
				} catch (Exception e) {
					errorMessage = "Type Error - Needs fixing";
				}
				req.setAttribute("errorMessage", errorMessage);
		
		
		req.getRequestDispatcher("/_view/create.jsp").forward(req, resp);
		
		
		
		
	}
}