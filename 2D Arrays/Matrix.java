import java.util.Scanner;

public class Matrix {
    public static int[] search (int arr[][], int target){
        for (int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] == target){
                    System.out.print("Element fount at index["+i+"]["+j+"]");
                    return new int[] {i, j};
                }
            }
        }
        return new int[] {};
    }

    public static void main (String []args){
        Scanner sc = new Scanner(System.in);

        int arr[][] = new int[3][3];
        int target = 5;

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

        search(arr, target);
    }
}