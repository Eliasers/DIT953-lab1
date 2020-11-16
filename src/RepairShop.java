import java.util.ArrayDeque;
import java.util.Deque;

/**
 * A repair shop that is able to take in a specific numbers of cars and later on let them out.
 */
public abstract class RepairShop implements ICarTransport {
    private final int maxNumberOfCars;
    private int numberOfCars;
    private final Deque<Car> brokenCars=new ArrayDeque<>(); //Change Car to specific type in specific repair shops


    /**
     * @param car Puts car in the repair shop, if max number of cars is not reached
     */
    @Override
    public void loadCar(Car car) {
        if (numberOfCars <= maxNumberOfCars) {
            brokenCars.push(car);
            numberOfCars++;
        }

    }

    /**
     * @return the car that has been in the workshop the longest time, removing it from the repair shop
     */
    @Override
    public Car unloadCar() {

        return brokenCars.pollLast();


    }

    /**
     * Constructs a Repair shop with default values
     */
    public RepairShop() {
        maxNumberOfCars = 12;
    }


}
