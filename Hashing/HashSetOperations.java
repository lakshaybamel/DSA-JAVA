
import java.util.HashSet;

public class HashSetOperations {

    public static void main(String[] args) {

        // Create HashSet (stores unique elements)
        HashSet<Integer> set = new HashSet<>();

        // add elements (duplicates are ignored)
        set.add(1);
        set.add(2);
        set.add(1); // duplicate
        set.add(3);
        set.add(4);
        set.add(5);
        set.add(3); // duplicate

        // print set (order not guaranteed)
        System.out.println(set);

        // check if element exists
        System.out.println(set.contains(1)); // true
        System.out.println(set.contains(8)); // false

        // remove elements
        System.out.println(set.remove(2)); // true (removed)
        System.out.println(set.remove(8)); // false (not present)

        // print after removal
        System.out.println(set);

        // number of elements
        System.out.println(set.size());

        // remove all elements
        set.clear();

        // check if set is empty
        System.out.println(set.isEmpty()); // true
    }
}
