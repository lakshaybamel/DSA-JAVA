public class LastOccurrence {

    // Find last occurrence of key recursively
    public static int lastOcc(int arr[], int key, int i) {
        if(i == arr.length) return -1;          // end of array
        int restIndex = lastOcc(arr, key, i+1); // check in rest of array
        if(restIndex != -1) return restIndex;   // found in rest → return it
        if(arr[i] == key) return i;             // otherwise check current
        return -1;                              // not found
    }

    public static void main(String[] args) {
        int arr[] = {2, 4, 6, 1, 5, 3, 7, 1, 8};
        System.out.println(lastOcc(arr, 1, 0)); // Output: 7
    }
}
