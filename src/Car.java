import java.awt.*;

/**
 * @author SM
 * Abstract superclass to all Car subobjects
 */
public abstract class Car extends MotorizedVehicle implements ITransportable {

    private double distanceToRamp = 0;

    /**
     * Constructor for Car class
     */
    public Car(int nrDoors, double enginePower, Color color, String modelName) {
        super(nrDoors, enginePower, color, modelName);
        stopEngine();
    }

    public double getDistanceToRamp() {
        return distanceToRamp;
    }

    public void setDistanceToRamp(double distance) {
        distanceToRamp = distance;
    }
}