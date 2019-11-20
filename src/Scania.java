import java.awt.*;

/**
 * @author SM
 * Subclass of Truck. Represents a Truck of model Scania that has a flatbed (implements IFlatbed)
 */
public class Scania extends Truck implements IFlatbed {

    private Flatbed flatbed;
    /**
     * Constructor for Scania class
     */
    public Scania() {
        super(2, 250, Color.darkGray, "Scania", 2.5, 3, 7);
        flatbed = new Flatbed(70);
    }

    @Override
    public void lowerFlatbed() {
        if(!isMoving()) {
            flatbed.lowerFlatbed();
        }
    }

    @Override
    public void raiseFlatbed() {
        if(!isMoving()) {
            flatbed.raiseFlatbed();
        }
    }

    @Override
    public int getFlatbedAngle() {
        return flatbed.getFlatbedAngle();
    }

    @Override
    public void setFlatbedAngle(int angle) {
        if(!isMoving()) {
            flatbed.setFlatbedAngle(angle);
        }
    }

    @Override
    public int getMaxFlatbedAngle() {
        return flatbed.getMaxFlatbedAngle();
    }

    @Override
    public boolean flatbedHasNoAngle() {
        return flatbed.flatbedHasNoAngle();
    }

    @Override
    public void gas(double amount) {
        if(flatbedHasNoAngle()) {
            super.gas(amount);
        }
    }

    @Override
    public void setCurrentSpeed(double speed) {
        if(flatbedHasNoAngle()) {
            super.setCurrentSpeed(speed);
        }
    }
}