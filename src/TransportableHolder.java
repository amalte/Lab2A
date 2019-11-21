import java.io.CharArrayReader;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author SM
 * Represents a TransportableHolder object (an object that can hold Transportable objects)
 */
public class TransportableHolder implements ITransportableHolder<ITransportable> {

    private int maxLoad;
    private double maxWidthMeter;
    private double maxHeightMeter;
    private double maxLengthMeter;
    protected Deque<ITransportable> loadedTransportables = new ArrayDeque<>();
    private double loadAndDropDistanceMeter;
    private double x;
    private double y;

    /**
     * Constructor for TransportableHolder class
     * @param maxLoad The maximum load of Transportables
     */
    public TransportableHolder(int maxLoad, double maxWidth, double maxHeight, double maxLength, double loadAndDropDistance) {
        this.maxLoad = maxLoad;
        maxWidthMeter = maxWidth;
        maxHeightMeter = maxHeight;
        maxLengthMeter = maxLength;
        this.loadAndDropDistanceMeter = loadAndDropDistance;
    }

    @Override
    public boolean loadTransport(ITransportable transport) {
        if(isTransportLoadable(transport)) {
            loadedTransportables.push(transport);
            transport.setX(x);
            transport.setY(y);
            return true;
        }
        return false;
    }

    @Override
    public ITransportable dropTransport() {
       if(isTransportDroppable()) {
           ITransportable t = loadedTransportables.pop();
           t.setX(x + loadAndDropDistanceMeter);
           t.setY(x + loadAndDropDistanceMeter);
           return t;
       }
       return null;
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

    @Override
    public Deque<ITransportable> getLoadedTransportables() {
        return loadedTransportables;
    }

    private boolean isTransportLoadable(ITransportable transport) {
        return loadedTransportables.size() < maxLoad
                && transportCloseEnough(transport)
                && !transportTooBig(transport);
    }

    private boolean isTransportDroppable() {
        return loadedTransportables.size() != 0;
    }

    public boolean transportCloseEnough(ITransportable transport) {
        return (Math.abs(x - transport.getX()) < loadAndDropDistanceMeter) && (Math.abs(y - transport.getY()) < loadAndDropDistanceMeter);
    }

    private boolean transportTooBig(ITransportable transport) {
        return (transport.getWidth() > maxWidthMeter) || (transport.getHeight() > maxHeightMeter) || (transport.getLength() > maxLengthMeter);
    }
}