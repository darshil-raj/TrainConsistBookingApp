package test;

import java.util.Arrays;

public class UC17ArraySort {

    // 🔹 Method to sort bogie names
    public static String[] sortBogieNames(String[] bogies) {
        Arrays.sort(bogies);   // Built-in sorting
        return bogies;
    }

    public static void main(String[] args) {

        String[] bogies = {
                "Sleeper",
                "AC Chair",
                "First Class",
                "General",
                "Luxury"
        };

        System.out.println("Before Sorting: " + Arrays.toString(bogies));

        sortBogieNames(bogies);

        System.out.println("After Sorting: " + Arrays.toString(bogies));
    }
}