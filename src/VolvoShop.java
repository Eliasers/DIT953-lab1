public class VolvoShop extends RepairShop {

    public void deposit(Volvo240 car){
        super.deposit(car);
    }

    public Volvo240 retrieve(int index){
        return (Volvo240)super.retrieve(index);
    }

}
