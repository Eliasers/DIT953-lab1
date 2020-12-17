import java.awt.*;

/**
 * Abstract class whose children should represent cars
 */
public abstract class ACar implements IMovable {
    /**
     * Number of doors on the car
     */
    private final int nrDoors;
    /**
     * Power of the car's engine
     */
    private final double enginePower;
    /**
     * The current speed of the car
     */
    private double currentSpeed;
    /**
     * Color of the car
     */
    private Color color;
    /**
     * The car model name
     */
    protected String modelName;

    /**
     * Coordinate of the car
     */
    protected double x = 0, y = 0;
    /**
     * The rotation angle of the car in radians
     */
    private double angle = 0;


    /**
     * Constructs a car with default values
     */
    public ACar() {
        nrDoors = 2;
        color = Color.red;
        enginePower = 125;
    }

    /**
     * Constructs a car with custom values
     */
    public ACar(int nrDoors, double enginePower, Color color) {
        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
        this.color = color;
    }


    /**
     * Get number of car doors
     *
     * @return Number of car doors
     */
    public int getNrDoors() {
        return nrDoors;
    }


    /**
     * Get the magnitude of the car's current velocity
     *
     * @return The magnitude of the car's current velocity
     */
    public double getCurrentSpeed() {
        return currentSpeed;
    }

    /**
     * Get the color of the car's chassis
     *
     * @return The color of the car's chassis
     */
    public Color getColor() {
        return color;
    }

    /**
     * Get the car's facing direction
     *
     * @return The car's current rotation angle
     */
    public double getAngle() {
        return angle;
    }

    /**
     * Sets the angle of the car's rotation. Used by transports
     *
     * @param angle The angle to set the car's rotation to
     */
    public void setAngle(double angle) {
        this.angle = angle;
    }

    /**
     * Set the color of the car's chassis
     *
     * @param clr The color to set the car's chassis color to
     */
    public void setColor(Color clr) {
        color = clr;
    }


    /**
     * Get the acceleration output of the car
     *
     * @return The acceleration output of the car
     */
    protected double speedFactor() {
        return getEnginePower() * 0.01;
    }

    /**
     * Accelerate the car
     *
     * @param amount Acceleration input factor
     */
    private void incrementSpeed(double amount) {
        currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount, enginePower);
    }

    /**
     * Decelerate the car
     *
     * @param amount Deceleration input factor
     */
    private void decrementSpeed(double amount) {
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount, 0);
    }

    /**
     * Step on the gas
     *
     * @param amount One minus the distance between the pedal and the metal
     */
    public void gas(double amount) {
        incrementSpeed(Math.max(0, Math.min(1, amount)));
    }

    /**
     * Step on the brake
     *
     * @param amount Brake hardness from zero to one
     */
    public void brake(double amount) {
        decrementSpeed(Math.max(0, Math.min(1, amount)));
    }

    /**
     * Move the car according to its velocity, derived from its current speed and rotation angle
     */
    @Override
    public void move() {
        x += Math.cos(angle) * getCurrentSpeed();
        y += Math.sin(angle) * getCurrentSpeed();
    }

    @Override
    public void turnLeft() {
        angle -= Math.PI / 2;
    }

    @Override
    public void turnRight() {
        angle += Math.PI / 2;
    }

    @Override
    public double[] getPosition() {
        return new double[]{x, y};
    }

    public double getDistance(ACar other) {
        return Math.sqrt(Math.pow(x - other.x, 2) + Math.pow(y - other.y, 2));
    }

    public static void positionCarBehind(ACar self, ACar other) {
        other.x -= Math.cos(self.getAngle()) * 2;
        other.y -= Math.sin(self.getAngle()) * 2;
    }

    public double getEnginePower() {
        return enginePower;
    }

    public void startEngine() {
        currentSpeed = 0.1;
    }

    public void stopEngine() {
        currentSpeed = 0;
    }
}