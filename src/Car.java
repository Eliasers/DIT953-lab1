import java.awt.*;

public abstract class Car implements IMovable {
    /**
     * Number of doors on the car
     */
    int nrDoors;
    /**
     * Power of the car's engine
     */
    double enginePower;
    /**
     * The current speed of the car
     */
    double currentSpeed;
    /**
     * Color of the car
     */
    Color color;
    /**
     * The car model name
     */
    String modelName;

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
    public int getNrDoors(){
        return nrDoors;
    }

    /**
     * @return The power of the car's engine
     */
    public double getEnginePower(){
        return enginePower;
    }

    /**
     * @return The magnitude of the car's current velocity
     */
    public double getCurrentSpeed(){
        return currentSpeed;
    }

    /**
     * @return The color of the car's chassis
     */
    public Color getColor(){
        return color;
    }

    /**
     * @param clr The color to set the car's chassis color to
     */
    public void setColor(Color clr){
        color = clr;
    }

    public void startEngine(){
        currentSpeed = 0.1;
    }

    public void stopEngine(){
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
    private void brake(double amount){
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