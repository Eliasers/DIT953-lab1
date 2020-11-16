import java.awt.*;
import java.lang.reflect.Type;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Deque;
import java.util.Iterator;

public class CarTransport extends Truck implements ICarTransport {

    private boolean platformLowered;

    private Deque<Car> loadedCars;

    public CarTransport() {
        super(2, 300, Color.yellow);
        platformLowered = false;
        loadedCars = new ArrayDeque<>();
    }

    @Override
    protected boolean platformLowered() {
        return platformLowered;
    }

    @Override
    public void loadCar(Car car) {
        if (!platformLowered() || getDistance(car) > 5 || car == this){
            //Car cannot be loaded because the platform is raised, the car is too far, or this transport is trying to load itself
            return;
        }
        loadedCars.push(car);
    }

    @Override
    public Car unloadCar() {
        Car car = loadedCars.pop();
        Car.positionCarBehind(this, car);
        return car;
    }

    @Override
    public void move() {
        super.move();
        for (Car car : loadedCars){
            car.x = x;
            car.y = y;
            car.setAngle(getAngle());
        }
    }
}
