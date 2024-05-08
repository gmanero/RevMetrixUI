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
    
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String remove = req.getParameter("remove");
    String add = req.getParameter("add");
    String eventId = req.getParameter("eventId");
    System.out.println(remove);
    
    if(remove !=null) {
    	eventController.removeSession(Integer.parseInt(remove));
    }
    else if(add!= null) {
    	if(add.equals("Archive")) {
    		eventController.finnishEvent(Integer.parseInt(eventId));
    	}
    	else {
    		try {
                eventController.addSessions(Integer.parseInt(eventId), Integer.parseInt(add));
            } catch (NumberFormatException e) {
                System.out.println("The string cannot be converted into an integer.");
            }
    	}
    	
    	
    }
    req.setAttribute("id", eventId);
    req.getRequestDispatcher("/_view/event.jsp").forward(req, resp);
    }
}
