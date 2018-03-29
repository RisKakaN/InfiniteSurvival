package martin.so.gdxgame.controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import martin.so.gdxgame.model.characters.Player;

public class PlayerController implements IPlayerController {

    private Player player;

    public PlayerController(Player player) {
        this.player = player;
    }

    @Override
    public void update() {
        if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
            player.setMovingNorth();
        } else if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
            player.setMovingSouth();
        }
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            player.setMovingWest();
        } else if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            player.setMovingEast();
        }
        if (Gdx.input.isKeyPressed(Input.Keys.SPACE)) {
            player.basicAttack();
        }
    }
}
