import java.util.Deque;

public class CarTransport extends Truck implements ICarTransport {

    private boolean platformLowered;

    private Deque<Car> loadedCars;

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
        car.x -= Math.cos(getAngle()) * 2;
        car.y -= Math.sin(getAngle()) * 2;
        return car;
    }

    @Override
    public void move() {
        super.move();
        for (Car car : loadedCars){
            car.x = x;
            car.y = y;
            car.set
        }
    }
}
