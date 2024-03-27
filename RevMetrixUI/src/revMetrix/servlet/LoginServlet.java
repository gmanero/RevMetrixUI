package revMetrix.servlet;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import revMetrix.model.RevMetrix;

public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.getRequestDispatcher("/_view/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        
        // Validate login credentials
        boolean isValidUser = false;
        for (RevMetrix.Account account : RevMetrix.AccountsList) {
            if (username.equals(account.getUsername()) && password.equals(account.getPassword())) {
                isValidUser = true;
                break;
            }
        }
        
        if (isValidUser) {
            req.getSession().setAttribute("username", username);
            resp.sendRedirect(req.getContextPath() + "/dashboard"); // Redirect to dashboard or desired page
        } else {
            req.setAttribute("errorMessage", "Invalid username or password");
            req.getRequestDispatcher("/_view/login.jsp").forward(req, resp);
        }
    }
}
