package martin.so.gdxgame.model.characters;

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
        int attackRange = 50;
        return (Math.sqrt(Math.pow(Math.abs(target.getPosX() - getPosX()), 2) + Math.pow(Math.abs(target.getPosY() - getPosY()), 2)) < attackRange);
    }
}
