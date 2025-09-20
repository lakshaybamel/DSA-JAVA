public class FirstOccurence {

    // Find first occurrence of key recursively
    public static int firstOcc(int arr[], int key, int i) {
        if(i == arr.length) return -1; // key not found
        if(arr[i] == key) return i;    // key found
        return firstOcc(arr, key, i+1); // check next index
    }

    public static void main(String[] args) {
        int arr[] = {2, 4, 6, 1, 5, 3, 7, 1, 8};
        System.out.println(firstOcc(arr, 1, 0)); // Output: 3
    }
}
