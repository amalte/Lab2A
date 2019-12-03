import GUI.CarController;
import GUI.CarView;
import Model.Saab95;
import Model.Scania;
import Model.Volvo240;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // Instance of this class
        CarController cc = new CarController(new ArrayList<>(Arrays.asList(
                new Volvo240(), new Saab95(), new Scania()
        )));

        cc.vehicles.get(1).setY(100);
        cc.vehicles.get(2).setY(200);

        // Start a new view and send a reference of self
        cc.frame = new CarView("CarSim 1.0", cc);

        // Start the timer
        cc.timer.start();
    }
}
