import org.example.Flight;
import org.example.FlightBuilder;
import org.example.Main;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class MainTest {

    List<Flight> flightList1 = FlightBuilder.createFlights();
    @Test
    public void departureBeforeCurrentTimeFilterTest() {
        List<Flight> flights = new ArrayList<>(flightList1);
        List<Flight> flightList = Main.departureBeforeCurrentTimeFilter(flights);
        List<Flight> expected = new ArrayList<>(flightList1);
        expected.remove(flightList1.get(2));
        Assertions.assertIterableEquals(expected, flightList);
        Assertions.assertNotNull(flightList);
    }
    @Test
    public void segmentsWithDateArrivalEarlierThanDepartureFilterTest() {
        List<Flight> flights = new ArrayList<>(flightList1);
        List<Flight> flightList = Main.segmentsWithDateArrivalEarlierThanDepartureFilter(flights);
        List<Flight> expected = new ArrayList<>(flightList1);
        expected.remove(flightList1.get(3));
        Assertions.assertIterableEquals(expected, flightList);
        Assertions.assertNotNull(flightList);
    }
    @Test
    public void moreThenTwoHoursWaitingFilterTest() {
        List<Flight> flights = new ArrayList<>(flightList1);
        List<Flight> flightList =  Main.flightsWhereMoreThenTwoHoursOnGroundFilter(flights);
        List<Flight> expected = new ArrayList<>(flightList1);
        expected.remove(flightList1.get(4));
        Assertions.assertIterableEquals(expected, flightList);
        Assertions.assertNotNull(flightList);
    }
}
