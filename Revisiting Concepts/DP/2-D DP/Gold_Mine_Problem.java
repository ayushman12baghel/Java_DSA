import java.util.*;

public class Gold_Mine_Problem {

    // Approach 1 Using Memoisation O(n*m)
    public static int maxGold(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int dp[][] = new int[n][m];
        for (int row[] : dp) {
            Arrays.fill(row, -1);
        }

        int ans = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, solve(grid, i, 0, dp));
        }

        return ans;
    }

    public static int solve(int grid[][], int i, int j, int dp[][]) {
        int n = grid.length;
        int m = grid[0].length;

        if (i < 0 || i >= n || j >= m) {
            return 0;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int right = solve(grid, i, j + 1, dp);
        int downDiag = solve(grid, i + 1, j + 1, dp);
        int upDiag = solve(grid, i - 1, j + 1, dp);

        dp[i][j] = grid[i][j] + Math.max(right, Math.max(downDiag, upDiag));

        return dp[i][j];
    }

    // Approach 2 Using Tabulation O(n*m)
    public static int maxGold2(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int dp[][] = new int[n][m];

        for (int i = 0; i < n; i++) {
            dp[i][m - 1] = grid[i][m - 1];
        }

        for (int j = m - 2; j >= 0; j--) {
            for (int i = 0; i < n; i++) {
                int right = dp[i][j + 1];
                int rightUp = (i - 1 >= 0 ? dp[i - 1][j + 1] : 0);
                int rightDown = (i + 1 < n ? dp[i + 1][j + 1] : 0);

                dp[i][j] = grid[i][j] + Math.max(right, Math.max(rightUp, rightDown));
            }
        }

        int ans = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, dp[i][0]);
        }

        return ans;
    }

    public static void main(String[] args) {
        int grid[][] = { { 1, 3, 3 }, { 2, 1, 4 }, { 0, 6, 4 } };

        System.out.println(maxGold(grid));
        System.out.println(maxGold2(grid));
    }
}
