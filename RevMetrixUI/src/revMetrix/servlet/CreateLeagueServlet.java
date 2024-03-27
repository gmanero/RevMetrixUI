package revMetrix.servlet;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import revMetrix.controller.LeagueController;
import revMetrix.model.RevMetrix;


public class CreateLeagueServlet extends HttpServlet {
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
		
		System.out.println("CreateLeague Servlet: doGet");
		
		req.getRequestDispatcher("/_view/createLeague.jsp").forward(req, resp);
	}
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		String leagueName = req.getParameter("leagueName");
        String leagueStartDate = req.getParameter("leagueStartDate");
        String leagueLocation = req.getParameter("leagueLocation");
        String leagueDescription = req.getParameter("leagueDescription");
        int leagueCapacity = Integer.parseInt(req.getParameter("leagueCapacity"));

		RevMetrix.League newLeague = new RevMetrix.League(LeagueController.generateNewId(), leagueName, leagueStartDate, leagueLocation, leagueDescription, leagueCapacity);
		
		revMetrix.addLeague(newLeague);
		
		System.out.println("CreateLeague Servlet: doPost");
		
		
		req.getRequestDispatcher("/_view/createLeague.jsp").forward(req, resp);
		
		
		
		
	}
}