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
	
	private Game game;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		System.out.println("Game Servlet: doGet");
		
		
		req.getRequestDispatcher("/_view/game.jsp").forward(req, resp);
	}
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    System.out.println("Game Servlet: doPost");

	    // Retrieving parameter from request
	    String numbers = req.getParameter("clickedPins");
	    System.out.println("Clicked Pins: " + numbers);

	    // Parse pins and calculate score
	    boolean[] pins = GameController.getPins(numbers);
	    int score = GameController.getScore(pins);
	    System.out.println("Calculated Score: " + score);

	    // Create an instance of the Game class if it doesn't exist
	    if (game == null) {
	        game = new Game(null, null, 0, new boolean[10], new int[20], 0);
	    }

	    // Update the score
	    game.setScore(score);

	    game.setScoreBoardValue(game.getShotNum(), score);

	    for (int i = 0; i < 20; i++) {
	        System.out.println("Scoreboard[" + i + "]: " + game.getScoreBoardValue(i));
	    }
	    
	    int newShotNum = game.getShotNum() + 1;
	    game.setShotNum(newShotNum);
	    
	    req.setAttribute("game", game);

	    // Forwarding request and response to JSP page
	    req.getRequestDispatcher("/_view/game.jsp").forward(req, resp);
	}

}