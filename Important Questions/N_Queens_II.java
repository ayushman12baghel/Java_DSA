public class N_Queens_II {
    static int count = 0;

    public static int totalNQueens(int n) {
        char board[][] = new char[n][n];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                board[i][j] = '.';
            }
        }
        nQueens(board, 0);
        return count;
    }

    public static boolean isSafe(char board[][], int row, int col) {
        // vertical
        for (int i = row - 1; i >= 0; i--) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }

        // diagonal left
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        for (int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        return true;
    }

    public static int nQueens(char board[][], int row) {
        if (row == board.length) {
            count++;
        }

        for (int i = 0; i < board.length; i++) {
            if (isSafe(board, row, i)) {
                board[row][i] = 'Q';
                nQueens(board, row + 1);
                board[row][i] = '.';
            }
        }
        return count;
    }

    public static void main(String args[]) {
        int n = 4;
        System.out.println(totalNQueens(n));
    }
}
