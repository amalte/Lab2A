package Interfaces;
import java.util.Deque;

/**
 * @author SM
 * Interface for objects that have a TransportableHolder
 */
public interface ITransportableHolder<T extends ITransportable> {
    /**
     * Loads given object onto the TransportableHolder
     * @param transport The object to be loaded
     * @return Returns true if load was successful
     */
    void loadTransport(T transport);

    /**
     * Drops a transport
     * @return Returns the dropped transport
     */
    ITransportable dropTransport();

    /**
     * Stack for all loaded transports
     * @return Returns loaded transports
     */
    Deque<T> getLoadedTransport();
}