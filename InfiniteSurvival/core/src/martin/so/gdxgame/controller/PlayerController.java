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
            player.moveNorth();
        } else if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
            player.moveSouth();
        }

        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            player.moveWest();
        } else if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            player.moveEast();
        }
    }
}
