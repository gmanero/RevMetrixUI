package revMetrix.db.persist;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import revMetrix.db.model.*;

public class InMemoryDatabase implements IDatabase {
    // In-memory storage for demo purposes
    private Map<Integer, Game> games = new HashMap<>();
    private Map<Integer, Frame> frames = new HashMap<>();
    private Map<Integer, Shot> shots = new HashMap<>();
    private int gameIdCounter = 1;
    private int frameIdCounter = 1;
    private int shotIdCounter = 1;

    @Override
    public List<Game> findAllGames() {
        return new ArrayList<>(games.values());
    }

    @Override
    public List<Frame> findAllFrames() {
        return new ArrayList<>(frames.values());
    }

    @Override
    public List<Shot> findAllShots() {
        return new ArrayList<>(shots.values());
    }

    // Implement other methods of the IDatabase interface similarly
    // ...
    
    @Override
    public Integer addGame(Game game) {
        int gameId = gameIdCounter++;
        game.setId(gameId);
        games.put(gameId, game);
        return gameId;
    }

    @Override
    public Integer addFrame(Frame frame) {
        int frameId = frameIdCounter++;
        frame.setId(frameId);
        frames.put(frameId, frame);
        return frameId;
    }

    @Override
    public Integer addShot(int gameId, int frameId, Shot shot) {
        int shotId = shotIdCounter++;
        shot.setId(shotId);
        shots.put(shotId, shot);
        return shotId;
    }
    
    // Implement other methods as needed
}