public class StringCompression {
    public static String compress(String str) {
        StringBuilder sb = new StringBuilder(); // efficient for string building

        for (int i = 0; i < str.length(); i++) {
            int count = 1;

            // Count consecutive duplicates
            while (i < str.length() - 1 && str.charAt(i) == str.charAt(i + 1)) {
                count++;
                i++;
            }

            sb.append(str.charAt(i));  // add character
            if (count > 1) {
                sb.append(count);      // add count only if > 1
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String str = "aaabbcccdd";
        System.out.println(compress(str)); // a3b2c3d2
    }
}
