public interface ITransportableHolder {

    void raiseRamp();
    void lowerRamp();
    boolean isRampOpen();
    void setRampOpen(boolean open);

    int getMaxLoad();
    void setMaxLoad(int maxLoad);

    void loadCar(Car car);
    void unloadCar();
    void updateLoadedCarsPosition();
}