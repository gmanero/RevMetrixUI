package revMetrix.servlet;

import java.io.IOException;


import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import revMetrix.controller.PracticeController;
import revMetrix.model.RevMetrix;


public class PracticesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RevMetrix revMetrix;
	ArrayList<RevMetrix.Practice> practices;
	
	@Override
    public void init() throws ServletException {
        super.init();
        // Initialize RevMetrix instance
        if(revMetrix==null) {
			revMetrix = new RevMetrix();
		}
    }
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		System.out.println("Practices Servlet: doGet");
		
		
		practices = revMetrix.getPracticeList();
		
		req.setAttribute("practices", practices);
		
		req.getRequestDispatcher("/_view/practices.jsp").forward(req, resp);
	}
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		if(revMetrix==null) {
			revMetrix = new RevMetrix();
		}
		try {
		String practiceName = req.getParameter("practiceName");
        String practiceStartDate = req.getParameter("practiceStartDate");
        String practiceLocation = req.getParameter("practiceLocation");
        String practiceDescription = req.getParameter("practiceDescription");
        int practiceCapacity = Integer.parseInt(req.getParameter("practiceCapacity"));
		
        //System.out.print("canary"+tournamentName+ tournamentStartDate+ tournamentLocation+ tournamentDescription+ tournamentCapacity);
        boolean flag = true;
        
        for(RevMetrix.Practice check:revMetrix.getPracticeList()) {
        	if(practiceName .equals( check.getPracticeName())) {
        		flag = false;
        	}
        }
        
        if(flag) {
        	int practiceId = PracticeController.generateNewId();

    		RevMetrix.Practice newPractice = new RevMetrix.Practice(practiceId, practiceName, practiceStartDate, practiceLocation, practiceDescription, practiceCapacity);
    		
    		revMetrix.addPractice(newPractice);
    		
    		System.out.println("Practices Servlet: doPost");
    		
    		
    		
        }
		}
		finally{
			
		}
        practices = revMetrix.getPracticeList();
        
		req.setAttribute("model", revMetrix);
		req.setAttribute("practices", practices);

		
		req.getRequestDispatcher("/_view/practices.jsp").forward(req, resp);
		
		
		
		
	}
}