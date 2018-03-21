package martin.so.gdxgame.model;

/**
 * The main attack of the player.
 */
public class BasicAttack implements IBasicAttack, ICollisionObject {

    private float posX;
    private float posY;
    private float height;
    private float width;

    private float speed;
    private Direction direction;
    private boolean isTargetHit;

    private WorldObjects worldObjects = WorldObjects.getInstance();

    private ICollisionHandler collisionHandler = CollisionHandler.getInstance();

    public BasicAttack(float posX, float posY, Direction direction) {
        // Spawn projectile a bit away from the player.
        switch (direction) {
            case NORTH:
                this.posX = posX;
                this.posY = posY + 50;
                break;
            case SOUTH:
                this.posX = posX;
                this.posY = posY - 50;
                break;
            case WEST:
                this.posX = posX - 50;
                this.posY = posY;
                break;
            case EAST:
                this.posX = posX + 50;
                this.posY = posY;
        }

        this.height = 10;
        this.width = 10;

        this.speed = 4;
        this.direction = direction;
        this.isTargetHit = false;
    }

    @Override
    public void moveForward() {
        switch (direction) {
            case NORTH:
                setPosY(getPosY() + speed);
                if (collisionHandler.checkCollisions(this)) {
                    isTargetHit = true;
                }
                break;
            case SOUTH:
                setPosY(getPosY() - speed);
                if (collisionHandler.checkCollisions(this)) {
                    isTargetHit = true;
                }
                break;
            case WEST:
                setPosX(getPosX() - speed);
                if (collisionHandler.checkCollisions(this)) {
                    isTargetHit = true;
                }
                break;
            case EAST:
                setPosX(getPosX() + speed);
                if (collisionHandler.checkCollisions(this)) {
                    isTargetHit = true;
                }
                break;
        }
    }

    @Override
    public void update() {
        if (!isTargetHit) {
            moveForward();
        } else {
            worldObjects.removeBasicAttack(this);
        }
    }

    @Override
    public boolean isTargetHit() {
        return isTargetHit;
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
