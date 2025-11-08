import java.util.*;

// Approach Using Memoisation O(n*m*k)
class Solution {
    public int numberOfPath(int[][] mat, int k) {
        int dp[][][] = new int[mat.length][mat[0].length][k + 1];
        for (int plane[][] : dp) {
            for (int row[] : plane) {
                Arrays.fill(row, -1);
            }
        }

        return solve(mat, k, 0, 0, dp);
    }

    public int solve(int grid[][], int k, int i, int j, int dp[][][]) {
        int n = grid.length;
        int m = grid[0].length;

        if (i >= n || j >= m || k < 0) {
            return 0;
        }

        if (i == n - 1 && j == m - 1) {
            return (k - grid[i][j]) == 0 ? 1 : 0;
        }

        if (dp[i][j][k] != -1) {
            return dp[i][j][k];
        }

        int count = solve(grid, k - grid[i][j], i + 1, j, dp);
        count += solve(grid, k - grid[i][j], i, j + 1, dp);

        return dp[i][j][k] = count;
    }
}

// Approach 2 Tabulation O(n*m*k)
class Solution {
    public int numberOfPath(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;

        int dp[][][] = new int[n][m][k + 1];

        if (grid[0][0] <= k) {
            dp[0][0][grid[0][0]] = 1;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int sum = 0; sum <= k; sum++) {
                    if (i == 0 && j == 0) {
                        continue;
                    }

                    int currentVal = grid[i][j];

                    if (sum >= currentVal) {
                        int fromTop = 0;
                        int fromLeft = 0;

                        if (i > 0) {
                            fromTop = dp[i - 1][j][sum - currentVal];
                        }

                        if (j > 0) {
                            fromLeft = dp[i][j - 1][sum - currentVal];
                        }

                        dp[i][j][sum] = fromTop + fromLeft;
                    }
                }
            }
        }

        return dp[n - 1][m - 1][k];
    }
}