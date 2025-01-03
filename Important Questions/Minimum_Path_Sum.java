import java.util.*;

public class Minimum_Path_Sum {

    public static int minPathSum(int grid[][]) {
        int dp[][] = new int[grid.length][grid[0].length];

        for (int row[] : dp) {
            Arrays.fill(row, -1);
        }

        return solve(grid, 0, 0, dp);
    }

    public static int solve(int grid[][], int i, int j, int dp[][]) {
        if (i == grid.length - 1 && j == grid[0].length - 1) {
            return grid[i][j];
        }

        if (i >= grid.length || j >= grid[0].length) {
            return Integer.MAX_VALUE;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int right = solve(grid, i, j + 1, dp);
        int bottom = solve(grid, i + 1, j, dp);

        return dp[i][j] = grid[i][j] + Math.min(right, bottom);
    }

    public static int minPathSum2(int[][] grid) {
        int dp[][] = new int[grid.length][grid[0].length];
        dp[0][0] = grid[0][0];

        for (int i = 1; i < grid.length; i++) {
            dp[i][0] = grid[i][0] + dp[i - 1][0];
        }

        for (int j = 1; j < grid[0].length; j++) {
            dp[0][j] = grid[0][j] + dp[0][j - 1];
        }

        for (int i = 1; i < grid.length; i++) {
            for (int j = 1; j < grid[0].length; j++) {
                dp[i][j] = grid[i][j] + Math.min(dp[i - 1][j], dp[i][j - 1]);
            }
        }

        return dp[grid.length - 1][grid[0].length - 1];
    }

    public static void main(String args[]) {
        int grid[][] = { { 1, 3, 1 }, { 1, 5, 1 }, { 4, 2, 1 } };

        System.out.println(minPathSum(grid));
        System.out.println(minPathSum2(grid));
    }
}
