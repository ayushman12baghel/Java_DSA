import java.util.*;

// Approach 1 Using Memoisation O(n*target)
class Solution {
    public int coinChange(int[] coins, int amount) {
        int dp[][] = new int[coins.length][amount + 1];
        for (int row[] : dp) {
            Arrays.fill(row, -1);
        }

        int result = solve(coins, 0, amount, dp);

        return result == Integer.MAX_VALUE / 2 ? -1 : result;
    }

    public int solve(int nums[], int index, int target, int dp[][]) {
        if (index >= nums.length) {
            return target == 0 ? 0 : Integer.MAX_VALUE / 2;
        }

        if (dp[index][target] != -1) {
            return dp[index][target];
        }

        int skip = solve(nums, index + 1, target, dp);
        int take = Integer.MAX_VALUE / 2;
        if (target >= nums[index]) {
            take = solve(nums, index, target - nums[index], dp) + 1;
        }

        return dp[index][target] = Math.min(take, skip);
    }
}

// Approach 2 Tabulation O(n*amount)
class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;

        int dp[][] = new int[n + 1][amount + 1];
        for (int row[] : dp) {
            Arrays.fill(row, Integer.MAX_VALUE / 2);
        }
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 0;
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 0; j <= amount; j++) {
                int skip = dp[i - 1][j];
                int take = Integer.MAX_VALUE / 2;
                if (coins[i - 1] <= j) {
                    take = 1 + dp[i][j - coins[i - 1]];
                }

                dp[i][j] = Math.min(take, skip);
            }
        }

        return dp[n][amount] == Integer.MAX_VALUE / 2 ? -1 : dp[n][amount];
    }
}

// Approach 3 Space Optimised O(n*amount)
class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;

        int dp[] = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE / 2);
        dp[0] = 0;

        for (int i = 1; i < n + 1; i++) {
            for (int j = coins[i - 1]; j <= amount; j++) {
                dp[j] = Math.min(dp[j], 1 + dp[j - coins[i - 1]]);
            }
        }

        return dp[amount] == Integer.MAX_VALUE / 2 ? -1 : dp[amount];
    }
}