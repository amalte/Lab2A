import Interfaces.ITransportable;
import Interfaces.ITransporter;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author SM
 * Represents a TransportableHolder object (an object that can hold Transportable objects)
 */
public class Transporter<T extends ITransportable> implements ITransporter<T> {

    private int maxLoad;
    private double maxWidthMeter;
    private double maxHeightMeter;
    private double maxLengthMeter;
    protected Deque<T> loadedTransport = new ArrayDeque<>();
    private double loadAndDropDistanceMeter;

    /**
     * Constructor for TransportableHolder class
     * @param maxLoad The maximum load of Transportables
     */
    public Transporter(int maxLoad, double maxWidth, double maxHeight, double maxLength, double loadAndDropDistance) {
        this.maxLoad = maxLoad;
        maxWidthMeter = maxWidth;
        maxHeightMeter = maxHeight;
        maxLengthMeter = maxLength;
        this.loadAndDropDistanceMeter = loadAndDropDistance;
    }

    @Override
    public boolean loadTransport(T transport, double pointX, double pointY) {
        if(isTransportLoadable(transport, pointX, pointY)) {
            loadedTransport.push(transport);
            transport.setX(pointX);
            transport.setY(pointY);
            return true;
        }
        return false;
    }

    @Override
    public T dropTransport(double pointX, double pointY) {
       if(isTransportDroppable()) {
           T t = loadedTransport.pop();
           t.setX(pointX + loadAndDropDistanceMeter);
           t.setY(pointY + loadAndDropDistanceMeter);
           return t;
       }
       return null;
    }

    public void setLoadedTransportPosition(double pointX, double pointY) {
        for(T t : loadedTransport) {
            t.setX(pointX);
            t.setY(pointY);
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

    private boolean isTransportLoadable(T transport, double pointX, double pointY) {
        return loadedTransport.size() < maxLoad
                && transportCloseEnough(transport, pointX, pointY)
                && !transportTooBig(transport);
    }

    private boolean isTransportDroppable() {
        return loadedTransport.size() != 0;
    }

    private boolean transportCloseEnough(T transport, double pointX, double pointY) {
        return (Math.abs(pointX - transport.getX()) < loadAndDropDistanceMeter) && (Math.abs(pointY - transport.getY()) < loadAndDropDistanceMeter);
    }

    private boolean transportTooBig(T transport) {
        return (transport.getWidth() > maxWidthMeter) || (transport.getHeight() > maxHeightMeter) || (transport.getLength() > maxLengthMeter);
    }
}