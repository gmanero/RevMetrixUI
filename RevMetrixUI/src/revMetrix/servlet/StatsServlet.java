package revMetrix.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import revMetrix.controller.AllAccountsController;
import revMetrix.controller.StatsController;

public class StatsServlet extends HttpServlet {
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
         
        System.out.println("Stats Servlet: doGet"); 
        req.setAttribute("loggedInName", loggedInName);
        req.setAttribute("loggedIn", loggedIn);
        req.getRequestDispatcher("/_view/stats.jsp").forward(req, resp);
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
    	
        System.out.println("Stats Servlet: doPost");
        StatsController SC = new StatsController();
        
        int totGames = SC.getTotalLifeTimeGames();
        System.out.print(totGames);

        Double averageGameScore = SC.getTotalGameScore();
        int numGames = 0;
        if (!req.getParameter("numGames").equals(totGames)) {
            numGames=Integer.parseInt(req.getParameter("numGames"));
        }
        
        System.out.print(numGames);
        int[] graphData = SC.getGraphData(numGames); // Pass selected value

        req.setAttribute("loggedInName", loggedInName);
        req.setAttribute("loggedIn", loggedIn);
        req.setAttribute("graphData", graphData);

        // Forward the request to the JSP
        req.getRequestDispatcher("/_view/stats.jsp").forward(req, resp);
    }
}
