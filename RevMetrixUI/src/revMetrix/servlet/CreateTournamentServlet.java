package revMetrix.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import revMetrix.controller.TournamentController;
import revMetrix.model.RevMetrix;


public class CreateTournamentServlet extends HttpServlet {
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
		
		System.out.println("Create Tournament Servlet: doGet");
		
		req.getRequestDispatcher("/_view/createTournament.jsp").forward(req, resp);
	}
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		String tournamentName = req.getParameter("tournamentName");
        String tournamentStartDate = req.getParameter("tournamentStartDate");
        String tournamentLocation = req.getParameter("tournamentLocation");
        String tournamentDescription = req.getParameter("tournamentDescription");
        int tournamentCapacity = Integer.parseInt(req.getParameter("tournamentCapacity"));

		RevMetrix.Tournament newTournament = new RevMetrix.Tournament(TournamentController.generateNewId(), tournamentName, tournamentStartDate, tournamentLocation, tournamentDescription, tournamentCapacity);
		
		revMetrix.addTournament(newTournament);
		
		System.out.println("CreateTournament Servlet: doPost");
		req.getRequestDispatcher("/_view/createTournament.jsp").forward(req, resp);	
	}
}