package revMetrix.model;

import java.util.ArrayList;
import java.util.List;


public class RevMetrix {
    public static List<Account> AccountsList = new ArrayList<>();
    public static List<Game> GamesList = new ArrayList<>();
    public static List<Event> EventsList = new ArrayList<>();
    public static List<Ball> BallsList = new ArrayList<>();
    
    //constructor
    public RevMetrix() {
        AccountsList = new ArrayList<>();
        GamesList = new ArrayList<>();
        EventsList = new ArrayList<>();
        BallsList = new ArrayList<>();
    }
    
    //add to an arraylist
    public void addAccount(Account account) {
        AccountsList.add(account);
    }
    public void addGame(Game game) {
        GamesList.add(game);
    }
    public void addEvent(Event event) {
        EventsList.add(event);
    }
    public void addBall(Ball ball) {
        BallsList.add(ball);
    }
    
    

    public static class Account {

		public static String email;
    	public static String username;
    	public static String password;
    	public static boolean isLoggedIn;

        public Account(String email, String username, String password, boolean isLoggedIn) {
        	Account.email = email;
            Account.username = username;
            Account.password = password;
            Account.isLoggedIn = isLoggedIn;
        }
        
        //getters
        public static String getEmail() {
            return email;
        }
        public static String getUsername() {
            return username;
        }
        public static String getPassword() {
            return password;
        }
        public static boolean getIsLoggedIn() {
            return isLoggedIn;
        }
        
        //setters
        public static void setEmail(String email) {
            Account.email = email;
        }
        public static void setUsername(String username) {
            Account.username = username;
        }
        public static void setPassword(String password) {
            Account.password = password;
        }
        public static void setLoggedIn(boolean isLoggedIn) {
        	Account.isLoggedIn = isLoggedIn;
        }
    }
    
    public static class Game{
    	public String gameId;
    	public String playerName;
        public int score;
        public boolean[] pins;

        public Game(String gameId, String playerName, int score, boolean[] pins) {
            this.gameId = gameId;
            this.playerName = playerName;
            this.score = score;
            this.pins = pins;
        }
        
      //getters
        public String getGameId() {
            return gameId;
        }
        public String getPlayerName() {
            return playerName;
        }
        public int getScore() {
            return score;
        }
        public boolean[] getPins() {
            return pins;
        }
        
        //setters
        public void setGameId(String gameId) {
            this.gameId = gameId;
        }
        public void setPlayerName(String playerName) {
            this.playerName = playerName;
        }
        public void setScore(int score) {
            this.score = score;
        }
        public void setPins(boolean[] pins) {
            this.pins = pins;
        }
    }
    public static class Event{
    	public static String eventId;
    	public static String eventName;
    	public static String eventDescription;

        public Event(String eventId, String eventName, String eventDescription) {
            Event.eventId = eventId;
            Event.eventName = eventName;
            Event.eventDescription = eventDescription;
        }
        
        //getters
        public static String getEventId() {
            return eventId;
        }
        public String getEventName() {
            return eventName;
        }
        public String getEventDescription() {
            return eventDescription;
        }
        
        //setters
        public static void setEventId(String eventId) {
        	Event.eventId = eventId;
        }
        public static void setEventName(String eventName) {
        	Event.eventName = eventName;
        }
        public static void setEventDescription(String eventDescription) {
        	Event.eventDescription = eventDescription;
        }
    }
    public static class Ball{
    	public static String ballId;
    	public static String brand;
    	public static String weight;

        public Ball(String ballId, String brand, String weight) {
            Ball.ballId = ballId;
            Ball.brand = brand;
            Ball.weight = weight;
        }
        
        //getters
        public static String getBallId() {
            return ballId;
        }
        public static String getBrand() {
            return brand;
        }
        public static String getWeight() {
            return weight;
        }
        
        //setters
        public static void setBallId(String ballId) {
        	Ball.ballId = ballId;
        }
        public static void setBrand(String brand) {
        	Ball.brand = brand;
        }
        public static void setWeight(String weight) {
        	Ball.weight = weight;
        }
    }
}
