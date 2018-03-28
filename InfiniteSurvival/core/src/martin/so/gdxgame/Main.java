package martin.so.gdxgame;

import com.badlogic.gdx.Game;
import martin.so.gdxgame.screens.GameScreen;

public class Main extends Game {

    @Override
    public void create() {
        this.setScreen(new GameScreen());
    }

    @Override
    public void render() {
        super.render();
    }
}