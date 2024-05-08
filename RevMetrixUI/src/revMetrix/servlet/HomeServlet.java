package revMetrix.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import revMetrix.controller.AllAccountsController;

public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String loggedInName = "";
        boolean loggedIn = false; // Initialize loggedIn to false

        AllAccountsController controller = new AllAccountsController();
        loggedIn = controller.isLoggedInAccount();
        System.out.println("Look here + "+ loggedIn);

        if (loggedIn) {
            loggedInName = controller.findLoggedInUser();
            System.out.println("Logged in name: " + loggedInName);
        }
		
        req.setAttribute("loggedInName", loggedInName);
        req.setAttribute("loggedIn", loggedIn);
		System.out.println("Home Servlet: doGet");
		
		req.getRequestDispatcher("/_view/home.jsp").forward(req, resp);
		
		
		String action = req.getParameter("action");

	    if ("Event".equals(action)) {
	        req.getRequestDispatcher("/_view/event.jsp").forward(req, resp);
	    } else if ("Game".equals(action)) {
	        req.getRequestDispatcher("/_view/game.jsp").forward(req, resp);
	    } else if ("Login".equals(action)) {
	        req.getRequestDispatcher("/_view/login.jsp").forward(req, resp);
	    } else if ("Stats".equals(action)) {
	        req.getRequestDispatcher("/_view/stats.jsp").forward(req, resp);
	    } else {
	        resp.sendRedirect("error.jsp");
	    }
	}
}