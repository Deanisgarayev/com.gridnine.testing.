package org.example;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    private static final LocalDateTime now = LocalDateTime.now();

    public static void main(String[] args) {

        List<Flight> flightList = FlightBuilder.createFlights();

        System.out.println("Исходные перелёты");
        flightList.forEach(System.out::println);

        System.out.println("Фильтрация вылетов до текущего момента времени");
        departureBeforeCurrentTimeFilter(flightList).forEach(System.out::println);

        System.out.println("Фильтрация сегментов с датой прилёта раньше даты вылета");
        segmentsWithDateArrivalEarlierThanDepartureFilter(flightList).forEach(System.out::println);

        System.out.println("Фильтрация перелетов, где общее время, проведённое на земле, превышает два часа " +
                "(время на земле — это интервал между прилётом одного сегмента и вылетом следующего за ним)");
        flightsWhereMoreThenTwoHoursOnGroundFilter(flightList).forEach(System.out::println);
    }

    public static List<Flight> departureBeforeCurrentTimeFilter(List<Flight> flightList) {
        List<Flight> flights = new ArrayList<>(flightList);
        for (Flight flight : flightList) {
            for (Segment segment : flight.getSegments()) {
                if (segment.getDepartureDate().isBefore(now)) {
                    flights.remove(flight);
                }
            }
        }
        return flights;
    }


    public static List<Flight> segmentsWithDateArrivalEarlierThanDepartureFilter(List<Flight> flightList) {
        List<Flight> flights = new ArrayList<>(flightList);
        for (Flight flight : flightList) {
            for (Segment segment : flight.getSegments()) {
                if (segment.getArrivalDate().isBefore(segment.getDepartureDate())) {
                    flights.remove(flight);
                }
            }
        }
        return flights;
    }

    public static List<Flight> flightsWhereMoreThenTwoHoursOnGroundFilter(List<Flight> flightList) {
        List<Flight> flights = new ArrayList<>(flightList);
        for (Flight flight : flightList) {
            List<Segment> segments = flight.getSegments();
            for (int i = 1; i < segments.size(); i++) {
                LocalDateTime lastArrival = segments.get(i-1).getArrivalDate();
                LocalDateTime nextDeparture = segments.get(i).getDepartureDate();
                if (lastArrival.until(nextDeparture, ChronoUnit.HOURS)>2){
                    flights.remove(flight);
                }
            }
        }
        return flights;
    }
}
