
import java.util.TreeSet;

public class CountDistinctElements {

    public static void main(String[] args) {

        int[] nums = {4, 3, 2, 5, 6, 7, 3, 4, 2, 1};

        // TreeSet stores unique elements in sorted order
        TreeSet<Integer> ts = new TreeSet<>();

        // add all elements to TreeSet
        for (int idx = 0; idx < nums.length; idx++) {
            ts.add(nums[idx]); // duplicates automatically ignored
        }

        // size of TreeSet = number of distinct elements
        System.out.println("Unique elements: " + ts.size());
    }
}
