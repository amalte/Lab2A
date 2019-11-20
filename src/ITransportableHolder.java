public interface ITransportableHolder {
    int getMaxLoad();
    void setMaxLoad(int maxLoad);

    void loadTransport(ITransportable transport);
    void dropTransport();
}