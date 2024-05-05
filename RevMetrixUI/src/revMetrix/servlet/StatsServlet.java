package revMetrix.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import revMetrix.db.persist.DatabaseProvider;
import revMetrix.db.persist.IDatabase;
import revMetrix.model.RevMetrix;

import revMetrix.controller.StatsController;

public class StatsServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
    	throws ServletException, IOException {
    	
        System.out.println("Stats Servlet: doGet");        
        
        req.getRequestDispatcher("/_view/stats.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
    	throws ServletException, IOException {
    	
        System.out.println("Stats Servlet: doPost");


        StatsController SC = new StatsController();
        
        Double averageGameScore = SC.getTotalGameScore();
        //int strikesPerGame = StatsQuery.strikeTotal();
        //int sparesPerGame = StatsQuery.spareTotal();
        
        req.setAttribute("averageGameScore", averageGameScore);
        //req.setAttribute("strikesPerGame", strikesPerGame);
        //req.setAttribute("sparesPerGame", sparesPerGame);
        
        

        // Set attributes in the request
        

        // Forward the request to the JSP
        req.getRequestDispatcher("/_view/stats.jsp").forward(req, resp);
    }
}