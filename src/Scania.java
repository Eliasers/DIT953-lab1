public class Scania extends Truck {

    private double platformAngle;

    @Override
    protected final boolean platformLowered() {
        return platformAngle > 0;
    }

    public void movePlatform(double amount){
        platformAngle += amount;
    }
}
