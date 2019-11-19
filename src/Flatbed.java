/**
 * @author SM
 * Represents a Flatbed object
 */
public class Flatbed implements IFlatbed {

    private int flatbedAngle;
    private final int maxFlatbedAngle;

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

    @Override
    public boolean flatbedHasNoAngle() {
        return flatbedAngle == 0;
    }
}
