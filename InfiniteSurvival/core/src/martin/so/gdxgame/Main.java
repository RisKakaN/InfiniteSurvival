package martin.so.gdxgame;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import martin.so.gdxgame.controller.PlayerController;
import martin.so.gdxgame.model.*;
import martin.so.gdxgame.view.EnemyView;
import martin.so.gdxgame.view.ObstacleView;
import martin.so.gdxgame.view.PlayerView;

public class Main extends ApplicationAdapter {

    private SpriteBatch batch;

    private Player player;
    private PlayerView playerView;
    private PlayerController playerController;

    private Enemy enemy;
    private EnemyView enemyView;

    private Obstacle obstacle;
    private ObstacleView obstacleView;

    private ICollisionHandler collisionHandler;

    @Override
    public void create() {
        batch = new SpriteBatch();
        collisionHandler = new CollisionHandler();
        player = new Player(100, 100, 32, 32, collisionHandler);
        playerView = new PlayerView(player);
        playerController = new PlayerController(player);
        // Temporary:
        obstacle = new Obstacle(200, 200, 32, 32);
        obstacleView = new ObstacleView(obstacle);

        enemy = new Enemy(300, 300, 32, 32, collisionHandler);
        enemyView = new EnemyView(enemy);

        collisionHandler.addCollisionObject(player);
        collisionHandler.addCollisionObject(obstacle);
        collisionHandler.addCollisionObject(enemy);
    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        playerController.update();
        playerView.render(batch);
        obstacleView.render(batch);
        enemyView.render(batch);
        batch.end();
    }

    @Override
    public void dispose() {
        playerView.dispose();
        obstacleView.dispose();
        enemyView.dispose();
        batch.dispose();
    }
}