import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author SM
 * Represents a TransportableHolder object (an object that can hold Transportable objects)
 */
public class TransportableHolder implements ITransportableHolder {

    private int maxLoad;
    private double maxWidthMeter;
    private double maxHeightMeter;
    private double maxLengthMeter;
    private Deque<ITransportable> loadedTransportables = new ArrayDeque<>();
    private double loadDistance = 3;
    private double x;
    private double y;

    /**
     * Constructor for TransportableHolder class
     * @param maxLoad The maximum load of Transportables
     * @param x X position of the TransportableHolder
     * @param y Y position of the TransportableHolder
     */
    public TransportableHolder(int maxLoad, double maxWidth, double maxHeight, double maxLength, double x, double y) {
        this.maxLoad = maxLoad;
        maxWidthMeter = maxWidth;
        maxHeightMeter = maxHeight;
        maxLengthMeter = maxLength;
        this.x = x;;
        this.y = y;
    }

    public void loadTransport(ITransportable transport) {
        if(isTransportLoadable(transport)) {
            loadedTransportables.push(transport);
        }
    }

    public void dropTransport() {
        if(isTransportDroppable()) {
            ITransportable t = loadedTransportables.pop();
            t.setX(x + loadDistance);
            t.setY(y + loadDistance);
        }
    }

    public void updateLoadedTransportPosition() {
        for(ITransportable t : loadedTransportables) {
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

    private boolean isTransportLoadable(ITransportable transport) {
        return loadedTransportables.size() < maxLoad
                && transportCloseEnough(transport)
                && !transportTooBig(transport);
    }

    private boolean isTransportDroppable() {
        return loadedTransportables.size() != 0;
    }

    private boolean transportCloseEnough(ITransportable transport) {
        return (Math.abs(x - transport.getX()) < loadDistance) && (Math.abs(y - transport.getY()) < loadDistance);
    }

    private boolean transportTooBig(ITransportable transport) {
        return (transport.getWidth() > maxWidthMeter) || (transport.getHeight() > maxHeightMeter) || (transport.getLength() > maxLengthMeter);
    }
}