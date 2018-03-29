package martin.so.gdxgame.testArea;

import martin.so.gdxgame.model.characters.Enemy;
import martin.so.gdxgame.model.characters.IEnemy;
import martin.so.gdxgame.model.objects.IObstacle;
import martin.so.gdxgame.model.objects.Obstacle;

import java.util.ArrayList;
import java.util.List;

public class TestArea {

    private List<IEnemy> enemies = new ArrayList<IEnemy>();
    private List<IObstacle> obstacles = new ArrayList<IObstacle>();

    public TestArea() {
        enemies.add(new Enemy(100, 500, 32, 32, 100, 100, 150));
        enemies.add(new Enemy(150, 500, 32, 32, 100, 100, 150));

        obstacles.add(new Obstacle(100, 300, 32, 32));
        obstacles.add(new Obstacle(150, 300, 32, 32));
        obstacles.add(new Obstacle(2000, 300, 32, 32));
    }

    public List<IEnemy> getEnemies() {
        return enemies;
    }

    public List<IObstacle> getObstacles() {
        return obstacles;
    }
}
