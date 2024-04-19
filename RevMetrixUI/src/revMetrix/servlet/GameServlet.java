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
	    String first = req.getParameter("firstRemaining");
	    System.out.println("Remaining Pins: " + first);
	    String firstFoul = req.getParameter("firstExtra");
	    System.out.println("foul: " + firstFoul);
	    
	    String second = req.getParameter("secondRemaining");
	    System.out.println("Remaining Pins: " + second);
	    String secondFoul = req.getParameter("secondExtra");
	    System.out.println("foul: " + secondFoul);
	    // Parse pins and calculate score
	    
	    // Create an instance of the Game class if it doesn't exist
	    /*
	    if (game == null) {
	        game = new Game(null, null, 0, new boolean[10], new Object[21], 0, new int[11], 0, 10, 0, 0, 0, 0);
	    }

	    // Update the score
	    game.setScore(game.getScore() + score);
	    if (game.getShotNum() % 2 == 1) {
	    	game.setPinsRemain(10);
	    }
	    else {
	    	game.setPinsRemain(10-score);
	    }

	    // Handle the current shot
	    if (game.getShotNum() % 2 == 0) {
	        if (score == 10) {
	            game.setScoreBoardValue(game.getShotNum(), "X");
	            game.setTotStrike(game.getTotStrike()+1);
	        } else {
	            game.setScoreBoardValue(game.getShotNum(), score);
	        }
	    } else {
	        if (score == 10) {
	            game.setScoreBoardValue(game.getShotNum(), "/");
	            game.setTotSpare(game.getTotSpare()+1);
	        } else {
	            game.setScoreBoardValue(game.getShotNum(), score);
	        }
	    }

	    // Handle the next shot after a strike
	    if (game.getScoreBoardValue(game.getShotNum()) == "X") {
	        int nextShotNum = game.getShotNum() + 1;
	        game.setShotNum(nextShotNum);
	        game.setScoreBoardValue(nextShotNum, "-");
	    }

	    // Handle foul
	    if ("F,".equals(numbers)) { // Remove the condition on the score
	        game.setScoreBoardValue(game.getShotNum(), "F");
	        game.setTotFoul(game.getTotFoul() + 1);
	    }
	    // Handle gutter
	    if ("G,".equals(numbers)) {
	        game.setScoreBoardValue(game.getShotNum(), "G");
	        game.setTotGutter(game.getTotGutter()+1);
	    }
	    
	    // Round/Game totals
	    if (game.getShotNum() % 2 == 1) {
	    	game.setScoreBoardTotNum(game.getScoreBoardTotNum()+score);
	    	game.setScoreBoardTotValue(game.getShotNum() / 2, game.getScoreBoardTotNum());
	    }
	    else {
	    	game.setScoreBoardTotNum(game.getScoreBoardTotNum()+score);
	    };
	    

	    for (int i = 0; i < 21; i++) {
	        System.out.println("Scoreboard[" + i + "]: " + game.getScoreBoardValue(i));
	    }

	    for (int i = 0; i < 10; i++) {
	        System.out.println("ScoreboardTot[" + i + "]: " + game.getScoreBoardTotValue(i));
	    }

	    
	    int newShotNum = game.getShotNum() + 1;
	    game.setShotNum(newShotNum);
	    */

	    req.setAttribute("game", game);

	    // Forwarding request and response to JSP page
	    req.getRequestDispatcher("/_view/game.jsp").forward(req, resp);
	}


}