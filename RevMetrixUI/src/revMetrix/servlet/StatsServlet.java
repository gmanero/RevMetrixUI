package revMetrix.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import revMetrix.db.StatsQuery;

public class StatsServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Stats Servlet: doGet");
        req.getRequestDispatcher("/_view/stats.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Stats Servlet: doPost");

        // Retrieve statistics data
        double averageGameScore = StatsQuery.gamesTotal();
        System.out.println(StatsQuery.gamesTotal());
        int strikesPerGame = StatsQuery.strikeTotal();
        System.out.println(StatsQuery.strikeTotal());
        int sparesPerGame = StatsQuery.spareTotal();
        System.out.println(StatsQuery.spareTotal());

        // Set attributes in the request
        req.setAttribute("averageGameScore", averageGameScore);
        req.setAttribute("strikesPerGame", strikesPerGame);
        req.setAttribute("sparesPerGame", sparesPerGame);

        // Forward the request to the JSP
        req.getRequestDispatcher("/_view/stats.jsp").forward(req, resp);
    }
}