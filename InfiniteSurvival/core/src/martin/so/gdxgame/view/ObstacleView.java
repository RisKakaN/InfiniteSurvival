package martin.so.gdxgame.view;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import martin.so.gdxgame.model.objects.IObstacle;
import martin.so.gdxgame.utils.AssetStrings;

public class ObstacleView implements IView {
    private Texture obstacleSprite;
    private IObstacle obstacle;

    public ObstacleView(IObstacle obstacle) {
        this.obstacle = obstacle;
        obstacleSprite = new Texture(AssetStrings.obstacle_sprite);
    }

    @Override
    public IObstacle getObject() {
        return obstacle;
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
