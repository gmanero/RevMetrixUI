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
import revMetrix.db.model.Game;

public class GameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//private ArrayList<Shot> shots;
	private String[] shotScores;
	private Integer[] scores;
	private int gameID;
	private GameController controller;
	int frameID;
	int GameID;
	int SessionID;
	//private ArrayList<Frame> frames;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		System.out.println("Game Servlet: doGet");
		String Id = req.getParameter("SesionID");
		if(Id!=null) {
			SessionID = Integer.parseInt(Id);
		}
		else {
			SessionID= 2;
		}
		
		
	  
	    
	    shotScores = new String[26];
	    scores = new Integer[12];
	    
	    
	    controller = new GameController();
	    System.out.println(gameID);
	    if(gameID==0) {
	    	//gameID = controller.newGame();
	    }
	    List<Ball> balls = controller.getAllBalls();
	    
	    ArrayList<Game> games = controller.GetGamesBySession(SessionID);
	    boolean[] locker = {true,true,true,true,true,true,true,true,true,true};
		req.setAttribute("locked", locker);
	    req.setAttribute("games", games);
	    req.setAttribute("balls", balls);
	   
		req.getRequestDispatcher("/_view/game.jsp").forward(req, resp);
	}
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    String first = req.getParameter("firstRemaining");
	    System.out.println("Remaining Pins: " + first);
	    String firstFoul = req.getParameter("firstExtra");
	    System.out.println("foul: " + firstFoul); 
		if(first==null) {
			 ArrayList<Game> games = controller.GetGamesBySession(SessionID);
			 gameID = Integer.parseInt((String)req.getParameter("Game"));
			 System.out.println("gotGameID");
			 ArrayList<Shot> shots = controller.GetShotsByGame(gameID);
			 ArrayList<Frame> frames = controller.GetFramesByGame(gameID);
			 List<Ball> balls = controller.getAllBalls();
			    String error = null;
			    int ball1 = 0;
			   
			    boolean[] lockout = new boolean[10];
			    boolean[] secondFrame = new boolean[1];
			 
			 req.setAttribute("games", games);
			 controller.updateframeScores(frames,shots);
			 shotScores = GameController.parseShots(shots);
			 scores = GameController.parseScores(frames, shots);
			 
			 req.setAttribute("games", games);
			 req.setAttribute("secondFrame", secondFrame);
			 req.setAttribute("locked", lockout);
			 req.setAttribute("frameIDWXYZ", frameID);
			 req.setAttribute("washout", GameController.getWashouts(shots));
			 req.setAttribute("split", GameController.getSplits(shots));
			 //req.setAttribute("lane", lane);
			 req.setAttribute("balls", balls);
			 req.setAttribute("error", error);
			 req.setAttribute("shotScores", shotScores);
			 req.setAttribute("scores", scores); 
			
		}
		else if(first.equals("New")) {
			    shotScores = new String[26];
			    scores = new Integer[12];
			    
			    
			    controller = new GameController();
			    gameID = controller.newGame();
			    List<Ball> balls = controller.getAllBalls();
			    ArrayList<Shot> shots = controller.GetShotsByGame(gameID);
			    ArrayList<Game> games = controller.GetGamesBySession(SessionID);
			    games.add(new Game());
			    
			    req.setAttribute("games", games);
			    req.setAttribute("balls", balls);
			    req.setAttribute("washout", GameController.getWashouts(shots));
			    req.setAttribute("split", GameController.getSplits(shots));
				req.getRequestDispatcher("/_view/game.jsp").forward(req, resp);
		}
		else if(first.equals("Rem")) {
			System.out.println("removing");
			 ArrayList<Game> games = controller.GetGamesBySession(SessionID);
			 //gameID = Integer.parseInt((String)req.getParameter("Game"));
			 System.out.println("gotGameID");
			 ArrayList<Shot> shots = controller.GetShotsByGame(gameID);
			 ArrayList<Frame> frames = controller.GetFramesByGame(gameID);
			 List<Ball> balls = controller.getAllBalls();
			 String error = null;
			 int ball1 = 0;
			 if(shots.size()>0&&shots.get(shots.size()-1).getShotNumber()==2) {
				 controller.removeShot(shots.get(shots.size()-1));
			 }
			 else if(shots.size()>0){
				 controller.removeShot(shots.get(shots.size()-1));
				 controller.removeFrame(frames.get(frames.size()-1));
			 }
			 shots = controller.GetShotsByGame(gameID);
			 frames = controller.GetFramesByGame(gameID);
			 boolean[] lockout = new boolean[10];
			 boolean[] secondFrame = new boolean[1];
			 
			 req.setAttribute("games", games);
			 
			 controller.updateframeScores(frames, shots);
			 shotScores = GameController.parseShots(shots);
			 scores = GameController.parseScores(frames, shots);
			 
			 req.setAttribute("games", games);
			 req.setAttribute("secondFrame", secondFrame);
			 req.setAttribute("locked", lockout);
			 req.setAttribute("frameIDWXYZ", frameID);
			 req.setAttribute("washout", GameController.getWashouts(shots));
			 req.setAttribute("split", GameController.getSplits(shots));
			 //req.setAttribute("lane", lane);
			 req.setAttribute("balls", balls);
			 req.setAttribute("error", error);
			 req.setAttribute("shotScores", shotScores);
			 req.setAttribute("scores", scores); 
		}
		else {
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
	    String lane = "";
	    try {
	    	ball1 = Integer.parseInt(req.getParameter("ball1"));
	    	System.out.println(ball1);
	    	lane = req.getParameter("lane");
	    }
	    finally{
	    	
	    }
	    // Retrieving parameter from request
	   
	    shots.add(GameController.addShot(shots, first, firstFoul, ball1));
	    //System.out.println("starting frameID");
	    boolean[] lockout = new boolean[10];
	    boolean[] secondFrame = new boolean[1];
	    
	   
	    
	    if(shots.get(shots.size()-1).getShotNumber()==1) {
	    	frames.add(GameController.addFrame(shots.get(shots.size()-1), null, lane));
	    	frameID= controller.storeFrame(frames.get(frames.size()-1));
	    	if(!GameController.isStrike(shots.get(shots.size()-1))) {
	    		lockout = GameController.getLockout(first);
	    		secondFrame[0]=true;
	    	}
	    }
	    else {
	    	frames.get(frames.size()-1).setFrameScore(GameController.frameScore(shots.get(shots.size()-2), shots.get(shots.size()-1)));
	    }
	    //int frameID= controller.storeFrame(frames.get(frames.size()-1));
	    controller.storeShot(gameID, frameID, shots.get(shots.size()-1),SessionID);
	    
	    controller.updateframeScores(frames, shots);
	    shotScores = GameController.parseShots(shots);
	    scores = GameController.parseScores(frames, shots);
	    controller.updateGameScore(gameID ,scores[10]);
	    ArrayList<Game> games = controller.GetGamesBySession(SessionID);
		controller.updateSessionDate(SessionID);
		controller.updateSessionScore(SessionID);
	    req.setAttribute("games", games);
	    req.setAttribute("secondFrame", secondFrame);
	    req.setAttribute("locked", lockout);
	    req.setAttribute("frameIDWXYZ", frameID);
	    req.setAttribute("washout", GameController.getWashouts(shots));
	    req.setAttribute("split", GameController.getSplits(shots));
	    req.setAttribute("lane", lane);
	    req.setAttribute("balls", balls);
	    req.setAttribute("error", error);
	    req.setAttribute("shotScores", shotScores);
	    req.setAttribute("scores", scores); 
		}
	    // Forwarding request and response to JSP page
		if(shotScores != null && GameController.isOver(shotScores)) {
			boolean[] locker = {true,true,true,true,true,true,true,true,true,true};
			req.setAttribute("locked", locker);
		}
	    req.getRequestDispatcher("/_view/game.jsp").forward(req, resp);
	}
	protected void doUpdate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}


}