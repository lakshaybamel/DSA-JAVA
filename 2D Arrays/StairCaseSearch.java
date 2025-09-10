public class StairCaseSearch {
    public static void search(int matrix[][], int key) {
        int row = 0, col = matrix[0].length - 1; // start from top-right

        while (row < matrix.length && col >= 0) {
            if (matrix[row][col] == key) { // key found
                System.out.println("Element found at index[" + row + "][" + col + "]");
                return;
            } else if (key < matrix[row][col]) {
                col--; // move left
            } else {
                row++; // move down
            }
        }
        System.out.println("Key not found!");
    }

    public static void main(String[] args) {
        int[][] matrix = {
            {10, 20, 30, 40},
            {15, 25, 35, 45},
            {27, 29, 37, 48},
            {32, 33, 39, 50}
        };

        int key = 33;
        search(matrix, key);
    }
}
