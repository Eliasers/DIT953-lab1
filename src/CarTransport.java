import java.awt.*;
import java.lang.reflect.Type;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Deque;
import java.util.Iterator;

/**
 * Class representing a Car transport
 */
public class CarTransport extends Truck implements ICarTransport {

    private boolean platformLowered;

    private Deque<Car> loadedCars;

    /**
     * Constructs a car transport with default values
     */
    public CarTransport() {
        super(2, 300, Color.yellow);
        platformLowered = false;
        loadedCars = new ArrayDeque<>();
    }

    /**
     * The state of the platform
     * @return The state of the platform
     */
    @Override
    protected boolean platformLowered() {
        return platformLowered;
    }

    /**
     * Loads car on car transport
     * @param car if the distance to the car isn't to long, the platform is lowered and the car isn't this car transport loads the car on the car transport
     */
    @Override
    public void loadCar(Car car) {
        if (!platformLowered() || getDistance(car) > 5 || car == this){
            //Car cannot be loaded because the platform is raised, the car is too far, or this transport is trying to load itself
            return;
        }
        loadedCars.push(car);
    }

    /**
     * Unload last loaded car from car transport
     * @return the last loaded car from car transport
     */
    @Override
    public Car unloadCar() {
        Car car = loadedCars.pop();
        Car.positionCarBehind(this, car);
        return car;
    }

    /**
     * Moves the car transport
     */
    @Override
    public void move() {
        super.move();
        for (Car car : loadedCars){
            car.x = x;
            car.y = y;
            car.setAngle(getAngle());
        }
    }

    public void lowerPlatform() {
        if (getCurrentSpeed() > 0) return;
        platformLowered = true;
    }

    public void raisePlatform() {
        platformLowered = false;
    }
}
