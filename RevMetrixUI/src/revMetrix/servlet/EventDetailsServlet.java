package revMetrix.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import revMetrix.controller.EventController;
import revMetrix.db.model.Event;

public class EventDetailsServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    private EventController eventController;

    @Override
    public void init() throws ServletException {
        super.init();
        eventController = new EventController();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int eventId = Integer.parseInt(request.getParameter("id"));
        
        // Retrieve event details from the controller
        ArrayList<Event> event = eventController.findEventByID(eventId);
        
        // Set event attribute to be used in JSP
        request.setAttribute("event", event);
        
        // Forward to JSP for rendering
        request.getRequestDispatcher("/eventDetails.jsp").forward(request, response);
    }
}
