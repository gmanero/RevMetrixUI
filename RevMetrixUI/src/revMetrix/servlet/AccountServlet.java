package revMetrix.servlet;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import revMetrix.controller.AllAccountsController;
import revMetrix.db.model.Account;
import revMetrix.db.model.Ball;

public class AccountServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private AllAccountsController controller;

    @Override
    public void init() throws ServletException {
        super.init();
        controller = new AllAccountsController();
    }

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
        
        
    	System.out.println("account Servlet: doGet");
        // Get all balls
        List<Ball> balls = controller.findAllBalls();

        // Set balls as attribute in request
        req.setAttribute("balls", balls);
        req.setAttribute("loggedInName", loggedInName);
        req.setAttribute("loggedIn", loggedIn);
        // Forward to JSP for rendering
        req.getRequestDispatcher("/account.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
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
    	System.out.println("account Servlet: doPost");
        // Get form parameters for new ball
        String name = req.getParameter("name");
        int weight = Integer.parseInt(req.getParameter("weight"));
        String color = req.getParameter("color");

        // Add new ball to database
        controller.insertBallIntoBallsTable(weight, color, name);
        req.setAttribute("loggedInName", loggedInName);
        req.setAttribute("loggedIn", loggedIn);
        // Redirect back to GET to display all balls
        req.getRequestDispatcher("/_view/account.jsp").forward(req, resp);
    }
}
