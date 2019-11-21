import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class VolvoFH16Test {
    VolvoFH16 truckTransporter = new VolvoFH16();
    Car volvo = new Volvo240();
    Car saab = new Saab95();

    public void resetTruck() {
        truckTransporter.closeRamp();
        truckTransporter.setCurrentSpeed(0);
        truckTransporter.getLoadedTransport().clear();
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
        assertEquals(true, truckTransporter.loadTransport(volvo, 0, 0));

        resetTruck();
        truckTransporter.closeRamp();
        assertEquals(false, truckTransporter.loadTransport(volvo, 0, 0));

        resetTruck();
        truckTransporter.openRamp();
        truckTransporter.loadTransport(saab, 0, 0);
        truckTransporter.loadTransport(saab, 0, 0);
        truckTransporter.loadTransport(saab,0, 0);
        truckTransporter.loadTransport(saab,0, 0);
        truckTransporter.loadTransport(saab, 0, 0);
        assertEquals(false, truckTransporter.loadTransport(saab, 0, 0));
    }

    @Test
    public void dropTransport() {
        resetTruck();
        truckTransporter.openRamp();
        truckTransporter.loadTransport(saab,0, 0);
        assertEquals(saab, truckTransporter.dropTransport(0, 0));

        resetTruck();
        truckTransporter.openRamp();
        truckTransporter.loadTransport(saab, 0, 0);
        truckTransporter.closeRamp();
        assertEquals(null, truckTransporter.dropTransport(0, 0));
    }

    @Test
    public void move() {
        resetTruck();
        truckTransporter.openRamp();
        truckTransporter.loadTransport(saab, 0, 0);
        truckTransporter.setX(50);
        truckTransporter.setY(50);
        truckTransporter.move();
        assertEquals(50, saab.getX());
        assertEquals(50, saab.getY());
    }

    @Test
    public void gas() {
        resetTruck();
        truckTransporter.gas(1);
        assertEquals(1, truckTransporter.getCurrentSpeed());

        resetTruck();
        truckTransporter.openRamp();
        truckTransporter.gas(1);
        assertEquals(0, truckTransporter.getCurrentSpeed());
    }

    @Test
    public void setCurrentSpeed() {
        resetTruck();
        truckTransporter.setCurrentSpeed(50);
        assertEquals(50, truckTransporter.getCurrentSpeed());

        resetTruck();
        truckTransporter.openRamp();
        truckTransporter.setCurrentSpeed(50);
        assertEquals(0, truckTransporter.getCurrentSpeed());
    }

}
