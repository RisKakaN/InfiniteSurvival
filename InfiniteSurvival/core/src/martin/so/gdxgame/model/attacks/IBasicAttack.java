package martin.so.gdxgame.model.attacks;

import martin.so.gdxgame.model.core.ICollisionObject;

public interface IBasicAttack extends ICollisionObject {
    void update(float delta);
    void moveForward(float delta);
    int getDamage();
    void setDamage(int damage);
}
