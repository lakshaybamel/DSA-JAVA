public class SortedRotated {

    // Function to search target in rotated sorted array
    public static int search(int arr[], int target, int si, int ei) {

        if (si > ei) return -1; // base case: not found

        int mid = si + (ei - si) / 2; // find mid index

        if (arr[mid] == target) return mid; // found target at mid

        // Case 1: Left part is sorted
        if (arr[si] <= arr[mid]) {
            // If target lies in left sorted part
            if (arr[si] <= target && target <= arr[mid]) {
                return search(arr, target, si, mid - 1);
            } else {
                return search(arr, target, mid + 1, ei);
            }
        }

        // Case 2: Right part is sorted
        else {
            // If target lies in right sorted part
            if (arr[mid] <= target && target <= arr[ei]) {
                return search(arr, target, mid + 1, ei);
            } else {
                return search(arr, target, si, mid - 1);
            }
        }
    }

    public static void main(String[] args) {
        int arr[] = {4, 5, 6, 7, 0, 1, 2};
        int target = 0; // expected output = index 4

        int targetIdx = search(arr, target, 0, arr.length - 1);
        System.out.println(targetIdx);
    }
}
