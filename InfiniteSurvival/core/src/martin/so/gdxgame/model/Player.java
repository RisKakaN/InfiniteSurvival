package martin.so.gdxgame.model;

public class Player implements IPlayer, ICollisionObject {

    private float posX;
    private float posY;
    private float height;
    private float width;
    private float oldPosX;
    private float oldPosY;

    private ICollisionHandler collisionHandler;

    public Player(float posX, float posY, float height, float width, ICollisionHandler collisionHandler) {
        this.posX = posX;
        this.posY = posY;
        this.height = height;
        this.width = width;
        this.oldPosX = posX;
        this.oldPosY = posY;
        this.collisionHandler = collisionHandler;
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
    public void moveNorth() {
        oldPosY = posY;
        setPosY(getPosY() + 2);
        if(collisionHandler.checkCollisions(this)) {
            posY = oldPosY;
        }
    }

    @Override
    public void moveSouth() {
        oldPosY = posY;
        setPosY((getPosY() - 2));
        if(collisionHandler.checkCollisions(this)) {
            posY = oldPosY;
        }
    }

    @Override
    public void moveWest() {
        oldPosX = posX;
        setPosX(getPosX() - 2);
        if(collisionHandler.checkCollisions(this)) {
            posX = oldPosX;
        }
    }

    @Override
    public void moveEast() {
        oldPosX = posX;
        setPosX(getPosX() + 2);
        if(collisionHandler.checkCollisions(this)) {
            posX = oldPosX;
        }
    }
}
