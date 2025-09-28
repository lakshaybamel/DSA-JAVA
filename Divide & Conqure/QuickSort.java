public class QuickSort {

    // Function to print the array
    public static void printArr(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // QuickSort function
    public static void sort(int arr[], int si, int ei) {
        if (si >= ei) return; // base case: 1 or 0 elements

        int pIdx = partition(arr, si, ei); // get pivot index

        sort(arr, si, pIdx - 1); // sort left part
        sort(arr, pIdx + 1, ei); // sort right part
    }

    // Partition function
    public static int partition(int arr[], int si, int ei) {
        int pivot = arr[ei]; // last element as pivot
        int i = si - 1;      // index of smaller element

        for (int j = si; j < ei; j++) {
            if (arr[j] <= pivot) {
                i++;
                // swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // swap pivot to correct position
        int temp = arr[i + 1];
        arr[i + 1] = arr[ei];
        arr[ei] = temp;

        return i + 1; // return pivot index
    }

    public static void main(String[] args) {
        int[] arr = {6, 3, 9, 8, 2, 5};
        sort(arr, 0, arr.length - 1); 
        printArr(arr); // Output: 2 3 5 6 8 9
    }
}
