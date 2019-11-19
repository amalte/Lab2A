import java.awt.*;

/**
 * @author SM
 * Subclass of Truck. Represents a truck of model VolvoFH16 that has a ramp and can hold Transportables (implements IRamp and ITransportableHolder)
 */
public class VolvoFH16 extends Truck implements IRamp, ITransportableHolder {

    /**
     * This truck has a ramp and can hold Transportables (implements IRamp and ITransportableHolder)
     */
    private Ramp ramp;
    private TransportableHolder transportableHolder;


    /**
     * Constructor for VolvoFH16 class
     */
    public VolvoFH16() {
        super(2, 350, Color.white, "VolvoFH16");
        transportableHolder = new TransportableHolder(5, getX(), getY());
        ramp = new Ramp();
    }

    @Override
    public void openRamp() {
        ramp.openRamp();
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
    public void loadTransport(ITransportable t) {
        if(!isMoving() && !isRampOpen()) {
            transportableHolder.loadTransport(t);
        }
    }

    @Override
    public void dropTransport() {
        if(!isMoving() && !isRampOpen()) {
            transportableHolder.dropTransport();
        }
    }

    @Override
    public void updateLoadedTransportPosition() {
        transportableHolder.updateLoadedTransportPosition();
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
