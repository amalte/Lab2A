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
    public void raiseRamp() {
        if(!isMoving()) {
            transportableHolder.raiseRamp();
        }
    }

    @Override
    public void lowerRamp() {
        if(!isMoving()) {
            transportableHolder.lowerRamp();
        }
    }

    @Override
    public void loadCar(Car car) {
        if(!isMoving()) {
            transportableHolder.loadCar(car);
        }
    }

    @Override
    public void unloadCar() {
        transportableHolder.unloadCar();
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
    public boolean isRampOpen() {
        return transportableHolder.isRampOpen();
    }

    @Override
    public void setRampOpen(boolean open) {
        transportableHolder.setRampOpen(open);
    }
}
