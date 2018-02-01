package martin.so.gdxgame.model;

public class Player implements IPlayer {

    private float posX;
    private float posY;

    public Player(float posX, float posY) {
        this.posX = posX;
        this.posY = posY;
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
}
