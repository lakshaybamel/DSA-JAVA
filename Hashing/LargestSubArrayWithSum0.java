
import java.util.HashMap;

public class LargestSubArrayWithSum0 {

    public static void main(String[] args) {

        int arr[] = {15, 2, -2, -8, 1, 7, 10, 23};

        // Map: prefixSum -> first index where it appears
        HashMap<Integer, Integer> map = new HashMap<>();

        int sum = 0; // prefix sum
        int len = 0; // maximum length found

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];

            // if same prefix sum seen before, subarray sum is 0
            if (map.containsKey(sum)) {
                len = Math.max(len, i - map.get(sum));
            } else {
                // store first occurrence of prefix sum
                map.put(sum, i);
            }
        }

        System.out.println("Largest subarray with sum as 0 = " + len);
    }
}
