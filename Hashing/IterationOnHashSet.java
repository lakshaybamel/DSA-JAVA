
import java.util.HashSet;
import java.util.Iterator;

public class IterationOnHashSet {

    public static void main(String[] args) {

        // Create HashSet
        HashSet<String> set = new HashSet<>();

        // Add elements
        set.add("Delhi");
        set.add("Mumbai");
        set.add("Chandigarh");
        set.add("Hisar");

        // Method 1: Using Iterator
        Iterator<String> it = set.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }

        // Method 2: Using Enhanced for-loop
        for (String city : set) {
            System.out.println(city);
        }
    }
}
