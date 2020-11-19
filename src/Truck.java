import java.awt.*;

/**
 * Abstract class whose children should represent trucks with platforms that can be raised and lowered
 */
public abstract class Truck extends Car {
    protected abstract boolean platformLowered();

    /**
     * the amount of gas given
     * @param amount One minus the distance between the pedal and the metal
     */
    @Override
    public void gas(double amount){
        if (platformLowered()) return;
        super.gas(amount);
    }


    public Truck() {
        super();
    }
    
    public Truck(int nrDoors, double enginePower, Color color) {
        super(nrDoors, enginePower, color);
    }
}
