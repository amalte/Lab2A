import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class VolvoFH16Test {
    VolvoFH16 truckTransporter = new VolvoFH16();
    Car volvo = new Volvo240();
    Car saab = new Saab95();

    public void resetTruck() {
        truckTransporter.closeRamp();
        truckTransporter.setCurrentSpeed(0);
        truckTransporter.getLoadedTransportables().clear();
    }

    @Test
    public void openRamp(){
        resetTruck();
        truckTransporter.setCurrentSpeed(50);
        truckTransporter.openRamp();
        assertEquals(false, truckTransporter.isRampOpen());

        resetTruck();
        truckTransporter.openRamp();
        assertEquals(true, truckTransporter.isRampOpen());
    }

    @Test
    public void loadTransport() {
        resetTruck();
        truckTransporter.openRamp();
        assertEquals(true, truckTransporter.loadTransport(volvo));

        resetTruck();
        truckTransporter.closeRamp();
        assertEquals(false, truckTransporter.loadTransport(volvo));

        resetTruck();
        truckTransporter.openRamp();
        truckTransporter.loadTransport(saab);
        truckTransporter.loadTransport(saab);
        truckTransporter.loadTransport(saab);
        truckTransporter.loadTransport(saab);
        truckTransporter.loadTransport(saab);
        assertEquals(false, truckTransporter.loadTransport(saab));
    }

    @Test
    public void dropTransport() {
        resetTruck();
        truckTransporter.openRamp();
        truckTransporter.loadTransport(saab);
        assertEquals(saab, truckTransporter.dropTransport());

        resetTruck();
        truckTransporter.openRamp();
        truckTransporter.loadTransport(saab);
        truckTransporter.closeRamp();
        assertEquals(null, truckTransporter.dropTransport());
    }

}
