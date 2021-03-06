/**
 * Class representing a Saab 95 car
 */
public class Saab95 extends ACar implements ITurbo{
    /**
     * The state of the turbo
     */
    private boolean turboOn;

    /**
     * Constructs a saab95 with default values
     */
    public Saab95(){
        super();
        modelName = "Saab95";
	    turboOn = false;
    }

    /**
     * Turbo set on
     */
    public void setTurboOn(){
        turboOn = true;
    }

    /**
     * Turbo set off
     */
    public void setTurboOff(){
        turboOn = false;
    }

    /**
     * Get the car's acceleartion factor
     * @return The car's acceleration factor
     */
    @Override
    public double speedFactor(){
        double turbo = 1;
        if(turboOn) turbo = 1.3;
        return getEnginePower() * 0.01 * turbo;
    }

}
