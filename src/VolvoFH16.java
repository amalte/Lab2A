import Interfaces.IRamp;
import Interfaces.ITransporter;

import java.awt.*;
import java.util.Deque;

/**
 * @author SM
 * Subclass of Truck. Represents a truck of model VolvoFH16 that has a ramp and can hold Transportables (implements Interfaces.IRamp and ITransportableHolder)
 */
public class VolvoFH16 extends Truck implements IRamp, ITransporter<Car> {

    /**
     * This truck has a ramp and can hold Transportables (implements Interfaces.IRamp and ITransportableHolder)
     */
    private Ramp ramp;
    private Transporter transportableHolder;

    /**
     * Constructor for VolvoFH16 class
     */
    public VolvoFH16() {
        super(2, 350, Color.white, "VolvoFH16", 2.5, 3, 9);
        transportableHolder = new Transporter<Car>(5, 2, 1.8, 5, 3);
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
    public boolean loadTransport(Car t, double pointX, double pointY) {
        if(!isMoving() && isRampOpen()) {
            return transportableHolder.loadTransport(t, getX(), getY());
        }
        return false;
    }

    @Override
    public Car dropTransport(double pointX, double pointY) {
        if(!isMoving() && isRampOpen()) {
            return  (Car) transportableHolder.dropTransport(getX(), getY());
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
    public Deque<Car> getLoadedTransport() {
        return transportableHolder.getLoadedTransport();
    }

    @Override
    public void move() {
        super.move();
        transportableHolder.setLoadedTransportPosition(getX(), getY());
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
