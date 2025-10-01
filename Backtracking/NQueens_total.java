public class NQueens_total {

    static int count = 0; // global counter

    // check if it's safe to place a queen at (row, col)
    public static boolean isSafe(char board[][], int row, int col) {
        // vertical up
        for (int i = row - 1; i >= 0; i--) {
            if (board[i][col] == 'Q') return false;
        }

        // diagonal left up
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') return false;
        }

        // diagonal right up
        for (int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++) {
            if (board[i][j] == 'Q') return false;
        }

        return true;
    }

    // recursive function to place queens row by row
    public static void nQueens(char board[][], int row) {
        // base case: all rows filled → one valid solution
        if (row == board.length) {
            count++; // increment counter
            return;
        }

        // try all columns in current row
        for (int j = 0; j < board.length; j++) {
            if (isSafe(board, row, j)) {
                board[row][j] = 'Q';   // place queen
                nQueens(board, row + 1); // recursive call
                board[row][j] = 'x';   // backtracking
            }
        }
    }

    public static void main(String[] args) {
        int n = 4;
        char board[][] = new char[n][n];

        // initialize board with 'x'
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = 'x';
            }
        }

        nQueens(board, 0);
        System.out.println("Total solutions for " + n + " Queens = " + count);
    }
}

/*
Time Complexity: O(N!) 
Space Complexity: O(N^2) for board + O(N) recursion depth
*/
