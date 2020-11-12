public class Scania extends Truck {

    private static double MAX_PLATFORM_ANGLE = 70.0;

    private double platformAngle;

    @Override
    protected final boolean platformLowered() {
        return platformAngle > 0;
    }

    public void movePlatform(double amount){
        if (getCurrentSpeed() > 0) return;
        platformAngle = Math.max(0, Math.min(MAX_PLATFORM_ANGLE, platformAngle + amount));
    }
}
