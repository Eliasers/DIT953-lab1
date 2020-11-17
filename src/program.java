import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

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
            System.out.println("Current X " + car.x);
            car.gas(1);
            car.move();
            //car.turnRight();
            if (car instanceof Volvo240 || car instanceof Saab95){
                paintCar(car, g);
            }
        }
    }

    void paintCar(Car car, Graphics g){
        int[][] carPoints = DrawPoints.DrawCar.GetPoints(car);
        int pointCount = DrawPoints.DrawCar.Count();

        g.drawPolygon(carPoints[0], carPoints[1], pointCount);
    }

    public static void main(String args[]){
        program frame = new program("Car demo");
        frame.setVisible(true);
        frame.setSize(600,600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);


        FrameUpdaterThread thread = new FrameUpdaterThread(frame);
        thread.start();
    }
}

class DrawPoints{
    static private double UniScale = 40;
    static private int xOff = 200, yOff = 200;

    public void SetOffset(int x, int y){
        xOff = x;
        yOff = y;
    }

    private static int[][] PointsToScreen(double[][] points){
        int[] tmpX;
        int[] tmpY;

        tmpX = new int[points[0].length];
        tmpY = new int[points[1].length];
        for (int i = 0; i < points[0].length; i++) {
            tmpX[i] = (int)(points[0][i] * UniScale) + xOff;
            tmpY[i] = (int)(points[1][i] * UniScale) + yOff;
        }

        return new int[][]{tmpX, tmpY};
    }
    private static int[][] PointsToScreen(double[][] points, IMovable movable){
        int[] tmpX = new int[points[0].length];
        int[] tmpY = new int[points[1].length];

        double[] movablePos = movable.getPosition();

        for (int i = 0; i < points[0].length; i++) {
            tmpX[i] = (int)((points[0][i] * UniScale) + movablePos[0]) + xOff;
            tmpY[i] = (int)((points[1][i] * UniScale) + movablePos[1]) + yOff;
        }

        return new int[][]{tmpX, tmpY};
    }

    private static double[][] Rotate2DArray(double[][] array, double angle){
        double[] tmpX = new double[array[0].length];
        double[] tmpY = new double[array[1].length];

        double cos = Math.cos(angle);
        double sin = Math.sin(angle);

        //NERD SHIT
        for (int i = 0; i < tmpX.length; i++) {
            tmpX[i] = cos * array[0][i] - sin * array[1][i];
            tmpY[i] = sin * array[0][i] + cos * array[1][i];
        }

        return new double[][]{tmpX, tmpY};
    }


    public static class DrawCar {
        private static double[] carXPoints = new double[]{
                -1.2, -1.5, -1.3, 1.3, 1.6, 1.4
        };
        private static double[] carYPoints = new double[]{
                0, -1, -1.6, -1.5, -1, 0
        };

        public static int Count() {
            return carXPoints.length;
        }

        public static int[][] GetPoints(Car car){
            double[][] coordinates = new double[][]{carXPoints, carYPoints};

            coordinates = Rotate2DArray(coordinates, car.getAngle());

            return PointsToScreen(coordinates, car);
        }
    }

};

class FrameUpdaterThread extends Thread {

    private JFrame frame;

    FrameUpdaterThread(JFrame frame) {
        this.frame = frame;
    }

    @Override
    public void run() {
        Graphics g = frame.getGraphics();
        try{
            while(true){
                frame.paint(g);
                TimeUnit.MILLISECONDS.sleep(500);
            }
        }
        catch (Exception e){
            System.out.println("Updater interrupted. Reason: " + e.getMessage());
        }

    }
}