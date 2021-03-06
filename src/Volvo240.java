import java.awt.*;

/**
 * Class representing a Volvo240 car
 */
public class Volvo240 extends ACar {

    /**
     * Indicates the trimfactor which affects speed
     */
    public final static double trimFactor = 1.25;

    /**
     * Constructs a Volvo240 with default values
     */
    public Volvo240(){
        super();
        modelName = "Volvo240";
        stopEngine();
    }

    /**
     * Gets the car's acceleration based on its properties
     * @return The car's acceleration factor
     */
    @Override
    public double speedFactor(){
        return getEnginePower() * 0.01 * trimFactor;
    }
}
