public class VolvoShop extends ARepairShop {

    public void deposit(Volvo240 car){
        super.deposit(car);
    }

    public Volvo240 retrieve(int index){
        return (Volvo240)super.retrieve(index);
    }

}
