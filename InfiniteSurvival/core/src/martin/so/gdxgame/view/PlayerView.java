package martin.so.gdxgame.view;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import martin.so.gdxgame.model.IPlayer;

public class PlayerView implements IView {

    private IPlayer player;

    private Texture playerSprite;

    private static final String playerSpriteImage = "player_sprite.png";

    public PlayerView(IPlayer player) {
        this.player = player;
        playerSprite = new Texture(playerSpriteImage);
    }

    public void render(SpriteBatch spriteBatch) {
        spriteBatch.draw(playerSprite, player.getPosX(), player.getPosY());
    }

    public void dispose() {
        playerSprite.dispose();
    }
}
