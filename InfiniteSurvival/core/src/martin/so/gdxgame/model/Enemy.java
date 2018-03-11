package martin.so.gdxgame.model;

public class Enemy extends Character implements IEnemy {

    public Enemy(float posX, float posY, float height, float width, int maxHealth, int currentHealth, ICollisionHandler collisionHandler) {
        super(posX, posY, height, width, maxHealth, currentHealth, collisionHandler);
    }
}
