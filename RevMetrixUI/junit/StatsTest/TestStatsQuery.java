/*package StatsTest;

import static org.junit.Assert.assertEquals;


import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import revMetrix.controller.StatsController;
import revMetrix.db.StatsQuery;
import revMetrix.db.model.Game;
import revMetrix.db.model.Shot;
import revMetrix.db.persist.DatabaseProvider;
import revMetrix.db.persist.IDatabase;

public class TestStatsQuery {
	
@Test
    public void testGamesTotalNoGames() {
	IDatabase db = DatabaseProvider.getInstance();
    List<Game> gameList = db.findAllGames();
    
    double gameTotal = 0;
    
    if (gameList.isEmpty()) {
        System.out.println("There are no games listed in the database");
    } else {
        gameTotal = StatsController.getTotalGameScore(gameList);
    }

    // Assert
    assertEquals(104.00, gameTotal, 0.001); // Assuming 104.00 is the expected total

    }
}*/