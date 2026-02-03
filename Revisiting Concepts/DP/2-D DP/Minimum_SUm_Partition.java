import java.util.*;

// Approach Using Memoisation O(n*totalSum)
class Solution {

    public int minDifference(int nums[]) {
        int totalSum = 0;

        for (int num : nums) {
            totalSum += num;
        }

        int dp[][] = new int[nums.length][totalSum + 1];
        for (int row[] : dp) {
            Arrays.fill(row, -1);
        }

        return solve(nums, 0, 0, totalSum, dp);
    }

    public int solve(int nums[], int index, int currentSum, int totalSum, int dp[][]) {
        if (index >= nums.length) {
            int otherSum = totalSum - currentSum;
            return Math.abs(otherSum - currentSum);
        }

        if (dp[index][currentSum] != -1) {
            return dp[index][currentSum];
        }

        int take = solve(nums, index + 1, currentSum + nums[index], totalSum, dp);
        int notTake = solve(nums, index + 1, currentSum, totalSum, dp);

        return dp[index][currentSum] = Math.min(take, notTake);
    }
}

// Approach 2 Tabulation O(n*totalSum)
class Solution {
    public int minDifference(int nums[]) {
        int n = nums.length;
        int totalSum = 0;

        for (int num : nums) {
            totalSum += num;
        }

        boolean dp[][] = new boolean[n + 1][totalSum + 1];
        dp[0][0] = true;

        for (int i = 1; i <= n; i++) {
            for (int sum = 0; sum < totalSum + 1; sum++) {
                /// skip
                dp[i][sum] = dp[i - 1][sum];

                if (sum >= nums[i - 1]) {
                    dp[i][sum] = dp[i][sum] || dp[i - 1][sum - nums[i - 1]];
                }
            }
        }

        int minDiff = Integer.MAX_VALUE;

        for (int i = totalSum / 2; i >= 0; i--) {
            if (dp[n][i]) {
                int otherSum = totalSum - i;
                minDiff = (otherSum - i);
                break;
            }
        }

        return minDiff;
    }
}

// Approach 3 Space Optimised
class Solution {
    public int minDifference(int nums[]) {
        int n = nums.length;
        int totalSum = 0;

        for (int num : nums) {
            totalSum += num;
        }

        boolean dp[] = new boolean[totalSum + 1];
        dp[0] = true;

        for (int num : nums) {
            for (int sum = totalSum; sum >= num; sum--) {
                dp[sum] = dp[sum] || dp[sum - num];
            }
        }

        int minDiff = Integer.MAX_VALUE;

        for (int sum = totalSum / 2; sum >= 0; sum--) {
            if (dp[sum]) {
                int otherSum = totalSum - sum;
                minDiff = (otherSum - sum);
                break;
            }
        }

        return minDiff;
    }
}
