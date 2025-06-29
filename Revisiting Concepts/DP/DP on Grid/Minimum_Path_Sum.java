import java.util.Arrays;

import java.util.*;

public class Minimum_Path_Sum {

    // Approach 1 Memoisation
    public static int minPathSum2(int[][] grid) {
        int dp[][] = new int[grid.length][grid[0].length];
        for (int row[] : dp) {
            Arrays.fill(row, -1);
        }

        return solve(grid, 0, 0, dp);
    }

    public static int solve(int grid[][], int i, int j, int dp[][]) {
        if (i >= grid.length || j >= grid[0].length) {
            return Integer.MAX_VALUE;
        }

        if (i == grid.length - 1 && j == grid[0].length - 1) {
            return grid[i][j];
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int right = solve(grid, i, j + 1, dp);
        int down = solve(grid, i + 1, j, dp);

        return dp[i][j] = grid[i][j] + Math.min(right, down);
    }

    // Approach 2 Tabulation
    public static int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int dp[][] = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = grid[0][0];
                } else if (i == 0 && j > 0) {
                    dp[i][j] = dp[0][j - 1] + grid[0][j];
                } else if (j == 0 && i > 0) {
                    dp[i][j] = dp[i - 1][0] + grid[i][j];
                } else {
                    dp[i][j] = grid[i][j] + Math.min(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[n - 1][m - 1];
    }

    public static void main(String args[]) {
        int grid[][] = { { 1, 3, 1 }, { 1, 5, 1 }, { 4, 2, 1 } };
        System.out.println(minPathSum(grid));
        System.out.println(minPathSum2(grid));
    }
}
