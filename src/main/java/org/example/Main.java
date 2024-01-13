package org.example;

import java.time.format.DateTimeFormatter;

import java.util.List;

public class Main {
    static DateTimeFormatter dateAndTime = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");

    public static void main(String[] args) {

        List<Flight> flightList = FlightBuilder.createFlights();

        System.out.println("Исходные перелёты, полученные из createFlights():");
        flightList.forEach(System.out::println);

        System.out.println("Вылет до текущего момента времени");
        departureBeforeCurrentTimeFilter(flightList).forEach(System.out::println);

        System.out.println("Сегменты с датой прилёта раньше даты вылета");
        segmentsWithDateArrivalEarlierThanDepartureFilter(flightList).forEach(System.out::println);

        System.out.println("Перелеты, где общее время, проведённое на земле, превышает два часа " +
                "(время на земле — это интервал между прилётом одного сегмента и вылетом следующего за ним)");
        flightsWhereMoreThenTwoHoursOnGroundFilter(flightList).forEach(System.out::println);
    }

    public static List<Flight> departureBeforeCurrentTimeFilter(List<Flight> flightList) {
        return flightList;
    }

    public static List<Flight> segmentsWithDateArrivalEarlierThanDepartureFilter(List<Flight> flightList) {
        return flightList;
    }

    public static List<Flight> flightsWhereMoreThenTwoHoursOnGroundFilter(List<Flight> flightList) {
        return flightList;
    }
}
