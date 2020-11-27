import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Enumeration;
import java.util.HashMap;

/*
* This class represents the Controller part in the MVC pattern.
* It's responsibilities is to listen to the View and responds in a appropriate manner by
* modifying the model state and the updating the view.
 */

public class CarController {
    // member fields:

    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;
    // The timer is started with an listener (see below) that executes the statements
    // each step between delays.
    private Timer timer = new Timer(delay, new TimerListener());

    // The frame that represents this instance View of the MVC pattern
    CarView frame;
    // A list of cars, modify if needed
    ArrayList<ACar> cars = new ArrayList<>();

    // The specs say one of each, I oblige. It may hurt a not-insignificant piece of my soul, but it will make a lot of things a hell of a lot easier for all of us
    Saab95 saab95;
    Scania scania;

    static int ARBITRARY_TEMPORARY_CAR_WIDTH_NUMBER = 100;

    //methods:

    public static void main(String[] args) {
        // Instance of this class
        CarController cc = new CarController();

        HashMap<ACar, BufferedImage> carImages = new HashMap<ACar, BufferedImage>();

        ACar volvo240 = new Volvo240();
        cc.cars.add(volvo240);
        carImages.put(volvo240, DrawPanel.getImage("Volvo240.jpg"));

        Saab95 saab95 = new Saab95();
        saab95.y += 100;
        cc.cars.add(saab95);
        carImages.put(saab95, DrawPanel.getImage("Saab95.jpg"));
        cc.saab95 = saab95;

        Scania scania = new Scania();
        scania.y += 200;
        cc.cars.add(scania);
        carImages.put(scania, DrawPanel.getImage("Scania.jpg"));
        cc.scania = scania;

        // Start a new view and send a reference of self
        cc.frame = new CarView("CarSim 1.0", cc);

        // Give the draw panel a reference to cars
        cc.frame.drawPanel.cars = cc.cars;
        // And carImages
        cc.frame.drawPanel.carImages = carImages;

        // Start the timer
        cc.timer.start();
    }

    /* Each step the TimerListener moves all the cars in the list and tells the
    * view to update its images. Change this method to your needs.
    * */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (ACar car : cars) {
                car.move();
                int x = (int) Math.round(car.getPosition()[0]);
                int y = (int) Math.round(car.getPosition()[1]);

                double angle = car.getAngle();

                if ((x > frame.getWidth() - ARBITRARY_TEMPORARY_CAR_WIDTH_NUMBER && Math.cos(angle) > 0) || (x < 0 && Math.cos(angle) < 0 )) {
                    car.stopEngine();
                    car.turnRight();
                    car.turnRight();
                    car.startEngine();
                }

                // repaint() calls the paintComponent method of the panel
                frame.drawPanel.repaint();
            }
        }
    }

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
            saab95.setTurboOn();
        } else {
            saab95.setTurboOff();
        }
    }

    void movePlatform(double value) {
        scania.movePlatform(value);
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
