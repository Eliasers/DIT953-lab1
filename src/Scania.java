import java.awt.*;

/**
 * Class representing a Scania Truck
 */
public class Scania extends ACar implements IPlatform {
    Platform platform;

    /**
     * The state of the platform
     * @return platform lowered if platformAngle not equals 0
     */
    @Override
    public final boolean platformLowered() {
        return platform.platformLowered();
    }

    /**
     * Constructs a Scania truck with default values
     */
    public Scania() {
        super(2, 175, Color.BLUE);
        platform = new Platform();
    }

    /**
     * Moves the platform by the specified angle. Pass negative values to raise
     * @param amount The amount to change the angle by in degrees
     */
    public final void movePlatform(double amount){
        if (getCurrentSpeed() > 0) return;
        platform.movePlatform(amount);
    }
}
