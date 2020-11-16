import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.util.ArrayList;

public class program extends JFrame{



    ArrayList<Car> cars;

    public program(String a){
        super(a);

        cars = new ArrayList<Car>();

        cars.add(new Volvo240());
    }

    public void paint(Graphics g) {
        super.paint(g);

        for (Car car : cars){
            if (car instanceof Volvo240 || car instanceof Saab95){
                paintCar(car, g);
            }
        }
    }

    void paintCar(Car car, Graphics g){


        g.drawPolygon(DrawPoints.carX, DrawPoints.carY, DrawPoints.carPointCount);
    }

    public static void main(String args[]){

        program frame = new program("Car demo");
        frame.setVisible(true);
        frame.setSize(600,600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

    }

}

class DrawPoints{
    static final int xOff = 400, yOff = 400;
    static double UniScale = 100;

    private static double[] carXPoints = new double[]{
            -1.2, -1.5, -1.3, 1.3, 1.6, 1.4
    };
    private static double[] carYPoints = new double[]{
            0, -1, -1.6, -1.5, -1, 0
    };
    public static int[] carX;
    public static int[] carY;

    public static int carPointCount = carXPoints.length;

    static{
        carX= new int[carPointCount];
        carY = new int[carPointCount];
        for (int i = 0; i < carPointCount; i++) {
            carX[i] = (int)(carXPoints[i] * UniScale) + xOff;
            carY[i] = (int)(carYPoints[i] * UniScale) + yOff;
        }
    }
};