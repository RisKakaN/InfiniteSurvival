package martin.so.gdxgame.view;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import martin.so.gdxgame.model.IObstacle;

public class ObstacleView implements IView {

    private Texture obstacleSprite;

    private IObstacle obstacle;

    private static final String obstacleSpriteImage = "obstacle_sprite.png";

    public ObstacleView(IObstacle obstacle) {
        this.obstacle = obstacle;
        obstacleSprite = new Texture(obstacleSpriteImage);
    }

    @Override
    public void render(SpriteBatch spriteBatch) {
        spriteBatch.draw(obstacleSprite, obstacle.getPosX(), obstacle.getPosY());
    }

    @Override
    public void dispose() {
        obstacleSprite.dispose();
    }
}
