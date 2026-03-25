import java.util.*;

// O(n^2)
class Solution {
    public boolean canPartitionGrid(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        long total = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                total += grid[i][j];
            }
        }

        if (total % 2 != 0) {
            return false;
        }

        long sumRow = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                sumRow += grid[i][j];
            }

            if (sumRow == total / 2) {
                return true;
            }
        }
        long sumCol = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                sumCol += grid[j][i];
            }

            if (sumCol == total / 2) {
                return true;
            }
        }

        return false;
    }
}