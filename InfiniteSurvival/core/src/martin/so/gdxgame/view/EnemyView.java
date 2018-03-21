package martin.so.gdxgame.view;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import martin.so.gdxgame.model.IEnemy;

public class EnemyView implements IView {

    private IEnemy enemy;

    private Texture enemySprite;

    private static final String enemySpriteImage = "enemy_sprite.png";

    public EnemyView(IEnemy enemy) {
        this.enemy = enemy;
        enemySprite = new Texture(enemySpriteImage);
    }

    public void render(SpriteBatch spriteBatch) {
        spriteBatch.draw(enemySprite, enemy.getPosX(), enemy.getPosY());
    }

    public void dispose() {
        enemySprite.dispose();
    }
}

