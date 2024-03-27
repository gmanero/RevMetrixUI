package revMetrix.model;

import java.util.ArrayList;
public class RevMetrix {
	public static ArrayList<Account> AccountsList = new ArrayList<>();
    private ArrayList<Game> GamesList = new ArrayList<>();
    private ArrayList<Event> EventsList = new ArrayList<>();
    private ArrayList<Ball> BallsList = new ArrayList<>();
    private ArrayList<Tournament> TournamentList = new ArrayList<>();
    private ArrayList<Practice> PracticeList = new ArrayList<>();
    private ArrayList<League> LeagueList = new ArrayList<>();
    
    //constructor
    public RevMetrix() {
        AccountsList = new ArrayList<>();
        GamesList = new ArrayList<>();
        EventsList = new ArrayList<>();
        BallsList = new ArrayList<>();
        TournamentList = new ArrayList<>();
        PracticeList = new ArrayList<>();
        LeagueList = new ArrayList<>();
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
    public void addPractice(Practice practice) {
    	PracticeList.add(practice);
    }
    public void addLeague(League league) {
    	LeagueList.add(league);
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
    public ArrayList<Practice> getPracticeList(){
    	return PracticeList;
    }
    public ArrayList<League> getLeagueList(){
    	return LeagueList;
    }
    

    public static class Account {
        private String email;
        private String username;
        private String password;
        private boolean isLoggedIn;

        public Account(String email, String username, String password, boolean isLoggedIn) {
            this.email = email;
            this.username = username;
            this.password = password;
            this.isLoggedIn = isLoggedIn;
        }

        public String getEmail() {
            return email;
        }

        public String getUsername() {
            return username;
        }

        public String getPassword() {
            return password;
        }

        public boolean getIsLoggedIn() {
            return isLoggedIn;
        }
    }
    public static class Game{
    	private String gameId;
        private String playerName;
        private int score;
        private boolean[] pins;
        private int[] scoreBoard;
        private int shotNum;

        public Game(String gameId, String playerName, int score, boolean[] pins, int[] scoreBoard, int shotNum) {
            this.gameId = gameId;
            this.playerName = playerName;
            this.score = score;
            this.pins = pins;
            this.scoreBoard = scoreBoard;
            this.shotNum = shotNum;
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
        public int[] getScoreBoard() {
            return scoreBoard;
        }
        public int getScoreBoardValue(int index) {
            return scoreBoard[index];
        }
        public int getShotNum() {
            return shotNum;
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
        public void setScoreBoard(int[] value) {
            this.scoreBoard = value;
        }
        public void setScoreBoardValue(int index, int value) {
            this.scoreBoard[index] = value;
        }
        public void setShotNum(int shotnum) {
            this.shotNum = shotnum;
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
        public String tournamentName;
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
    public static class Practice {
        private int practiceId;
        private String practiceName;
        private String practiceStartDate;
        private String practiceLocation;
        private String practiceDescription;
        private int practiceCapacity;
    
        public Practice(int practiceId, String practiceName, String practiceStartDate, String practiceLocation, String practiceDescription, int practiceCapacity) {
        this.practiceId = practiceId;
        this.practiceName = practiceName;
        this.practiceStartDate = practiceStartDate;
        this.practiceLocation = practiceLocation;
        this.practiceDescription = practiceDescription;
        this.practiceCapacity = practiceCapacity;
        }
        
     // Getter methods
        public int getPracticeId() {
            return practiceId;
        }

        public String getPracticeName() {
            return practiceName;
        }

        public String getPracticeStartDate() {
            return practiceStartDate;
        }

        public String getPracticeLocation() {
            return practiceLocation;
        }

        public String getPracticeDescription() {
            return practiceDescription;
        }

        public int getPracticeCapacity() {
            return practiceCapacity;
        }

        // Setter methods
        public void setPracticeId(int practiceId) {
            this.practiceId = practiceId;
        }

        public void setPracticeName(String practiceName) {
            this.practiceName = practiceName;
        }

        public void setPracticeStartDate(String practiceStartDate) {
            this.practiceStartDate = practiceStartDate;
        }

        public void setPracticeLocation(String practiceLocation) {
            this.practiceLocation = practiceLocation;
        }

        public void setPracticeDescription(String practiceDescription) {
            this.practiceDescription = practiceDescription;
        }

        public void setPracticeCapacity(int practiceCapacity) {
            this.practiceCapacity = practiceCapacity;
        }        
    }
    public static class League {
        private int leagueId;
        private String leagueName;
        private String leagueStartDate;
        private String leagueLocation;
        private String leagueDescription;
        private int leagueCapacity;

        public League(int leagueId, String leagueName, String leagueStartDate, String leagueLocation, String leagueDescription, int leagueCapacity) {
            this.leagueId = leagueId;
            this.leagueName = leagueName;
            this.leagueStartDate = leagueStartDate;
            this.leagueLocation = leagueLocation;
            this.leagueDescription = leagueDescription;
            this.leagueCapacity = leagueCapacity;
        }

        // Getter methods
        public int getLeagueId() {
            return leagueId;
        }

        public String getLeagueName() {
            return leagueName;
        }

        public String getLeagueStartDate() {
            return leagueStartDate;
        }

        public String getLeagueLocation() {
            return leagueLocation;
        }

        public String getLeagueDescription() {
            return leagueDescription;
        }

        public int getLeagueCapacity() {
            return leagueCapacity;
        }

        // Setter methods
        public void setLeagueId(int leagueId) {
            this.leagueId = leagueId;
        }

        public void setLeagueName(String leagueName) {
            this.leagueName = leagueName;
        }

        public void setLeagueStartDate(String leagueStartDate) {
            this.leagueStartDate = leagueStartDate;
        }

        public void setLeagueLocation(String leagueLocation) {
            this.leagueLocation = leagueLocation;
        }

        public void setLeagueDescription(String leagueDescription) {
            this.leagueDescription = leagueDescription;
        }

        public void setLeagueCapacity(int leagueCapacity) {
            this.leagueCapacity = leagueCapacity;
        }
    }

    
    
}
