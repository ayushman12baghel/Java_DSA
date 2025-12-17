import java.util.*;

//Approach Using Memoisation O(n*k)
class Solution {
    public long maximumProfit(int[] prices, int k) {
        long dp[][][][] = new long[prices.length][k + 1][2][2];
        for (long grid[][][] : dp) {
            for (long plane[][] : grid) {
                for (long row[] : plane) {
                    Arrays.fill(row, Long.MIN_VALUE);
                }
            }
        }

        return solve(prices, k, 0, 0, 0, dp);
    }

    public long solve(int prices[], int k, int index, int canTake, int isTransaction, long dp[][][][]) {
        if (index >= prices.length) {
            return isTransaction == 1 ? Long.MIN_VALUE / 2 : 0;
        }

        if (k == 0) {
            return 0;
        }

        if (dp[index][k][canTake][isTransaction] != Long.MIN_VALUE) {
            return dp[index][k][canTake][isTransaction];
        }

        long action = 0;
        long skip = solve(prices, k, index + 1, canTake, isTransaction, dp);

        if (isTransaction == 0) {
            long buyNormally = -prices[index] + solve(prices, k, index + 1, 0, 1, dp);
            long sellShort = prices[index] + solve(prices, k, index + 1, 1, 1, dp);

            action = Math.max(buyNormally, sellShort);
        } else {
            if (canTake == 1) {// We short selled the stock earlier so We need to buy here
                action = -prices[index] + solve(prices, k - 1, index + 1, 0, 0, dp);
            } else {// We bought the stock earlier so we have to sell here
                action = prices[index] + solve(prices, k - 1, index + 1, 0, 0, dp);
            }
        }

        return dp[index][k][canTake][isTransaction] = Math.max(skip, action);
    }
}

// Approach 2 Tabulation O(n*k)
class Solution {
    public long maximumProfit(int[] prices, int k) {
        int n = prices.length;
        long dp[][][][] = new long[n + 1][k + 1][2][2];

        for (int j = 0; j <= k; j++) {
            for (int c = 0; c <= 1; c++) {
                dp[n][j][c][1] = Long.MIN_VALUE / 2;
            }
        }

        for (int index = n - 1; index >= 0; index--) {
            for (int j = 1; j <= k; j++) {
                for (int c = 0; c <= 1; c++) {
                    for (int t = 0; t <= 1; t++) {
                        long action = 0;
                        long skip = dp[index + 1][j][c][t];

                        if (t == 0) {
                            long buyNormally = -prices[index] + dp[index + 1][j][0][1];
                            long sellShort = prices[index] + dp[index + 1][j][1][1];

                            action = Math.max(buyNormally, sellShort);
                        } else {
                            if (c == 1) {
                                action = -prices[index] + dp[index + 1][j - 1][0][0];
                            } else {
                                action = prices[index] + dp[index + 1][j - 1][0][0];
                            }
                        }

                        dp[index][j][c][t] = Math.max(skip, action);
                    }
                }
            }
        }

        // for(int i=0;i<=k;i++){
        // System.out.println(dp[0][i][0][0]+" ");
        // }

        return dp[0][k][0][0];
    }
}