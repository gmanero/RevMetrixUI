package revMetrix.servlet;

import java.io.IOException;

import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import revMetrix.controller.EventController;
import revMetrix.db.model.Event;

public class LeaguesServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private EventController eventController;

    @Override
    public void init() throws ServletException {
        super.init();
            eventController = new EventController();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("Leagues Servlet: doGet");

        // Get all tournaments from the EventController
        List<Event> leagues = eventController.getAllOngoingLeagueEvents();

        req.setAttribute("tournaments", leagues);

        req.getRequestDispatcher("/_view/leagues.jsp").forward(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Handling of POST requests can be added if needed
        doGet(req, resp); // Just call doGet for both GET and POST for simplicity
    }
}
