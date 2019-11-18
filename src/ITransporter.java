public interface ITransporter {

    void raiseRamp();
    void lowerRamp();

    void loadCar(Car car);
    void unloadCar();
    void updateLoadedCarsPosition();

    int getMaxLoad();
    void setMaxLoad(int maxLoad);

    boolean isRampOpen();
    void setRampOpen(boolean open);

    void gas(double amount);
    void setCurrentSpeed(double speed);
}