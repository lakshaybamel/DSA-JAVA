public class MergeSort {

    // Print array
    public static void printArr(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // Recursive function to divide array
    public static void sort(int arr[], int si, int ei) {
        if (si >= ei) return;  // base case: 1 element

        int mid = si + (ei - si) / 2;  // find middle

        sort(arr, si, mid);     // sort left half
        sort(arr, mid + 1, ei); // sort right half
        merge(arr, si, mid, ei); // merge both
    }

    // Merge two sorted halves
    public static void merge(int arr[], int si, int mid, int ei) {
        int temp[] = new int[ei - si + 1];
        int i = si;      // pointer for left part
        int j = mid + 1; // pointer for right part
        int k = 0;       // pointer for temp

        // compare elements from both halves
        while (i <= mid && j <= ei) {
            if (arr[i] < arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }

        // copy remaining left elements
        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        // copy remaining right elements
        while (j <= ei) {
            temp[k++] = arr[j++];
        }

        // copy temp back to original array
        for (k = 0, i = si; k < temp.length; k++, i++) {
            arr[i] = temp[k];
        }
    }

    public static void main(String[] args) {
        int arr[] = {6, 3, 9, 5, 2, 1};
        sort(arr, 0, arr.length - 1);
        printArr(arr);  // Output: 1 2 3 5 6 9
    }
}
