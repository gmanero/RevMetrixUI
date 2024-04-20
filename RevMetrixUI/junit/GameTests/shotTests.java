package GameTests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import revMetrix.controller.GameController;
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
}
