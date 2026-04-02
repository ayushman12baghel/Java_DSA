import java.util.*;

// Approach Using Memoisation O(n*m)
class Solution {
    public int maximumAmount(int[][] coins) {
        int n = coins.length;
        int m = coins[0].length;

        int dp[][][] = new int[n][m][3];
        for (int plane[][] : dp) {
            for (int row[] : plane) {
                Arrays.fill(row, Integer.MIN_VALUE);
            }
        }

        return solve(coins, 0, 0, 0, dp);
    }

    public int solve(int coins[][], int i, int j, int count, int dp[][][]) {
        int n = coins.length;
        int m = coins[0].length;

        if (i >= n || j >= m) {
            return Integer.MIN_VALUE;
        }

        if (dp[i][j][count] != Integer.MIN_VALUE) {
            return dp[i][j][count];
        }

        if (i == n - 1 && j == m - 1) {
            if (coins[i][j] < 0 && count < 2) {
                return dp[i][j][count] = 0;
            }

            return dp[i][j][count] = coins[i][j];
        }

        int right = solve(coins, i + 1, j, count, dp);
        int down = solve(coins, i, j + 1, count, dp);
        int result;

        if (coins[i][j] < 0) {
            int take = coins[i][j] + Math.max(right, down);

            int skip = Integer.MIN_VALUE;
            if (count < 2) {
                skip = Math.max(solve(coins, i + 1, j, count + 1, dp), solve(coins, i, j + 1, count + 1, dp));
            }

            result = Math.max(take, skip);
        } else {
            result = coins[i][j] + Math.max(right, down);
        }

        return dp[i][j][count] = result;
    }
}

// Approach 2 Tabulation O(n*m)
class Solution {
    public int maximumAmount(int[][] coins) {
        int n = coins.length;
        int m = coins[0].length;

        int dp[][][] = new int[n][m][3];
        if (coins[n - 1][m - 1] < 0) {
            dp[n - 1][m - 1][0] = 0;
            dp[n - 1][m - 1][1] = 0;
            dp[n - 1][m - 1][2] = coins[n - 1][m - 1];
        } else {
            dp[n - 1][m - 1][0] = coins[n - 1][m - 1];
            dp[n - 1][m - 1][1] = coins[n - 1][m - 1];
            dp[n - 1][m - 1][2] = coins[n - 1][m - 1];
        }

        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                if (i == n - 1 && j == m - 1) {
                    continue;
                }

                for (int count = 2; count >= 0; count--) {
                    int down = (i + 1 < n) ? dp[i + 1][j][count] : Integer.MIN_VALUE;
                    int right = (j + 1 < m) ? dp[i][j + 1][count] : Integer.MIN_VALUE;
                    int result;

                    if (coins[i][j] < 0) {
                        int take = coins[i][j] + Math.max(right, down);

                        int skip = Integer.MIN_VALUE;
                        if (count < 2) {
                            int downSkip = (i + 1 < n) ? dp[i + 1][j][count + 1] : Integer.MIN_VALUE;
                            int rightSkip = (j + 1 < m) ? dp[i][j + 1][count + 1] : Integer.MIN_VALUE;
                            skip = Math.max(downSkip, rightSkip);
                        }

                        result = Math.max(take, skip);
                    } else {
                        result = coins[i][j] + Math.max(right, down);
                    }

                    dp[i][j][count] = result;
                }
            }
        }

        return dp[0][0][0];
    }
}