import java.awt.*;

public abstract class Car implements IMovable {
    /**
     * Number of doors on the car
     */
    private int nrDoors;
    /**
     * Power of the car's engine
     */
    private double enginePower;
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
    private String modelName;

    /**
     * Coordinate of the car
     */
    public double x = 0, y = 0;
    /**
     * The rotation angle of the car in radians
     */
    private double angle = 0;

    /**
     * Constructs a car with default values
     */
    public Car(){
        nrDoors = 2;
        color = Color.red;
        enginePower = 125;
        modelName = "Saab95";
        stopEngine();
    }

    /**
     * Get number of car doors
     * @return Number of car doors
     */
    public int getNrDoors(){
        return nrDoors;
    }

    /**
     * Get the power of the car's engine
     * @return The power of the car's engine
     */
    public double getEnginePower(){
        return enginePower;
    }

    /**
     * Get the magnitude of the car's current velocity
     * @return The magnitude of the car's current velocity
     */
    public double getCurrentSpeed(){
        return currentSpeed;
    }

    /**
     * Get the color of the car's chassis
     * @return The color of the car's chassis
     */
    public Color getColor(){
        return color;
    }

    /**
     * Get the car's facing direction
     * @return The car's current rotation angle
     */
    public double getAngle() {
        return angle;
    }

    /**
     * Set the color of the car's chassis
     * @param clr The color to set the car's chassis color to
     */
    public void setColor(Color clr){
        color = clr;
    }

    /**
     * Start the car's engine
     */
    private void startEngine(){
        currentSpeed = 0.1;
    }

    /**
     * Stop the car's engine
     */
    protected void stopEngine(){
        currentSpeed = 0;
    }

    /**
     * Get the acceleration output of the car
     * @return The acceleration output of the car
     */
    protected abstract double speedFactor();

    /**
     * Accelerate the car
     * @param amount Acceleration input factor
     */
    private void incrementSpeed(double amount){
        currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount,enginePower);
    }

    /**
     * Decelerate the car
     * @param amount Deceleration input factor
     */
    private void decrementSpeed(double amount){
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount,0);
    }

    /**
     * Step on the gas
     * @param amount One minus the distance between the pedal and the metal
     */
    public void gas(double amount){
        amount = clampInput(amount);
        incrementSpeed(amount);
    }

    /**
     * Step on the brake
     * @param amount Brake hardness from zero to one
     */
    public void brake(double amount){
        amount = clampInput(amount);
        decrementSpeed(amount);
    }

    /**
     * Clamp a value between zero and one
     * @param input The input value
     * @return  The input value clamped between zero and one
     */
    private double clampInput(double input) {
        return Math.max(0, Math.min(1, input));
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
}