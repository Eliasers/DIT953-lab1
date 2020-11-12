/**
 * Abstract class whose children should represent trucks with platforms that can be raised and lowered
 */
public abstract class Truck extends Car {
    protected abstract boolean platformLowered();

    @Override
    public void gas(double amount){
        if (platformLowered()) return;
        super.gas(amount);
    }
}
