import org.example.Flight;
import org.example.Main;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


import java.util.ArrayList;
import java.util.List;



public class MainTest {
    private static final Main out = new Main();



    @Test
    public void departureBeforeCurrentTimeFilterTest() {
        List<Flight> flights = new ArrayList<>();
        List<Flight> flightList = Main.departureBeforeCurrentTimeFilter(flights);
        List<Flight> expected = new ArrayList<>();
        Assertions.assertIterableEquals(expected, flightList);
        Assertions.assertNotNull(flightList);
    }
    @Test
    public void segmentsWithDateArrivalEarlierThanDepartureFilterTest() {
        List<Flight> flights = new ArrayList<>();
        List<Flight> flightList = Main.segmentsWithDateArrivalEarlierThanDepartureFilter(flights);
        List<Flight> expected = new ArrayList<>();
        Assertions.assertIterableEquals(expected, flightList);
        Assertions.assertNotNull(flightList);
    }
    @Test
    public void moreThenTwoHoursWaitingFilterTest() {
        List<Flight> flights = new ArrayList<>();
        List<Flight> flightList =  Main.flightsWhereMoreThenTwoHoursOnGroundFilter(flights);
        List<Flight> expected = new ArrayList<>();
        Assertions.assertIterableEquals(expected, flightList);
        Assertions.assertNotNull(flightList);
    }
}
