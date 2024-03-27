package revMetrix.servlet;

import java.io.IOException;

import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import revMetrix.model.RevMetrix;


public class PracticesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	RevMetrix revMetrix;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		System.out.println("Practices Servlet: doGet");
		
		ArrayList<RevMetrix.Practice> practices = revMetrix.getPracticeList();
		req.setAttribute("practices", practices);
		
		req.getRequestDispatcher("/_view/practices.jsp").forward(req, resp);
	}
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		System.out.println("Practices Servlet: doPost");
		
		
		req.getRequestDispatcher("/_view/practices.jsp").forward(req, resp);
		
		
		
		
	}
}