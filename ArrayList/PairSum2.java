import java.util.*;

public class PairSum2 {

    // Brute Force - O(n^2)
    // Check every possible pair
    public static boolean pairSumBrute(ArrayList<Integer> list, int target) {
        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(i) + list.get(j) == target) {
                    return true; // pair found
                }
            }
        }
        return false; // no pair found
    }

    // Two Pointer Approach - O(n)
    // Works only on a sorted & rotated array
    public static boolean pairSumTwoPtr(ArrayList<Integer> list, int target) {
        int n = list.size();
        int pivot = -1; // breaking point (where rotation happens)

        // Step 1: Find pivot (point of rotation)
        for (int i = 0; i < n - 1; i++) {
            if (list.get(i) > list.get(i + 1)) {
                pivot = i;
                break;
            }
        }

        // Step 2: Initialize left (smallest) and right (largest)
        int left = (pivot + 1) % n; // index of smallest element
        int right = pivot;          // index of largest element

        // Step 3: Search for pair using circular two-pointer
        while (left != right) {
            int sum = list.get(left) + list.get(right);

            if (sum == target) {
                return true; // pair found
            } else if (sum < target) {
                left = (left + 1) % n; // move left circularly forward
            } else {
                right = (right + n - 1) % n; // move right circularly backward
            }
        }

        return false; // no pair found
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();

        // Rotated sorted array
        list.add(11);
        list.add(15);
        list.add(6);
        list.add(8);
        list.add(9);
        list.add(10);

        int target = 16;

        // Test both approaches
        System.out.println("Brute Force: " + pairSumBrute(list, target));
        System.out.println("Two Pointer: " + pairSumTwoPtr(list, target));
    }
}
