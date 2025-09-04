import java.util.*;

public class LargestSmallest{

    //largest
    public static int getLargest(int arr[]){
        int largest = Integer.MIN_VALUE; //-infinity

        for (int i = 0; i < arr.length; i++){
            if (largest < arr[i]){
                largest = arr[i];
            }
        }
    return largest;
    }

    //smallest
    public static int getSmallest(int arr[]){
        int smallest = Integer.MAX_VALUE; //+infinity

        for (int i = 0; i < arr.length; i++){
            if (smallest > arr[i]){
                smallest = arr[i];
            }
        }
    return smallest;
    }

    public static void main(String []args){
        int arr[] = {10, 22, 14, 34, 5, 18};
        System.out.println("Largest no. in the array is " + getLargest(arr));
        System.out.println("Largest no. in the array is " + getSmallest(arr));
    }
}