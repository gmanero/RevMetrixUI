package GameTests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import revMetrix.controller.GameController;
import revMetrix.db.model.Frame;
import revMetrix.db.model.Shot;


public class shotTests {
	@Before
	public void setUp() {
		
	}
	@Test
	public void testShotScore() {
		assertTrue(GameController.getShotScore(1,"0,1,2,3,4,5,6,7,8,9",null,"").equals("-"));
		assertTrue(GameController.getShotScore(1,"0,1,2,3,4,5,6,7,8",null,"").equals("1"));
		assertTrue(GameController.getShotScore(1,"0,1,2,3,4,5,6,7",null,"").equals("2"));
		assertTrue(GameController.getShotScore(1,"0,1,2,3,4,5,6",null,"").equals("3"));
		assertTrue(GameController.getShotScore(1,"0,1,2,3,4,5",null,"").equals("4"));
		assertTrue(GameController.getShotScore(1,"0,1,2,3,4",null,"").equals("5"));
		assertTrue(GameController.getShotScore(1,"0,1,2,3",null,"").equals("6"));
		assertTrue(GameController.getShotScore(1,"0,1,2",null,"").equals("7"));
		assertTrue(GameController.getShotScore(1,"0,1",null,"").equals("8"));
		assertTrue(GameController.getShotScore(1,"0",null,"").equals("9"));
		assertTrue(GameController.getShotScore(1,"",null,"").equals("X"));
		assertTrue(GameController.getShotScore(2,"",null,"").equals("/"));
		assertTrue(GameController.getShotScore(1,"0,1,2,3,4,5,6,7,8,9",null,"F").contentEquals("F"));
		assertTrue(GameController.getShotScore(2,"0,1,2,3,4,5,6,7,8,9",null,"F").contentEquals("F"));
		assertTrue(GameController.getShotScore(2,"0","0,1","").contentEquals("1")); 
		assertTrue(GameController.getShotScore(2,"0,1","0,1,2,3,4","").contentEquals("3"));
		
	}
	@Test
	public void testAddShot() {
		Shot test = GameController.addShot(1, "0,1,2,3,4,5,6,7,8,9", null, "F", 0);
		assertTrue(test.getBallId()==0);
		assertTrue(test.getShotNumber()==1);
		assertTrue(test.getPins().equals("0,1,2,3,4,5,6,7,8,9"));
		assertTrue(test.getShotScore().equals("F"));
		
		Shot test2 = GameController.addShot(2, "0,1,2,3,4,5,6,7,8,9", "0,1,2,3,4,5,6,7,8,9", "", 1);
		assertTrue(test2.getBallId()==1);
		assertTrue(test2.getShotNumber()==2);
		assertTrue(test2.getPins().equals("0,1,2,3,4,5,6,7,8,9"));
		assertTrue(test2.getShotScore().equals("-"));
	}
	@Test
	public void testFrameScore() {
		Shot a = GameController.addShot(1, "0,1,2,3,4,5,6,7,8,9",null, "", 0); 		// -
		Shot b = GameController.addShot(2, "0,1","0,1,2,3,4,5,6,7,8,9", "", 0);		// 8
		Shot c = GameController.addShot(1, "", null, "", 0);						// X
		Shot d = GameController.addShot(1, "0", null,"", 0);						// 9
		Shot e = GameController.addShot(2, "", "0","", 0);							// /
		Shot f = GameController.addShot(1, "0,1,2",null, "", 0); 					// 7
		Shot g = GameController.addShot(2, "1,2","0,1,2", "", 0); 					// 1
		Shot h = GameController.addShot(1, "0,1,2,3,4,5,6,7,8,9", null, "F", 0);	// -
		
		assertTrue(GameController.frameScore(a, b) == 8);
		assertTrue(GameController.frameScore(c,null) == 10);
		assertTrue(GameController.frameScore(d, e)==10);
		assertTrue(GameController.frameScore(f, g)==8);
		
		 
		
	}
	@Test
	public void testAddScoreStrike() {
		Shot a = GameController.addShot(1, "0,1,2,3,4,5,6,7,8,9",null, "", 0); 		// -
		Shot b = GameController.addShot(2, "0,1","0,1,2,3,4,5,6,7,8,9", "", 0);		// 8
		Shot c = GameController.addShot(1, "", null, "", 0);						// X
		Shot d = GameController.addShot(1, "0", null,"", 0);						// 9
		Shot e = GameController.addShot(2, "", "0","", 0);							// /
		Shot f = GameController.addShot(1, "0,1,2",null, "", 0); 					// 7
		Shot g = GameController.addShot(2, "1,2","0,1,2", "", 0); 					// 1
		Shot h = GameController.addShot(1, "0,1,2,3,4,5,6,7,8,9", null, "F", 0);	// -
		
		assertTrue(GameController.addScoreStrike(a, b)==8);
		assertTrue(GameController.addScoreStrike(b, c)==18);
		assertTrue(GameController.addScoreStrike(c, d)==19);
		assertTrue(GameController.addScoreStrike(d, e)==10);
		assertTrue(GameController.addScoreStrike(f, g)==8);
		assertTrue(GameController.addScoreStrike(g, h)==1);
		assertTrue(GameController.addScoreStrike(c, c)==20);
		assertTrue(GameController.addScoreStrike(h, h)==0);
		
	}
	@Test
	public void testAddScoreSpare() {
		Shot a = GameController.addShot(1, "0,1,2,3,4,5,6,7,8,9",null, "", 0); 		// -
		Shot b = GameController.addShot(2, "0,1","0,1,2,3,4,5,6,7,8,9", "", 0);		// 8
		Shot c = GameController.addShot(1, "", null, "", 0);						// X
		Shot d = GameController.addShot(1, "0", null,"", 0);						// 9
		Shot e = GameController.addShot(2, "", "0","", 0);							// /
		Shot f = GameController.addShot(1, "0,1,2",null, "", 0); 					// 7
		Shot g = GameController.addShot(2, "1,2","0,1,2", "", 0); 					// 1
		Shot h = GameController.addShot(1, "0,1,2,3,4,5,6,7,8,9", null, "F", 0);	// -
		assertTrue(GameController.addScoreSpare(a)==0);
		assertTrue(GameController.addScoreSpare(b)==8);
		assertTrue(GameController.addScoreSpare(c)==10);
		assertTrue(GameController.addScoreSpare(d)==9);
		assertTrue(GameController.addScoreSpare(f)==7);
		assertTrue(GameController.addScoreSpare(g)==1);
	}
	@Test
	public void testIsStrike() {
		Shot a = GameController.addShot(1, "0,1,2,3,4,5,6,7,8,9",null, "", 0); 		// -
		Shot b = GameController.addShot(2, "0,1","0,1,2,3,4,5,6,7,8,9", "", 0);		// 8
		Shot c = GameController.addShot(1, "", null, "", 0);						// X
		Shot d = GameController.addShot(1, "0", null,"", 0);						// 9
		Shot e = GameController.addShot(2, "", "0","", 0);							// /
		Shot f = GameController.addShot(1, "0,1,2",null, "", 0); 					// 7
		Shot g = GameController.addShot(2, "1,2","0,1,2", "", 0); 					// 1
		Shot h = GameController.addShot(1, "0,1,2,3,4,5,6,7,8,9", null, "F", 0);	// -
		assertFalse(GameController.isStrike(a));
		assertFalse(GameController.isStrike(b));
		assertTrue(GameController.isStrike(c));
		assertFalse(GameController.isStrike(d));
		assertFalse(GameController.isStrike(e));
		assertFalse(GameController.isStrike(f));
		assertFalse(GameController.isStrike(g));
		assertFalse(GameController.isStrike(h));
	}
	@Test
	public void testIsSpare() {
		Shot a = GameController.addShot(1, "0,1,2,3,4,5,6,7,8,9",null, "", 0); 		// -
		Shot b = GameController.addShot(2, "0,1","0,1,2,3,4,5,6,7,8,9", "", 0);		// 8
		Shot c = GameController.addShot(1, "", null, "", 0);						// X
		Shot d = GameController.addShot(1, "0", null,"", 0);						// 9
		Shot e = GameController.addShot(2, "", "0","", 0);							// /
		Shot f = GameController.addShot(1, "0,1,2",null, "", 0); 					// 7
		Shot g = GameController.addShot(2, "1,2","0,1,2", "", 0); 					// 1
		Shot h = GameController.addShot(1, "0,1,2,3,4,5,6,7,8,9", null, "F", 0);	// -
		assertFalse(GameController.isSpare(a));
		assertFalse(GameController.isSpare(b));
		assertFalse(GameController.isSpare(c));
		assertFalse(GameController.isSpare(d));
		assertTrue(GameController.isSpare(e));
		assertFalse(GameController.isSpare(f));
		assertFalse(GameController.isSpare(g));
		assertFalse(GameController.isSpare(h));
		
	}
	@Test
	public void testGetShotScore() {
		assertTrue(GameController.getShotScore(2, "", "0","")== "/");								// /
		assertTrue(GameController.getShotScore(1, "0,1,2,3,4,5,6,7,8,9", null, "F")== "F");			// F
		assertTrue(GameController.getShotScore(1, "0,1,2,3,4,5,6,7,8,9",null, "") == "-"); 			// -
		assertTrue(GameController.getShotScore(1, "", null, "")== "X");								// X
		
		
		
	}
	@Test
	public void testParseShots() {
		 ArrayList<Shot> shots = new ArrayList<Shot>();
		 shots.add(GameController.addShot(1, "0,1,2,3,4,5,6,7,8,9",null, "", 0)); 		// -
		 shots.add(GameController.addShot(2, "0,1","0,1,2,3,4,5,6,7,8,9", "", 0));		// 8
		 shots.add(GameController.addShot(1, "", null, "", 0));							// X
		 shots.add(GameController.addShot(1, "0", null,"", 0));							// 9
		 shots.add(GameController.addShot(2, "", "0","", 0));							// /
		 shots.add(GameController.addShot(1, "0,1,2",null, "", 0)); 					// 7
		 shots.add(GameController.addShot(2, "1,2","0,1,2", "", 0)); 					// 1
		
		
	}
	@Test
	public void testUpdateFrameScores() {
		 ArrayList<Shot> shots = new ArrayList<Shot>();
		 ArrayList<Frame> frames = new ArrayList<Frame>();
		 shots.add(GameController.addShot(1, "0,1,2,3,4,5,6,7,8,9",null, "", 0)); 		// -
		 shots.add(GameController.addShot(2, "0,1","0,1,2,3,4,5,6,7,8,9", "", 0));		// 8
		 shots.add(GameController.addShot(1, "", null, "", 0));							// X
		 shots.add(GameController.addShot(1, "0", null,"", 0));							// 9
		 shots.add(GameController.addShot(2, "", "0","", 0));							// /
		 shots.add(GameController.addShot(1, "0,1,2",null, "", 0)); 					// 7
		 shots.add(GameController.addShot(2, "1,2","0,1,2", "", 0)); 					// 1
		
		 frames.add(GameController.addFrame(shots.get(0), shots.get(1), "0"));			// 8
		 frames.add(GameController.addFrame(shots.get(2), null, "0"));					// 10
		 frames.add(GameController.addFrame(shots.get(3), shots.get(4), "0"));			// 10
		 frames.add(GameController.addFrame(shots.get(5), shots.get(6), "0"));			// 8
	}
	@Test
	public void testParseScores() {
		 ArrayList<Shot> shots = new ArrayList<Shot>();
		 ArrayList<Frame> frames = new ArrayList<Frame>();
		 shots.add(GameController.addShot(1, "0,1,2,3,4,5,6,7,8,9",null, "", 0)); 		// -
		 shots.add(GameController.addShot(2, "0,1","0,1,2,3,4,5,6,7,8,9", "", 0));		// 8
		 shots.add(GameController.addShot(1, "", null, "", 0));							// X
		 shots.add(GameController.addShot(1, "0", null,"", 0));							// 9
		 shots.add(GameController.addShot(2, "", "0","", 0));							// /
		 shots.add(GameController.addShot(1, "0,1,2",null, "", 0)); 					// 7
		 shots.add(GameController.addShot(2, "1,2","0,1,2", "", 0)); 					// 1
		
		 frames.add(GameController.addFrame(shots.get(0), shots.get(1), "0"));			// 8
		 frames.add(GameController.addFrame(shots.get(2), null, "0"));					// 10
		 frames.add(GameController.addFrame(shots.get(3), shots.get(4), "0"));			// 10
		 frames.add(GameController.addFrame(shots.get(5), shots.get(6), "0"));			// 8
		 
		 
	}
	@Test
	public void testAddFrame() {
		Shot a = GameController.addShot(1, "0,1,2,3,4,5,6,7,8,9",null, "", 0); 		// -
		Shot b = GameController.addShot(2, "0,1","0,1,2,3,4,5,6,7,8,9", "", 0);		// 8
		Shot c = GameController.addShot(1, "", null, "", 0);						// X
		Shot d = GameController.addShot(1, "0", null,"", 0);						// 9
		Shot e = GameController.addShot(2, "", "0","", 0);							// /
		Shot f = GameController.addShot(1, "0,1,2",null, "", 0); 					// 7
		Shot g = GameController.addShot(2, "1,2","0,1,2", "", 0); 					// 1
		Shot h = GameController.addShot(1, "0,1,2,3,4,5,6,7,8,9", null, "F", 0);	// -
		Frame one	 = GameController.addFrame(a, b, "1-2");
		Frame two	 = GameController.addFrame(c, null, "1-2");
		Frame three	 = GameController.addFrame(d, e, "1-2");
		Frame four = GameController.addFrame(f, g, "1-2");
		assertTrue(one.getFrameScore()==8);
		assertTrue(two.getFrameScore()==10);
		assertTrue(three.getFrameScore()==10);
		assertTrue(four.getFrameScore()==8);
			
	}
	@Test
	public void testCheckError() {
		assertTrue(GameController.checkError("1,,2,3", "1,2"));
		assertTrue(GameController.checkError("1,2,3,4,5", ""));
		assertTrue(GameController.checkError("1,2", "1,2"));
		assertTrue(GameController.checkError("", ""));
		assertFalse(GameController.checkError("", "1"));
		assertFalse(GameController.checkError("1,2,3", "1,2,3,4"));
		assertFalse(GameController.checkError("", "1"));
		assertFalse(GameController.checkError("", "1,2"));
		
	}
	@Test
	public void testGetShotsByGame() {
		GameController controller = new GameController();
		assertTrue(controller.GetShotsByGame(1)!=null);
	}
	@Test
	public void testGetFramesByGame() {
		GameController controller = new GameController();
		assertTrue(controller.GetFramesByGame(2)!=null);
	}
	@Test
	public void testGetFramesByGameDupeCheck() {
		GameController controller = new GameController();
		ArrayList<Frame> frames = controller.GetFramesByGame(1);
		for (int i = 0; i<frames.size()-1;i++){
			for(int j = i+1; j<frames.size()-1;j++){
				assertFalse(frames.get(i)==frames.get(j));
			}
		}
		
	}
	@Test
	public void testSplit() {
		assertFalse(GameController.isSplit(2, "1,2,3,4"));
		assertFalse(GameController.isSplit(2, "8,9"));
		assertFalse(GameController.isSplit(1, "0,1,2"));
		assertFalse(GameController.isSplit(1, "0,1,3"));
		assertFalse(GameController.isSplit(1, ""));
		assertFalse(GameController.isSplit(1, "0"));
		assertFalse(GameController.isSplit(1, "2,3,8"));
		assertTrue(GameController.isSplit(1, "0,7"));
		assertTrue(GameController.isSplit(1, "0,8"));
		assertTrue(GameController.isSplit(1, "3,8"));
		assertTrue(GameController.isSplit(1, "0,2,9"));
		assertTrue(GameController.isSplit(1, "0,2,6"));
		assertTrue(GameController.isSplit(1, "3,4,6"));
		assertTrue(GameController.isSplit(1, "3,6,7"));
		assertTrue(GameController.isSplit(1, "2,4,9"));
		assertTrue(GameController.isSplit(1, "2,3,7"));
		assertFalse(GameController.isSplit(1, "2,8,9"));
	}
	
}
