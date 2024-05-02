package revMetrix.servlet;

import java.io.IOException;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import revMetrix.controller.EstablishmentController;
import revMetrix.controller.InsertEventController;
import revMetrix.controller.EventController;
import revMetrix.db.model.Establishment;
import revMetrix.db.model.Event;

public class CreateServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/_view/create.jsp").forward(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String errorMessage = null;
        String successMessage = null;

        try {
            String eventName = req.getParameter("eventName");
            String description = req.getParameter("description");
            String type = req.getParameter("eventType");
            String establishmentIdParam = req.getParameter("establishment");
            String newEstablishmentName = req.getParameter("newEstablishment");
            int numberOfSessions = Integer.parseInt(req.getParameter("numberOfSessions"));

            if (eventName == null || description == null || type == null) {
                errorMessage = "Missing Required Data";
            } else {
                if (establishmentIdParam.equals("addNew") && newEstablishmentName != null && !newEstablishmentName.isEmpty()) {
                    EstablishmentController establishmentController = new EstablishmentController();
                    establishmentController.insertEstablishmentIntoEstablishmentsTable(newEstablishmentName);
                    InsertEventController controller = new InsertEventController();
                    controller.insertEvent(newEstablishmentName, eventName, description, type);
                    EventController eventcontroller = new EventController();
                    int eventId = eventcontroller.findEventIdByInfo(eventName, description);
                    System.out.println(numberOfSessions);
                    for(int i =0; i < numberOfSessions;i++) {
                    	System.out.println("For loop session");
                    	controller.insertSession(0, eventId, "0", "0", 0);
                    }
                    successMessage = "Event added successfully";
                }
                else {
                	InsertEventController controller = new InsertEventController();
                    controller.insertEvent(establishmentIdParam, eventName, description, type);
                    EventController eventcontroller = new EventController();
                    int eventId = eventcontroller.findEventIdByInfo(eventName, description);
                    System.out.println(numberOfSessions);
                    for(int i= 0;  i< numberOfSessions;i++) {
                    	System.out.println("For loop session");
                    	controller.insertSession(0, eventId, "0", "0", 0);
                    }
                    successMessage = "Event added successfully";
                }
            }
        } catch (Exception e) {
            errorMessage = "Error: " + e.getMessage();
        }

        req.setAttribute("errorMessage", errorMessage);
        req.setAttribute("successMessage", successMessage);

        req.getRequestDispatcher("/_view/create.jsp").forward(req, resp);
    }
}
