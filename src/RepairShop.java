import java.util.ArrayList;
import java.util.List;

/**
 * Children should represent workshops that can have cars admitted, to a capacity, and retrieved
 */
public abstract class RepairShop {
    protected int capacity;
    protected List<Car> cars;

    /**
     * Constructs a Repair shop with default values
     */
    public RepairShop(){
        cars = new ArrayList<>();
        capacity = 12;
    }

    protected void deposit(Car car){
        if (cars.size() == capacity) return;
        cars.add(car);
    }

    protected Car retrieve(int index) {
        Car car = cars.get(index);
        cars.remove(car);
        return car;}
}
