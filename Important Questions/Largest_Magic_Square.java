import java.util.*;

// Approach 1 Normal O(n^5)
class Solution {
    public int largestMagicSquare(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        for (int size = Math.min(n, m); size >= 2; size--) {
            for (int i = 0; i <= n - size; i++) {
                for (int j = 0; j <= m - size; j++) {
                    if (solve(grid, i, j, size)) {
                        return size;
                    }
                }
            }
        }

        return 1;
    }

    public boolean solve(int grid[][], int row, int col, int size) {
        int finalSum = Integer.MIN_VALUE;
        // Checking row
        for (int i = row; i < row + size; i++) {
            int sum = 0;
            for (int j = col; j < col + size; j++) {
                sum += grid[i][j];
            }

            if (finalSum == Integer.MIN_VALUE) {
                finalSum = sum;
            }

            if (sum != finalSum) {
                return false;
            }
        }

        // Checking col
        for (int i = col; i < col + size; i++) {
            int sum = 0;
            for (int j = row; j < row + size; j++) {
                sum += grid[j][i];
            }

            if (sum != finalSum) {
                return false;
            }
        }

        // Checking leftToRightDiagonal
        int upperSum = 0;
        for (int i = row, j = col; i < row + size && j < col + size; i++, j++) {
            upperSum += grid[i][j];
        }

        if (upperSum != finalSum) {
            return false;
        }

        // Checking rightToLeftDiagonal
        int lowerSum = 0;
        for (int i = row + size - 1, j = col; i >= row && j < col + size; i--, j++) {
            lowerSum += grid[i][j];
        }

        if (lowerSum != finalSum) {
            return false;
        }

        return true;
    }
}

// Approach 2 Using Prefix Sum O(n^4)
class Solution {
    public int largestMagicSquare(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int rowPrefix[][] = new int[n + 1][m + 1];
        int colPrefix[][] = new int[n + 1][m + 1];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                rowPrefix[i][j + 1] = rowPrefix[i][j] + grid[i][j];
                colPrefix[i + 1][j] = colPrefix[i][j] + grid[i][j];
            }
        }

        for (int size = Math.min(n, m); size >= 2; size--) {
            for (int i = 0; i <= n - size; i++) {
                for (int j = 0; j <= m - size; j++) {
                    if (solve(grid, i, j, size, rowPrefix, colPrefix)) {
                        return size;
                    }
                }
            }
        }

        return 1;
    }

    public boolean solve(int grid[][], int row, int col, int size, int rowPrefix[][], int colPrefix[][]) {
        int finalSum = rowPrefix[row][col + size] - rowPrefix[row][col];

        // Checking row
        for (int i = row; i < row + size; i++) {
            int sum = rowPrefix[i][col + size] - rowPrefix[i][col];

            if (sum != finalSum) {
                return false;
            }
        }

        // Checking col
        for (int i = col; i < col + size; i++) {
            int sum = colPrefix[row + size][i] - colPrefix[row][i];

            if (sum != finalSum) {
                return false;
            }
        }

        // Checking leftToRightDiagonal
        int upperSum = 0;
        for (int i = row, j = col; i < row + size && j < col + size; i++, j++) {
            upperSum += grid[i][j];
        }

        if (upperSum != finalSum) {
            return false;
        }

        // Checking rightToLeftDiagonal
        int lowerSum = 0;
        for (int i = row + size - 1, j = col; i >= row && j < col + size; i--, j++) {
            lowerSum += grid[i][j];
        }

        if (lowerSum != finalSum) {
            return false;
        }

        return true;
    }
}