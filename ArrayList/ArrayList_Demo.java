import java.util.ArrayList;

public class ArrayList_Demo {
    public static void main(String args[]) {

        // create ArrayList
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<String> list2 = new ArrayList<>();
        ArrayList<Boolean> list3 = new ArrayList<>();

        // Add element - O(1)
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        list.add(1, 9); //O(n)

        // print ArrayList
        System.out.println(list);

        // Get Element - O(1)
        int element = list.get(2);
        System.out.println(element);

        // Remove Element - O(n)
        list.remove(2);
        System.out.println(list);

        // Set element at index (updation) - O(n)
        list.set(2, 10);
        System.out.println(list);


        // Contains element - O(n)
        System.out.println(list.contains(10));

        // Size of ArrayList
        System.out.println(list.size());

        for(int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();

    }
}