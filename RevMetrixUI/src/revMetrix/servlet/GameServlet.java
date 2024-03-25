package revMetrix.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import revMetrix.model.RevMetrix;
import revMetrix.model.RevMetrix.Game;

public class GameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	RevMetrix revMetrix;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		System.out.println("Game Servlet: doGet");
		
		req.getRequestDispatcher("/_view/game.jsp").forward(req, resp);
	}
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		System.out.println("Game Servlet: doPost");
		
		String numbers = req.getParameter("clickedPins");
		System.out.println(numbers);
        
		//parse {for controller}
		String output= "";
		int count=0;
		System.out.println(numbers);
		if(numbers.compareTo("")!=0&&numbers.compareTo("G,")!=0&&numbers.compareTo("F,")!=0) {
			String[] values = numbers.split(",");
			boolean[] pins = {false,false,false,false,false,false,false,false,false,false};
			
			for(String s: values) {
				try {
					count++;
					pins[Integer.parseInt(s.trim())-1] = true;
					
				}
				finally{
					
				}
				
			}
			if(count == 10) {
				output = "X";
			}
			
			
		}
		else if (numbers.compareTo("")==0) {
			output = "-";
			
		}
		else {
			output = numbers;
		}
		req.setAttribute("firstFrame_shot1", output);
		System.out.println(output);
		//splits
		
		
		
		req.getRequestDispatcher("/_view/game.jsp").forward(req, resp);
		
		
		
		
	}
}