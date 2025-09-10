import java.util.Scanner;

public class Matrix {
    public static void main (String []args){
        Scanner sc = new Scanner(System.in);

        int arr[][] = new int[3][3];

        for (int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr[0].length; j++) {
                System.out.print("Enter element at index["+i+"]["+j+"] : ");
                arr[i][j] = sc.nextInt();
            }
        }

        System.out.println("Matrix : ");
        for (int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}