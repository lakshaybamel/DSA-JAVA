import java.util.*;

public class MaxWater {

    // Brute Force Approach - O(n^2)
    // Checks all possible pairs of lines and finds maximum area
    public static int storeWaterBrute(ArrayList<Integer> height) {
        int n = height.size();
        int maxArea = 0;

        // Try all pairs (i, j)
        for (int left = 0; left < n; left++) {
            for (int right = left + 1; right < n; right++) {
                int width = right - left; // distance between lines
                int h = Math.min(height.get(left), height.get(right)); // min height of the two lines
                int area = width * h; // area formed
                maxArea = Math.max(maxArea, area); // update maximum area
            }
        }
        return maxArea;
    }

    // Two Pointer Approach - O(n)
    // Uses two pointers and moves the smaller one to maximize area
    public static int storeWaterTwoPointer(ArrayList<Integer> height) {
        int left = 0, right = height.size() - 1; // two pointers at ends
        int maxArea = 0;

        // Move pointers until they meet
        while (left < right) {
            int width = right - left; // distance between lines
            int h = Math.min(height.get(left), height.get(right)); // min height of the two lines
            int area = width * h; // area formed
            maxArea = Math.max(maxArea, area); // update maximum area

            // Move the pointer with the smaller height
            if (height.get(left) < height.get(right)) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        ArrayList<Integer> height = new ArrayList<>();
        // Example input: [1, 8, 6, 2, 5, 4, 8, 3, 7]
        height.add(1);
        height.add(8);
        height.add(6);
        height.add(2);
        height.add(5);
        height.add(4);
        height.add(8);
        height.add(3);
        height.add(7);

        // Test both methods
        System.out.println("Brute Force Max Area: " + storeWaterBrute(height));
        System.out.println("Two Pointer Max Area: " + storeWaterTwoPointer(height));
    }
}
