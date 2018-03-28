package martin.so.gdxgame.screens;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import martin.so.gdxgame.controller.PlayerController;
import martin.so.gdxgame.model.*;
import martin.so.gdxgame.testArea.TestArea;
import martin.so.gdxgame.view.BasicAttackView;
import martin.so.gdxgame.view.EnemyView;
import martin.so.gdxgame.view.ObstacleView;
import martin.so.gdxgame.view.PlayerView;

import java.util.ArrayList;
import java.util.List;

public class GameScreen implements Screen {

    private WorldObjects worldObjects = WorldObjects.getInstance();

    private SpriteBatch batch;
    private OrthographicCamera playerCam;

    private Player player;
    private PlayerView playerView;
    private PlayerController playerController;

    public GameScreen() {
        TestArea area = new TestArea();
        worldObjects.initiateWorld(area);

        playerCam = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

        batch = new SpriteBatch();

        player = worldObjects.getPlayer();
        playerView = new PlayerView(player);
        playerController = new PlayerController(player);

        for (IObstacle obstacle : worldObjects.getObstacles()) {
            worldObjects.getObstacleViews().add(new ObstacleView(obstacle));
        }

        for (IEnemy enemy : worldObjects.getEnemies()) {
            worldObjects.getEnemyViews().add(new EnemyView(enemy));
        }
    }

    private void updateEnemies() {
        for (IEnemy enemy : worldObjects.getEnemies()) {
            enemy.followTarget(player);
        }
    }


    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        updateEnemies();
        List<IBasicAttack> basicAttacks = new ArrayList<IBasicAttack>(worldObjects.getBasicAttacks());
        for (IBasicAttack basicAttack : basicAttacks) {
            basicAttack.update();
        }

        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.setProjectionMatrix((playerCam.combined));

        batch.begin();
        playerController.update();
        playerView.render(batch);
        for (EnemyView enemyView : worldObjects.getEnemyViews()) {
            enemyView.render(batch);
        }
        for (ObstacleView obstacleView : worldObjects.getObstacleViews()) {
            obstacleView.render(batch);
        }
        for (BasicAttackView basicAttackView : worldObjects.getBasicAttackViews()) {
            basicAttackView.render(batch);
        }

        // Update camera.
        playerCam.update();
        playerCam.position.set(player.getPosX() + player.getWidth() / 2, player.getPosY() + player.getHeight() / 2, 0);

        batch.end();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        playerView.dispose();
        for (EnemyView enemyView : worldObjects.getEnemyViews()) {
            enemyView.dispose();
        }
        for (ObstacleView obstacleView : worldObjects.getObstacleViews()) {
            obstacleView.dispose();
        }
        for (BasicAttackView basicAttackView : worldObjects.getBasicAttackViews()) {
            basicAttackView.dispose();
        }
        batch.dispose();
    }
}
