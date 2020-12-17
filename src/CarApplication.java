import javax.swing.*;
import java.awt.*;

public class CarApplication {

    static int width = 1200, height = 800;

    public static void main(String args[]){
        //Create model
        World world = new World(width, height);
        world.addCar(new Volvo240());
        world.addCar(new Saab95());
        world.addCar(new Scania());

        //Create frame for view and controller

        JFrame frame = new JFrame();

        frame.setTitle("Car Simulator");
        frame.setPreferredSize(new Dimension(width, height));
        frame.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));

        //Add view
        frame.add(new CarView());

        //Add controller
        frame.add(new CarController());

    }

}
