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
        public String email;
		public String username;
		public String password;
		public boolean isLoggedIn;

        public Account(String email, String username, String password, boolean isLoggedIn) {
        	this.email = email;
        	this.username = username;
        	this.password = password;
        	this.isLoggedIn = isLoggedIn;
        }
        
        //getters
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
        
        //setters
        public void setEmail(String email) {
        	this.email = email;
        }
        public void setUsername(String username) {
        	this.username = username;
        }
        public void setPassword(String password) {
        	this.password = password;
        }
        public void setLoggedIn(boolean isLoggedIn) {
        	this.isLoggedIn = isLoggedIn;
        }

    }
    public static class Game{
    	private String gameId;
        private String playerName;
        private int score;
        private boolean[] pins;
        private Object[] scoreBoard;
        private int shotNum;
        private int[] scoreBoardTot;
        private int scoreBoardTotNum;
        private int pinsRemain;
        private int totStrike;
        private int totSpare;
        private int totGutter;
        private int totFoul;




        public Game(String gameId, String playerName, int score, boolean[] pins, Object[] scoreBoard, int shotNum, int[]scoreBoardTot, int scoreBoardTotNum, int pinsRemain, int totStrike, int totSpare, int totGutter, int totFoul) {
            this.gameId = gameId;
            this.playerName = playerName;
            this.score = score;
            this.pins = pins;
            this.scoreBoard = scoreBoard;
            this.shotNum = shotNum;
            this.scoreBoardTot = scoreBoardTot;
            this.scoreBoardTotNum = scoreBoardTotNum;
            this.pinsRemain = pinsRemain;
            this.totStrike = totStrike;
            this.totSpare = totSpare;
            this.totGutter = totGutter;
            this.totFoul = totFoul;
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
        public Object[] getScoreBoard() {
            return scoreBoard;
        }
        public Object getScoreBoardValue(int index) {
            return scoreBoard[index];
        }
        public int getShotNum() {
            return shotNum;
        }
        public int[] getScoreBoardTot() {
            return scoreBoardTot;
        }
        public int getScoreBoardTotValue(int index) {
            return scoreBoardTot[index];
        }
        public int getScoreBoardTotNum() {
            return scoreBoardTotNum;
        }
        public int getPinsRemain() {
            return pinsRemain;
        }
        public int getTotStrike() {
            return totStrike;
        }
        public int getTotSpare() {
            return totSpare;
        }
        public int getTotGutter() {
            return totGutter;
        }
        public int getTotFoul() {
            return totFoul;
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
        public void setScoreBoard(Object[] value) {
            this.scoreBoard = value;
        }
        public void setScoreBoardValue(int index, Object value) {
            this.scoreBoard[index] = value;
        }
        public void setShotNum(int shotnum) {
            this.shotNum = shotnum;
        }
        public void setScoreBoardTot(int[] scoreBoardTot) {
            this.scoreBoardTot = scoreBoardTot;
        }
        public void setScoreBoardTotValue(int index, int value) {
            this.scoreBoardTot[index] = value;
        }
        public void setScoreBoardTotNum(int scoreBoardTotNum) {
            this.scoreBoardTotNum = scoreBoardTotNum;
        }
        public void setPinsRemain(int pinsRemain) {
            this.pinsRemain = pinsRemain;
        }
        public void setTotStrike(int totStrike) {
            this.totStrike = totStrike;
        }
        public void setTotSpare(int totSpare) {
            this.totSpare = totSpare;
        }
        public void setTotGutter(int totGutter) {
            this.totGutter = totGutter;
        }
        public void setTotFoul(int totFoul) {
            this.totFoul = totFoul;
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
    
    public void addBall(String ballId, String weight, String color) {
        BallsList.add(new Ball(ballId, weight, color));
    }
    
    public static class Ball{
    	private String ballId;
        private String weight;
        private String color;
        


        public Ball(String ballId, String weight, String color) {
            this.ballId = ballId;
            this.weight = weight;
            this.color = color;
        }
        
        //getters
        public String getBallId() {
            return ballId;
        }
        public String getColor() {
            return color;
        }
        public String getWeight() {
            return weight;
        }
        
        //setters
        public void setBallId(String ballId) {
            this.ballId = ballId;
        }
        public void setBrand(String color) {
            this.color = color;
        }
        public void setWeight(String weight) {
            this.weight = weight;
        }
    }

    public static class Stats{
    	private int avgFrameScore;
        private int strikePer;
        private int sparePer;
        private int openFrame;

        public Stats(int avgFrameScore, int strikePer, int sparePer, int openFrame) {
            this.avgFrameScore = avgFrameScore;
            this.strikePer = strikePer;
            this.sparePer = sparePer;
            this.openFrame = openFrame;
        }
        
        //getters
        public int getAvgFrameScore() {
            return avgFrameScore;
        }
        public int getBrand() {
            return strikePer;
        }
        public int getSparePer() {
            return sparePer;
        }
        public int getOpenFrame() {
            return openFrame;
        }
        
        //setters
        public void setBallId(int avgFrameScore) {
            this.avgFrameScore = avgFrameScore;
        }
        public void strikePer(int strikePer) {
            this.strikePer = strikePer;
        }
        public void setSparePer(int sparePer) {
            this.sparePer = sparePer;
        }
        public void setOpenFrame(int openFrame) {
            this.openFrame = openFrame;
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
