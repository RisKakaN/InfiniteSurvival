package martin.so.gdxgame.model.core;

import martin.so.gdxgame.model.attacks.IBasicAttack;
import martin.so.gdxgame.model.characters.IEnemy;
import martin.so.gdxgame.model.characters.Player;
import martin.so.gdxgame.model.objects.IObstacle;
import martin.so.gdxgame.testArea.TestArea;
import martin.so.gdxgame.view.BasicAttackView;
import martin.so.gdxgame.view.EnemyView;
import martin.so.gdxgame.view.ObstacleView;

import java.util.ArrayList;
import java.util.List;

/**
 * Singleton class for storing and handling all objects in the game.
 */
public class WorldObjects {
    private static final WorldObjects worldObjects = new WorldObjects();

    private Player player;
    private List<ICollisionObject> collisionObjects;

    private List<IEnemy> enemies;
    private List<EnemyView> enemyViews;

    private List<IObstacle> obstacles;
    private List<ObstacleView> obstacleViews;

    private List<IBasicAttack> basicAttacks;
    private List<BasicAttackView> basicAttackViews;

    private CollisionHandler collisionHandler = CollisionHandler.getInstance();

    public static WorldObjects getInstance() {
        return worldObjects;
    }

    private WorldObjects() {
    }

    public void initiateWorld(TestArea area) {
        player = new Player(100, 100, 32, 32, 100, 100, 300);
        collisionObjects = new ArrayList<ICollisionObject>();
        enemies = new ArrayList<IEnemy>();
        enemyViews = new ArrayList<EnemyView>();
        obstacles = new ArrayList<IObstacle>();
        obstacleViews = new ArrayList<ObstacleView>();
        basicAttacks = new ArrayList<IBasicAttack>();
        basicAttackViews = new ArrayList<BasicAttackView>();

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

    public List<EnemyView> getEnemyViews() {
        return enemyViews;
    }

    public void removeEnemy(IEnemy enemy) {
        collisionHandler.removeCollisionObject(enemy);
        getEnemies().remove(enemy);
        List<EnemyView> enemyViews = new ArrayList<EnemyView>(getEnemyViews());
        for (EnemyView enemyView : enemyViews) {
            if (enemy == enemyView.getObject()) {
                getEnemyViews().remove(enemyView);
                enemyView.dispose();
                enemyView = null;
            }
        }
    }

    public List<IObstacle> getObstacles() {
        return obstacles;
    }

    public List<ObstacleView> getObstacleViews() {
        return obstacleViews;
    }

    public void addBasicAttack(IBasicAttack basicAttack) {
        basicAttacks.add(basicAttack);
        basicAttackViews.add(new BasicAttackView(basicAttack));
    }

    public List<IBasicAttack> getBasicAttacks() {
        return basicAttacks;
    }

    public List<BasicAttackView> getBasicAttackViews() {
        return basicAttackViews;
    }

    public void removeBasicAttack(IBasicAttack basicAttack) {
        collisionHandler.removeCollisionObject(basicAttack);
        getBasicAttacks().remove(basicAttack);
        List<BasicAttackView> basicAttackViews = new ArrayList<BasicAttackView>(getBasicAttackViews());
        for (BasicAttackView basicAttackView : basicAttackViews) {
            if (basicAttack == basicAttackView.getObject()) {
                getBasicAttackViews().remove(basicAttackView);
                basicAttackView.dispose();
                basicAttackView = null;
            }
        }
    }
}
