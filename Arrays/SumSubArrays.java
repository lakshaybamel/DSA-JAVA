import java.util.*;

public class SumSubArrays {

    public static void printSubArrays(int arr[]) {
        int count = 0;
        int maxSum = Integer.MIN_VALUE;
        int minSum = Integer.MAX_VALUE;

        for (int i = 0; i < arr.length; i++){
            int sum = 0;
            for (int j = i; j < arr.length; j++){
                sum = sum + arr[j];
                System.out.print(" (");
                for (int k = i; k <= j; k++){ //print
                    System.out.print(arr[k]); //subarray
                    if (k < j) System.out.print(", ");
                }
                System.out.print(")-> Sum = " + sum);
                count++;

                // Update max and min sums
                if (sum > maxSum) maxSum = sum;
                if (sum < minSum) minSum = sum;

            }
            System.out.println();
        }
        System.out.println("Total pairs of sub-arrays = " + count);
        System.out.println("Maximum subarray sum = " + maxSum);
        System.out.println("Minimum subarray sum = " + minSum);

    }

    public static void main(String []args) {
        int arr[] = {2, 4, 6, 8, 10};
        printSubArrays(arr);
    }
}