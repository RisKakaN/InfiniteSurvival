package martin.so.gdxgame.testArea;

import martin.so.gdxgame.model.Enemy;
import martin.so.gdxgame.model.IEnemy;
import martin.so.gdxgame.model.IObstacle;
import martin.so.gdxgame.model.Obstacle;

import java.util.ArrayList;
import java.util.List;

public class TestArea {

    private List<Enemy> enemies = new ArrayList<Enemy>();
    private List<Obstacle> obstacles = new ArrayList<Obstacle>();

    public TestArea() {
        enemies.add(new Enemy(100, 500, 32, 32, 100, 100, 150));
        enemies.add(new Enemy(150, 500, 32, 32, 100, 100, 150));

        obstacles.add(new Obstacle(100, 300, 32, 32));
        obstacles.add(new Obstacle(150, 300, 32, 32));
        obstacles.add(new Obstacle(2000, 300, 32, 32));
    }

    public List<Enemy> getEnemies() {
        return enemies;
    }

    public List<Obstacle> getObstacles() {
        return obstacles;
    }
}
