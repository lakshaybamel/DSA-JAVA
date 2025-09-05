import java.util.*;

public class BinarySearch{

    public static int bSearch(int arr[], int key){
        int start = 0;
        int end = arr.length-1;

        while (start <= end){
            //mid
            int mid = (start + end)/2;

            // comparision
            if (arr[mid] == key){ //mid
                return mid;
            }

            if (arr[mid] > key) { //left
                end = mid -1;
            }

            if (arr[mid] < key) { //right
                start = mid + 1;
            }
        }
        return -1;
    }

    public static void main (String []args){
        int arr[] = {2, 5, 6, 8, 11, 14, 20, 21, 25};
        int key = 55;
        int index = bSearch(arr, key);

        if (index != -1){
            System.out.println("Element found at index : " + index);
        } else {
            System.out.println("Element not found!");
        }  
    }
}