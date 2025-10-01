public class FindPermutations {

    public static void findPermu(String str, String ans) {
        // base case: when input string becomes empty
        if (str.length() == 0) {
            System.out.println(ans); // print one permutation
            return;
        }

        // recursive case: pick each character one by one
        for (int i = 0; i < str.length(); i++) {
            char curr = str.charAt(i); // choose current char

            // remove chosen char from str
            String newStr = str.substring(0, i) + str.substring(i + 1);

            // add chosen char to answer and recurse
            findPermu(newStr, ans + curr);
        }
    }

    public static void main(String args[]) {
        String str = "abc";
        findPermu(str, "");
    }
}
