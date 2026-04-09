

package main;

import java.util.*;
import java.util.stream.Collectors;

public class UC9GroupBogy {

    // Simple Bogie class
    public static class Bogie {
        private String type; // e.g., "Sleeper", "AC Chair", "First Class"
        private int seatCapacity;

        public Bogie(String type, int seatCapacity) {
            this.type = type;
            this.seatCapacity = seatCapacity;
        }

        public String getType() {
            return type;
        }

        public int getSeatCapacity() {
            return seatCapacity;
        }

        @Override
        public String toString() {
            return "Bogie{" + "type='" + type + '\'' + ", seatCapacity=" + seatCapacity + '}';
        }
    }

    public static void main(String[] args) {
        // Create a list of bogies
        List<Bogie> bogies = Arrays.asList(
                new Bogie("Sleeper", 72),
                new Bogie("AC Chair", 78),
                new Bogie("First Class", 54),
                new Bogie("Sleeper", 72),
                new Bogie("AC Chair", 80)
        );

        // Group bogies by type using Collectors.groupingBy
        Map<String, List<Bogie>> groupedBogies = bogies.stream()
                .collect(Collectors.groupingBy(Bogie::getType));

        // Print grouped result
        System.out.println("Grouped Bogies by Type:");
        groupedBogies.forEach((type, list) -> {
            System.out.println(type + " => " + list);
        });

        // Program continues...
        System.out.println("\nOriginal bogie list size: " + bogies.size());
    }
}
