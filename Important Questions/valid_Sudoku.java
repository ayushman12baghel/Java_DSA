import java.util.*;

public class valid_Sudoku {
    public static boolean isValid(int matrix[][]) {
        int n = matrix.length;
        int m = matrix[0].length;

        // Validate Row
        for (int row = 0; row < n; row++) {
            Set<Integer> set = new HashSet<>();
            for (int col = 0; col < m; col++) {
                if (matrix[row][col] == 0) {
                    continue;
                }

                if (set.contains(matrix[row][col])) {
                    return false;
                }

                set.add(matrix[row][col]);
            }
        }

        // Validate Column
        for (int col = 0; col < m; col++) {
            Set<Integer> set = new HashSet<>();
            for (int row = 0; row < n; row++) {
                if (matrix[row][col] == 0) {
                    continue;
                }

                if (set.contains(matrix[row][col])) {
                    return false;
                }

                set.add(matrix[row][col]);
            }
        }

        // Validate 3x3 Matrix
        for (int row = 0; row < n; row += 3) {
            int endRow = row + 2;
            for (int col = 0; col < m; col += 3) {
                int endCol = col + 2;

                if (!validate(matrix, row, endRow, col, endCol)) {
                    return false;
                }
            }
        }

        return true;
    }

    public static boolean validate(int matrix[][], int startRow, int endRow, int startCol, int endCol) {
        Set<Integer> set = new HashSet<>();

        for (int i = startRow; i <= endRow; i++) {
            for (int j = startCol; j <= endCol; j++) {
                if (matrix[i][j] == 0) {
                    continue;
                }

                if (set.contains(matrix[i][j])) {
                    return false;
                }

                set.add(matrix[i][j]);
            }
        }

        return true;
    }

    // Approach 2 Direct
    public static boolean isValidSudoku(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        Set<String> set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == '.') {
                    continue;
                }

                String row = board[i][j] + "R" + i;
                String col = board[i][j] + "C" + j;
                String box = board[i][j] + "B" + (i / 3) + (j / 3);

                if (set.contains(row) || set.contains(col) || set.contains(box)) {
                    return false;
                }

                set.add(row);
                set.add(col);
                set.add(box);
            }
        }

        return true;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                { 3, 0, 6, 5, 0, 8, 4, 0, 0 },
                { 5, 2, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 8, 7, 0, 0, 0, 0, 3, 1 },
                { 0, 0, 3, 0, 1, 0, 0, 8, 0 },
                { 9, 0, 0, 8, 6, 3, 0, 0, 5 },
                { 0, 5, 0, 0, 9, 0, 6, 0, 0 },
                { 1, 3, 0, 0, 0, 0, 2, 5, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 7, 4 },
                { 0, 0, 5, 2, 0, 6, 3, 0, 0 }
        };

        System.out.println(isValid(matrix));
    }
}
