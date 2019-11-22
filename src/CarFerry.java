import Interfaces.ITransportable;
import Interfaces.ITransportableHolder;
import java.awt.*;
import java.util.Deque;

/**
 * @author SM
 * Represents a CarFerry object (a ferry object that can hold car objects)
 */
public class CarFerry extends MotorizedVehicle implements ITransportableHolder<Car> {

    Ramp ramp;
    TransportableHolder transportableHolder;

    /**
     * Constructor for MotorizedVehicle class
     *
     * @param nrDoors     Number of doors on a vehicle
     * @param enginePower Engine power of a vehicle
     * @param color       Color of a vehicle
     * @param modelName   Model name of a vehicle
     * @param width       Width in meters of vehicle
     * @param height      Height in meters of vehicle
     * @param length      Length in meters of vehicle
     */
    public CarFerry(int nrDoors, double enginePower, Color color, String modelName, double width, double height, double length) {
        super(nrDoors, enginePower, color, modelName, width, height, length);
        ramp = new Ramp();
        transportableHolder = new TransportableHolder<Car>(40, 2,2, 5, 5, getX(), getY());
    }

    public void openRamp() {
        ramp.openRamp();
    }

    public void closeRamp() {
        ramp.closeRamp();
    }

    public boolean isRampOpen() {
        return ramp.isRampOpen();
    }

    public void setRampOpen(boolean open) {
        ramp.setRampOpen(open);
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
    public void loadTransport(Car transport) {
        if(isRampOpen() && transportableHolder.isTransportLoadable(transport)) {
            transportableHolder.loadTransport(transport);
        }
    }

    @Override
    public void dropTransport() {
        if(isRampOpen() && transportableHolder.isTransportDroppable())
        {
            /*ITransportable c = transportableHolder.getLoadedTransport().getLast();
            transportableHolder.loadedTransport.removeLast();
            c.setX(getX() + transportableHolder.getLoadAndDropDistanceMeter());
            c.setY(getY() + transportableHolder.getLoadAndDropDistanceMeter());*/
        }
    }
}
