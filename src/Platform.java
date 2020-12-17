public class Platform implements IPlatform{
    private static final double maxAngle = 70.0;

    private double platformAngle;

    @Override
    public void movePlatform(double amount) {
        platformAngle = Math.max(0, Math.min(maxAngle, platformAngle + amount));
    }

    @Override
    public boolean platformLowered() {
        return platformAngle > 0;
    }
}
