import java.util.*;

public class Maximum_Non_Negative_Product_in_Matrix {

    // Approach 1 Memoisation
    static int mod = 1000000007;

    public static int maxProductPath(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        long dp[][][] = new long[n][m][2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                dp[i][j][0] = Long.MIN_VALUE;
                dp[i][j][1] = Long.MAX_VALUE;
            }
        }
        long ans[] = solve(grid, 0, 0, dp);

        return (int) (ans[0] < 0 ? -1 : ans[0] % mod);
    }

    public static long[] solve(int grid[][], int i, int j, long dp[][][]) {
        int n = grid.length;
        int m = grid[0].length;
        if (i >= n || j >= m) {
            return new long[] { Long.MIN_VALUE, Long.MAX_VALUE };
        }

        if (i == grid.length - 1 && j == grid[0].length - 1) {
            return new long[] { grid[i][j], grid[i][j] };
        }

        if (dp[i][j][0] != Long.MIN_VALUE && dp[i][j][1] != Long.MAX_VALUE) {
            return new long[] { dp[i][j][0], dp[i][j][1] };
        }

        long minVal = Long.MAX_VALUE;
        long maxVal = Long.MIN_VALUE;

        if (i + 1 < n) {
            long downMax[] = solve(grid, i + 1, j, dp);
            maxVal = Math.max(maxVal, Math.max(downMax[0] * grid[i][j], downMax[1] * grid[i][j]));
            minVal = Math.min(minVal, Math.min(downMax[0] * grid[i][j], downMax[1] * grid[i][j]));
        }

        if (j + 1 < m) {
            long rightMax[] = solve(grid, i, j + 1, dp);
            maxVal = Math.max(maxVal, Math.max(rightMax[0] * grid[i][j], rightMax[1] * grid[i][j]));
            minVal = Math.min(minVal, Math.min(rightMax[0] * grid[i][j], rightMax[1] * grid[i][j]));
        }

        return dp[i][j] = new long[] { maxVal, minVal };
    }

    // Approach 2 Tabulation
    public static int maxProductPath2(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        long dp[][][] = new long[n][m][2];
        dp[0][0][0] = grid[0][0];
        dp[0][0][1] = grid[0][0];

        for (int i = 1; i < n; i++) {
            dp[i][0][0] = dp[i - 1][0][0] * grid[i][0];
            dp[i][0][1] = dp[i - 1][0][1] * grid[i][0];
        }
        for (int j = 1; j < m; j++) {
            dp[0][j][0] = dp[0][j - 1][0] * grid[0][j];
            dp[0][j][1] = dp[0][j - 1][1] * grid[0][j];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                long topMax = dp[i - 1][j][0];
                long topMin = dp[i - 1][j][1];
                long leftMax = dp[i][j - 1][0];
                long leftMin = dp[i][j - 1][1];

                dp[i][j][0] = Math.max(topMax * grid[i][j],
                        Math.max(topMin * grid[i][j],
                                Math.max(leftMax * grid[i][j], leftMin * grid[i][j])));

                dp[i][j][1] = Math.min(topMax * grid[i][j],
                        Math.min(topMin * grid[i][j],
                                Math.min(leftMax * grid[i][j], leftMin * grid[i][j])));

            }
        }

        return (int) (dp[n - 1][m - 1][0] < 0 ? -1 : dp[n - 1][m - 1][0] % mod);
    }

    public static void main(String args[]) {
        int grid[][] = { { 1, -2, 1 }, { 1, -2, 1 }, { 3, -4, 1 } };

        System.out.println(maxProductPath(grid));
        System.out.println(maxProductPath2(grid));
    }
}
