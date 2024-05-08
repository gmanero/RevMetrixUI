package revMetrix.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import revMetrix.controller.LeagueSheetController;
import revMetrix.db.model.Event;
import revMetrix.db.model.LeagueSheet;
import java.util.ArrayList; 

public class LeagueSheetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	 protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			System.out.println("League Sheet Servlet:  doGet");
			LeagueSheetController controller = new LeagueSheetController();
			ArrayList<LeagueSheet> leagueSheet = controller.getLeagueSheet();
			
			req.setAttribute("leagueSheet", leagueSheet);
	        req.getRequestDispatcher("/_view/leagueSheet.jsp").forward(req, resp);
	    }
	@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("League Sheet Servlet:  doPost");

		LeagueSheetController controller = new LeagueSheetController();
		ArrayList<LeagueSheet> leagueSheet = controller.getLeagueSheet();
		
		request.setAttribute("leagueSheet", leagueSheet);
		request.getRequestDispatcher("/_view/leagueSheet.jsp").forward(request, response);
	    
    }
}
	