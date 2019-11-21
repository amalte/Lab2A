import Interfaces.ITransporter;

import java.util.Deque;

public class CarWorkshop<T extends Car> implements ITransporter<T> {

    Transporter transporter;

    public CarWorkshop(int maxLoad, double maxWidth, double maxHeight, double maxLength) {
        transporter = new Transporter<T>(maxLoad, maxWidth, maxHeight, maxLength, 5);
    }

    @Override
    public int getMaxLoad() {
        return transporter.getMaxLoad();
    }

    @Override
    public void setMaxLoad(int maxLoad) {
        transporter.setMaxLoad(maxLoad);
    }

    @Override
    public Deque<T> getLoadedTransport() {
        return transporter.getLoadedTransport();
    }

    @Override
    public boolean loadTransport(T transport, double pointX, double pointY) {
            return transporter.loadTransport(transport, 0, 0);
    }

    @Override
    public T dropTransport(double pointX, double pointY) {
        return (T) transporter.dropTransport(0, 0);
    }
}
