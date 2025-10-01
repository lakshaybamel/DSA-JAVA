public class NQueens_all {

    // check if it's safe to place a queen at (row, col)
    public static boolean isSafe(char board[][], int row, int col) {
        // check vertical up
        for (int i = row - 1; i >= 0; i--) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }

        // check diagonal left up
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        // check diagonal right up
        for (int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        return true; // safe position
    }

    // recursive function to place queens row by row
    public static void nQueens(char board[][], int row) {
        // base case: all rows are filled → solution found
        if (row == board.length) {
            printBoard(board);
            return;
        }

        // try placing queen in each column of current row
        for (int j = 0; j < board.length; j++) {
            if (isSafe(board, row, j)) {
                board[row][j] = 'Q';   // place queen
                nQueens(board, row + 1); // recursive call for next row
                board[row][j] = 'x';   // backtracking → remove queen
            }
        }
    }

    // print the chess board
    public static void printBoard(char board[][]) {
        System.out.println("---------Chess Board----------");
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int n = 4;
        char board[][] = new char[n][n];

        // initialize board with 'x' (empty)
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = 'x';
            }
        }

        // start from row 0
        nQueens(board, 0);
    }
}
/*
Time Complexity: O(N!) 
Space Complexity: O(N^2) for board + O(N) recursion depth
*/
