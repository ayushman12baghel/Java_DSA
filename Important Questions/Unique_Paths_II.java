import java.util.*;

public class Unique_Paths_II {

    // Memoisation
    public static int uniquePaths(int obstacleGrid[][]) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int dp[][] = new int[m][n];

        for (int row[] : dp) {
            Arrays.fill(row, -1);
        }

        return backtrack(obstacleGrid, dp, 0, 0, m, n);
    }

    public static int backtrack(int grid[][], int dp[][], int row, int col, int m, int n) {
        if (row >= m || col >= n) {
            return 0;
        }
        if (row == m - 1 && col == n - 1) {
            return 1;
        }
        if (grid[row][col] == 1) {
            return 0;
        }
        if (dp[row][col] != -1) {
            return dp[row][col];
        } else {
            dp[row][col] = backtrack(grid, dp, row + 1, col, m, n) + backtrack(grid, dp, row, col + 1, m, n);
        }

        return dp[row][col];
    }

    // Tabulation
    public static int uniquePaths2(int obstacleGrid[][]) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int dp[][] = new int[m][n];

        for (int col = 0; col < n; col++) {
            if (col > 0 && obstacleGrid[0][col - 1] == 1) {
                obstacleGrid[0][col] = 1;
                dp[0][col] = 0;
            } else if (obstacleGrid[0][col] == 1) {
                dp[0][col] = 0;
            } else {
                dp[0][col] = 1;
            }
        }
        for (int row = 0; row < m; row++) {
            if (row > 0 && obstacleGrid[row - 1][0] == 1) {
                obstacleGrid[row][0] = 1;
                dp[row][0] = 0;
            } else if (obstacleGrid[row][0] == 1) {
                dp[row][0] = 0;
            } else {
                dp[row][0] = 1;
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }

        return dp[m - 1][n - 1];
    }

    public static void main(String args[]) {
        int obstacleGrid[][] = { { 0, 0, 0 }, { 0, 1, 0 }, { 0, 0, 0 } };
        System.out.println(uniquePaths(obstacleGrid));
        System.out.println(uniquePaths2(obstacleGrid));
    }
}
