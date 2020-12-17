import java.util.List;

public class World {
    List<ACar> cars;



    class InputHandler {
        // Calls the gas method for each car once
        void gas(int amount) {
            double gas = ((double) amount) / 100;
            for (ACar car : cars
            ) {
                car.gas(gas);
            }
        }

        // Calls the brake method for each car once
        void brake(int amount) {
            double brake = ((double) amount) / 100;
            for (ACar car : cars
            ) {
                car.brake(brake);
            }
        }

        void setTurbo(boolean value) {
            if (value){
                for (ACar car : cars) {
                    if (car instanceof ITurbo) {
                        ((ITurbo) car).setTurboOn();
                    }
                }
            } else {
                for (ACar car : cars) {
                    if (car instanceof ITurbo) {
                        ((ITurbo) car).setTurboOff();
                    }
                }
            }
        }

        void movePlatform(double value) {
            for (ACar car : cars) {
                if (car instanceof IPlatform) {
                    ((IPlatform) car).movePlatform(value);
                }
            }
        }

        void start() {
            for (ACar car : cars){
                car.startEngine();
            }
        }

        void stop() {
            for (ACar car : cars){
                car.stopEngine();
            }
        }
    }
}
