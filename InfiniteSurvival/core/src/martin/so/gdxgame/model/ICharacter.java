package martin.so.gdxgame.model;

public interface ICharacter extends ICollisionObject {
    void moveNorth();
    void moveSouth();
    void moveWest();
    void moveEast();

    int getCurrentHealth();
    void setCurrentHealth(int currentHealth);
    int getMaxHealth();
    void setMaxHealth(int maxHealth);

    boolean isAlive();
}
