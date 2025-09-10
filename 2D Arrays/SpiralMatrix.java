public class SpiralMatrix {
    public static void printSpiral(int[][] matrix) {   
        int top = 0;                    // starting row
        int bottom = matrix.length - 1; // ending row
        int left = 0;                   // starting column
        int right = matrix[0].length - 1; // ending column

        while (top <= bottom && left <= right) {
            // 1️. Print top row (left → right)
            for (int j = left; j <= right; j++) {
                System.out.print(matrix[top][j] + " ");
            }
            top++;

            // 2️. Print right column (top → bottom)
            for (int i = top; i <= bottom; i++) {
                System.out.print(matrix[i][right] + " ");
            }
            right--;

            // 3️. Print bottom row (right → left), if rows remain
            if (top <= bottom) {
                for (int j = right; j >= left; j--) {
                    System.out.print(matrix[bottom][j] + " ");
                }
                bottom--;
            }

            // 4️. Print left column (bottom → top), if columns remain
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    System.out.print(matrix[i][left] + " ");
                }
                left++;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {
            {1,  2,  3,  4},
            {5,  6,  7,  8},
            {9, 10, 11, 12},
            {13,14, 15, 16}
        };

        printSpiral(matrix);
    }
}
