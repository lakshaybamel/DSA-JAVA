import java.util.*;

public class ArrayFn {
    public static void update (int arr[]){
        for (int i = 0; i <= arr.length; i++){
            arr[i] = arr[i] + 1;
            return;
        }
    }

    public static void main (String []args) {
        int arr[] = {10, 15, 20};
        update(arr);
        for (int i = 0; i < arr.length; i++){
            System.out.println(arr[i]);
        }
    }
}