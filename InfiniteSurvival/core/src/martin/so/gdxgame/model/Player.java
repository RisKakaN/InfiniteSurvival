package martin.so.gdxgame.model;

public class Player extends Character implements IPlayer {

    private WorldObjects worldObjects = WorldObjects.getInstance();

    public Player(float posX, float posY, float height, float width, int maxHealth, int currentHealth, float speed) {
        super(posX, posY, height, width, maxHealth, currentHealth, speed);
    }

    @Override
    public void basicAttack() {
        IBasicAttack basicAttack = new BasicAttack(getPosX() + getWidth()/2-5, getPosY() + getHeight()/2-5, getDirection());
        worldObjects.addBasicAttack(basicAttack);

    }
}