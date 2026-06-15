import java.util.*;

//Approach 1 DP Memoisation O(n*weight)
class Solution {
    public int minimumCost(int[] cost, int w) {
        int dp[][] = new int[cost.length][w + 1];
        for (int row[] : dp) {
            Arrays.fill(row, -1);
        }

        int ans = solve(cost, 0, w, dp);
        return ans == Integer.MAX_VALUE / 2 ? -1 : ans;
    }

    public int solve(int nums[], int index, int weight, int dp[][]) {
        if (index >= nums.length) {
            return weight == 0 ? 0 : Integer.MAX_VALUE / 2;
        }

        if (weight == 0) {
            return 0;
        }

        if (dp[index][weight] != -1) {
            return dp[index][weight];
        }

        int take = Integer.MAX_VALUE / 2;
        if (index + 1 <= weight && nums[index] != -1) {
            take = solve(nums, index, weight - index - 1, dp) + nums[index];
        }

        int skip = solve(nums, index + 1, weight, dp);

        return dp[index][weight] = Math.min(take, skip);
    }
}

// Approach 2 Tabulation O(n*w)
class Solution {
    public int minimumCost(int[] nums, int w) {
        int n = nums.length;

        int dp[][] = new int[n + 1][w + 1];
        for (int row[] : dp) {
            Arrays.fill(row, Integer.MAX_VALUE / 2);
        }

        for (int i = 0; i <= n; i++) {
            dp[i][0] = 0;
        }

        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j <= w; j++) {
                int take = Integer.MAX_VALUE / 2;

                if (i + 1 <= j && nums[i] != -1) {
                    take = dp[i][j - i - 1] + nums[i];
                }

                int skip = dp[i + 1][j];

                dp[i][j] = Math.min(take, skip);

            }

        }

        return dp[0][w] == Integer.MAX_VALUE / 2 ? -1 : dp[0][w];
    }
}

// Approach 3 O(n*w) + O(w) space
class Solution {
    public int minimumCost(int[] nums, int w) {
        int n = nums.length;

        int dp[] = new int[w + 1];
        Arrays.fill(dp, Integer.MAX_VALUE / 2);

        dp[0] = 0;

        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j <= w; j++) {
                int take = Integer.MAX_VALUE / 2;

                if (i + 1 <= j && nums[i] != -1) {
                    take = dp[j - i - 1] + nums[i];
                }

                int skip = dp[j];

                dp[j] = Math.min(take, skip);

            }

        }

        return dp[w] == Integer.MAX_VALUE / 2 ? -1 : dp[w];
    }
}