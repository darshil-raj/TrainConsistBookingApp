package test;

import java.util.Arrays;

public class UC19BinarySearch {

    // 🔹 Binary Search Method
    public static boolean binarySearch(String[] bogieIds, String key) {

        // Handle empty array
        if (bogieIds.length == 0) return false;

        // 🔹 Ensure sorted
        Arrays.sort(bogieIds);

        int low = 0;
        int high = bogieIds.length - 1;

        while (low <= high) {

            int mid = (low + high) / 2;

            int compare = key.compareTo(bogieIds[mid]);

            if (compare == 0) {
                return true; // found
            }
            else if (compare < 0) {
                high = mid - 1; // search left
            }
            else {
                low = mid + 1; // search right
            }
        }

        return false; // not found
    }

    public static void main(String[] args) {

        String[] bogies = {"BG101","BG205","BG309","BG412","BG550"};

        String searchKey = "BG309";

        boolean found = binarySearch(bogies, searchKey);

        if (found) {
            System.out.println("Bogie Found: " + searchKey);
        } else {
            System.out.println("Bogie Not Found");
        }
    }
}