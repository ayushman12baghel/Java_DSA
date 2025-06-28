import java.util.*;

public class Unique_Paths {

    // Approach 1 Using Memoisation O(n^2)
    public static int uniquePaths(int m, int n) {
        int dp[][] = new int[m][n];
        for (int row[] : dp) {
            Arrays.fill(row, -1);
        }

        return solve(m, n, 0, 0, dp);
    }

    public static int solve(int n, int m, int i, int j, int dp[][]) {
        if (i >= n || j >= m) {
            return 0;
        }

        if (i == n - 1 && j == m - 1) {
            return 1;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        return dp[i][j] = solve(n, m, i + 1, j, dp) + solve(n, m, i, j + 1, dp);
    }

    // Approach 2 Using Tabulation O(n^2)
    public static int uniquePaths2(int n, int m) {
        int dp[][] = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }

        return dp[n - 1][m - 1];
    }

    public static void main(String args[]) {
        int m = 3, n = 7;

        System.out.println(uniquePaths(m, n));
        System.out.println(uniquePaths2(n, m));
    }
}
