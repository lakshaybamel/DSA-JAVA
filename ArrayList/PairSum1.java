import java.util.*;

public class PairSum1 {

    // Brute Force - O(n^2)
    // Check all possible pairs to see if any sum equals target
    public static boolean pairSumBruit(ArrayList<Integer> list, int target) {
        for(int i = 0; i < list.size(); i++) {
            for(int j = i+1; j < list.size(); j++) {
                if(list.get(i) + list.get(j) == target) 
                    return true; // found pair
            }
        }
        return false;
    }

    // Two Pointer Approach - O(n)
    // Works only on a sorted list
    public static boolean pairSumTwoPtr(ArrayList<Integer> list, int target) {
        int left = 0, right = list.size()-1;

        while(left < right) {
            int sum = list.get(left) + list.get(right);

            if(sum == target) return true;       // found pair
            else if(sum < target) left++;        // move left forward
            else right--;                        // move right backward
        }

        return false;
    }

    public static void main(String []args) {
        ArrayList<Integer> list = new ArrayList<>();
        // Sorted input list for two-pointer method
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        int target = 5;

        //System.out.println(pairSumBruit(list, target));
        System.out.println(pairSumTwoPtr(list, target)); // true (2+3)
    }
}
