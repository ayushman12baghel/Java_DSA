import java.util.*;

// Approach 1 Memoisation O(n*m*k)
class Solution {
    int MOD = 1000000007;

    public int numberOfPaths(int[][] grid, int k) {
        int dp[][][] = new int[grid.length][grid[0].length][k];
        for (int plane[][] : dp) {
            for (int row[] : plane) {
                Arrays.fill(row, -1);
            }
        }

        return solve(grid, 0, 0, grid[0][0] % k, k, dp);
    }

    public int solve(int grid[][], int i, int j, int mod, int k, int dp[][][]) {
        int n = grid.length;
        int m = grid[0].length;

        if (i == n - 1 && j == m - 1) {
            return mod % k == 0 ? 1 : 0;
        }

        if (dp[i][j][mod] != -1) {
            return dp[i][j][mod];
        }

        int ways = 0;

        if (i + 1 < n) {
            ways = (ways + solve(grid, i + 1, j, (grid[i + 1][j] + mod) % k, k, dp)) % MOD;
        }

        if (j + 1 < m) {
            ways = (ways + solve(grid, i, j + 1, (grid[i][j + 1] + mod) % k, k, dp)) % MOD;
        }

        return dp[i][j][mod] = ways;
    }
}

// Approach 2 Tabulation
class Solution {
    public int numberOfPaths(int[][] grid, int k) {
        int MOD = 1000000007;
        int n = grid.length;
        int m = grid[0].length;

        int dp[][][] = new int[n][m][k];
        dp[n - 1][m - 1][grid[n - 1][m - 1] % k] = 1;

        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                for (int rem = 0; rem < k; rem++) {
                    if (i == n - 1 && j == m - 1) {
                        continue;
                    }

                    int current = grid[i][j];
                    int newRem = (rem + current) % k;

                    if (i + 1 < n) {
                        dp[i][j][newRem] = (dp[i][j][newRem] + dp[i + 1][j][rem]) % MOD;
                    }
                    if (j + 1 < m) {
                        dp[i][j][newRem] = (dp[i][j][newRem] + dp[i][j + 1][rem]) % MOD;
                    }
                }
            }
        }

        return dp[0][0][0];
    }
}