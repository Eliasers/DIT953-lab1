/**
 * A repairshop that is able to take in a specific numbers of cars and later on let them out.
 */
public class RepairShop implements ICarTransport{
    private int maxNumberOfCars;


    /**
     * @param car Puts car in the repairshop
     */
    @Override
    public void loadCar(Car car) {

    }

    /**
     * @return Removes car from the repairshop
     */
    @Override
    public Car unloadCar() {
        return null;
    }


}
