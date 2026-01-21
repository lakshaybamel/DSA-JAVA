
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;

public class TreeSetUse {

    public static void main(String[] args) {

        // HashSet: no order maintained
        HashSet<String> hs = new HashSet<>();
        hs.add("Delhi");
        hs.add("Mumbai");
        hs.add("Chandigarh");
        hs.add("Hisar");

        System.out.println(hs);

        // LinkedHashSet: insertion order maintained
        LinkedHashSet<String> lhs = new LinkedHashSet<>();
        lhs.add("Delhi");
        lhs.add("Mumbai");
        lhs.add("Chandigarh");
        lhs.add("Hisar");

        System.out.println(lhs);

        // TreeSet: elements stored in sorted order
        TreeSet<String> ts = new TreeSet<>();
        ts.add("Delhi");
        ts.add("Mumbai");
        ts.add("Chandigarh");
        ts.add("Hisar");

        System.out.println(ts);
    }
}
