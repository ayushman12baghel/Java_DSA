import java.util.*;

public class Maximum_Non_Negative_Product_in_Array {

    public static int maxProductPath(int grid[][]) {
        int mod = 1000000007;
        long dp[][][] = new long[grid.length][grid[0].length][2];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                dp[i][j][0] = Long.MIN_VALUE;
                dp[i][j][1] = Long.MAX_VALUE;
            }
        }

        long ans[] = solve(grid, 0, 0, dp);

        return (ans[0] >= 0 ? (int) (ans[0] % mod) : -1);
    }

    public static long[] solve(int grid[][], int i, int j, long dp[][][]) {
        if (i >= grid.length || j >= grid[0].length) {
            return new long[] { Long.MIN_VALUE, Long.MAX_VALUE };
        }

        if (i == grid.length - 1 && j == grid[0].length - 1) {
            return new long[] { grid[i][j], grid[i][j] };
        }

        if (dp[i][j][0] != Long.MIN_VALUE && dp[i][j][1] != Long.MAX_VALUE) {
            return dp[i][j];
        }

        long maxVal = Long.MIN_VALUE;
        long minVal = Long.MAX_VALUE;

        if (i + 1 < grid.length) {
            long current[] = solve(grid, i + 1, j, dp);
            maxVal = Math.max(maxVal, Math.max(current[0] * grid[i][j], current[1] * grid[i][j]));
            minVal = Math.min(minVal, Math.min(current[0] * grid[i][j], current[1] * grid[i][j]));
        }

        if (j + 1 < grid[0].length) {
            long current[] = solve(grid, i, j + 1, dp);
            maxVal = Math.max(maxVal, Math.max(current[0] * grid[i][j], current[1] * grid[i][j]));
            minVal = Math.min(minVal, Math.min(current[0] * grid[i][j], current[1] * grid[i][j]));
        }

        dp[i][j][0] = maxVal;
        dp[i][j][1] = minVal;

        return dp[i][j];
    }

    public static int maxProductPath2(int[][] grid) {
        int mod = 1000000007;
        long dp[][][] = new long[grid.length][grid[0].length][2];
        dp[0][0] = new long[] { grid[0][0], grid[0][0] };

        for (int i = 1; i < grid.length; i++) {
            dp[i][0][0] = grid[i][0] * dp[i - 1][0][0];
            dp[i][0][1] = grid[i][0] * dp[i - 1][0][1];
        }

        for (int i = 1; i < grid[0].length; i++) {
            dp[0][i][0] = grid[0][i] * dp[0][i - 1][0];
            dp[0][i][1] = grid[0][i] * dp[0][i - 1][1];
        }

        for (int i = 1; i < grid.length; i++) {
            for (int j = 1; j < grid[0].length; j++) {
                long leftMax = dp[i][j - 1][0];
                long leftMin = dp[i][j - 1][1];
                long topMax = dp[i - 1][j][0];
                long topMin = dp[i - 1][j][1];

                dp[i][j][0] = Math.max(leftMax * grid[i][j],
                        Math.max(leftMin * grid[i][j],
                                Math.max(topMax * grid[i][j],
                                        topMin * grid[i][j])));
                dp[i][j][1] = Math.min(leftMax * grid[i][j],
                        Math.min(leftMin * grid[i][j],
                                Math.min(topMax * grid[i][j],
                                        topMin * grid[i][j])));
            }
        }

        long maxVal = dp[grid.length - 1][grid[0].length - 1][0];

        return (maxVal >= 0 ? (int) (maxVal % mod) : -1);

    }

    public static void main(String args[]) {
        int grid[][] = { { 1, -2, 1 }, { 1, -2, 1 }, { 3, -4, 1 } };

        System.out.println(maxProductPath(grid));
        System.out.println(maxProductPath2(grid));
    }
}
