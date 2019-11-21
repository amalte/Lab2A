import java.util.Deque;

public class CarWorkshop<T extends Car> implements ITransportableHolder<T> {

    TransportableHolder transportableHolder;

    public CarWorkshop(int maxLoad, double maxWidth, double maxHeight, double maxLength) {
        transportableHolder = new TransportableHolder(maxLoad, maxWidth, maxHeight, maxLength, 5);
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
    public boolean loadTransport(T transport) {
            return transportableHolder.loadTransport(transport);
    }

    @Override
    public T dropTransport() {
        return (T) transportableHolder.dropTransport();
    }
}
