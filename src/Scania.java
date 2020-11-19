import java.awt.*;

/**
 * Class representing a Scania Truck
 */
public class Scania extends Truck {

    private static double MAX_PLATFORM_ANGLE = 70.0;

    private double platformAngle;

    /**
     * The state of the platform
     * @return platform lowered if platformAngle not equals 0
     */
    @Override
    protected final boolean platformLowered() {
        return platformAngle > 0;
    }

    /**
     * constructs a Scania truck with default values
     */
    public Scania() {
        super(2, 175, Color.BLUE);
        this.platformAngle = 0;
    }


    public final void movePlatform(double amount){
        if (getCurrentSpeed() > 0) return;
        platformAngle = Math.max(0, Math.min(MAX_PLATFORM_ANGLE, platformAngle + amount));
    }
}
