package main;

import java.util.*;

public class UC10TotalSeatTest {

    public static int calculateTotalSeats(List<Bogie> bogies) {
        return bogies.stream()
                .map(Bogie::getCapacity)
                .reduce(0, Integer::sum);
    }

    public static void main(String[] args) {

        List<Bogie> bogies = Arrays.asList(
                new Bogie("Sleeper", 72),
                new Bogie("AC Chair", 60),
                new Bogie("First Class", 40)
        );

        int totalSeats = calculateTotalSeats(bogies);

        System.out.println("Total Seating Capacity: " + totalSeats);
    }
}