package martin.so.gdxgame.model;

public class Player extends Character implements IPlayer {

    public Player(float posX, float posY, float height, float width, int maxHealth, int currentHealth, ICollisionHandler collisionHandler) {
        super(posX, posY, height, width, maxHealth, currentHealth, collisionHandler);
    }
}