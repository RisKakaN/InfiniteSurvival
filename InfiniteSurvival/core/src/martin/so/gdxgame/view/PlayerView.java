package martin.so.gdxgame.view;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import martin.so.gdxgame.model.Player;

public class PlayerView implements IView {

    private Player player;

    private Texture playerSprite;

    private static final String playerSpriteImage = "player_sprite.png";

    public PlayerView(Player player) {
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
