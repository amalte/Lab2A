import org.junit.Ignore;

import java.awt.*;

/**
 * @author SM
 * Subclass of Truck. Represents a truck of model VolvoFH16 that can hold Transportables (implements ITransportableHolder)
 */
public class VolvoFH16 extends Truck implements ITransportableHolder {

    /**
     * This truck can hold Transportables (implements ITransportableHolder)
     */
    TransportableHolder transportableHolder;

    /**
     * Constructor for VolvoFH16 class
     */
    public VolvoFH16() {
        super(2, 350, Color.white, "VolvoFH16");
        transportableHolder = new TransportableHolder(5, getX(), getY());
    }

    @Override
    public void loadCar(Car car) {
        // TODO - Cannot load if ramp is closed
        if(!isMoving()) {
            transportableHolder.loadCar(car);
        }
    }

    @Override
    public void unloadCar() {
        // TODO - Cannot unload if ramp is open
        if(!isMoving()) {
            transportableHolder.unloadCar();
        }
    }

    @Override
    public void updateLoadedCarsPosition() {
        transportableHolder.updateLoadedCarsPosition();
    }

    @Override
    public int getMaxLoad() {
        return transportableHolder.getMaxLoad();
    }

    @Override
    public void setMaxLoad(int maxLoad) {
        transportableHolder.setMaxLoad(maxLoad);
    }

    @Override
    public void increaseAngle() {
        setAngle(70);
    }

    @Override
    public void decreaseAngle() {
        setAngle(0);
    }

    @Override
    public void setAngle(int degree) {
        if(degree != 0 || degree != 70) {
            return;
        } else {
            setAngle(degree);
        }
    }
}
