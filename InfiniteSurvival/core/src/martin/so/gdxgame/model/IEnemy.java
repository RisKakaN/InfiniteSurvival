package martin.so.gdxgame.model;

public interface IEnemy extends ICharacter {
    void followTarget(ICharacter target);
    boolean isInAttackRange(ICharacter target);
}
