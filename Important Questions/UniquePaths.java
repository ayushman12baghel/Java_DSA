public class UniquePaths {

    public static int uniquePaths(int m, int n) {
        int dp[][] = new int[m][n];
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        return dp[m - 1][n - 1];
    }

    public static int uniquePaths2(int m, int n) {
        int dp[][] = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = -1;
            }
        }
        return backtrack(0, 0, m, n, dp);
    }

    public static int backtrack(int row, int col, int m, int n, int dp[][]) {
        if (row >= m || col >= n) {
            return 0;
        }
        if (row == m - 1 && col == n - 1) {
            return 1;
        }

        if (dp[row][col] != -1) {
            return dp[row][col];
        } else {
            dp[row][col] = backtrack(row + 1, col, m, n, dp) + backtrack(row, col + 1, m, n, dp);
        }

        return dp[row][col];
    }

    public static void main(String[] args) {
        int m = 3;
        int n = 7;

        System.out.println(uniquePaths(m, n));
        System.out.println(uniquePaths2(m, n));
    }
}
