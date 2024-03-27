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
		
		 String destIn = req.getParameter("destination");
	        String destOut = null;
	        
	        
	        // Forward based on the action parameter
	        if ("revMetrix".equals(destIn)) {
	           destOut = "/_view/index.jsp";
	        } 
	        else if ("login".equals(destIn)) {
	        	 destOut = "/_view/login.jsp";
	        } 
	        else if ("event".equals(destIn)) {
	        	 destOut = "/_view/event.jsp";
	        } 
	        else if ("register".equals(destIn)) {
	        	destOut = "/_view/registration.jsp";
	        } 
	        else if ("account".equals(destIn)) {
	        	destOut = "/_view/account.jsp";
	        }  
	        else if ("game".equals(destIn)) {
	        	destOut = "/_view/game.jsp";
	        } 
	        else if ("stats".equals(destIn)) {
	        	destOut = "/_view/stats.jsp";	
	        } 
	        else if ("create".equals(destIn)) {
	        	destOut = "/_view/create.jsp";
	        } 
	        else if ("createLeague".equals(destIn)) {
	        	destOut = "/_view/createLeague.jsp";
	        }
	       	else if ("createPractice".equals(destIn)) {
	        	destOut = "/_view/createPractice.jsp";
	        }
	        else if ("createTournament".equals(destIn)) {
	        	destOut = "/_view/createTournament.jsp";
	        }
	        else if ("leagues".equals(destIn)) {
	        	destOut = "/_view/leagues.jsp";
	        }
	        else if ("practices".equals(destIn)) {
	        	destOut = "/_view/practices.jsp";
	        }
	        else if ("tournaments".equals(destIn)) {
	        	destOut = "/_view/tournaments.jsp";
	        }
	        else if ("yourGames".equals(destIn)) {
	        	destOut = "/_view/yourGames.jsp";
	        }
	        else if ("accountCreation".equals(destIn)) {
	        	destOut = "/_view/accountCreation.jsp";
	        }
	        else {
	           destOut = "/_view/index.jsp";
	        }
	        req.getRequestDispatcher(destOut).forward(req, resp);
	        
		//req.getRequestDispatcher("/_view/game.jsp").forward(req, resp);
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

	    req.setAttribute("game", game);

	    // Forwarding request and response to JSP page
	    req.getRequestDispatcher("/_view/game.jsp").forward(req, resp);
	}


}