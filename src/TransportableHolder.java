import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author SM
 * Subclass of MotorizedVehicle. Represents a transporter object
 */
public class TransportableHolder implements ITransportableHolder {

    private boolean rampOpen = false;
    private int maxLoad;
    private Deque<Car> loadedCars = new ArrayDeque<>();
    private double x;
    private  double y;

    /**
     * Constructor for TransportableHolder class
     * @param maxLoad The maximum load of Transportables
     * @param x X position of the TransportableHolder
     * @param y Y position of the TransportableHolder
     */
    public TransportableHolder(int maxLoad, double x, double y) {
        this.maxLoad = maxLoad;
        this.x = x;;
        this.y = y;
    }

    @Override
    public void raiseRamp() {
        rampOpen = false;

    }

    @Override
    public void lowerRamp() {
        rampOpen = true;
    }

    public boolean isRampOpen() {
        return rampOpen;
    }

    public void setRampOpen(boolean open) {
        rampOpen = open;
    }

    public void loadCar(Car car) {
        if(isCarLoadable(car)) {
            loadedCars.push(car);
        }
    }

    public void unloadCar() {
        if(isCarUnloadable()) {
            Car car = loadedCars.pop();
            car.setX(x + 3);
            car.setY(y + 3);
        }
    }

    public void updateLoadedCarsPosition() {
        for(Car c : loadedCars) {
            c.setX(x);
            c.setY(y);
        }
    }

    @Override
    public int getMaxLoad() {
        return maxLoad;
    }

    @Override
    public void setMaxLoad(int maxLoad) {
        this.maxLoad = maxLoad;
    }

    private boolean isCarLoadable(Car car) {
        return isRampOpen() && loadedCars.size() < maxLoad && (Math.abs(x - car.getX()) < 3 && Math.abs(y - car.getY()) < 3);
    }

    private boolean isCarUnloadable() {
        return loadedCars.size() != 0 && isRampOpen();
    }
}