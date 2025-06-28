import java.util.*;

public class Unique_Paths_II {

    // Approach 1 Using Memoisation O(n^2)
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int dp[][] = new int[obstacleGrid.length][obstacleGrid[0].length];
        for (int row[] : dp) {
            Arrays.fill(row, -1);
        }

        return solve(obstacleGrid, 0, 0, dp);
    }

    public static int solve(int grid[][], int i, int j, int dp[][]) {
        if (i >= grid.length || j >= grid[0].length) {
            return 0;
        }

        if (grid[i][j] == 1) {
            return 0;
        }

        if (i == grid.length - 1 && j == grid[0].length - 1) {
            return 1;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        return dp[i][j] = solve(grid, i + 1, j, dp) + solve(grid, i, j + 1, dp);
    }

    // Approach 2 Tabulation O(n^2)
    public static int uniquePathsWithObstacles2(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int dp[][] = new int[n][m];

        for (int i = 0; i < n; i++) {
            if (i > 0 && dp[i - 1][0] == 0) {
                dp[i][0] = 0;
            } else if (grid[i][0] == 1) {
                dp[i][0] = 0;
            } else {
                dp[i][0] = 1;
            }
        }

        for (int j = 0; j < m; j++) {
            if (j > 0 && dp[0][j - 1] == 0) {
                dp[0][j] = 0;
            } else if (grid[0][j] == 1) {
                dp[0][j] = 0;
            } else {
                dp[0][j] = 1;
            }
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (grid[i][j] == 1) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }

        return dp[n - 1][m - 1];
    }

    public static void main(String args[]) {
        int grid[][] = { { 0, 0, 0 }, { 0, 1, 0 }, { 0, 0, 0 } };

        System.out.println(uniquePathsWithObstacles(grid));
        System.out.println(uniquePathsWithObstacles2(grid));
    }
}
