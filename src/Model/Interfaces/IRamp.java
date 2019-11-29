package Model.Interfaces;

/** @author SM
 * Interface for objects that have a ramp
 */
public interface IRamp {

    /**
     * Opens ramp
     */
    void openRamp();

    /**
     * Closes ramp
     */
    void closeRamp();

    /**
     * Is ramp open?
     * @return Returns true if ramp is open
     */
    boolean isRampOpen();
    void setRampOpen(boolean open);
}
