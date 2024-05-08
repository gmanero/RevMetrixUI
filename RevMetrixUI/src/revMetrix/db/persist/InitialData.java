package revMetrix.db.persist;

import java.io.IOException;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import revMetrix.db.model.Account;
import revMetrix.db.model.Ball;
import revMetrix.db.model.Establishment;
import revMetrix.db.model.Event;
import revMetrix.db.model.Frame;
import revMetrix.db.model.Game;
import revMetrix.db.model.Session;
import revMetrix.db.model.Pair;
import revMetrix.db.model.Junction;
import revMetrix.db.model.Shot;

public class InitialData {

	// reads initial Author data from CSV file and returns a List of Authors
	public static List<Account> getAccounts() throws IOException {
		List<Account> accountList = new ArrayList<Account>();
		ReadCSV readAccounts = new ReadCSV("account.csv");
		try {
			// auto-generated primary key for authors table
			Integer accountId =1;
			while (true) {
				List<String> tuple = readAccounts.next();
				if (tuple == null) {
					break;
				}
				Iterator<String> i = tuple.iterator();
				Account account = new Account();
				Integer.parseInt(i.next());
				// read author ID from CSV file, but don't use it
				// it's there for reference purposes, just make sure that it is correct
				// when setting up the BookAuthors CSV file				
				// auto-generate author ID, instead
				account.setAccountId(accountId++);				
				account.setEmail(i.next());
				account.setPassword(i.next());
				account.setFirstname(i.next());
				account.setLastname(i.next());
				account.setIsLoggedIn(Boolean.parseBoolean(i.next()));
				accountList.add(account);
			}
			System.out.println("accountList loaded from CSV file");
			return accountList;
		} finally {
			readAccounts.close();
		}
	}
	
	// reads initial Book data from CSV file and returns a List of Books
	public static List<Ball> getBalls() throws IOException {
		List<Ball> ballList = new ArrayList<Ball>();
		ReadCSV readBalls = new ReadCSV("ball.csv");
		try {
			// auto-generated primary key for table books
			Integer ballId = 1;
			while (true) {
				List<String> tuple = readBalls.next();
				if (tuple == null) {
					break;
				}
				Iterator<String> i = tuple.iterator();
				Ball ball = new Ball();
				Integer.parseInt(i.next());
				// read book ID from CSV file, but don't use it
				// it's there for reference purposes, just make sure that it is correct
				// when setting up the BookAuthors CSV file
				// auto-generate book ID, instead
				ball.setBallId(ballId++);				
				ball.setWeight(Integer.parseInt(i.next()));
				ball.setColor(i.next());
				ball.setName(i.next());
				
				ballList.add(ball);
			}
			System.out.println("ballList loaded from CSV file");			
			return ballList;
		} finally {
			readBalls.close();
		}
	}
	
	// reads initial Book data from CSV file and returns a List of Books
		public static List<Establishment> getEstablishments() throws IOException {
			List<Establishment> establishmentList = new ArrayList<Establishment>();
			ReadCSV readEstablishments = new ReadCSV("establishment.csv");
			try {
				// auto-generated primary key for table books
				Integer establishmentId = 1;
				while (true) {
					List<String> tuple = readEstablishments.next();
					if (tuple == null) {
						break;
					}
					Iterator<String> i = tuple.iterator();
					Establishment establishment = new Establishment();
					Integer.parseInt(i.next());
					// read book ID from CSV file, but don't use it
					// it's there for reference purposes, just make sure that it is correct
					// when setting up the BookAuthors CSV file
					// auto-generate book ID, instead
					establishment.setEstablishmentId(establishmentId++);				
					establishment.setName(i.next());
					establishment.setAddress(i.next());
					establishment.setPhoneNumber(i.next());
					establishment.setLanes(Integer.parseInt(i.next()));
					establishmentList.add(establishment);
				}
				System.out.println("establishmentList loaded from CSV file");			
				return establishmentList;
			} finally {
				readEstablishments.close();
			}
		}
		
		// reads initial Event data from CSV file and returns a List of Events
	    public static List<Event> getEvents() throws IOException {
	        List<Event> eventList = new ArrayList<Event>();
	        ReadCSV readEvents = new ReadCSV("event.csv");
	        try {
	        	
	            Integer eventId = 1; // auto-generated primary key for events table
	            while (true) {
	                List<String> tuple = readEvents.next();
	                if (tuple == null) {
	                    break;
	                }
	                Iterator<String> i = tuple.iterator();
	                Event event = new Event();
	                Integer.parseInt(i.next());
	                // Read event ID from CSV file, but don't use it. It's there for reference purposes.
	                // Auto-generate event ID instead.
	           
	                event.setEventId(eventId++);
	                
	                // Assuming your Event model has properties like type, establishmentId, name, and description.
	                event.setType(Integer.parseInt(i.next()));
	                event.setEstablishmentId(Integer.parseInt(i.next()));
	                event.setName(i.next());
	                event.setDescription(i.next());
	                event.setDone(Boolean.parseBoolean(i.next()));
	                event.setStartdate(i.next());
	                
	                eventList.add(event);
	            }
	            System.out.println("eventList loaded from CSV file");
	            return eventList;
	        } finally {
	            readEvents.close();
	        }
	    }
	    
	 // reads initial Frame data from CSV file and returns a List of Frames
	    public static List<Frame> getFrames() throws IOException {
	        List<Frame> frameList = new ArrayList<Frame>();
	        ReadCSV readFrames = new ReadCSV("frame.csv");
	        try {
	        	
	            Integer frameId = 1; // auto-generated primary key for frames table
	            while (true) {
	                List<String> tuple = readFrames.next();
	                if (tuple == null) {
	                    break;
	                }
	                Iterator<String> i = tuple.iterator();
	                Frame frame = new Frame();
	                Integer.parseInt(i.next());
	                // Read frame ID from CSV file, but don't use it. It's there for reference purposes.
	                // Auto-generate frame ID instead.
	          
	                frame.setFrameId(frameId++);
	                frame.setFrameScore(Integer.parseInt(i.next()));
	                frame.setLane(Integer.parseInt(i.next()));
	                
	                frameList.add(frame);
	            }
	            System.out.println("frameList loaded from CSV file");
	            return frameList;
	        } finally {
	            readFrames.close();
	        }
	    }
	    
	 // reads initial Game data from CSV file and returns a List of Games
	    public static List<Game> getGames() throws IOException {
	        List<Game> gameList = new ArrayList<Game>();
	        ReadCSV readGames = new ReadCSV("game.csv");
	        try {
	        	
	        	Integer gameId = 1; // auto-generated primary key for games table
	            while (true) {
	                List<String> tuple = readGames.next();
	                if (tuple == null) {
	                    break;
	                }
	                Iterator<String> i = tuple.iterator();
	                Game game = new Game();
	                Integer.parseInt(i.next());
	                // Read game ID from CSV file, but don't use it. It's there for reference purposes.
	                // Auto-generate game ID instead.
	              
	                game.setGameId(gameId++);
	                game.setGameScore(Integer.parseInt(i.next()));
	                game.setStartingLane(Integer.parseInt(i.next()));
	                game.setOpponent(i.next());
	                game.setHandicap(Integer.parseInt(i.next()));
	                game.setdone(true);
	                
	                gameList.add(game);
	            }
	            System.out.println("gameList loaded from CSV file");
	            return gameList;
	        } finally {
	            readGames.close();
	        }
	    }
		
	    public static List<Session> getSessions() throws IOException {
	        List<Session> sessionList = new ArrayList<Session>();
	        ReadCSV readSessions = new ReadCSV("session.csv");
	        try {
	        	
	            Integer sessionId = 1; // auto-generated primary key for sessions table
	            while (true) {
	                List<String> tuple = readSessions.next();
	                if (tuple == null) {
	                    break;
	                }
	                Iterator<String> i = tuple.iterator();
	                Session session = new Session();
	                Integer.parseInt(i.next());
	                // Read session ID from CSV file, but don't use it. It's there for reference purposes.
	                // Auto-generate session ID instead.
	        
	                session.setSessionId(sessionId++);
	                session.setSessionScore(Integer.parseInt(i.next()));
	                session.setEventId(Integer.parseInt(i.next()));
	                session.setLanes(i.next());
	                session.setDate(i.next());
	                session.setUserId(Integer.parseInt(i.next()));
	                
	                sessionList.add(session);
	            }
	            System.out.println("sessionList loaded from CSV file");
	            return sessionList;
	        } finally {
	            readSessions.close();
	        }
	    }
	    
	 // reads initial Shot data from CSV file and returns a List of Shots
	    public static List<Shot> getShots() throws IOException {
	        List<Shot> shotList = new ArrayList<Shot>();
	        ReadCSV readShots = new ReadCSV("shot.csv");
	        try {
	        	
	            Integer shotId = 1; // auto-generated primary key for shots table
	            while (true) {
	                List<String> tuple = readShots.next();
	                if (tuple == null) {
	                    break;
	                }
	                Iterator<String> i = tuple.iterator();
	                Shot shot = new Shot();
	                Integer.parseInt(i.next());
	                // Read shot ID from CSV file, but don't use it. It's there for reference purposes.
	                // Auto-generate shot ID instead.
	                
	                shot.setShotId(shotId++);
	                shot.setShotNumber(Integer.parseInt(i.next()));
	                shot.setPins(i.next());
	                shot.setBallId(Integer.parseInt(i.next()));
	                shot.setSplit(Boolean.parseBoolean(i.next()));
	                shot.setWashout(Boolean.parseBoolean(i.next()));
	                shot.setShotScore(i.next());
	                
	                shotList.add(shot);
	            }
	            System.out.println("shotList loaded from CSV file");
	            return shotList;
	        } finally {
	            readShots.close();
	        }
	    }
	    
	// reads initial BookAuthor data from CSV file and returns a List of BookAuthors
	public static List<Junction> getJunction() throws IOException {
		List<Junction> junctionList = new ArrayList<Junction>();
		ReadCSV readJunction = new ReadCSV("junction.csv");
		try {
			while (true) {
				List<String> tuple = readJunction.next();
				if (tuple == null) {
					break;
				}
				Iterator<String> i = tuple.iterator();
				Junction junction = new Junction();
				junction.setSessionId(Integer.parseInt(i.next()));
				junction.setGameId(Integer.parseInt(i.next()));
				junction.setFrameId(Integer.parseInt(i.next()));
				junction.setShotId(Integer.parseInt(i.next()));
				junctionList.add(junction);
			}
			System.out.println("Junction loaded from CSV file");			
			return junctionList;
		} finally {
			readJunction.close();
		}
	}
}