import java.awt.*;

/**
 * @author SM
 * Subclass of MotorizedVehicle. Represents a Truck object
 */
public class Truck extends MotorizedVehicle {

    public Truck(int nrDoors, double enginePower, Color color, String modelName) {
        super(nrDoors, enginePower, color, modelName);
        stopEngine();
    }
}