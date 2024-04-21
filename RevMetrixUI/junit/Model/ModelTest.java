package Model;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import revMetrix.db.model.Account;
import revMetrix.db.model.Ball;
import revMetrix.db.model.Establishment;
import revMetrix.db.model.Event;
import revMetrix.db.model.Frame;
import revMetrix.db.model.Game;
import revMetrix.db.model.Junction;
import revMetrix.db.model.Session;
import revMetrix.db.model.Shot;

public class ModelTest {
	private Account account;
	private Ball ball;
	private Establishment establishment;
	private Event event;
	private Frame frame;
	private Game game;
	private Junction junction;
	private Session session;
	private Shot shot;
	
	@Before
	public void setUp() {
		account = new Account();
		ball = new Ball();
		establishment = new Establishment();
		event = new Event();
		frame = new Frame();
		game = new Game();
		junction = new Junction();
		session = new Session();
		shot = new Shot();
	}
	
	//ACCOUNT TESTS=======================================
	@Test
    public void testSetAndGetAccountId() {
        int accountId = 12345;
        account.setAccountId(accountId);
        assertEquals(accountId, account.getAccountId());
    }
    @Test
    public void testSetAndGetEmail() {
        String email = "example@example.com";
        account.setEmail(email);
        assertEquals(email, account.getEmail());
    }
    @Test
    public void testSetAndGetPassword() {
        String password = "password123";
        account.setPassword(password);
        assertEquals(password, account.getPassword());
    }
    @Test
    public void testSetAndgetFirstname() {
        String firstname = "John";
        account.setFirstname(firstname);
        assertEquals(firstname, account.getFirstname());
    }
    @Test
    public void testSetAndgetLastname() {
        String lastname = "Doe";
        account.setLastname(lastname);
        assertEquals(lastname, account.getLastname());
    }
    @Test
    public void testSetAndIsLoggedIn() {
        boolean isLoggedIn = true;
        account.setIsLoggedIn(isLoggedIn);
        assertEquals(isLoggedIn, account.isLoggedIn());
    }
  //====================================================
  //BALL TESTS==========================================
    @Test
    public void testSetAndGetBallId() {
        int ballId = 12345;
        ball.setBallId(ballId);
        assertEquals(ballId, ball.getBallId());
    }
    @Test
    public void testSetAndGetWeight() {
        int weight = 16;
        ball.setWeight(weight);
        assertEquals(weight, ball.getWeight());
    }
    @Test
    public void testSetAndGetColor() {
        String color = "Red";
        ball.setColor(color);
        assertEquals(color, ball.getColor());
    }
    @Test
    public void testSetAndgetName() {
        String name = "Pro";
        ball.setName(name);
        assertEquals(name, ball.getName());
    }
  //====================================================
  //ESTABLISHMENT TESTS=================================
    @Test
    public void testSetAndGetEstablishmentId() {
        int establishmentId = 12345;
        establishment.setEstablishmentId(establishmentId);
        assertEquals(establishmentId, establishment.getEstablishmentId());
    }
    @Test
    public void testSetAndGetName() {
        String name = "ABC Bowling Alley";
        establishment.setName(name);
        assertEquals(name, establishment.getName());
    }
    @Test
    public void testSetAndGetAddress() {
        String address = "123 Main Street";
        establishment.setAddress(address);
        assertEquals(address, establishment.getAddress());
    }
    @Test
    public void testSetAndGetPhoneNumber() {
        String phoneNumber = "555-1234";
        establishment.setPhoneNumber(phoneNumber);
        assertEquals(phoneNumber, establishment.getPhoneNumber());
    }
    @Test
    public void testSetAndGetLanes() {
        int lanes = 10;
        establishment.setLanes(lanes);
        assertEquals(lanes, establishment.getLanes());
    }
  //====================================================
  //EVENT TESTS=========================================
    @Test
    public void testSetAndGetEventId() {
        int eventId = 12345;
        event.setEventId(eventId);
        assertEquals(eventId, event.getEventId());
    }
    @Test
    public void testSetAndGetType() {
        int type = 2;
        event.setType(type);
        assertEquals(type, event.getType());
    }
    @Test
    public void testSetAndGetEventEstablishmentId() {
        int establishmentId = 6789;
        event.setEstablishmentId(establishmentId);
        assertEquals(establishmentId, event.getEstablishmentId());
    }
    @Test
    public void testSetAndGetEventName() {
        String name = "League Night";
        event.setName(name);
        assertEquals(name, event.getName());
    }
    @Test
    public void testSetAndGetDescription() {
        String description = "Weekly league competition";
        event.setDescription(description);
        assertEquals(description, event.getDescription());
    }
  //====================================================
  //FRAME TESTS=========================================
    @Test
    public void testSetAndGetFrameId() {
        int frameId = 1;
        frame.setFrameId(frameId);
        assertEquals(frameId, frame.getFrameId());
    }
    @Test
    public void testSetAndGetFrameScore() {
        int frameScore = 5;
        frame.setFrameScore(frameScore);
        assertEquals(frameScore, frame.getFrameScore());
    }
    @Test
    public void testSetAndGetLane() {
        int lane = 3;
        frame.setLane(lane);
        assertEquals(lane, frame.getLane());
    }
  //====================================================
  //GAME TESTS==========================================
    @Test
    public void testSetAndGetGameId() {
        int gameId = 12345;
        game.setGameId(gameId);
        assertEquals(gameId, game.getGameId());
    }
    @Test
    public void testSetAndGetGameScore() {
        int gameScore = 250;
        game.setGameScore(gameScore);
        assertEquals(gameScore, game.getGameScore());
    }
    @Test
    public void testSetAndGetStartingLane() {
        int startingLane = 5;
        game.setStartingLane(startingLane);
        assertEquals(startingLane, game.getStartingLane());
    }
    @Test
    public void testSetAndgetOpponent() {
        String opponent = "Team A";
        game.setOpponent(opponent);
        assertEquals(opponent, game.getOpponent());
    }
    @Test
    public void testSetAndGetHandicap() {
        int handicap = 10;
        game.setHandicap(handicap);
        assertEquals(handicap, game.getHandicap());
    }
  //====================================================
  //JUNCTION TESTS======================================
    @Test
    public void testSetAndGetJunctionSessionId() {
        int sessionId = 1;
        junction.setSessionId(sessionId);
        assertEquals(sessionId, junction.getSessionId());
    }
    @Test
    public void testSetAndGetJunctionFrameId() {
        int frameId = 2;
        junction.setFrameId(frameId);
        assertEquals(frameId, junction.getFrameId());
    }
    @Test
    public void testSetAndGetJunctionGameId() {
        int gameId = 3;
        junction.setGameId(gameId);
        assertEquals(gameId, junction.getGameId());
    }
    @Test
    public void testSetAndGetJunctionShotId() {
        int shotId = 4;
        junction.setShotId(shotId);
        assertEquals(shotId, junction.getShotId());
    }
  //====================================================
  //SESSION TESTS=======================================
    @Test
    public void testSetAndGetSessionId() {
        int sessionId = 1;
        session.setSessionId(sessionId);
        assertEquals(sessionId, session.getSessionId());
    }
    @Test
    public void testSetAndGetSessionScore() {
        int sessionScore = 250;
        session.setSessionScore(sessionScore);
        assertEquals(sessionScore, session.getSessionScore());
    }
    @Test
    public void testSetAndGetSessionEventId() {
        int eventId = 3;
        session.setEventId(eventId);
        assertEquals(eventId, session.getEventId());
    }
    @Test
    public void testSetAndGetSessionLanes() {
        String lanes = "1,2,3";
        session.setLanes(lanes);
        assertEquals(lanes, session.getLanes());
    }
    @Test
    public void testSetAndGetDate() {
        String date = "2024-04-18";
        session.setDate(date);
        assertEquals(date, session.getDate());
    }
    @Test
    public void testSetAndGetUserId() {
        int userId = 5;
        session.setUserId(userId);
        assertEquals(userId, session.getUserId());
    }
  //====================================================
  //SHOT TESTS==========================================
    @Test
    public void testSetAndGetShotId() {
        int shotId = 1;
        shot.setShotId(shotId);
        assertEquals(shotId, shot.getShotId());
    }
    @Test
    public void testSetAndGetShotNumber() {
        int shotNumber = 1;
        shot.setShotNumber(shotNumber);
        assertEquals(shotNumber, shot.getShotNumber());
    }
    @Test
    public void testSetAndGetPins() {
        String pins = "7-2";
        shot.setPins(pins);
        assertEquals(pins, shot.getPins());
    }
    @Test
    public void testSetAndGetShotBallId() {
        int ballId = 2;
        shot.setBallId(ballId);
        assertEquals(ballId, shot.getBallId());
    }
    @Test
    public void testSetAndGetSplit() {
        boolean split = true;
        shot.setSplit(split);
        assertEquals(split, shot.getSplit());
    }
    @Test
    public void testSetAndGetWashout() {
        boolean washout = false;
        shot.setWashout(washout);
        assertEquals(washout, shot.getWashout());
    }
    @Test
    public void testSetAndGetShotScore() {
        String shotScore = "7";
        shot.setShotScore(shotScore);
        assertEquals(shotScore, shot.getShotScore());
    }
  //====================================================
}
	
