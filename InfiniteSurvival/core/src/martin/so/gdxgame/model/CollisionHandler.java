package martin.so.gdxgame.model;

import java.util.ArrayList;
import java.util.List;

public class CollisionHandler implements ICollisionHandler {

    private List<ICollisionObject> collisionObjects = new ArrayList<ICollisionObject>();

    private static CollisionHandler collisionHandler = new CollisionHandler();

    public static CollisionHandler getInstance() {
        return collisionHandler;
    }

    private CollisionHandler() {
    }

    @Override
    public void initiateCollisionObjects(List<ICollisionObject> collisionObjects) {
        this.collisionObjects.addAll(collisionObjects);
    }

    /**
     * Check collision when firstObject runs into secondObject.
     */
    @Override
    public boolean collides(ICollisionObject firstObject, ICollisionObject secondObject) {
        float firstObjectHeight = firstObject.getPosY() + firstObject.getHeight();
        float firstObjectWidth = firstObject.getPosX() + firstObject.getWidth();
        float firstObjectPosX = firstObject.getPosX();
        float firstObjectPosY = firstObject.getPosY();

        float secondObjectHeight = secondObject.getPosY() + secondObject.getHeight();
        float secondObjectWidth = secondObject.getPosX() + secondObject.getWidth();
        float secondObjectPosX = secondObject.getPosX();
        float secondObjectPosY = secondObject.getPosY();

        return ((firstObjectWidth  > secondObjectPosX) && // Left to right.
                (firstObjectPosX < secondObjectWidth) && // Right to left.
                (firstObjectPosY < secondObjectHeight) && // Top to bottom.
                (firstObjectHeight > secondObjectPosY) // Bottom to top.
        );
    }

    /**
     * Loop through collisionObjects and check if
     * firstCollisionObject collides with secondCollisionObject.
     */
    @Override
    public boolean checkCollisions(ICollisionObject firstCollisionObject) {
        for (ICollisionObject secondCollisionObject : collisionObjects) {
            if (!(firstCollisionObject.equals(secondCollisionObject)) && collides(firstCollisionObject, secondCollisionObject)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Adds collisionObject to the list of collisionObjects.
     */
    @Override
    public void addCollisionObject(ICollisionObject collisionObject) {
        if (!collisionObjects.contains(collisionObject)) {
            collisionObjects.add(collisionObject);
        }
    }
}
