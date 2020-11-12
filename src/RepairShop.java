import java.util.ArrayList;

/**
 * A repair shop that is able to take in a specific numbers of cars and later on let them out.
 */
public class RepairShop {
    int maxNumberOfCars;
    private final ArrayList<Car> brokenCars = new ArrayList<>(10);


    /**
     * @param car Puts car in the repair shop
     */
    public void loadCar(Car car) {
        brokenCars.add(car);
    }

    /**
     * @return Removes car from the repair shop by index nr, if the number given currently is in repair shop
     */
    public Car unloadCar(int indexNr) {
        if (indexNr >= 0 && indexNr < maxNumberOfCars) {
            return brokenCars.remove(0);
        }
        return null;
    }

    /**
     * Constructs a Repair shop with default values
     */
    public RepairShop() {
        maxNumberOfCars = 12;
    }


}
