package revMetrix.servlet;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import revMetrix.controller.AllAccountsController;
import revMetrix.db.model.Account;

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
        // Forward to JSP for rendering
        req.getRequestDispatcher("/account.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        // Get all accounts
        List<Account> accounts = controller.getAllAccounts();

        // Set accounts as attribute in request
        req.setAttribute("accounts", accounts);

        // Forward to JSP for rendering
        req.getRequestDispatcher("/account.jsp").forward(req, resp);
    }

}
