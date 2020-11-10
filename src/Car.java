import java.awt.*;

public abstract class Car implements IMovable {
    /**
     * Number of doors on the car
     */
    protected int nrDoors;
    /**
     * Power of the car's engine
     */
    protected double enginePower;
    /**
     * The current speed of the car
     */
    private double currentSpeed;
    /**
     * Color of the car
     */
    protected Color color;
    /**
     * The car model name
     */
    protected String modelName;

    /**
     * The x and y coordinates of the car
     */
    double x = 0, y = 0;
    /**
     * The rotation angle of the car in radians
     */
    double angle = 0;

    /**
     * @return Number of car doors
     */
    private int getNrDoors(){
        return nrDoors;
    }

    /**
     * @return The power of the car's engine
     */
    private double getEnginePower(){
        return enginePower;
    }

    /**
     * @return The magnitude of the car's current velocity
     */
    private double getCurrentSpeed(){
        return currentSpeed;
    }

    /**
     * @return The color of the car's chassis
     */
    private Color getColor(){
        return color;
    }

    /**
     * @param clr The color to set the car's chassis color to
     */
    private void setColor(Color clr){
        color = clr;
    }

    private void startEngine(){
        currentSpeed = 0.1;
    }

    protected void stopEngine(){
        currentSpeed = 0;
    }

    /**
     * @return The acceleration output of the car
     */
    protected abstract double speedFactor();

    /**
     * @param amount Acceleration input factor
     */
    private void incrementSpeed(double amount){
        currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount,enginePower);
    }

    /**
     * @param amount Deceleration input factor
     */
    private void decrementSpeed(double amount){
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount,0);
    }

    /**
     * @param amount One minus the distance between the pedal and the metal
     */
    public void gas(double amount){
        amount = clampInput(amount);
        incrementSpeed(amount);
    }

    /**
     * @param amount Brake hardness from zero to one
     */
    public void brake(double amount){
        amount = clampInput(amount);
        decrementSpeed(amount);
    }

    /**
     * @param input The input value
     * @return  The input value clamped between zero and one
     */
    private double clampInput(double input) {
        return Math.max(0, Math.min(1, input));
    }

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