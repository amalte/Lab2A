package Interfaces;

/**
 * @author SM
 * Interface for objects that have a flatbed
 */
public interface IFlatbed {

    void lowerFlatbed();
    void raiseFlatbed();

    int getFlatbedAngle();
    void setFlatbedAngle(int angle);

    int getMaxFlatbedAngle();

    boolean flatbedHasNoAngle();
}
