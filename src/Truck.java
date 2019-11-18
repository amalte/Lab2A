import java.awt.*;

/**
 * @author SM
 * Subclass of MotorizedVehicle. Represents a FlatbedTruck object
 */
public abstract class Truck extends MotorizedVehicle {

    private int flatbedDegree = 0;

    public Truck(int nrDoors, double enginePower, Color color, String modelName) {
        super(nrDoors, enginePower, color, modelName);
    }

    public void lowerFlatbed() {
        if(!isMoving()){
            int degree = flatbedDegree - 1;
            degree = Math.min(degree, 70);
            flatbedDegree = Math.max(degree, 0);
        }
    }

    public void raiseFlatbed() {
        if(!isMoving()){
            int degree = flatbedDegree + 1;
            degree = Math.min(degree, 70);
            flatbedDegree = Math.max(degree, 0);
        }
    }

    public int getFlatbedDegree() {
        return flatbedDegree;
    }

    public void setFlatbedDegree(int degree) {
        if(!isMoving()) {
            degree = Math.min(degree, 70);
            flatbedDegree = Math.max(degree, 0);
        }
    }

    @Override
    public void gas(double amount) {
        if(isFlatbedLowered()) {
            super.gas(amount);
        }
    }

    @Override
    public void setCurrentSpeed(double speed) {
        if(isFlatbedLowered()) {
            super.setCurrentSpeed(speed);
        }
    }

    private boolean isFlatbedLowered(){
        return flatbedDegree == 0;
    }
}