import org.junit.jupiter.api.Test;

public class VolvoFH16Test {
    VolvoFH16 truckTransporter = new VolvoFH16();

    @Test
    public void test() {
        Saab95 saab95 = new Saab95();
        CarWorkshop<Volvo240> w = new CarWorkshop(5, 22, 2, 2, 2,2);
        w.loadTransport(saab95);
    }
}
