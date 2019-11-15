public interface IHoldTransportable {

    int getMaxLoad();
    void setMaxLoad(int maxLoad);

    void raiseRamp();
    void lowerRamp();
}