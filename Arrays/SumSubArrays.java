import java.util.*;

public class SumSubArrays {

    //time complexity O(n^3)
    //Brute force - bad - not optimised because using 3 nested loops
    public static void printSubArraysSum(int arr[]) {
        int count = 0;
        int maxSum = Integer.MIN_VALUE;
        int minSum = Integer.MAX_VALUE;

        for (int i = 0; i < arr.length; i++){
            for (int j = i; j < arr.length; j++){
                int sum = 0;
                sum = sum + arr[j];
                System.out.print(" (");
                for (int k = i; k <= j; k++){ //print
                    System.out.print(arr[k]); //subarray
                    if (k < j) System.out.print(", ");
                    sum = sum + arr[k];
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


    //using prefix sum to optamise the code
    //time complexity O(n^2) < O(n^3)
    public static void prefixSubArraysSum(int arr[]) {
        int sum;    
        int maxSum = Integer.MIN_VALUE;
        int minSum = Integer.MAX_VALUE;
        int prefix[] = new int[arr.length];

        //calculate prefix
        prefix[0] = arr[0];
        for (int i = 1; i < arr.length; i++){
            prefix[i] = prefix[i-1] + arr[i];
        }

        for (int i = 0; i < arr.length; i++){
            for (int j = i; j < arr.length; j++){
                sum = i == 0 ? prefix[j] : prefix[j] - prefix[i-1];

                // Update max and min sums
                if (sum > maxSum) maxSum = sum;
                if (sum < minSum) minSum = sum;
            }
        }
        System.out.println("Maximum subarray sum = " + maxSum);
        System.out.println("Minimum subarray sum = " + minSum);
    }

    public static void main(String []args) {
        int arr[] = {2, 4, 6, 8, 10};
        //printSubArraysSum(arr);
        prefixSubArraysSum(arr);
    }
}