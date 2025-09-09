import java.util.Arrays;
import java.util.Collections;

public class InbuiltSort {
    public static void sortAscending(int[] arr) {
        // Sort in ascending order (works directly with int[])
        Arrays.sort(arr);

        System.out.print("Ascending: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void sortDescending(Integer[] arr) {
        // Sort in descending order (must use Integer[], not int[])
        Arrays.sort(arr, Collections.reverseOrder());

        System.out.print("Descending: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int arr1[] = {5, 4, 1, 3, 2};
        Integer arr2[] = {5, 4, 1, 3, 2}; // wrapper Integer type

        sortAscending(arr1);   // works with int[]
        sortDescending(arr2);  // works with Integer[]
    }
}