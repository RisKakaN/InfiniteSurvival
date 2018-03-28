package martin.so.gdxgame.model;

public interface IEnemy extends ICharacter {
    void followTarget(ICharacter target, float delta);
    boolean isInAttackRange(ICharacter target);
}
