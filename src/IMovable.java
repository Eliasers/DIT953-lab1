import java.util.Stack;

/**
 * Interface for objects with positions that are meant to be changed through movement
 */
public interface IMovable {

    /**
     *  Implementations should resolve one frame of movement using the object's current velocity
     */
    void move();

    /**
     *  Implementations should rotate the object 90 degrees counter-clockwise
     */
    void turnLeft();

    /**
     * Implementations should rotate the object 90 degrees clockwise
     */
    void turnRight();

    /**
     * Implementations should return a vector to represent position
     */
    double[] getPosition();
}
