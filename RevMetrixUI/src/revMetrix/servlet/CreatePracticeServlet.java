package revMetrix.servlet;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import revMetrix.controller.PracticeController;
import revMetrix.model.RevMetrix;


public class CreatePracticeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RevMetrix revMetrix;
	
	@Override
    public void init() throws ServletException {
        super.init();
        // Initialize RevMetrix instance
        revMetrix = new RevMetrix();
    }
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		System.out.println("CreatePractice Servlet: doGet");
		
		req.getRequestDispatcher("/_view/createPractice.jsp").forward(req, resp);
	}
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		String practiceName = req.getParameter("practiceName");
        String practiceStartDate = req.getParameter("practiceStartDate");
        String practiceLocation = req.getParameter("practiceLocation");
        String practiceDescription = req.getParameter("practiceDescription");
        int practiceCapacity = Integer.parseInt(req.getParameter("practiceCapacity"));
        
        RevMetrix.Practice newPractice = new RevMetrix.Practice(PracticeController.generateNewId(), practiceName, practiceStartDate, practiceLocation, practiceDescription, practiceCapacity);
        
        revMetrix.addPractice(newPractice);
		
		System.out.println("CreatePractice Servlet: doPost");
		
		
		req.getRequestDispatcher("/_view/createPractice.jsp").forward(req, resp);
		
		
		
		
	}
}