import java.awt.*;

/**
 * Class representing a Volvo240 car
 */
public class Volvo240 extends Car {

    /**
     * Indicates the trimfactor which affects speed
     */
    public final static double trimFactor = 1.25;

    /**
     * Constructs a Volvo240 with default values
     */
    public Volvo240(){
        super();
        stopEngine();
    }

    /**
     * Gets the car's acceleration based on its properties
     * @return The car's acceleration factor
     */
    public double speedFactor(){
        return getEnginePower() * 0.01 * trimFactor;
    }
}
