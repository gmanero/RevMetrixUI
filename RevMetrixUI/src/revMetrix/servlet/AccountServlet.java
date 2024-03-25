package revMetrix.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import revMetrix.model.RevMetrix;


public class AccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	RevMetrix revMetrix;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		System.out.println("Accounts Servlet: doGet");
		
		req.getRequestDispatcher("/_view/account.jsp").forward(req, resp);
	}
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		System.out.println("Account Servlet: doPost");
		
		
		req.getRequestDispatcher("/_view/account.jsp").forward(req, resp);
		
		
		
		
	}
}