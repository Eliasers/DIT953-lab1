import java.util.Deque;

public class CarTransport extends Truck implements ICarTransport {

    private boolean platformLowered;

    private Deque<Car> loadedCars;

    @Override
    protected boolean platformLowered() {
        return platformLowered;
    }

    public void loadCar(Car car) {
        if (!platformLowered() || )
        loadedCars.push(car);
    }

    public Car unloadCar() {
        return loadedCars.pop();
    }
}
