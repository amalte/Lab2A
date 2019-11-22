import Interfaces.IPositionable;
import Interfaces.ITransportableHolder;
import java.util.Deque;

/**
 * @author SM
 * Class for workshops that only take in Car objects
 */
public class CarWorkshop<T extends Car> implements ITransportableHolder<T>, IPositionable {

    TransportableHolder transportableHolder;
    private double x;
    private double y;

    /**
     * Constructor for CarWorkshop
     * @param maxLoad Max amount of Car objects to be loaded
     * @param maxWidth Max width of Car objects to be loaded
     * @param maxHeight Max height of Car objects to be loaded
     * @param maxLength Max length of Car objects to be loaded
     * @param x X position for the workshop
     * @param y Y position for the workshop
     */
    public CarWorkshop(int maxLoad, double maxWidth, double maxHeight, double maxLength, double x, double y) {
        this.x = x;
        this.y = y;
        transportableHolder = new TransportableHolder<T>(maxLoad, maxWidth, maxHeight, maxLength, 5, x, y);
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
    public Deque<T> getLoadedTransport() {
        return transportableHolder.getLoadedTransport();
    }

    @Override
    public void loadTransport(T transport) {
        if(transportableHolder.isTransportLoadable(transport))
            transportableHolder.loadTransport(transport);
    }

    @Override
    public void dropTransport() {
        transportableHolder.dropTransport();
    }

    @Override
    public double getX() {
        return x;
    }

    @Override
    public void setX(double x) {
        this.x = x;
    }

    @Override
    public double getY() {
        return y;
    }

    @Override
    public void setY(double y) {
        this.y = y;
    }
}
