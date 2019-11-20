import java.awt.*;

/**
 * @author SM
 * Abstract superclass to all Car subobjects
 */
public abstract class Car extends MotorizedVehicle implements ITransportable {

    /**
     * Constructor for Car class
     */
    public Car(int nrDoors, double enginePower, Color color, String modelName, double width, double height, double length) {
        super(nrDoors, enginePower, color, modelName, width, height, length);
        stopEngine();
    }

    @Override
    public double getWidth() {
        return super.getWidth();
    }

    @Override
    public void setWidth(double w) {
        super.setWidth(w);
    }

    @Override
    public double getHeight() {
        return super.getHeight();
    }

    @Override
    public void setHeight(double h) {
        super.setHeight(h);
    }

    @Override
    public double getLength() {
        return super.getLength();
    }

    @Override
    public void setLength(double l) {
        super.setLength(l);
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