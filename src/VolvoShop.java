public class VolvoShop extends RepairShop {

    public void deposit(Volvo240 car){
        if (cars.size() == capacity) return;
        cars.add(car);
    }

    Volvo240 retrieve(int index){
        Volvo240 car = (Volvo240)cars.get(index);
        cars.remove(car);
        return car;
    }

}
