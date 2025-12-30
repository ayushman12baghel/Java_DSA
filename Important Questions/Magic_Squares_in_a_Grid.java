import java.util.*;

// Approach Checking All Properties of it O(N.M)
class Solution {
    public int numMagicSquaresInside(int[][] grid) {
        int count = 0;

        for (int i = 0; i <= grid.length - 3; i++) {
            for (int j = 0; j <= grid[0].length - 3; j++) {
                count += (solve(grid, i, j) ? 1 : 0);
            }
        }

        return count;
    }

    public boolean solve(int grid[][], int row, int col) {
        if (grid[row + 1][col + 1] != 5) {
            return false;
        }
        Set<Integer> set = new HashSet<>();

        // Checking Uniqueness
        for (int i = row; i < row + 3; i++) {
            for (int j = col; j < col + 3; j++) {
                if (grid[i][j] <= 0 || grid[i][j] > 9 || set.contains(grid[i][j])) {
                    return false;
                }

                set.add(grid[i][j]);
            }
        }

        // checking col
        for (int j = col; j < col + 3; j++) {
            int colSum = 0;

            for (int i = row; i < row + 3; i++) {
                colSum += grid[i][j];
            }

            if (colSum != 15) {
                return false;
            }
        }

        // checking row
        for (int i = row; i < row + 3; i++) {
            int rowSum = 0;

            for (int j = col; j < col + 3; j++) {
                rowSum += grid[i][j];
            }

            if (rowSum != 15) {
                return false;
            }
        }

        // Checking Diagonal
        int upperSum = 0;
        for (int i = row, j = col; i < row + 3 && j < col + 3; i++, j++) {
            upperSum += grid[i][j];
        }

        if (upperSum != 15) {
            return false;
        }

        int lowerSum = 0;
        for (int i = row + 2, j = col; i >= row && j < col + 3; i--, j++) {
            lowerSum += grid[i][j];
        }

        if (lowerSum != 15) {
            return false;
        }

        return true;
    }
}