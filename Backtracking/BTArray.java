public class BTArray {

    // Recursive function to fill array and apply backtracking
    public static void changeArr(int arr[], int i, int val) {
        if (i == arr.length) { // base case: array filled
            printArr(arr);
            return;
        }

        arr[i] = val; // set current index
        changeArr(arr, i + 1, val + 1); // recursion for next index
        arr[i] = arr[i] - 2; // backtracking: modify before returning
    }

    // Print array
    public static void printArr(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] main) {
        int arr[] = new int[5];
        changeArr(arr, 0, 1); // start filling from index 0 with value 1
        printArr(arr); // print final array after backtracking
    }
}
