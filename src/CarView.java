import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;


/**
 * This class represents the full view of the MVC pattern of your car simulator.
 * It initializes with being center on the screen and attaching it's controller in it's state.
 * It communicates with the Controller by calling methods of it when an action fires of in
 * each of it's components.
 * TODO: Write more actionListeners and wire the rest of the buttons
 **/

public class CarView extends JPanel implements IUpdatable {
    private static final int X = 800;
    private static final int Y = 800;
    private final IWorld world;
    private HashMap<? extends ACar, BufferedImage> carImages= new HashMap<>();

    // Constructor
    public CarView(int x, int y, IWorld world ) {
        this.world = world;
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);
        carImages.put(Volvo240);
    }


    public void update() {
        repaint();
    }



    public static BufferedImage getImage(String path) {
        // Print an error message in case file is not found with a try/catch block
        try {
            // You can remove the "pics" part if running outside of IntelliJ and
            // everything is in the same main folder.
            // volvoImage = ImageIO.read(new File("Volvo240.jpg"));

            // Rememember to rightclick src New -> Package -> name: pics -> MOVE *.jpg to pics.
            // if you are starting in IntelliJ.
            return ImageIO.read(DrawPanel.class.getResourceAsStream("pics/" + path));
        } catch (IOException ex)
        {
            ex.printStackTrace();
        }
        return null;
    }

    // This method is called each time the panel updates/refreshes/repaints itself
    // TODO: Change to suit your needs.
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (ACar car : cars) {
            g.drawImage(carImages.get(car), (int)Math.round(car.getPosition()[0]), (int)Math.round(car.getPosition()[1]), null);
        }

    }
}