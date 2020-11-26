/**
 * Interface for objects loading or unloading cars
 */
public interface ICarTransport {
    /**
     * Loads a car into the object
     * @param car
     */
    public void loadCar(ACar car);

    /**
     * Unloads a car from the object
     * @return The car retrieved from the object
     */
    public ACar unloadCar();
}
