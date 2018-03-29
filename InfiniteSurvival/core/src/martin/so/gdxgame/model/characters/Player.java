package martin.so.gdxgame.model.characters;

import martin.so.gdxgame.model.attacks.BasicAttack;
import martin.so.gdxgame.model.attacks.IBasicAttack;
import martin.so.gdxgame.model.core.WorldObjects;

public class Player extends Character implements IPlayer {

    private WorldObjects worldObjects = WorldObjects.getInstance();

    public Player(float posX, float posY, float height, float width, int maxHealth, int currentHealth, float speed) {
        super(posX, posY, height, width, maxHealth, currentHealth, speed);
    }

    @Override
    public void basicAttack() {
        IBasicAttack basicAttack = new BasicAttack(getPosX() + getWidth() / 2 - 5, getPosY() + getHeight() / 2 - 5, getDirection(), 10, 50);
        worldObjects.addBasicAttack(basicAttack);
    }
}