package martin.so.gdxgame.controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import martin.so.gdxgame.model.Player;


public class PlayerController implements IPlayerController {

    private Player player;

    public PlayerController(Player player) {
        this.player = player;
    }

    @Override
    public void update() {
        if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
            player.setPosY(player.getPosY() + 2);
        } else if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
            player.setPosY(player.getPosY() - 2);
        }

        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            player.setPosX(player.getPosX() - 2);
        } else if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            player.setPosX(player.getPosX() + 2);
        }
    }
}
