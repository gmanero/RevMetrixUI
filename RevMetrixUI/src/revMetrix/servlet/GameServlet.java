package revMetrix.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import revMetrix.controller.GameController;
import revMetrix.db.model.Frame;
import revMetrix.db.model.Shot;
import revMetrix.model.RevMetrix;
import revMetrix.model.RevMetrix.Game;

public class GameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ArrayList<Shot> shots;
	private String[] shotScores;
	private int[] scores;
	private ArrayList<Frame> frames;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		System.out.println("Game Servlet: doGet");
		
	    if(shots == null) {
	    	shots = new ArrayList<Shot>();
	    }
	    if(shotScores == null) {
	    	shotScores = new String[26];
	    }
	    if(scores == null) {
	    	scores = new int[12];
	    }
	    if(frames == null) {
	    	frames = new ArrayList<Frame>();
	    }
		
		req.getRequestDispatcher("/_view/game.jsp").forward(req, resp);
	}
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    System.out.println("Game Servlet: doPost");
	    // populate array from database
	    
	    if(shots == null) {
	    	shots = new ArrayList<Shot>();
	    }
	    if(shotScores == null) {
	    	shotScores = new String[21];
	    }
	    if(scores == null) {
	    	scores = new int[12];
	    }
	    // Retrieving parameter from request
	    String first = req.getParameter("firstRemaining");
	    System.out.println("Remaining Pins: " + first);
	    String firstFoul = req.getParameter("firstExtra");
	    System.out.println("foul: " + firstFoul); 
	    //grab ball id when its possible
	    
	    String second = req.getParameter("secondRemaining");
	    System.out.println("Remaining Pins: " + second);
	    String secondFoul = req.getParameter("secondExtra");
	    System.out.println("foul: " + secondFoul);
	    //grab ball id when its possible
	    
	    Shot firstShot = GameController.addShot(1, first, null, firstFoul, 0);
	    shots.add(firstShot);
	    Shot secondShot = null;
	    if (!GameController.isStrike(firstShot)) {
	    	secondShot = GameController.addShot(2, second, first, secondFoul, 0);
	    	shots.add(secondShot);
	    }
	    frames.add(GameController.addFrame(firstShot, secondShot, "placeholder"));
	    GameController.updateframeScores(frames, shots);
	    shotScores = GameController.parseShots(shots);
	    scores = GameController.parseScores(frames, shots);

	    req.setAttribute("shotScores", shotScores);
	    req.setAttribute("scores", scores);

	    // Forwarding request and response to JSP page
	    req.getRequestDispatcher("/_view/game.jsp").forward(req, resp);
	}


}