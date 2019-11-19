import java.awt.*;

/**
 * @author SM
 * Abstract superclass to all Car subobjects
 */
public abstract class Car extends MotorizedVehicle implements ITransportable {

    /**
     * Constructor for Car class
     */
    public Car(int nrDoors, double enginePower, Color color, String modelName) {
        super(nrDoors, enginePower, color, modelName);
        stopEngine();
    }

    @Override
    public void setX(double x) {
        super.setX(x);
    }

    @Override
    public double getX() {
        return super.getX();
    }

    @Override
    public void setY(double y) {
        super.setY(y);
    }

    @Override
    public double getY() {
        return super.getY();
    }
}