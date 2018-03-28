package martin.so.gdxgame.model;

import java.util.List;

public interface ICollisionHandler {
    void initiateCollisionObjects(List<ICollisionObject> collisionObjects);
    boolean collides(ICollisionObject firstObject, ICollisionObject secondObject);
    boolean checkCollisions(ICollisionObject firstCollisionObject);
    void addCollisionObject(ICollisionObject collisionObject);
    void removeCollisionObject(ICollisionObject collisionObject);
}
