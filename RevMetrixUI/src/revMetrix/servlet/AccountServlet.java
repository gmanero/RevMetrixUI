package revMetrix.servlet;

import java.io.IOException;

import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import revMetrix.controller.AllAccountsController;
import revMetrix.db.model.Account;
import revMetrix.db.model.Ball;
import revMetrix.db.model.Establishment;
import revMetrix.controller.EstablishmentController;

public class AccountServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private AllAccountsController controller;

    @Override
    public void init() throws ServletException {
        super.init();
        controller = new AllAccountsController();
    }

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
        
        EstablishmentController Econtroller = new EstablishmentController();
    	System.out.println("account Servlet: doGet");
        // Get all balls
        List<Ball> balls = controller.findAllBalls();
        List<Establishment> establishments = Econtroller.getAllEstablishments();

        // Set balls as attribute in request
        req.setAttribute("establishments", establishments);
        req.setAttribute("balls", balls);
        req.setAttribute("loggedInName", loggedInName);
        req.setAttribute("loggedIn", loggedIn);
        // Forward to JSP for rendering
        req.getRequestDispatcher("/account.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
    	String loggedInName = "";
        boolean loggedIn = false; // Initialize loggedIn to false

        AllAccountsController controller = new AllAccountsController();
        EstablishmentController Econtroller = new EstablishmentController();
        loggedIn = controller.isLoggedInAccount();
        System.out.println("Look here + "+ loggedIn);

        if (loggedIn) {
            loggedInName = controller.findLoggedInUser();
            System.out.println("Logged in name: " + loggedInName);
        }
        
        String action = req.getParameter("action");
        
        if ("addEstablishment".equals(action)) {
            // Get form parameters for new establishment
            String name = req.getParameter("establishmentName");
            String address = req.getParameter("establishmentAddress");
            String phoneNumber = req.getParameter("phoneNumber");
            int lanes = Integer.parseInt(req.getParameter("lanes"));
            
            // Insert new establishment into the database
            Econtroller.insertEstablishmentIntoEstablishmentsTable(name, address, phoneNumber, lanes);
        }

        if ("updateEstablishment".equals(action)&&req.getParameter("establishmentId")!=null) {
            // Update establishment details
            int establishmentId = Integer.parseInt(req.getParameter("establishmentId"));
            String fieldName = req.getParameter("fieldName");
            String newValue = req.getParameter("newValue");

            // Determine which attribute to update based on the field name
            switch (fieldName) {
                case "name":
                    Econtroller.updateEstablishmentName(establishmentId, newValue);
                    break;
                case "address":
                    Econtroller.updateEstablishmentAddress(establishmentId, newValue);
                    break;
                case "phoneNumber":
                    Econtroller.updateEstablishmentPhoneNumber(establishmentId, newValue);
                    break;
                case "lanes":
                    int newLanes = Integer.parseInt(newValue);
                    Econtroller.updateEstablishmentLanes(establishmentId, newLanes);
                    break;
                default:
                    // Handle unrecognized field name
                    break;
            }
        }

    	System.out.println("account Servlet: doPost");
        // Get form parameters for new ball
    	int weight = 0;
    	String color = req.getParameter("color");
        String name = req.getParameter("name");
        try {
        	weight = Integer.parseInt(req.getParameter("weight"));
        	controller.insertBallIntoBallsTable(weight, color, name);
        }catch(NumberFormatException e) {
        	
        }
        
        

        // Add new ball to database
        
        req.setAttribute("loggedInName", loggedInName);
        req.setAttribute("loggedIn", loggedIn);
        // Redirect back to GET to display all balls
        req.getRequestDispatcher("/_view/account.jsp").forward(req, resp);
    }
}
