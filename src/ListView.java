import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ListView extends JPanel implements IUpdatable {

    private static final int X = 800;
    private static final int Y = 800;
    private final IWorld world;
    private HashMap<Class, BufferedImage> images = new HashMap<>();

    private List<IMovable> entities = new ArrayList<IMovable>();

    // Constructor
    public ListView(IWorld world) {
        super();

        this.world = world;
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(240, 240));
        this.setBackground(Color.gray);

    }


    public void update() {
        entities = world.getEntities();
        repaint();
    }

    // This method is called each time the panel updates/refreshes/repaints itself
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (int i = 0; i < entities.size(); i++) {
            IMovable entity = entities.get(i);
            if (entity instanceof ACar)
            {
                g.drawString(entity.getClass().getName() + ": " + ((ACar)entity).getCurrentSpeed() + " speed units", 10, 30 + i * 20);
            }
        }

    }
}

