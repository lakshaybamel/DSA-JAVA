import java.util.Scanner;

public class StringBasics {
    public static void main(String[] args) {

        //Decleration
        char arr[] = {'a', 'b', 'c', 'd'};
        String str = "abcd";
        String str2 = new String("abcd");

        //Strings are IMMUTABLE

        //user input
        // Scanner sc = new Scanner(System.in);
        // String name = sc.nextLine();
        // System.out.println(name);

        //String length
        String city = "Gurugram";
        System.out.println(city.length());

        //concatenation
        String firstName = "Lakshay";
        String lastName = "Bamel";
        String fullName =  firstName + " " + lastName;
        System.out.println(fullName);

        //String charAt method
        String name = "Lakshay";
        System.out.println(name.charAt(0));

        //Access all String elements
        for (int i = 0; i < name.length(); i++) {
            System.out.print(name.charAt(i) + " ");
        }
        System.out.println();

        //compare two strings
        String s1 = "Tony";
        String s2 = "Tony";
        String s3 = new String("Tony");

        if (s1 == s2) {
            System.out.println("Strings are equal.");
        } else {
            System.out.println("Strings are not equal.");
        }

        if (s1 == s3) {
            System.out.println("Strings are equal.");
        } else {
            System.out.println("Strings are not equal.");
        }

        if (s1.equals(s3)) {
            System.out.println("Strings are equal.");
        } else {
            System.out.println("Strings are not equal.");
        }
    }
}