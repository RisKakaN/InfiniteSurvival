package martin.so.gdxgame.model;

public interface IEnemy {
    void followTarget(ICharacter target);
    boolean isInAttackRange(ICharacter target);
}
