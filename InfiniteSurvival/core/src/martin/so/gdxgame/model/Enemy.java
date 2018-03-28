package martin.so.gdxgame.model;

public class Enemy extends Character implements IEnemy {

    public Enemy(float posX, float posY, float height, float width, int maxHealth, int currentHealth, float speed) {
        super(posX, posY, height, width, maxHealth, currentHealth, speed);
    }

    @Override
    public void followTarget(ICharacter target, float delta) {
        if (!isInAttackRange(target)) {
            if (target.getPosX() + target.getWidth() < getPosX()) {
                setMovingWest();
            } else if (target.getPosX() > getPosX() + getWidth()) {
                setMovingEast();
            }
            if (target.getPosY() + target.getHeight() > getPosY()) {
                setMovingNorth();
            } else if (target.getPosY() < getPosY() + getHeight()) {
                setMovingSouth();
            }
            move(delta);
        }
    }

    @Override
    public boolean isInAttackRange(ICharacter target) {
        // Temporary attack range for now.
        int attackRange = 20;

        float firstObjectHeight = getPosY() + getHeight();
        float firstObjectWidth = getPosX() + getWidth();
        float firstObjectPosX = getPosX();
        float firstObjectPosY = getPosY();

        float secondObjectHeight = target.getPosY() + target.getHeight();
        float secondObjectWidth = target.getPosX() + target.getWidth();
        float secondObjectPosX = target.getPosX();
        float secondObjectPosY = target.getPosY();

        return ((firstObjectWidth + attackRange > secondObjectPosX) &&
                (firstObjectPosX < secondObjectWidth + attackRange) &&
                (firstObjectPosY < secondObjectHeight + attackRange) &&
                (firstObjectHeight + attackRange > secondObjectPosY));
    }

    @Override
    public void update() {

    }
}
