package martin.so.gdxgame.model;

public interface IBasicAttack extends ICollisionObject {
    void moveForward();
    boolean isTargetHit();
    int getDamage();
    void setDamage(int damage);
}
