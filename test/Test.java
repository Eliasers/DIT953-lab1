import java.awt.*;

import static org.junit.Assert.*;

public class Test {
    final double maxDivergence = 0.00001;

    @org.junit.Test
    public void test_saab95() {
        Saab95 saab = new Saab95();
        car_test(saab);

        //Turbo
        saab.setTurboOn();
        double speedBeforeTurbo = saab.speedFactor();
        saab.setTurboOff();
        assertNotEquals(speedBeforeTurbo, saab.speedFactor(), maxDivergence);
    }

    @org.junit.Test
    public void test_volvo240(){
        Volvo240 volvo = new Volvo240();
        car_test(volvo);
    }

    void car_test(Car car){
        car.gas(1);

        //LEFT
        car.turnLeft();
        moveChangeXY(car, false, true);

        //X change, Y no change FORWARD AGAIN
        car.turnRight();
        moveChangeXY(car, true, false);

        //BRAKE CAR TO A STOP
        //X no change, Y no change STOPPED
        car.brake(1);
        moveChangeXY(car, false, false);

        //Start engine
        //X change, Y change STARTED
        car.startEngine();
        moveChangeXY(car, true, false);

        //Angle
        double oldAngle = car.getAngle();
        car.turnRight();
        assertNotEquals(oldAngle, car.getAngle(), maxDivergence);

        //Color
        car.setColor(Color.red);
        Color oldColor = car.getColor();
        car.setColor(Color.black);
        assertNotEquals(oldColor.getRed(), car.getColor().getRed(), maxDivergence);

        //Nr of doors always the same but I think not less than 0 which is a problem you can get i guess idk why and how would this even be tested? the nr of doors can be literally anything but a negative number. With this number represented by an int it could be literally anywhere from 0 to 2147483647. How the hell would we even test this i require a reinquiry into this colossal heap of manure!
        assertTrue(car.getNrDoors() >= 0);
    }

    void moveChangeXY(Car car, boolean xChange, boolean yChange){
        double oldX = car.x;
        double oldY = car.y;

        //Accelerate
        car.move();
        //X
        if (xChange) assertNotEquals(oldX, car.x, maxDivergence);
        else assertEquals(oldX, car.x, maxDivergence);
        //Y
        if (yChange) assertNotEquals(oldY, car.y, maxDivergence);
        else assertEquals(oldY, car.y, maxDivergence);
    }
}
