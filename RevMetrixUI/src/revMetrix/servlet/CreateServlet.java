package revMetrix.servlet;

import java.io.IOException;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import revMetrix.controller.EstablishmentController;
import revMetrix.controller.InsertEventController;
import revMetrix.db.model.Establishment;

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

            if (eventName == null || description == null || type == null) {
                errorMessage = "Missing Required Data";
            } else {
                if (establishmentIdParam.equals("addNew") && newEstablishmentName != null && !newEstablishmentName.isEmpty()) {
                    EstablishmentController establishmentController = new EstablishmentController();
                    Integer newEstablishmentId = establishmentController.insertEstablishmentIntoEstablishmentsTable(newEstablishmentName);

                    if (newEstablishmentId > 0) {
                        establishmentIdParam = String.valueOf(newEstablishmentId);
                        successMessage = "New Establishment Added: " + newEstablishmentName;
                    } else {
                        errorMessage = "Failed to Add New Establishment";
                    }
                }

                InsertEventController controller = new InsertEventController();
                controller.insertEvent(establishmentIdParam, eventName, description, type);
                successMessage = "Event added successfully";
            }
        } catch (Exception e) {
            errorMessage = "Error: " + e.getMessage();
        }

        req.setAttribute("errorMessage", errorMessage);
        req.setAttribute("successMessage", successMessage);

        req.getRequestDispatcher("/_view/create.jsp").forward(req, resp);
    }
}
