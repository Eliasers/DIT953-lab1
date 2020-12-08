import java.awt.*;

/**
 * Abstract class whose children should represent trucks with platforms that can be raised and lowered
 */
public abstract class ATruck extends ACar {
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

    /**
     * Constructs a truck with default values
     */
    public ATruck() {
        super();
    }

    /**
     * Constructs a car with custom values
     */
    public ATruck(int nrDoors, double enginePower, Color color) {
        super(nrDoors, enginePower, color);
    }
}