
import java.util.HashSet;

public class UnionIntersection {

    public static void main(String[] args) {

        int[] arr1 = {7, 3, 9};
        int[] arr2 = {6, 3, 9, 2, 9, 4};

        HashSet<Integer> hs = new HashSet<>();

        // UNION
        // add all elements of arr1
        for (int i = 0; i < arr1.length; i++) {
            hs.add(arr1[i]);
        }

        // add all elements of arr2
        for (int i = 0; i < arr2.length; i++) {
            hs.add(arr2[i]); // duplicates ignored
        }

        // size of set = union count
        System.out.println("Union: " + hs.size());

        // INTERSECTION
        hs.clear(); // clear set

        // add elements of arr1
        for (int i = 0; i < arr1.length; i++) {
            hs.add(arr1[i]);
        }

        int count = 0;

        // check elements of arr2
        for (int i = 0; i < arr2.length; i++) {
            if (hs.contains(arr2[i])) {
                count++;            // common element found
                hs.remove(arr2[i]); // avoid double counting
            }
        }

        System.out.println("Intersection: " + count);
    }
}
