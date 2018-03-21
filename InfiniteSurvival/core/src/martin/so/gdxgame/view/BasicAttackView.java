package martin.so.gdxgame.view;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import martin.so.gdxgame.model.IBasicAttack;


public class BasicAttackView implements IView {

    private IBasicAttack basicAttack;

    private Texture basicAttackSprite;

    private static final String basicAttackSpriteImage = "BasicAttack.png";

    public BasicAttackView(IBasicAttack basicAttack) {
        this.basicAttack = basicAttack;
        basicAttackSprite = new Texture(basicAttackSpriteImage);
    }

    public void render(SpriteBatch spriteBatch) {
        spriteBatch.draw(basicAttackSprite, basicAttack.getPosX(), basicAttack.getPosY());
    }

    public IBasicAttack getBasicAttack() {
        return basicAttack;
    }

    public void dispose() {
        basicAttackSprite.dispose();
    }
}
