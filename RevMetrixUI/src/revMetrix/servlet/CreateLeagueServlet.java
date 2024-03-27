package revMetrix.servlet;

import java.io.IOException;
import java.util.ArrayList;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import revMetrix.controller.LeagueController;
import revMetrix.model.RevMetrix;


public class CreateLeagueServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RevMetrix revMetrix;
	ArrayList<RevMetrix.League> leagues;
	
	@Override
    public void init() throws ServletException {
        super.init();
        // Initialize RevMetrix instance
        revMetrix = new RevMetrix();
    }
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		leagues = revMetrix.getLeagueList();
		
		req.setAttribute("leagues", leagues);
		
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
        
        int leagueId = LeagueController.generateNewId();

		RevMetrix.League newLeague = new RevMetrix.League(leagueId, leagueName, leagueStartDate, leagueLocation, leagueDescription, leagueCapacity);
		
		revMetrix.addLeague(newLeague);
		
		req.setAttribute("league", leagues);
		
		System.out.println("CreateLeague Servlet: doPost");
		
		
		req.getRequestDispatcher("/_view/createLeague.jsp").forward(req, resp);
		
		
		
		
	}
}