package martin.so.gdxgame.view;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import martin.so.gdxgame.model.attacks.IBasicAttack;
import martin.so.gdxgame.utils.AssetStrings;

public class BasicAttackView implements IView {
    private IBasicAttack basicAttack;
    private Texture basicAttackSprite;

    public BasicAttackView(IBasicAttack basicAttack) {
        this.basicAttack = basicAttack;
        basicAttackSprite = new Texture(AssetStrings.basicAttack_sprite);
    }

    @Override
    public IBasicAttack getObject() {
        return basicAttack;
    }

    @Override
    public void render(SpriteBatch spriteBatch) {
        spriteBatch.draw(basicAttackSprite, basicAttack.getPosX(), basicAttack.getPosY());
    }

    @Override
    public void dispose() {
        basicAttackSprite.dispose();
    }
}
