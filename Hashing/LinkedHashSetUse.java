
import java.util.HashSet;
import java.util.LinkedHashSet;

public class LinkedHashSetUse {

    public static void main(String[] args) {

        // HashSet: does NOT maintain insertion order
        HashSet<String> hs = new HashSet<>();

        // Add elements
        hs.add("Delhi");
        hs.add("Mumbai");
        hs.add("Chandigarh");
        hs.add("Hisar");

        // Order may vary
        System.out.println(hs);

        // LinkedHashSet: maintains insertion order
        LinkedHashSet<String> lhs = new LinkedHashSet<>();

        // Add elements
        lhs.add("Delhi");
        lhs.add("Mumbai");
        lhs.add("Chandigarh");
        lhs.add("Hisar");

        // Prints in insertion order
        System.out.println(lhs);
    }
}
