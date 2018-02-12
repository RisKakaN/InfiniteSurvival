package martin.so.gdxgame.model;

public interface ICollisionHandler {
    boolean collides(ICollisionObject firstObject, ICollisionObject secondObject);
    boolean checkCollisions(ICollisionObject firstCollisionObject);
    void addCollisionObject(ICollisionObject collisionObject);
}
