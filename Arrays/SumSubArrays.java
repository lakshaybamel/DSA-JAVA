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

    //max and min subarray sum with the help of kadanes algorithm
    //time complexity for max is O(n)
    /*Below code 
    -> Dont give correct max sum of SubArray when all array elements are -ve
    -> Dont give correct min sum of SubArray when all array elements are +ve*/
    public static void kadanesBoth(int arr[]) {
    int maxSum = Integer.MIN_VALUE;
    int minSum = Integer.MAX_VALUE;
    int currentMax = 0;
    int currentMin = 0;

    for (int i = 0; i < arr.length; i++) {
        // For max subarray sum
        currentMax += arr[i];
        if (currentMax < 0) currentMax = 0;
        maxSum = Math.max(maxSum, currentMax);

        // For min subarray sum
        currentMin += arr[i];
        if (currentMin > 0) currentMin = 0;
        minSum = Math.min(minSum, currentMin);
    }

    System.out.println("Max subarray sum is : " + maxSum);
    System.out.println("Min subarray sum is : " + minSum);
}

/*
- Time Complexity: O(n) — single pass through the array
- Space Complexity: O(1) — no extra storage needed
- Edge Case Handling: Works even when all elements are negative or positive*/
public static void kadanesAnyArray(int arr[]) {
    int currentMax = arr[0];
    int maxSum = arr[0];
    int currentMin = arr[0];
    int minSum = arr[0];

    for (int i = 1; i < arr.length; i++) {
        // Update current max and overall max
        currentMax = Math.max(arr[i], currentMax + arr[i]);
        maxSum = Math.max(maxSum, currentMax);

        // Update current min and overall min
        currentMin = Math.min(arr[i], currentMin + arr[i]);
        minSum = Math.min(minSum, currentMin);
    }

    System.out.println("Max subarray sum is : " + maxSum);
    System.out.println("Min subarray sum is : " + minSum);
}

    public static void main(String []args) {
        int arr[] = {2, 4, 6, 8, 10};
        int arr1[] = {-2, -3, 4, -1, -2, 1, 5, -3}; //mix array
        int arr2[] = {-2, -5, -3, -9, -12, -6}; //all negative
        int arr3[] = {2, 11, 8, 1, 12, 6, 3}; //all positive
        //printSubArraysSum(arr);
        //prefixSubArraysSum(arr);
        //kadanesBoth(arr1);
        kadanesAnyArray(arr1);
        kadanesAnyArray(arr2);
        kadanesAnyArray(arr3);
    }
}