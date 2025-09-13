import java.util.*;

public class UpperCase {
    public static String toUpperCase(String str) {
        StringBuilder sb = new StringBuilder();

        // Convert the first character to uppercase
        sb.append(Character.toUpperCase(str.charAt(0)));

        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == ' ' && i < str.length() - 1) {
                // Add space
                sb.append(' ');
                // Convert next character to uppercase
                i++;
                sb.append(Character.toUpperCase(str.charAt(i)));
            } else {
                sb.append(str.charAt(i));
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String str = "hi, i am lakshay bamel";
        System.out.println(toUpperCase(str));  // Output: Hi, I Am Lakshay Bamel
    }
}
