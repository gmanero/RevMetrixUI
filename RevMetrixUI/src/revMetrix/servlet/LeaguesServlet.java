package revMetrix.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import revMetrix.model.RevMetrix;


public class LeaguesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	RevMetrix revMetrix;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		System.out.println("Leagues Servlet: doGet");
		
		req.getRequestDispatcher("/_view/leagues.jsp").forward(req, resp);
	}
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		System.out.println("Leagues Servlet: doPost");
		
		
		req.getRequestDispatcher("/_view/leagues.jsp").forward(req, resp);
		
		
		
		
	}
}