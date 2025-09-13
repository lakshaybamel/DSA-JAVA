import java.util.*;

public class StringBuilderDemo {
    public static void main(String[] args) {
        // Create an empty StringBuilder
        StringBuilder sb = new StringBuilder("");

        // Append all characters from 'a' to 'z'
        for (char ch = 'a'; ch <= 'z'; ch++) {  // loop runs 26 times → O(26) ~ O(1)
            sb.append(ch); // efficient appending
        }

        // Print the final string
        System.out.println(sb);  // Output: abcdefghijklmnopqrstuvwxyz
    }
}
