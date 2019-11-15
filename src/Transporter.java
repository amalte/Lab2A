import java.awt.*;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author SM
 * Subclass of MotorizedVehicle. Represents a transporter object
 */
public abstract class Transporter extends MotorizedVehicle implements IHoldTransportable {

    private boolean rampOpen = false;
    private int maxLoad;
    private Deque<Car> loadedCars = new ArrayDeque<>();

    /**
     * Constructor for Transporter class
     */
    public Transporter(int nrDoors, double enginePower, Color color, String modelName, int maxLoad) {
        super(nrDoors, enginePower, color, modelName);
        this.maxLoad = maxLoad;
    }

    @Override
    public void raiseRamp() {
        if(!isMoving()){
            rampOpen = false;
        }
    }

    @Override
    public void lowerRamp() {
        if(!isMoving()) {
            rampOpen = true;
        }
    }

    public boolean isRampOpen() {
        return rampOpen;
    }

    public void setRampOpen(boolean open) {
        if(!isMoving()) {
            rampOpen = open;
        }
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

    @Override
    public void gas(double amount) {
        if(!isRampOpen()) {
            super.gas(amount);
        }
    }

    @Override
    public void setCurrentSpeed(double speed) {
        if(!isRampOpen()) {
            super.setCurrentSpeed(speed);
        }
    }

    private boolean isCarLoadable(Car car) {
        return isRampOpen() && loadedCars.size() < maxLoad && (Math.abs(x - car.getX()) < 3 && Math.abs(y - car.getY()) < 3);
    }

    private boolean isCarUnloadable() {
        return loadedCars.size() != 0 && isRampOpen();
    }
}