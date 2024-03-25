package revMetrix.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import revMetrix.controller.GameController;
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
		System.out.println(numbers);
		
		boolean[] pins = GameController.getPins(numbers);
		int score = GameController.getScore(pins);
		
		req.setAttribute("firstFrame_shot1", score);
		
		//splits
		
		
		
		req.getRequestDispatcher("/_view/game.jsp").forward(req, resp);
		
		
		
		
	}
}