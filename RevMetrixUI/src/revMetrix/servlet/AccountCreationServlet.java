package revMetrix.servlet;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import revMetrix.model.RevMetrix;

public class AccountCreationServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.getRequestDispatcher("/_view/accountCreation.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String email = req.getParameter("email");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        
        // Validate input (add more validation as needed)
        if (email != null && username != null && password != null) {
            // Check for existing email or username
            boolean exists = false;
            for (RevMetrix.Account account : RevMetrix.AccountsList) {
                if (email.equals(account.getEmail())) {
                    exists = true;
                    req.setAttribute("errorMessage", "Email already in use");
                    req.getRequestDispatcher("/_view/accountCreation.jsp").forward(req, resp);
                    break;
                } else if (username.equals(account.getUsername())) {
                    exists = true;
                    req.setAttribute("errorMessage", "Username already taken");
                    req.getRequestDispatcher("/_view/accountCreation.jsp").forward(req, resp);
                    break;
                }
            }
            
            if (!exists) {
                // Create a new account and add it to the list
                RevMetrix.Account account = new RevMetrix.Account(email, username, password, false);
                RevMetrix.AccountsList.add(account);
                resp.sendRedirect(req.getContextPath() + "/login"); // Redirect to login page
            }
        } else {
            // Handle invalid input
            req.setAttribute("errorMessage", "All fields are required");
            req.getRequestDispatcher("/_view/accountCreation.jsp").forward(req, resp);
        }
    }
}
