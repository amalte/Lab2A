import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CarWorkshopTest {
    CarWorkshop<Car> carWorkshop = new CarWorkshop<>(5, 3, 4, 5);
    CarWorkshop<Volvo240> volvoWorkshop = new CarWorkshop<>(5, 3, 4, 5);
    CarWorkshop<Saab95> saabWorkshop = new CarWorkshop<>(5, 3, 4, 5);

    Volvo240 volvo = new Volvo240();
    Saab95 saab = new Saab95();

    @Test
    public void loadTransport() {
        carWorkshop.loadTransport(saab, 0, 0);
        carWorkshop.loadTransport(volvo, 0, 0);
        assertEquals(2, carWorkshop.getLoadedTransport().size());

        volvoWorkshop.loadTransport(volvo, 0, 0);
        assertEquals(1, volvoWorkshop.getLoadedTransport().size());
        saabWorkshop.loadTransport(saab, 0, 0);
        assertEquals(1, saabWorkshop.getLoadedTransport().size());

        carWorkshop.loadTransport(saab, 0, 0);
        carWorkshop.loadTransport(saab, 0, 0);
        carWorkshop.loadTransport(saab, 0, 0);
        assertEquals(false, carWorkshop.loadTransport(saab,0,0));
        assertEquals(5, carWorkshop.getLoadedTransport().size());


        // ---These should give compile errors when uncommented--- //
        //volvoWorkshop.loadTransport(saab, 0, 0);
        //saabWorkshop.loadTransport(volvo, 0, 0);

    }

    @Test
    public void dropTransport() {
        carWorkshop.getLoadedTransport().clear();
        volvoWorkshop.getLoadedTransport().clear();
        saabWorkshop.getLoadedTransport().clear();

        carWorkshop.loadTransport(saab, 0, 0);
        carWorkshop.dropTransport(0,0);
        assertEquals(0, carWorkshop.getLoadedTransport().size());

        volvoWorkshop.loadTransport(volvo, 0, 0);
        volvoWorkshop.dropTransport(0,0);
        assertEquals(0, volvoWorkshop.getLoadedTransport().size());

        saabWorkshop.loadTransport(saab, 0, 0);
        saabWorkshop.loadTransport(saab, 0, 0);
        saabWorkshop.dropTransport(0,0);
        saabWorkshop.dropTransport(0,0);
        assertEquals(0, saabWorkshop.getLoadedTransport().size());
    }
}
