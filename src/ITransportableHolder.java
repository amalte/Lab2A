public interface ITransportableHolder {

    int getMaxLoad();
    void setMaxLoad(int maxLoad);

    void loadCar(Car car);
    void unloadCar();
    void updateLoadedCarsPosition();
}