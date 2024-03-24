package revMetrix.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class IndexServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        
        System.out.println("Index Servlet: doGet");
        
   
        String destIn = req.getParameter("destination");
        String destOut = null;
        
        
        // Forward based on the action parameter
        if ("revMetrix".equals(destIn)) {
           destOut = "/_view/index.jsp";
        } else if ("login".equals(destIn)) {
        	 destOut = "/_view/login.jsp";
        } else if ("event".equals(destIn)) {
        	 destOut = "/_view/event.jsp";
        } else if ("register".equals(destIn)) {
        	destOut = "/_view/registration.jsp";
        } else if ("account".equals(destIn)) {
        	destOut = "/_view/account.jsp";
        }  else if ("game".equals(destIn)) {
        	destOut = "/_view/game.jsp";
        } else if ("stats".equals(destIn)) {
        	destOut = "/_view/stats.jsp";	
        }  
        else {
           destOut = "/_view/index.jsp";
        }
        req.getRequestDispatcher(destOut).forward(req, resp);
    }
}
