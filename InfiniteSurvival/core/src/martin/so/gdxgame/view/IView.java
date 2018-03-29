package martin.so.gdxgame.view;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import martin.so.gdxgame.model.core.ICollisionObject;

public interface IView {
    ICollisionObject getObject();
    void render(SpriteBatch spriteBatch);
    void dispose();
}
