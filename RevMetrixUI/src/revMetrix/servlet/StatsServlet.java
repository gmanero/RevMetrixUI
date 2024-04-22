package revMetrix.servlet;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import revMetrix.db.StatQuery;

public class StatsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		try {
            // Call your StatsQuery class to calculate statistics

            // Retrieve statistics from StatsQuery class
            double averageGameScore = StatQuery.getAverageGameScore();
            double strikesPerGame = StatQuery.getStrikesPerGame();
            double sparesPerGame = StatQuery.getSparesPerGame();
            //int openFrameCount = StatQuery.getOpenFrameCount();

            // Set attributes in request object
            req.setAttribute("averageGameScore", averageGameScore);
            req.setAttribute("strikesPerGame", strikesPerGame);
            req.setAttribute("sparesPerGame", sparesPerGame);
            //request.setAttribute("openFrameCount", openFrameCount);

            // Forward to JSP
            req.getRequestDispatcher("/stats.jsp").forward(req, resp);
        } catch (Exception e) {
            // Handle exception
            e.printStackTrace();
        }
		
		
		System.out.println("Stats Servlet: doGet");
		
		req.getRequestDispatcher("/_view/stats.jsp").forward(req, resp);
	}
}