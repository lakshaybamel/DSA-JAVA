public class RemoveDuplicates {

    // Recursively remove duplicate characters
    public static void removeDup(String str, int idx, StringBuilder newStr, boolean map[]) {
        if(idx == str.length()) { // reached end of string
            System.out.println(newStr);
            return;
        }

        char currentChar = str.charAt(idx);

        if(map[currentChar - 'a']) { // already added, skip
            removeDup(str, idx + 1, newStr, map);
        } else {
            map[currentChar - 'a'] = true; // mark as seen
            removeDup(str, idx + 1, newStr.append(currentChar), map);
        }
    }

    public static void main(String []args) {
        String str = "appnnacollege";
        removeDup(str, 0, new StringBuilder(""), new boolean[26]); // start recursion
    }
}
  