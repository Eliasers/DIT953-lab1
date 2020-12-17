import javax.swing.*;
import java.awt.*;

public class CarApplication {

    static int width = 1200, height = 800;

    public static void main(String[] args){
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
        CarView view = new CarView(width, height - 240, world);
        frame.add(view);

        //Add controller
        frame.add(new CarController(world.getHandler()));

        // Make the frame pack all its components by respecting the sizes if possible.
        frame.pack();

        // Get the computer screen resolution
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        // Center the frame
        frame.setLocation(dim.width/2-frame.getSize().width/2, dim.height/2-frame.getSize().height/2);
        // Make the frame visible
        frame.setVisible(true);
        // Make sure the frame exits when "x" is pressed
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Create updater
        Updater updater = new Updater(new IUpdatable[]{world, view});

        Timer timer = new Timer(50, updater);

    }

}
