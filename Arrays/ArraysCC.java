import java.util.*;

public class ArraysCC {
    public static void main(String[] args) {

        int marks[] = new int[50];

        System.out.println("Length of array = " + marks.length);

        Scanner sc = new Scanner(System.in);

        marks[0] = sc.nextInt();
        marks[1] = sc.nextInt();
        marks[2] = sc.nextInt();

        System.out.println("Phy : " + marks[0]);
        System.out.println("Chem : " + marks[1]);
        System.out.println("Math : " + marks[2]);

        marks[2] += 10;
        System.out.println("Math updated : " + marks[2]);

        int percentage = (marks[0] + marks[1] + marks[2]) / 3;
        System.out.println("percentage = " + percentage + "%");
    }
}
