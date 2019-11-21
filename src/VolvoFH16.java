import java.awt.*;
import java.util.Deque;

/**
 * @author SM
 * Subclass of Truck. Represents a truck of model VolvoFH16 that has a ramp and can hold Transportables (implements IRamp and ITransportableHolder)
 */
public class VolvoFH16 extends Truck implements IRamp, ITransportableHolder<Car> {

    /**
     * This truck has a ramp and can hold Transportables (implements IRamp and ITransportableHolder)
     */
    private Ramp ramp;
    private TransportableHolder transportableHolder;

    /**
     * Constructor for VolvoFH16 class
     */
    public VolvoFH16() {
        super(2, 350, Color.white, "VolvoFH16", 2.5, 3, 9);
        transportableHolder = new TransportableHolder(5, 2, 1.8, 5, 3);
        ramp = new Ramp();
    }

    @Override
    public void openRamp() {
        if(!isMoving()) {
            ramp.openRamp();
        }
    }

    @Override
    public void closeRamp() {
        ramp.closeRamp();
    }

    @Override
    public boolean isRampOpen() {
        return ramp.isRampOpen();
    }

    @Override
    public void setRampOpen(boolean open) {
        ramp.setRampOpen(open);
    }

    @Override
    public boolean loadTransport(Car t) {
        if(!isMoving() && isRampOpen()) {
            return transportableHolder.loadTransport(t);
        }
        return false;
    }

    @Override
    public Car dropTransport() {
        if(!isMoving() && isRampOpen()) {
            return  (Car) transportableHolder.dropTransport();
        }
        return null;
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
    public Deque<ITransportable> getLoadedTransportables() {
        return transportableHolder.getLoadedTransportables();
    }

    @Override
    public void move() {
        super.move();
        transportableHolder.updateLoadedTransportPosition();
    }

    @Override
    public void gas(double amount) {
        if(!isRampOpen()) {
            super.gas(amount);
        }
    }

    @Override
    public void setCurrentSpeed(double speed) {
        if(!isRampOpen()) {
            super.setCurrentSpeed(speed);
        }
    }
}
