/** @author SM
 * Interface for objects that have a ramp
 */
public interface IRamp {

    void openRamp();
    void closeRamp();

    boolean isRampOpen();
    void setRampOpen(boolean open);
}
