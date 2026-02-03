import java.util.*;

// Approach 1 Using Memoisation O(n*W)
class Solution {
    public int knapsack(int W, int val[], int wt[]) {
        // code here
        int dp[][] = new int[val.length][W + 1];
        for (int row[] : dp) {
            Arrays.fill(row, -1);
        }

        return solve(val, wt, W, 0, dp);
    }

    public int solve(int value[], int weight[], int W, int index, int dp[][]) {
        if (index >= value.length) {
            return 0;
        }

        if (dp[index][W] != -1) {
            return dp[index][W];
        }

        int skip = solve(value, weight, W, index + 1, dp);
        int take = 0;

        if (weight[index] <= W) {
            take = solve(value, weight, W - weight[index], index + 1, dp) + value[index];
        }

        return dp[index][W] = Math.max(skip, take);
    }
}

// Approach 2 Tabulation O(n*W)
class Solution {
    public int knapsack(int W, int value[], int weight[]) {
        // code here
        int n = value.length;
        int dp[][] = new int[n + 1][W + 1];

        for (int i = 1; i <= n; i++) {
            for (int w = 0; w <= W; w++) {

                int skip = dp[i - 1][w];
                int take = 0;
                if (w >= weight[i - 1]) {
                    take = dp[i - 1][w - weight[i - 1]] + value[i - 1];
                }

                dp[i][w] = Math.max(take, skip);
            }
        }

        return dp[n][W];
    }
}

// Space Optimised
class Solution {
    public int knapsack(int W, int value[], int weight[]) {
        // code here
        int n = value.length;
        int dp[] = new int[W + 1];

        for (int i = 0; i < n; i++) {
            for (int w = W; w >= weight[i]; w--) {
                dp[w] = Math.max(dp[w], dp[w - weight[i]] + value[i]);
            }
        }

        return dp[W];
    }
}