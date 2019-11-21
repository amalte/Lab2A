package Interfaces;

import java.util.Deque;

public interface ITransporter<T> {
    int getMaxLoad();
    void setMaxLoad(int maxLoad);
    Deque<T> getLoadedTransport();

    boolean loadTransport(T transport, double pointX, double pointY);
    T dropTransport(double transporterX, double transporterY);
}