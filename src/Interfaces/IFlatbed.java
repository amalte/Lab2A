package Interfaces;

/**
 * @author SM
 * Interface for objects that have a flatbed
 */
public interface IFlatbed {

    /**
     * Lowers flatbed
     */
    void lowerFlatbed();

    /**
     * Raises flatbed
     */
    void raiseFlatbed();

    /**
     * Is flatbed lowered?
     * @return Returns true if flatbed is not lowered (when flatbed has no angle)
     */
    boolean flatbedHasNoAngle();

    int getFlatbedAngle();
    void setFlatbedAngle(int angle);
    int getMaxFlatbedAngle();
}
