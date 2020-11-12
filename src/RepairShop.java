import java.util.Deque;
/**
 * A repair shop that is able to take in a specific numbers of cars and later on let them out.
 */
public class RepairShop implements ICarTransport{
    private int maxNumberOfCars;
    private Deque<Car> brokenCars;


    /**
     * @param car Puts car in the repair shop
     */
    @Override
    public void loadCar(Car car) {
        brokenCars.push(car);
    }

    /**
     * @return Removes car from the repair shop
     */
    @Override
    public Car unloadCar() {
        return brokenCars.pop();
    }

    /**
     * Constructs a Repair shop with default values
     */
    public RepairShop(){
        maxNumberOfCars = 12;
    }


}
