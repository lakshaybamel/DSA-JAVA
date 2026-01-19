
import java.util.HashMap;

public class ValidAnagram {

    // Function to check if two strings are anagrams
    public static boolean isAnagram(String s, String t) {

        // If lengths differ, cannot be anagrams
        if (s.length() != t.length()) {
            return false;
        }

        // Map to store frequency of characters in s
        HashMap<Character, Integer> map = new HashMap<>();

        // Count characters of string s
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        // Decrease count using characters of string t
        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);

            // character not present -> not an anagram
            if (map.get(ch) == null) {
                return false;
            }

            // reduce frequency
            if (map.get(ch) == 1) {
                map.remove(ch);
            } else {
                map.put(ch, map.get(ch) - 1);
            }
        }

        // if map is empty -> all counts matched
        return map.isEmpty();
    }

    public static void main(String[] args) {
        String s = "race";
        String t = "care";

        System.out.println(isAnagram(s, t)); // true
    }
}
