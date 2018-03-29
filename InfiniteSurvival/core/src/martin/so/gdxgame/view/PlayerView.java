package martin.so.gdxgame.view;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import martin.so.gdxgame.model.characters.IPlayer;
import martin.so.gdxgame.utils.AssetStrings;

public class PlayerView implements IView {
    private IPlayer player;
    private Texture playerSprite;

    public PlayerView(IPlayer player) {
        this.player = player;
        playerSprite = new Texture(AssetStrings.player_sprite);
    }

    @Override
    public IPlayer getObject() {
        return player;
    }

    @Override
    public void render(SpriteBatch spriteBatch) {
        spriteBatch.draw(playerSprite, player.getPosX(), player.getPosY());
    }

    @Override
    public void dispose() {
        playerSprite.dispose();
    }
}
