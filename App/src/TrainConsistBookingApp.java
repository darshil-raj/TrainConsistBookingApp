import java.util.HashMap;
import java.util.Map;

public class  TrainConsistBookingApp{

    public static void main(String[] args) {

        // Welcome message
        System.out.println("=== Train Consist Management App ===");

        // Create HashMap for bogie-capacity mapping
        Map<String, Integer> bogieCapacityMap = new HashMap<>();

        // Insert bogie capacities
        bogieCapacityMap.put("Sleeper", 72);
        bogieCapacityMap.put("AC Chair", 54);
        bogieCapacityMap.put("First Class", 24);

        // Display bogie capacities
        System.out.println("\nBogie Capacity Details:");

        for (Map.Entry<String, Integer> entry : bogieCapacityMap.entrySet()) {
            System.out.println(entry.getKey() + " -> Capacity: " + entry.getValue());
        }

        // Program continues...
    }
}