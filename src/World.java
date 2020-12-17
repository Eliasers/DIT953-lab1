import java.util.List;

public class World implements IUpdatable, IWorld {
    static private final int ARBITRARY_TEMPORARY_CAR_WIDTH_NUMBER = 100;

    List<ACar> cars;

    private int width, height;

    @Override
    public void update() {
        for (ACar car : cars) {
            car.move();
            int x = (int) Math.round(car.getPosition()[0]);
            int y = (int) Math.round(car.getPosition()[1]);

            double angle = car.getAngle();

            if ((x > width - ARBITRARY_TEMPORARY_CAR_WIDTH_NUMBER && Math.cos(angle) > 0) || (x < 0 && Math.cos(angle) < 0 )) {
                car.stopEngine();
                car.turnRight();
                car.turnRight();
                car.startEngine();
            }
        }
    }

    @Override
    public List<IMovable> getEntities() {
        return (List<IMovable>)(List<?>)cars;
    }


    class InputHandler {
        World world;

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
