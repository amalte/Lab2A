import java.awt.*;

/**
 * @author SM
 * Subclass of Transporter. Represents a transporter of model VolvoFH16
 */
public class VolvoFH16 extends Transporter implements IHoldTransportable {

    private final int maxLoad = 5;

    /**
     * Constructor for VolvoFH16 class
     */
    public VolvoFH16() {
        super(2, 350, Color.white, "VolvoFH16", 5);
    }
}
