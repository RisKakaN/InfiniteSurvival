package martin.so.gdxgame;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import martin.so.gdxgame.controller.PlayerController;
import martin.so.gdxgame.model.*;
import martin.so.gdxgame.testArea.TestArea;
import martin.so.gdxgame.view.EnemyView;
import martin.so.gdxgame.view.ObstacleView;
import martin.so.gdxgame.view.PlayerView;

import java.util.ArrayList;
import java.util.List;

public class Main extends ApplicationAdapter {

    private WorldObjects worldObjects = WorldObjects.getInstance();

    private SpriteBatch batch;
    private OrthographicCamera playerCam;

    private Player player;
    private PlayerView playerView;
    private PlayerController playerController;

    private List<EnemyView> enemyViews = new ArrayList<EnemyView>();
    private List<ObstacleView> obstacleViews = new ArrayList<ObstacleView>();

    @Override
    public void create() {
        playerCam = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

        batch = new SpriteBatch();

        TestArea area = new TestArea();
        worldObjects.initiateWorld(area);

        player = worldObjects.getPlayer();
        playerView = new PlayerView(player);
        playerController = new PlayerController(player);

        for(IObstacle obstacle : worldObjects.getObstacles()) {
            obstacleViews.add(new ObstacleView(obstacle));
        }

        for(IEnemy enemy : worldObjects.getEnemies()) {
            enemyViews.add(new EnemyView(enemy));
        }

    }

    private void updateEnemies() {
        for (IEnemy enemy : worldObjects.getEnemies()) {
            enemy.followTarget(player);
        }
    }

    @Override
    public void render() {
        updateEnemies();

        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.setProjectionMatrix((playerCam.combined));

        batch.begin();
        playerController.update();
        playerView.render(batch);
        for(EnemyView enemyView : enemyViews) {
            enemyView.render(batch);
        }
        for(ObstacleView obstacleView : obstacleViews) {
            obstacleView.render(batch);
        }

        // Update camera.
        playerCam.update();
        playerCam.position.set(player.getPosX() + player.getWidth() / 2, player.getPosY() + player.getHeight() / 2, 0);

        batch.end();
    }

    @Override
    public void dispose() {
        playerView.dispose();
        for(EnemyView enemyView : enemyViews) {
            enemyView.dispose();
        }
        for(ObstacleView obstacleView : obstacleViews) {
            obstacleView.dispose();
        }
        batch.dispose();
    }
}