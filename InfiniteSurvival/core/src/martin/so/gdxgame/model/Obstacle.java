package martin.so.gdxgame.model;

public class Obstacle implements IObstacle, ICollisionObject {

    private float posX;
    private float posY;
    private float height;
    private float width;

    public Obstacle(float posX, float posY, float height, float width) {
        this.posX = posX;
        this.posY = posY;
        this.height = height;
        this.width = width;
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
        posX = newPosX;
    }

    @Override
    public void setPosY(float newPosY) {
        posY = newPosY;
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
    public void update() {

    }
}
