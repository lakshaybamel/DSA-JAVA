import java.util.*;

public class SubArrays {

    public static void printSubArrays(int arr[]) {
        int count = 0;
        for (int i = 0; i < arr.length; i++){
            for (int j = i; j < arr.length; j++){
                System.out.print(" (");
                for (int k = i; k <= j; k++){ //print
                    System.out.print(arr[k]); //subarray
                    if (k < j) System.out.print(", ");
                }
                System.out.print(") ");
                count++;
            }
            System.out.println();
        }
        System.out.println("Total pairs of sub-arrays = " + count);
    }

    public static void main(String []args) {
        int arr[] = {2, 4, 6, 8, 10};
        printSubArrays(arr);
    }
}