public class InsertionSort {
    public static void sort (int[] arr){
        for (int i = 1; i < arr.length; i++) {
            int current = arr[i]; // element to insert
            int previous = i - 1;

            // shift bigger elements one step forward
            while (previous >= 0 && arr[previous] > arr[current]){
                arr[previous + 1] = arr[previous];
                previous--;
            }
            // insert current element in its correct place
            arr[previous + 1] = current;
        }
    }

    public static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String[] args){
        int arr[] = {5, 4, 1, 3, 2};
        sort(arr);
        print(arr);
    }
}