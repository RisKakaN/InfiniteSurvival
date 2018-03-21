package martin.so.gdxgame.model;

public interface IBasicAttack extends ICollisionObject {
    void moveForward();
    void update();
    boolean isTargetHit();
}
