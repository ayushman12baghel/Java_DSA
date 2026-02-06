import java.util.*;

// Approach Using Tabulation O(n*m)
class Solution {
    public int minFallingPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int dp[][] = new int[n][m];
        for (int row[] : dp) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        for (int i = 0; i < m; i++) {
            dp[0][i] = grid[0][i];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int topLeft = (j > 0 ? dp[i - 1][j - 1] : Integer.MAX_VALUE);
                int topRight = (j + 1 < m ? dp[i - 1][j + 1] : Integer.MAX_VALUE);
                int top = dp[i - 1][j];

                dp[i][j] = grid[i][j] + Math.min(topLeft, Math.min(topRight, top));
            }
        }

        int minAns = Integer.MAX_VALUE;
        for (int j = 0; j < m; j++) {
            minAns = Math.min(minAns, dp[n - 1][j]);
        }

        return minAns;
    }
}