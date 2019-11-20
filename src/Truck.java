import java.awt.*;

/**
 * @author SM
 * Subclass of MotorizedVehicle. Represents a Truck object
 */
public abstract class Truck extends MotorizedVehicle {

    public Truck(int nrDoors, double enginePower, Color color, String modelName, double width, double height, double length) {
        super(nrDoors, enginePower, color, modelName, width, height, length);
        stopEngine();
    }
}