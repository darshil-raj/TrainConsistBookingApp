package test;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

// Bogie class
class Bogie {
    String name;
    int capacity;

    public Bogie(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return name + " (Capacity: " + capacity + ")";
    }
}

public class TrainApp {

    // Reusable method for filtering
    public static List<Bogie> filterBogiesByCapacity(List<Bogie> bogies, int threshold) {
        return bogies.stream()
                .filter(b -> b.capacity > threshold)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {

        System.out.println("=== Train Consist Management App ===");

        // Create bogie list
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 54));
        bogies.add(new Bogie("First Class", 24));

        // Display original list
        System.out.println("\nAll Bogies:");
        System.out.println(bogies);

        // Apply filtering
        List<Bogie> filtered = filterBogiesByCapacity(bogies, 60);

        // Display filtered result
        System.out.println("\nFiltered Bogies (Capacity > 60):");
        filtered.forEach(System.out::println);

        // Verify original list unchanged
        System.out.println("\nOriginal List After Filtering:");
        System.out.println(bogies);
    }
}
