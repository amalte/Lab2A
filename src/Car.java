import Interfaces.ITransportable;

import java.awt.*;

/**
 * @author SM
 * Abstract superclass to all Car subobjects
 */
public abstract class Car extends MotorizedVehicle implements ITransportable {

    /**
     * Constructor for Car class
     * @param nrDoors Number of doors on a vehicle
     * @param enginePower Engine power of a vehicle
     * @param color Color of a vehicle
     * @param modelName Model name of a vehicle
     * @param width Width in meters of vehicle
     * @param height Height in meters of vehicle
     * @param length Length in meters of vehicle
     */
    public Car(int nrDoors, double enginePower, Color color, String modelName, double width, double height, double length) {
        super(nrDoors, enginePower, color, modelName, width, height, length);
        stopEngine();
    }
}