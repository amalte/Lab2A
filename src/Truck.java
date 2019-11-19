import java.awt.*;

/**
 * @author SM
 * Subclass of MotorizedVehicle. Represents a FlatbedTruck object
 */
public class Truck extends MotorizedVehicle {

    /**
     * Angle of the Trucks ramp/bed
     */
    private int angle = 0;

    public Truck(int nrDoors, double enginePower, Color color, String modelName) {
        super(nrDoors, enginePower, color, modelName);
    }

    public void decreaseAngle() {
        if(!isMoving()){
            int degree = angle - 1;
            degree = Math.min(degree, 70);
            angle = Math.max(degree, 0);
        }
    }

    public void increaseAngle() {
        if(!isMoving()){
            int degree = angle + 1;
            degree = Math.min(degree, 70);
            angle = Math.max(degree, 0);
        }
    }

    public int getAngle() {
        return angle;
    }

    public void setAngle(int degree) {
        if(!isMoving()) {
            degree = Math.min(degree, 70);
            angle = Math.max(degree, 0);
        }
    }

    @Override
    public void gas(double amount) {
        if(noAngle()) {
            super.gas(amount);
        }
    }

    @Override
    public void setCurrentSpeed(double speed) {
        if(noAngle()) {
            super.setCurrentSpeed(speed);
        }
    }

    private boolean noAngle(){
        return angle == 0;
    }
}