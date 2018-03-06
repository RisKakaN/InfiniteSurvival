package martin.so.gdxgame.model;

public class Enemy extends Character implements IEnemy {

    public Enemy(float posX, float posY, float height, float width, ICollisionHandler collisionHandler) {
        super(posX, posY, height, width, collisionHandler);
    }
}
