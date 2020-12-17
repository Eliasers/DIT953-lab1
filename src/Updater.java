import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/* Each step the TimerListener moves all the cars in the list and tells the
 * view to update its images. Change this method to your needs.
 * */
public class Updater implements ActionListener {
    private IUpdatable[] objectsToUpdate;
    
    public Updater(IUpdatable[] objectsToUpdate){
        super();

        this.objectsToUpdate = objectsToUpdate;
    }

    public void actionPerformed(ActionEvent e) {
        for (IUpdatable updatable : objectsToUpdate){
            updatable.update();
        }
        
        //Old update logic
        /*for (ACar car : cars) {
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
        }*/
    }
}