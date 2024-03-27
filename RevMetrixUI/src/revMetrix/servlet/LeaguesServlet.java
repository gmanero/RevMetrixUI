package revMetrix.servlet;

import java.io.IOException;

import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import revMetrix.controller.LeagueController;
import revMetrix.model.RevMetrix;


public class LeaguesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RevMetrix revMetrix;
	ArrayList<RevMetrix.League> leagues;
	
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
		
		System.out.println("Leagues Servlet: doGet");
		
		leagues = revMetrix.getLeagueList();
		
		req.setAttribute("leagues", leagues);
		
		req.getRequestDispatcher("/_view/leagues.jsp").forward(req, resp);
	}
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		if(revMetrix==null) {
			revMetrix = new RevMetrix();
		}
		try {
			String leagueName = req.getParameter("leagueName");
	        String leagueStartDate = req.getParameter("leagueStartDate");
	        String leagueLocation = req.getParameter("leagueLocation");
	        String leagueDescription = req.getParameter("leagueDescription");
	        int leagueCapacity = Integer.parseInt(req.getParameter("leagueCapacity"));
	        
	        boolean flag = true;
	        
	        for(RevMetrix.League check:revMetrix.getLeagueList()) {
	        	if(leagueName .equals( check.getLeagueName())) {
	        		flag = false;
	        }
		}
		if(flag) {
			int leagueId = LeagueController.generateNewId();
			
			RevMetrix.League newLeague = new RevMetrix.League(leagueId, leagueName, leagueStartDate, leagueLocation, leagueDescription, leagueCapacity);
			
			revMetrix.addLeague(newLeague);
			
			System.out.println("Leagues Servlet: doPost");
		
		}
		}
		finally {
			
		}
		leagues = revMetrix.getLeagueList();
		
		req.setAttribute("model", revMetrix);
		req.setAttribute("leagues", leagues);
		
		req.getRequestDispatcher("/_view/leagues.jsp").forward(req, resp);
		
		
		
		
	}
}