public class DiagonalSum {

    //Brute Force (O(n²))
    public static int sumBrute(int matrix[][]) {
        int total = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (i == j) { // primary diagonal
                    total += matrix[i][j];
                } else if (i + j == matrix.length - 1) { // secondary diagonal
                    total += matrix[i][j];
                }
            }
        }
        return total;
    }


    //Optimized (O(n))
    public static int sum(int matrix[][]) {
        int total = 0;
        int n = matrix.length;

        for (int i = 0; i < n; i++) {
            // Primary diagonal
            total += matrix[i][i];

            // Secondary diagonal (avoid double counting center when n is odd)
            if (i != n - 1 - i) {   
                total += matrix[i][n - 1 - i];
            }
        }
        return total;
    }

    public static void main(String[] args) {
        int[][] matrix = {
            {1,  2,  3,  4},
            {5,  6,  7,  8},
            {9, 10, 11, 12},
            {13,14, 15, 16}
        };

        System.out.println("Sum = " + sum(matrix));
    }
}