import java.util.*;

//Approach 1 Using Memoisation O(n)
class Solution {
    public int maxProfit(int arr[]) {
        int dp[][] = new int[arr.length][2];
        for (int row[] : dp) {
            Arrays.fill(row, -1);
        }

        return solve(arr, 0, true, dp);
    }

    public int solve(int nums[], int index, boolean canTake, int dp[][]) {
        if (index >= nums.length) {
            return 0;
        }

        if (dp[index][canTake ? 1 : 0] != -1) {
            return dp[index][canTake ? 1 : 0];
        }

        if (canTake) {
            int take = solve(nums, index + 1, false, dp) - nums[index];
            int notTake = solve(nums, index + 1, canTake, dp);

            return dp[index][canTake ? 1 : 0] = Math.max(take, notTake);
        } else {
            int sell = solve(nums, index + 2, true, dp) + nums[index];
            int notSell = solve(nums, index + 1, false, dp);

            return dp[index][canTake ? 1 : 0] = Math.max(sell, notSell);
        }
    }
}

// Approach 2 Tabularion O(n)
class Solution {
    public int maxProfit(int arr[]) {
        int n = arr.length;
        int[][] dp = new int[n + 2][2];

        for (int i = n - 1; i >= 0; i--) {

            // When we can buy
            dp[i][1] = Math.max(-arr[i] + dp[i + 1][0], dp[i + 1][1]);

            // When we can sell
            dp[i][0] = Math.max(arr[i] + dp[i + 2][1], dp[i + 1][0]);
        }

        return dp[0][1];
    }
}
