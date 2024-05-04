package revMetrix.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import revMetrix.controller.AllAccountsController;
import revMetrix.model.RevMetrix;

public class IndexServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        
        System.out.println("Index Servlet: doGet");

        String destIn = req.getParameter("destination");
        String destOut = null;
        String loggedInName = "";
        boolean loggedIn = false; // Initialize loggedIn to false

        AllAccountsController controller = new AllAccountsController();
        loggedIn = controller.isLoggedInAccount();
        System.out.println("LOOK HERE " + loggedIn);

        if (loggedIn) {
            loggedInName = "Hello, " + controller.findLoggedInUser();
            System.out.println("Logged in name: " + loggedInName);
        }

        // Handle logout action
        if (!loggedIn) {
        	destOut = "/_view/login.jsp";
        } else {
            // Handle other actions
            if ("RevMetrix".equals(destIn)) {
                destOut = "/_view/index.jsp";
            } else if ("login".equals(destIn)) {
                destOut = "/_view/login.jsp";
            } else if ("logout".equals(destIn)) {
            	controller.logOutAllAccounts();
            	loggedIn = false;
                destOut = "/_view/login.jsp";
            } else if ("event".equals(destIn)) {
                destOut = "/_view/event.jsp";
            } else if ("register".equals(destIn)) {
                destOut = "/_view/registration.jsp";
            } else if ("account".equals(destIn)) {
                destOut = "/_view/account.jsp";
            } else if ("game".equals(destIn)) {
                destOut = "/game";
            } else if ("stats".equals(destIn)) {
                destOut = "/_view/stats.jsp";    
            } else if ("create".equals(destIn)) {
                destOut = "/_view/create.jsp";
            } else if ("createLeague".equals(destIn)) {
                destOut = "/_view/createLeague.jsp";
            } else if ("createPractice".equals(destIn)) {
                destOut = "/_view/createPractice.jsp";
            } else if ("createTournament".equals(destIn)) {
                destOut = "/_view/createTournament.jsp";
            } else if ("leagues".equals(destIn)) {
                destOut = "/_view/leagues.jsp";
            } else if ("practices".equals(destIn)) {
                destOut = "/_view/practices.jsp";
            } else if ("tournaments".equals(destIn)) {
                destOut = "/_view/tournaments.jsp";
            } else if ("yourGames".equals(destIn)) {
                destOut = "/_view/yourGames.jsp";
            } else {
                destOut = "/_view/index.jsp";
            }
        }

        // Set attributes and forward the request
        req.setAttribute("loggedInName", loggedInName);
        req.setAttribute("loggedIn", loggedIn);
        req.getRequestDispatcher(destOut).forward(req, resp);
    }
}
