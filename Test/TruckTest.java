import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class TruckTest {
    Truck truck = new Scania();

    @Test
    public void testLowerFlatbed() {
        truck.setFlatbedDegree(70);
        truck.lowerFlatbed();
        assertEquals(69, truck.getFlatbedDegree());

        truck.setFlatbedDegree(0);
        truck.lowerFlatbed();
        assertEquals(0, truck.getFlatbedDegree());
    }

    @Test
    public void testRaiseFlatbed() {
        truck.setFlatbedDegree(0);
        truck.raiseFlatbed();
        assertEquals(1, truck.getFlatbedDegree());

        truck.setFlatbedDegree(70);
        truck.raiseFlatbed();
        assertEquals(70, truck.getFlatbedDegree());

    }

    @Test
    public void testSetFlatbedDegree() {
        truck.setFlatbedDegree(0);
        assertEquals(0, truck.getFlatbedDegree());

        truck.setFlatbedDegree(50);
        assertEquals(50, truck.getFlatbedDegree());

        truck.setFlatbedDegree(-3);
        assertEquals(0, truck.getFlatbedDegree());

        truck.setFlatbedDegree(85);
        assertEquals(70, truck.getFlatbedDegree());
    }

    @Test
    public void testGas() {
        truck.setFlatbedDegree(5);
        truck.gas(1);
        assertEquals(0, truck.getCurrentSpeed(), 0.0001);

        truck.setFlatbedDegree(0);
        truck.gas(1);
        assertEquals(1, truck.getCurrentSpeed(), 0.0001);

    }

    @Test
    public void testSetCurrentSpeed() {
        truck.setCurrentSpeed(0);
        truck.setFlatbedDegree(10);
        truck.setCurrentSpeed(100);
        assertEquals(0, truck.getCurrentSpeed(), 0.0001);

        truck.setFlatbedDegree(0);
        truck.setCurrentSpeed(50);
        truck.setFlatbedDegree(5);
        assertEquals(50, truck.getCurrentSpeed(), 0.0001);
        assertEquals(0, truck.getFlatbedDegree());

    }
}