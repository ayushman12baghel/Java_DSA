import java.util.*;

public class N_Queens_I {

    public static List<String> construct(char board[][]) {
        List<String> list = new ArrayList<>();

        for (int i = 0; i < board.length; i++) {
            String str = new String(board[i]);
            list.add(str);
        }

        return list;
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

    public static void nQueens(List<List<String>> ans, char board[][], int row) {
        if (row == board.length) {
            ans.add(construct(board));
            return;
        }

        for (int i = 0; i < board.length; i++) {
            if (isSafe(board, row, i)) {
                board[row][i] = 'Q';
                nQueens(ans, board, row + 1);
                board[row][i] = '.';
            }
        }
    }

    public static List<List<String>> solveQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        char board[][] = new char[n][n];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                board[i][j] = '.';
            }
        }
        nQueens(ans, board, 0);
        return ans;
    }

    public static void main(String args[]) {
        int n = 4;
        List<List<String>> ans = solveQueens(n);

        for (List<String> str : ans) {
            for (String str2 : str) {
                System.out.print(str2 + " ");
            }
            System.out.println();
        }
    }
}
