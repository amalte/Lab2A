package Model;

import java.awt.*;

/**
 * @author SM
 * Subclass of Model.Truck. Represents a Model.Truck of model Model.Scania that has a flatbed (implements IFlatbed)
 */
public class Scania extends Truck {

    private Flatbed flatbed;
    /**
     * Constructor for Model.Scania class
     */
    public Scania() {
        super(2, 250, Color.darkGray, "Model.Scania", 2.5, 3, 7);
        flatbed = new Flatbed(70);
    }

    public void lowerFlatbed() {
        if(!isMoving()) {
            flatbed.lowerFlatbed();
        }
    }

    public void raiseFlatbed() {
        if(!isMoving()) {
            flatbed.raiseFlatbed();
        }
    }

    public int getMaxFlatbedAngle() {
        return flatbed.getMaxFlatbedAngle();
    }

    public boolean flatbedHasNoAngle() {
        return flatbed.flatbedHasNoAngle();
    }

    @Override
    public void gas(double amount) {
        if(flatbedHasNoAngle()) {
            super.gas(amount);
        }
    }

    public int getFlatbedAngle() {
        return flatbed.getFlatbedAngle();
    }

    public void setFlatbedAngle(int angle) {
        if(!isMoving()) {
            flatbed.setFlatbedAngle(angle);
        }
    }

    @Override
    public void setCurrentSpeed(double speed) {
        if(flatbedHasNoAngle()) {
            super.setCurrentSpeed(speed);
        }
    }
}