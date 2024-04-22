package revMetrix.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import revMetrix.controller.EventController;
import revMetrix.db.model.Event;

public class EventServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    private EventController eventController;

    @Override
    public void init() throws ServletException {
        super.init();
        eventController = new EventController();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Event Servlet: doGet");

        // Fetch all events
        ArrayList<Event> events = eventController.getAllEvents();
        
        // Set events as an attribute to be used in JSP
        req.setAttribute("events", events);

        // Forward to JSP for rendering
        req.getRequestDispatcher("/event.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Handling POST requests (if needed)
        doGet(req, resp);
    }
}
