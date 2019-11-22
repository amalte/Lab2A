import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CarWorkshopTest {
    CarWorkshop<Car> carWorkshop = new CarWorkshop<>(5, 3, 4, 5, 0, 0);
    CarWorkshop<Volvo240> volvoWorkshop = new CarWorkshop<>(5, 3, 4, 5,0,0);
    CarWorkshop<Saab95> saabWorkshop = new CarWorkshop<>(5, 3, 4, 5,0,0);

    Volvo240 volvo = new Volvo240();
    Saab95 saab = new Saab95();

    @Test
    public void loadTransport() {
        carWorkshop.loadTransport(saab);
        carWorkshop.loadTransport(volvo);
        assertEquals(2, carWorkshop.getLoadedTransport().size());

        volvoWorkshop.loadTransport(volvo);
        assertEquals(1, volvoWorkshop.getLoadedTransport().size());
        saabWorkshop.loadTransport(saab);
        assertEquals(1, saabWorkshop.getLoadedTransport().size());

        carWorkshop.loadTransport(saab);
        carWorkshop.loadTransport(saab);
        carWorkshop.loadTransport(saab);
        assertEquals(false, carWorkshop.loadTransport(saab));
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

        carWorkshop.loadTransport(saab);
        carWorkshop.dropTransport();
        assertEquals(0, carWorkshop.getLoadedTransport().size());

        volvoWorkshop.loadTransport(volvo);
        volvoWorkshop.dropTransport();
        assertEquals(0, volvoWorkshop.getLoadedTransport().size());

        saabWorkshop.loadTransport(saab);
        saabWorkshop.loadTransport(saab);
        saabWorkshop.dropTransport();
        saabWorkshop.dropTransport();
        assertEquals(0, saabWorkshop.getLoadedTransport().size());
    }
}
