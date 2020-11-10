/**
 * Interface for objects with positions that are meant to be changed through movement
 */
public interface IMovable {

    /**
     *  Resolve one frame of movement using the object's current velocity
     */
    void move();
    /**
     *  Rotate the object 90 degrees counter-clockwise
     */
    void turnLeft();

    /**
     * Rotate the object 90 degrees clockwise
     */
    void turnRight();

}
