package martin.so.gdxgame.model;

public class Obstacle implements ICollisionObject {

    private float posX;
    private float posY;
    private int height;
    private int width;

    public Obstacle(float posX, float posY, int height, int width) {
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
    public int getHeight() {
        return height;
    }

    @Override
    public int getWidth() {
        return width;
    }
}
