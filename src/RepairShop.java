import java.util.ArrayList;
import java.util.List;

/**
 * Children should represent workshops that can have cars admitted, to a capacity, and retrieved
 */
public abstract class RepairShop {
    protected int capacity;
    protected List<ACar> cars;

    /**
     * Constructs a Repair shop with default values
     */
    public RepairShop(){
        cars = new ArrayList<>();
        capacity = 12;
    }

    /**
     * Deposit a car to the repair shop
     * @param car The car to be deposited
     */
    protected void deposit(ACar car){
        if (cars.size() == capacity) return;
        cars.add(car);
    }

    /**
     * Retrieve a car from the repair shop
     * @param index The position of the car to retrieve
     * @return The retrieved car
     */
    protected ACar retrieve(int index) {
        ACar car = cars.get(index);
        cars.remove(car);
        return car;}
}
