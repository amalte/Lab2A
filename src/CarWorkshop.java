public class CarWorkshop<T extends Car> implements ITransportableHolder {

    private T t;
    TransportableHolder transportableHolder;

    public CarWorkshop(int maxLoad, double maxWidth, double maxHeight, double maxLength, double x, double y) {
        transportableHolder = new TransportableHolder(maxLoad, maxWidth, maxHeight, maxLength, x, y);
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
    public void loadTransport(ITransportable transport) {
        transportableHolder.loadTransport(transport);
    }

    @Override
    public void dropTransport() {
        transportableHolder.dropTransport();
    }
}
