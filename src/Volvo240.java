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
        nrDoors = 4;
        color = Color.black;
        enginePower = 100;
        modelName = "Volvo240";
        stopEngine();
    }

    /**
     * @return The car's acceleration factor
     */
    public double speedFactor(){
        return enginePower * 0.01 * trimFactor;
    }
}
