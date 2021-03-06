import java.awt.*;

import static org.junit.Assert.*;

public class Test {
    final double maxDivergence = 0.00001;

    @org.junit.Test
    public void testSaab95() {
        Saab95 saab = new Saab95();
        carTest(saab);

        //Turbo
        saab.setTurboOn();
        double speedBeforeTurbo = saab.speedFactor();
        saab.setTurboOff();
        assertNotEquals(speedBeforeTurbo, saab.speedFactor(), maxDivergence);
    }

    @org.junit.Test
    public void testVolvo240() {
        Volvo240 volvo = new Volvo240();
        carTest(volvo);
    }

    @org.junit.Test
    public void testScania() {
        Scania scania = new Scania();
        carTest(scania);
        stopCar(scania);
        scania.movePlatform(1);
        scania.gas(1);
        assertEquals(0, scania.getCurrentSpeed(), maxDivergence);
        scania.movePlatform(-1);
        scania.gas(1);
        assertNotEquals(0, scania.getCurrentSpeed(), maxDivergence);
        double speed = scania.getCurrentSpeed();
        scania.movePlatform(1); //Should fail because car is in motion...
        scania.gas(1); //... meaning this succeeds since the platform wasn't lowered
        assertTrue(scania.getCurrentSpeed() > speed);
    }

    void carTest(ACar car) {
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

    void moveChangeXY(ACar car, boolean xChange, boolean yChange) {
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

    void stopCar(ACar car) {
        while (car.getCurrentSpeed() > 0) {
            car.brake(1);
        }
    }

    @org.junit.Test
    public void testCarTransport() {
        CarTransport carTransport = new CarTransport();
        Volvo240 volvo = new Volvo240();
        carTest(carTransport);
        stopCar(carTransport);
        carTransport.movePlatform(70);
        carTransport.gas(1);
        assertEquals(0, carTransport.getCurrentSpeed(), maxDivergence);
        
        carTransport.loadCar(volvo);
        assertEquals(volvo, carTransport.unloadCar());

    }

    @org.junit.Test
    public void testShop() {
        VolvoShop volvoShop = new VolvoShop();
        Volvo240 volvo = new Volvo240();
        volvoShop.deposit(volvo);
        assertEquals(volvo, volvoShop.retrieve(0));
    }
}
