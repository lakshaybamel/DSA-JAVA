
import java.util.HashMap;

public class SubArraySumEqualToK {

    public static void main(String[] args) {

        int arr[] = {10, 2, -2, -20, 10};
        int k = -10;

        // Map: prefixSum -> frequency
        HashMap<Integer, Integer> map = new HashMap<>();

        // Base case: prefix sum 0 occurs once
        map.put(0, 1);

        int sum = 0; // prefix sum
        int ans = 0; // count of subarrays

        for (int j = 0; j < arr.length; j++) {
            sum += arr[j];

            // If (sum - k) exists, we found subarrays ending at j
            if (map.containsKey(sum - k)) {
                ans += map.get(sum - k);
            }

            // Store/update frequency of current prefix sum
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        System.out.println(ans);
    }
}
