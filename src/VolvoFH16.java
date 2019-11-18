import java.awt.*;

/**
 * @author SM
 * Subclass of Transporter. Represents a transporter of model VolvoFH16
 */
public class VolvoFH16 extends Truck implements ITransporter {

    Transporter transporter = new Transporter(5);

    /**
     * Constructor for VolvoFH16 class
     */
    public VolvoFH16() {
        super(2, 350, Color.white, "VolvoFH16");
    }

    @Override
    public void raiseRamp() {
        transporter.raiseRamp();
    }

    @Override
    public void lowerRamp() {
        transporter.lowerRamp();
    }

    @Override
    public void loadCar(Car car) {
        transporter.loadCar(car);
    }

    @Override
    public void unloadCar() {
        transporter.unloadCar();
    }

    @Override
    public void updateLoadedCarsPosition() {
        transporter.updateLoadedCarsPosition();
    }

    @Override
    public int getMaxLoad() {
        return transporter.getMaxLoad();
    }

    @Override
    public void setMaxLoad(int maxLoad) {
        transporter.setMaxLoad(maxLoad);
    }

    @Override
    public boolean isRampOpen() {
        return transporter.isRampOpen();
    }

    @Override
    public void setRampOpen(boolean open) {
        transporter.setRampOpen(open);
    }
}
