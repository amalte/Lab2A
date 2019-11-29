package Model;

import Model.Interfaces.IFlatbed;

/**
 * @author SM
 * Represents a Model.Flatbed object
 */
public class Flatbed implements IFlatbed {

    private int flatbedAngle; // Angle of flatbed
    private final int maxFlatbedAngle; // Max angle of flatbed

    /**
     * Constructor for Model.Flatbed class
     * @param maxFlatbedAngle Max angle the flatbed can have
     */
    public Flatbed(int maxFlatbedAngle) {
        this.maxFlatbedAngle = maxFlatbedAngle;
    }

    @Override
    public void lowerFlatbed() {
        int angle = flatbedAngle - 1;
        angle = Math.min(angle, maxFlatbedAngle);
        flatbedAngle = Math.max(angle, 0);
    }

    @Override
    public void raiseFlatbed() {
        int angle = flatbedAngle + 1;
        angle = Math.min(angle, maxFlatbedAngle);
        flatbedAngle = Math.max(angle, 0);
    }

    @Override
    public boolean flatbedHasNoAngle() {
        return flatbedAngle == 0;
    }

    @Override
    public int getFlatbedAngle() {
        return flatbedAngle;
    }

    @Override
    public void setFlatbedAngle(int angle) {
        angle = Math.min(angle, maxFlatbedAngle);
        flatbedAngle = Math.max(angle, 0);
    }

    @Override
    public int getMaxFlatbedAngle() {
        return maxFlatbedAngle;
    }
}
