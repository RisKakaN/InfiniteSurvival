package martin.so.gdxgame.model;

import martin.so.gdxgame.testArea.TestArea;

import java.util.ArrayList;
import java.util.List;

/**
 * Singleton class for storing all objects in the game.
 */
public class WorldObjects {

    private static WorldObjects worldObjects = new WorldObjects();

    private Player player;
    private List<ICollisionObject> collisionObjects = new ArrayList<ICollisionObject>();
    private List<IEnemy> enemies = new ArrayList<IEnemy>();
    private List<IObstacle> obstacles = new ArrayList<IObstacle>();

    private CollisionHandler collisionHandler = CollisionHandler.getInstance();

    public static WorldObjects getInstance() {
        return worldObjects;
    }

    private WorldObjects() {
        player = new Player(100, 100, 32, 32, 100, 100);
    }

    public void initiateWorld(TestArea area) {
        enemies.addAll(area.getEnemies());
        obstacles.addAll(area.getObstacles());

        collisionObjects.addAll(area.getEnemies());
        collisionObjects.addAll(area.getObstacles());

        collisionHandler.addCollisionObject(player);
        collisionHandler.initiateCollisionObjects(collisionObjects);
    }

    public Player getPlayer() {
        return player;
    }

    public List<IEnemy> getEnemies() {
        return enemies;
    }

    public List<IObstacle> getObstacles() {
        return obstacles;
    }
}
