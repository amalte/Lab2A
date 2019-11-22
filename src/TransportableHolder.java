import Interfaces.IPositionable;
import Interfaces.ITransportable;
import Interfaces.ITransportableHolder;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author SM
 * Represents a TransportableHolder object (an object that can hold objects)
 */
public class TransportableHolder<T extends ITransportable> implements ITransportableHolder<T>, IPositionable {

    private int maxLoad; // Max amount of object that can be loaded
    private double maxWidthMeter; // Max width in meters of object to be transported
    private double maxHeightMeter; // Max height in meters of object to be transported
    private double maxLengthMeter; // Max length in meters of object to be transported
    protected Deque<T> loadedTransport = new ArrayDeque<>(); // Stack of all loaded objects
    private double loadAndDropDistanceMeter; // Distance in meters that an object can be loaded, and will drop from current position
    private double x; // X Position of the TransportableHolder
    private double y; // Y Position of the TransportableHolder

    /**
     * Constructor for TransportableHolder class
     * @param maxLoad Max amount of object that can be loaded
     * @param maxWidth Max width in meters of object to be transported
     * @param maxHeight Max height in meters of object to be transported
     * @param maxLength Max length in meters of object to be transported
     * @param loadAndDropDistance // Distance in meters that an object can be loaded, and will drop from current position
     * @param x // X Position of the TransportableHolder
     * @param y // Y Position of the TransportableHolder
     */
    public TransportableHolder(int maxLoad, double maxWidth, double maxHeight, double maxLength, double loadAndDropDistance, double x, double y) {
        this.maxLoad = maxLoad;
        maxWidthMeter = maxWidth;
        maxHeightMeter = maxHeight;
        maxLengthMeter = maxLength;
        this.loadAndDropDistanceMeter = loadAndDropDistance;
        this.x = x;
        this.y = y;
    }

    @Override
    public void loadTransport(T transport) {
            loadedTransport.push(transport);
            transport.setX(x);
            transport.setY(y);
    }

    @Override
    public void dropTransport() {
       if(isTransportDroppable()) {
           ITransportable t = loadedTransport.pop();
           t.setX(x + loadAndDropDistanceMeter);
           t.setY(y + loadAndDropDistanceMeter);
       }
    }

    /**
     * Updates position of the TransportableHolder and all objects it currently holds
     * @param x X Position to set to
     * @param y Y Position to set to
     */
    public void updatePosition(double x, double y) {
        this.x = x;
        this.y = y;
        for(ITransportable t : loadedTransport) {
            t.setX(x);
            t.setY(y);
        }
    }

    @Override
    public int getMaxLoad() {
        return maxLoad;
    }

    @Override
    public void setMaxLoad(int maxLoad) {
        this.maxLoad = maxLoad;
    }

    @Override
    public Deque<T> getLoadedTransport() {
        return loadedTransport;
    }

    public double getLoadAndDropDistanceMeter() {
        return loadAndDropDistanceMeter;
    }

    /**
     * Checks if the object can be loaded
     * @param transport Object to be loaded
     * @return Returns true if object can be loaded and false if it cannot
     */
    protected boolean isTransportLoadable(T transport) {
        return loadedTransport.size() < maxLoad
                && transportCloseEnough(transport)
                && !transportTooBig(transport);
    }

    /**
     * Checks if an object which is already loaded can be dropped
     * @return Returns true if object can be dropped
     */
    protected boolean isTransportDroppable() {
        return loadedTransport.size() != 0;
    }

    /**
     * Checks if object is close enough to be loaded
     * @param transport Object to load
     * @return Returns true if it is close enough to be loaded and false if it is not.
     */
    protected boolean transportCloseEnough(T transport) {
        return ((Math.abs(x - transport.getX())) < loadAndDropDistanceMeter) && ((Math.abs(y - transport.getY())) < loadAndDropDistanceMeter);
    }

    /**
     * Checks if object is too big to be loaded
     * @param transport Object to be loaded
     * @return Returns true if object is too big to be loaded and false if it can be loaded
     */
    protected boolean transportTooBig(T transport) {
        return (transport.getWidth() > maxWidthMeter) || (transport.getHeight() > maxHeightMeter) || (transport.getLength() > maxLengthMeter);
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