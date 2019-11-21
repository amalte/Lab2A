import java.util.Deque;

public interface ITransportableHolder<T> {
    int getMaxLoad();
    void setMaxLoad(int maxLoad);
    Deque<ITransportable> getLoadedTransportables();

    boolean loadTransport(T transport);
    T dropTransport();
}