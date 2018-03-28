package martin.so.gdxgame.model;

public interface ICharacter extends ICollisionObject {
    void move(float delta);
    void moveNorth(float delta);
    void moveSouth(float delta);
    void moveWest(float delta);
    void moveEast(float delta);
    void setMovingNorth();
    void setMovingSouth();
    void setMovingWest();
    void setMovingEast();
    Direction getDirection();

    int getCurrentHealth();
    void setCurrentHealth(int currentHealth);
    int getMaxHealth();
    void setMaxHealth(int maxHealth);

    float getSpeed();
    void setSpeed(float speed);

    boolean isAlive();
    void takeDamage(int damage);
}
