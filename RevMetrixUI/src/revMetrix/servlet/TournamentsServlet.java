package revMetrix.servlet;

import java.io.IOException;



import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import revMetrix.controller.TournamentController;
import revMetrix.model.RevMetrix;


public class TournamentsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RevMetrix revMetrix;
	ArrayList<RevMetrix.Tournament>  tournaments;
	
	@Override
    public void init() throws ServletException {
        super.init();
        // Initialize RevMetrix instance
        revMetrix = new RevMetrix();
    }
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		System.out.println("Tournaments Servlet: doGet");
		
		
		tournaments = revMetrix.getTournamentList();
		
		req.setAttribute("tournaments", tournaments);
		
		req.getRequestDispatcher("/_view/tournaments.jsp").forward(req, resp);
	}
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		if(revMetrix==null) {
			revMetrix = new RevMetrix();
		}
		
		String tournamentName = req.getParameter("tournamentName");
        String tournamentStartDate = req.getParameter("tournamentStartDate");
        String tournamentLocation = req.getParameter("tournamentLocation");
        String tournamentDescription = req.getParameter("tournamentDescription");
        int tournamentCapacity = Integer.parseInt(req.getParameter("tournamentCapacity"));
        
        //System.out.print("canary"+tournamentName+ tournamentStartDate+ tournamentLocation+ tournamentDescription+ tournamentCapacity);
        boolean flag = true;
        
        for(RevMetrix.Tournament check:revMetrix.getTournamentList()) {
        	if(tournamentName == check.getTournamentName()) {
        		flag = false;
        	}
        }
        
        if(flag) {
        	int tournamentId = TournamentController.generateNewId();

    		RevMetrix.Tournament newTournament = new RevMetrix.Tournament(tournamentId, tournamentName, tournamentStartDate, tournamentLocation, tournamentDescription, tournamentCapacity);
    		
    		revMetrix.addTournament(newTournament);
    		
    		System.out.println("Tournaments Servlet: doPost");
    		
    		
    		
        }
        tournaments = revMetrix.getTournamentList();
        
		
		req.setAttribute("tournaments", tournaments);
		req.getRequestDispatcher("/_view/tournaments.jsp").forward(req, resp);
		
		
		
		
	}
}