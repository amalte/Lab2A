import Interfaces.IRamp;

/**
 * @author SM
 * Represents a Ramp object
 */
public class Ramp implements IRamp {

    private boolean rampOpen = false; // The ramps state (open (true) or closed (false)

    @Override
    public void openRamp() {
        rampOpen = true;
    }

    @Override
    public void closeRamp() {
        rampOpen = false;
    }

    @Override
    public boolean isRampOpen() {
        return rampOpen;
    }

    @Override
    public void setRampOpen(boolean open) {
        rampOpen = open;
    }
}
