package revMetrix.servlet;

import java.io.IOException;


import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import revMetrix.model.RevMetrix;


public class TournamentsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RevMetrix revMetrix;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		System.out.println("Tournaments Servlet: doGet");
		
		ArrayList<RevMetrix.Tournament> tournaments = revMetrix.getTournamentList();
		
		req.setAttribute("tournaments", tournaments);
		
		req.getRequestDispatcher("/_view/tournaments.jsp").forward(req, resp);
	}
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		System.out.println("Tournaments Servlet: doPost");
		
		
		req.getRequestDispatcher("/_view/tournaments.jsp").forward(req, resp);
		
		
		
		
	}
}