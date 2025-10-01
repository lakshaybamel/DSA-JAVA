public class NQueens_one {

    public static boolean isSafe(char board[][], int row, int col) {
        for (int i = row - 1; i >= 0; i--) {
            if (board[i][col] == 'Q') return false;
        }
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') return false;
        }
        for (int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++) {
            if (board[i][j] == 'Q') return false;
        }
        return true;
    }

    public static boolean nQueens(char board[][], int row) {
        if (row == board.length) {
            printBoard(board);
            return true; // found one solution
        }

        for (int j = 0; j < board.length; j++) {
            if (isSafe(board, row, j)) {
                board[row][j] = 'Q'; // place queen
                if (nQueens(board, row + 1)) {
                    return true;    // stop after first solution
                }
                board[row][j] = 'x'; // ✅ backtrack if not valid
            }
        }
        return false;
    }

    public static void printBoard(char board[][]) {
        System.out.println("Solution exist:");
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

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = 'x';
            }
        }

        if (!nQueens(board, 0)) {
            System.out.println("No solution exists for " + n + " Queens.");
        }
    }
}
