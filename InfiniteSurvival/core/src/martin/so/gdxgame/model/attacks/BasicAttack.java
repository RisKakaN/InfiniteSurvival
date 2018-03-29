package martin.so.gdxgame.model.attacks;

import martin.so.gdxgame.model.core.CollisionHandler;
import martin.so.gdxgame.model.core.ICollisionHandler;
import martin.so.gdxgame.model.core.ICollisionObject;
import martin.so.gdxgame.model.core.WorldObjects;
import martin.so.gdxgame.utils.Direction;

/**
 * The main attack of the player.
 */
public class BasicAttack implements IBasicAttack, ICollisionObject {

    private float posX;
    private float posY;
    private float height;
    private float width;

    private Direction direction;
    private static final int spawnOffset = 30;

    private int damage;
    private float speed;

    private boolean isTargetHit;

    private WorldObjects worldObjects = WorldObjects.getInstance();

    private ICollisionHandler collisionHandler = CollisionHandler.getInstance();

    public BasicAttack(float posX, float posY, Direction direction, int damage, float speed) {
        // Spawn projectile a bit away from the player.
        switch (direction) {
            case NORTH:
                this.posX = posX;
                this.posY = posY + spawnOffset;
                break;
            case SOUTH:
                this.posX = posX;
                this.posY = posY - spawnOffset;
                break;
            case WEST:
                this.posX = posX - spawnOffset;
                this.posY = posY;
                break;
            case EAST:
                this.posX = posX + spawnOffset;
                this.posY = posY;
        }

        this.height = 10;
        this.width = 10;
        this.direction = direction;
        this.damage = damage;
        this.speed = speed;
        this.isTargetHit = false;
    }

    @Override
    public void moveForward(float delta) {
        switch (direction) {
            case NORTH:
                setPosY(getPosY() + speed * delta);
                if (collisionHandler.checkCollisions(this)) {
                    isTargetHit = true;
                }
                break;
            case SOUTH:
                setPosY(getPosY() - speed * delta);
                if (collisionHandler.checkCollisions(this)) {
                    isTargetHit = true;
                }
                break;
            case WEST:
                setPosX(getPosX() - speed * delta);
                if (collisionHandler.checkCollisions(this)) {
                    isTargetHit = true;
                }
                break;
            case EAST:
                setPosX(getPosX() + speed * delta);
                if (collisionHandler.checkCollisions(this)) {
                    isTargetHit = true;
                }
                break;
        }
    }

    @Override
    public void update(float delta) {
        if (!isTargetHit) {
            moveForward(delta);
        } else {
            worldObjects.removeBasicAttack(this);
        }
    }

    @Override
    public int getDamage() {
        return damage;
    }

    @Override
    public void setDamage(int damage) {
        this.damage = damage;
    }

    @Override
    public float getPosX() {
        return posX;
    }

    @Override
    public float getPosY() {
        return posY;
    }

    @Override
    public void setPosX(float newPosX) {
        this.posX = newPosX;
    }

    @Override
    public void setPosY(float newPosY) {
        this.posY = newPosY;
    }

    @Override
    public float getHeight() {
        return height;
    }

    @Override
    public float getWidth() {
        return width;
    }
}
