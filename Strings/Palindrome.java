import java.util.*;

public class Palindrome {
    public static boolean checkPalindrome(String str) {
        int n = str.length();
        for (int i = 0; i < n/2; i++) {
            if (str.charAt(i) != str.charAt(n - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String []args) {
        String str = "madam";
        String str1 = "nitin";
        String str2 = "racecar";
        String str3 = "lakshay";
        System.out.println(checkPalindrome(str));
        System.out.println(checkPalindrome(str1));
        System.out.println(checkPalindrome(str2));
        System.out.println(checkPalindrome(str3));
    }
}