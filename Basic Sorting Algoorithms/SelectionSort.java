public class SelectionSort {
    public static void sort(int[] arr) {
        // Outer loop → runs n-1 times
        for (int i = 0; i < arr.length-1; i++){

            int minPos = i; // assume current index i has the minimum element

            // Inner loop → find the actual minimum element in the remaining array
            for (int j = i + 1; j < arr.length; j++){
                if (arr[minPos] > arr[j]) {
                    minPos = j; // update minPos if a smaller element is found
                }
            }
            // Swap the smallest element with the element at index i
            int temp = arr[minPos];
            arr[minPos] = arr[i];
            arr[i] = temp;
        }
    }

    public static void print(int[] arr) {
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }
    
    public static void main(String []args){
        int arr[] = {5, 4, 1, 2, 3};
        sort(arr);
        print(arr);
    }
}