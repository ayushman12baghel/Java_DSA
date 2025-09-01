import java.util.*;

public class Sudoku_Solver {

    // Backtracking
    public static void solveSudoku(char[][] board) {
        solve(board);
    }

    public static boolean solve(char board[][]) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    for (int d = 0; d < 9; d++) {
                        char digit = (char) ('1' + d);
                        if (isValid(board, i, j, digit)) {
                            board[i][j] = digit;

                            if (solve(board)) {
                                return true;
                            }

                            board[i][j] = '.';
                        }
                    }

                    return false;
                }
            }
        }

        return true;
    }

    public static boolean isValid(char board[][], int row, int col, char digit) {
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == digit) {
                return false;
            }

            if (board[row][i] == digit) {
                return false;
            }
        }

        int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;

        for (int i = startRow; i <= startRow + 2; i++) {
            for (int j = startCol; j <= startCol + 2; j++) {
                if (board[i][j] == digit) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        char[][] board = {
                { '5', '3', '.', '.', '7', '.', '.', '.', '.' },
                { '6', '.', '.', '1', '9', '5', '.', '.', '.' },
                { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
                { '8', '.', '.', '.', '6', '.', '.', '.', '3' },
                { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
                { '7', '.', '.', '.', '2', '.', '.', '.', '6' },
                { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
                { '.', '.', '.', '4', '1', '9', '.', '.', '5' },
                { '.', '.', '.', '.', '8', '.', '.', '7', '9' }
        };

        solveSudoku(board);

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}
