package revMetrix.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import revMetrix.controller.AllAccountsController;
import revMetrix.db.model.Ball;
import revMetrix.db.model.Event;

public class BallDetailsServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    private AllAccountsController allAccountsController;

    @Override
    public void init() throws ServletException {
        super.init();
        allAccountsController = new AllAccountsController();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String loggedInName = "";
        boolean loggedIn = false; // Initialize loggedIn to false

        AllAccountsController controller = new AllAccountsController();
        loggedIn = controller.isLoggedInAccount();
        System.out.println("Look here + "+ loggedIn);

        if (loggedIn) {
            loggedInName = controller.findLoggedInUser();
            System.out.println("Logged in name: " + loggedInName);
        }
    	 int ballId = Integer.parseInt(request.getParameter("id"));
        
        // Check if ballIdParam is not null or empty
      
                // Retrieve ball details from the controller
                ArrayList<Ball> ball = allAccountsController.findBallById(ballId);
                
                // Set ball attribute to be used in JSP
                request.setAttribute("ball", ball);
                request.setAttribute("loggedInName", loggedInName);
                request.setAttribute("loggedIn", loggedIn);

                
                // Forward to JSP for rendering
                request.getRequestDispatcher("/ballDetails.jsp").forward(request, response);
            }
}
