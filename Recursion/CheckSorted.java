public class CheckSorted {
    public static boolean isSorted(int []arr, int i) {
        if(i == arr.length-1) return true;  
        if(arr[i] > arr[i+1]) return false;
        return isSorted(arr, i+1);
    }
    public static void main(String []main) {
        int arr[] = {1, 2, 3, 4, 9, 6};
        System.out.println(isSorted(arr, 0));
    }
}