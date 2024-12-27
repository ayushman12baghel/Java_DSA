import java.util.*;

public class Unique_Paths_II {

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

    public static void main(String args[]) {
        int obstacleGrid[][] = { { 0, 0, 0 }, { 0, 1, 0 }, { 0, 0, 0 } };
        System.out.println(uniquePaths(obstacleGrid));
    }
}
