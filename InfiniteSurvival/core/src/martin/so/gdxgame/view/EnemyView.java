package martin.so.gdxgame.view;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import martin.so.gdxgame.model.characters.IEnemy;
import martin.so.gdxgame.utils.AssetStrings;

public class EnemyView implements IView {
    private IEnemy enemy;
    private Texture enemySprite;

    public EnemyView(IEnemy enemy) {
        this.enemy = enemy;
        enemySprite = new Texture(AssetStrings.enemy_sprite);
    }

    @Override
    public IEnemy getObject() {
        return enemy;
    }

    @Override
    public void render(SpriteBatch spriteBatch) {
        spriteBatch.draw(enemySprite, enemy.getPosX(), enemy.getPosY());
    }

    @Override
    public void dispose() {
        enemySprite.dispose();
    }
}

