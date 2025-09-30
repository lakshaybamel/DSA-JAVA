public class FindSubstrings {

    public static void findSubstr(String str, String ans, int i) {
        // base case: if we reached end of string
        if (i == str.length()) {
            if (ans.length() == 0) {
                System.out.println("null"); // empty subset
            } else {
                System.out.println(ans); // print formed substring
            }
            return;
        }

        // choice 1 → include current char
        findSubstr(str, ans + str.charAt(i), i + 1);

        // choice 2 → exclude current char
        findSubstr(str, ans, i + 1);
    }

    public static void main(String args[]) {
        String str = "abc";
        findSubstr(str, "", 0); // start with empty ans
    }
}
