package revMetrix.model;

import java.util.ArrayList;

import java.util.List;

 
public class RevMetrix {
	public static ArrayList<Account> AccountsList = new ArrayList<>();
    private ArrayList<Game> GamesList = new ArrayList<>();
    private ArrayList<Event> EventsList = new ArrayList<>();
    private ArrayList<Ball> BallsList = new ArrayList<>();
    private ArrayList<Tournament> TournamentList = new ArrayList<>();
    
    //constructor
    public RevMetrix() {
        AccountsList = new ArrayList<>();
        GamesList = new ArrayList<>();
        EventsList = new ArrayList<>();
        BallsList = new ArrayList<>();
        TournamentList = new ArrayList<>();
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
    public void addTournament(Tournament tournament) {
    	TournamentList.add(tournament);
    }
    
    public ArrayList<Account> getAccountsList(){
    	return AccountsList;
    }
    public ArrayList<Game> getGamesList(){
    	return GamesList;
    }
    public ArrayList<Event> geEventsList(){
    	return EventsList;
    }
    public ArrayList<Ball> getBallsList(){
    	return BallsList;
    }
    public ArrayList<Tournament> getTournamentList(){
    	return TournamentList;
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
        public void setEmail(String email) {
        	Account.email = email;
        }
        public void setUsername(String username) {
        	Account.username = username;
        }
        public void setPassword(String password) {
        	Account.password = password;
        }
        public void setLoggedIn(boolean isLoggedIn) {
        	Account.isLoggedIn = isLoggedIn;
        }
    }
    public static class Game{
    	private String gameId;
        private String playerName;
        private int score;
        private boolean[] pins;

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
    	private String eventId;
        private String eventName;
        private String eventDescription;

        public Event(String eventId, String eventName, String eventDescription) {
            this.eventId = eventId;
            this.eventName = eventName;
            this.eventDescription = eventDescription;
        }
        
        //getters
        public String getEventId() {
            return eventId;
        }
        public String getEventName() {
            return eventName;
        }
        public String getEventDescription() {
            return eventDescription;
        }
        
        //setters
        public void setEventId(String eventId) {
            this.eventId = eventId;
        }
        public void setEventName(String eventName) {
            this.eventName = eventName;
        }
        public void setEventDescription(String eventDescription) {
            this.eventDescription = eventDescription;
        }
    }
    public static class Ball{
    	private String ballId;
        private String brand;
        private String weight;

        public Ball(String ballId, String brand, String weight) {
            this.ballId = ballId;
            this.brand = brand;
            this.weight = weight;
        }
        
        //getters
        public String getBallId() {
            return ballId;
        }
        public String getBrand() {
            return brand;
        }
        public String getWeight() {
            return weight;
        }
        
        //setters
        public void setBallId(String ballId) {
            this.ballId = ballId;
        }
        public void setBrand(String brand) {
            this.brand = brand;
        }
        public void setWeight(String weight) {
            this.weight = weight;
        }
    }
    
    public static class Tournament {
        private int tournamentId;
        private String tournamentName;
        private String tournamentStartDate;
        private String tournamentLocation;
        private String tournamentDescription;
        private int tournamentCapacity;
    
        public Tournament(int tournamentId, String tournamentName, String tournamentStartDate, String tournamentLocation, String tournamentDescription, int tournamentCapacity) {
        this.tournamentId = tournamentId;
        this.tournamentName = tournamentName;
        this.tournamentStartDate = tournamentStartDate;
        this.tournamentLocation = tournamentLocation;
        this.tournamentDescription = tournamentDescription;
        this.tournamentCapacity = tournamentCapacity;
        }
        
        // Getter methods
        public int getTournamentId() {
            return tournamentId;
        }

        public String getTournamentName() {
            return tournamentName;
        }

        public String getTournamentStartDate() {
            return tournamentStartDate;
        }

        public String getTournamentLocation() {
            return tournamentLocation;
        }

        public String getTournamentDescription() {
            return tournamentDescription;
        }

        public int getTournamentCapacity() {
            return tournamentCapacity;
        }

        // Setter methods
        public void setTournamentId(int tournamentId) {
            this.tournamentId = tournamentId;
        }

        public void setTournamentName(String tournamentName) {
            this.tournamentName = tournamentName;
        }

        public void setTournamentStartDate(String tournamentStartDate) {
            this.tournamentStartDate = tournamentStartDate;
        }

        public void setTournamentLocation(String tournamentLocation) {
            this.tournamentLocation = tournamentLocation;
        }

        public void setTournamentDescription(String tournamentDescription) {
            this.tournamentDescription = tournamentDescription;
        }

        public void setTournamentCapacity(int tournamentCapacity) {
            this.tournamentCapacity = tournamentCapacity;
        }
        
    }
    
}
