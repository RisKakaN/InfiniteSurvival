package martin.so.gdxgame.model.characters;

public interface IEnemy extends ICharacter {
    void followTarget(ICharacter target, float delta);
    boolean isInAttackRange(ICharacter target);
}
