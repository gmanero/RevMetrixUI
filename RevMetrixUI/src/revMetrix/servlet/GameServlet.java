package revMetrix.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import revMetrix.controller.GameController;
import revMetrix.db.model.Ball;
import revMetrix.db.model.Frame;
import revMetrix.db.model.Shot;
import revMetrix.model.RevMetrix;
import revMetrix.model.RevMetrix.Game;

public class GameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//private ArrayList<Shot> shots;
	private String[] shotScores;
	private Integer[] scores;
	private int gameID;
	private GameController controller;
	//private ArrayList<Frame> frames;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		System.out.println("Game Servlet: doGet");
		
	  
	    
	    shotScores = new String[26];
	    scores = new Integer[12];
	    
	    
	    controller = new GameController();
	    gameID = controller.newGame();
	    List<Ball> balls = controller.getAllBalls();
	    req.setAttribute("balls", balls);
	    System.out.println("Game all set");
		req.getRequestDispatcher("/_view/game.jsp").forward(req, resp);
	}
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    System.out.println("Game Servlet: doPost");
	    // populate array from database
	    //if (gameID >=1) {
	    	//gameID = Integer.parseInt(req.getParameter("GameID"));
	    //}
	    ArrayList<Shot> shots = controller.GetShotsByGame(gameID);
	    ArrayList<Frame> frames = controller.GetFramesByGame(gameID);
	    System.out.print("Size = "+frames.size());
	    if(shots == null) {
	    	shots = new ArrayList<Shot>();
	    }
	    if(shotScores == null) {
	    	shotScores = new String[21];
	    }
	    if(scores == null) {
	    	scores = new Integer[12];
	    }
	    List<Ball> balls = controller.getAllBalls();
	    String error = null;
	    int ball1 = 0;
	    int ball2 = 0;
	    String lane = "";
	    try {
	    	ball1 = Integer.parseInt(req.getParameter("ball1"));
	    	System.out.println(ball1);
	    	ball2 = Integer.parseInt(req.getParameter("ball2"));
	    	System.out.println(ball2);
	    	lane = req.getParameter("lane");
	    }
	    finally{
	    	
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
	    if (!GameController.checkError(first, second)) {
	    	error = "Error invalid shot, try again";
	    }
	    else {
	    Shot firstShot = GameController.addShot(1, first, null, firstFoul, ball1);
	    shots.add(firstShot);
	    Shot secondShot = null;
	    if (!GameController.isStrike(firstShot)) {
	    	secondShot = GameController.addShot(2, second, first, secondFoul, ball2);
	    	shots.add(secondShot);
	    }
	    frames.add(GameController.addFrame(firstShot, secondShot, lane));
	    int frameID= controller.storeFrame(frames.get(frames.size()-1));
	    controller.storeShot(gameID, frameID, firstShot);
	    if(secondShot!=null) {
	    	controller.storeShot(gameID, frameID, secondShot);
	    }
	    controller.updateframeScores(frames, shots);
	    shotScores = GameController.parseShots(shots);
	    scores = GameController.parseScores(frames, shots);
	    }
	    System.out.print("Size = "+frames.size());
	    req.setAttribute("lane", lane);
	    req.setAttribute("balls", balls);
	    req.setAttribute("error", error);
	    req.setAttribute("shotScores", shotScores);
	    req.setAttribute("scores", scores); 
	    
	    // Forwarding request and response to JSP page
	    req.getRequestDispatcher("/_view/game.jsp").forward(req, resp);
	}


}