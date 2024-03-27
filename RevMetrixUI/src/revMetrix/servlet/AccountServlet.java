package revMetrix.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import revMetrix.model.RevMetrix;

public class AccountServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Accounts Servlet: doGet");
        req.getRequestDispatcher("/_view/account.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Account Servlet: doPost");
        
        // Extract parameters from the request
        String name = req.getParameter("name");
        String weight = req.getParameter("weight");
        String color = req.getParameter("color");

        // Instantiate the RevMetrix model
        RevMetrix revMetrix = new RevMetrix();

        // Call the method in the model to add the new bowling ball
        revMetrix.addBall(name, weight, color);

        // Redirect back to the account page
        resp.sendRedirect(req.getContextPath() + "/account");
    }
}
