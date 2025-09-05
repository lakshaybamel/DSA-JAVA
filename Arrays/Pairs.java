import java.util.*;

public class Pairs {

    public static void printPairs(int arr[]) {
        int count = 0;
        for(int i = 0; i < arr.length; i++) {
            int current_pos = arr[i]; //2, 4, 6, 8, 10
            for(int j = i + 1; j < arr.length; j++){
                System.out.print("(" + current_pos + "," + arr[j] + ")");
                count++;
            }
            System.out.println();
        }
        System.out.println("Total pairs = " + count);
    }

    public static void main(String []args) {
        int arr[] = {2, 4, 6, 8, 10};
        printPairs(arr);
    }
}