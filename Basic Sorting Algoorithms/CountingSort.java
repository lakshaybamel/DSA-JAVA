public class CountingSort {
    public static void sort (int[] arr){
        // Step 1: Find the largest element in the array
        int largest = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            largest = Math.max(largest, arr[i]);
        }

        // Step 2: Create a count array of size (largest + 1)
        // Each index will store the frequency of that number
        int count[] = new int[largest+1];

        // Step 3: Count the frequency of each element in the input array
        for (int i = 0; i < arr.length; i++) {
            count[arr[i]]++;
        }

        // Step 4: Place elements back into the array in sorted order
        int j = 0; // index for arr
        for (int i = 0; i < arr.length; i++) {
            while (count[i] > 0) {
                arr[j] = i;   // put the number into the array
                j++;          // move to next position
                count[i]--;   // decrease frequency
            }
        }
    }

    public static void print (int[] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void main (String[] args){
        int arr[] = {1, 4, 1, 3, 2, 4, 3, 7};
        sort(arr);
        print(arr);
    }
}