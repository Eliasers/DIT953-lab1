import java.awt.*;

public class Scania extends Truck {

    private static double MAX_PLATFORM_ANGLE = 70.0;

    private double platformAngle;

    @Override
    protected final boolean platformLowered() {
        return platformAngle > 0;
    }

    public Scania() {
        super(2, 175, Color.BLUE);
        this.platformAngle = 0;
    }

    public final void movePlatform(double amount){
        if (getCurrentSpeed() > 0) return;
        platformAngle = Math.max(0, Math.min(MAX_PLATFORM_ANGLE, platformAngle + amount));
    }
}
