package martin.so.gdxgame.model;

public abstract class Character implements ICharacter, ICollisionObject {

    private float posX;
    private float posY;
    private float height;
    private float width;
    private float oldPosX;
    private float oldPosY;

    private boolean movingNorth;
    private boolean movingSouth;
    private boolean movingWest;
    private boolean movingEast;

    private Direction direction;

    private int maxHealth;
    private int currentHealth;

    private float speed;
    private float diagonalMovementReduction;

    private ICollisionHandler collisionHandler = CollisionHandler.getInstance();

    Character(float posX, float posY, float height, float width, int maxHealth, int currentHealth, float speed) {
        this.posX = posX;
        this.posY = posY;
        this.height = height;
        this.width = width;
        this.oldPosX = posX;
        this.oldPosY = posY;
        this.direction = Direction.NORTH;

        this.maxHealth = maxHealth;
        this.currentHealth = currentHealth;
        this.speed = speed;
    }

    @Override
    public float getPosX() {
        return posX;
    }

    @Override
    public void setPosX(float newPosX) {
        this.posX = newPosX;
    }

    @Override
    public float getPosY() {
        return posY;
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

    @Override
    public void move(float delta) {
        if ((movingWest || movingEast) && (movingNorth || movingSouth)) {
            diagonalMovementReduction = (float) Math.cos(Math.toRadians(45));
        } else {
            diagonalMovementReduction = 1;
        }
        if (movingNorth) {
            moveNorth(delta);
        } else if (movingSouth) {
            moveSouth(delta);
        }
        if (movingWest) {
            moveWest(delta);
        } else if (movingEast) {
            moveEast(delta);
        }
        movingNorth = false;
        movingSouth = false;
        movingWest = false;
        movingEast = false;
    }

    @Override
    public void moveNorth(float delta) {
        direction = Direction.NORTH;
        oldPosY = posY;
        setPosY(getPosY() + speed * diagonalMovementReduction * delta);
        if (collisionHandler.checkCollisions(this)) {
            posY = oldPosY;
        }
    }

    @Override
    public void moveSouth(float delta) {
        direction = Direction.SOUTH;
        oldPosY = posY;
        setPosY((getPosY() - speed * diagonalMovementReduction * delta));
        if (collisionHandler.checkCollisions(this)) {
            posY = oldPosY;
        }
    }

    @Override
    public void moveWest(float delta) {
        direction = Direction.WEST;
        oldPosX = posX;
        setPosX(getPosX() - speed * diagonalMovementReduction * delta);
        if (collisionHandler.checkCollisions(this)) {
            posX = oldPosX;
        }
    }

    @Override
    public void moveEast(float delta) {
        direction = Direction.EAST;
        oldPosX = posX;
        setPosX(getPosX() + speed * diagonalMovementReduction * delta);
        if (collisionHandler.checkCollisions(this)) {
            posX = oldPosX;
        }
    }

    @Override
    public void setMovingNorth() {
        movingNorth = true;
    }

    @Override
    public void setMovingSouth() {
        movingSouth = true;
    }

    @Override
    public void setMovingWest() {
        movingWest = true;
    }

    @Override
    public void setMovingEast() {
        movingEast = true;
    }

    @Override
    public Direction getDirection() {
        return direction;
    }

    @Override
    public int getMaxHealth() {
        return maxHealth;
    }

    @Override
    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    @Override
    public int getCurrentHealth() {
        return currentHealth;
    }

    @Override
    public void setCurrentHealth(int currentHealth) {
        this.currentHealth = currentHealth;
    }

    @Override
    public float getSpeed() {
        return speed;
    }

    @Override
    public void setSpeed(float speed) {
        this.speed = speed;
    }

    @Override
    public boolean isAlive() {
        return currentHealth > 0;
    }

    @Override
    public void takeDamage(int damage) {
        this.currentHealth -= damage;
    }
}
