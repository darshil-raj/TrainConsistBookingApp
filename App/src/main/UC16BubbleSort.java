package test;

public class UC16BubbleSort {

    // 🔹 Bubble Sort Method
    public static void bubbleSort(int[] arr) {

        int n = arr.length;

        // Outer loop (passes)
        for (int i = 0; i < n - 1; i++) {

            // Inner loop (comparison)
            for (int j = 0; j < n - i - 1; j++) {

                // Swap if wrong order
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    // 🔹 Display method
    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    // 🔹 Main
    public static void main(String[] args) {

        int[] capacities = {72, 56, 24, 70, 60};

        System.out.print("Before Sorting: ");
        printArray(capacities);

        bubbleSort(capacities);

        System.out.print("After Sorting: ");
        printArray(capacities);
    }
}