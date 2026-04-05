import java.util.*;

// Approach 1 Using Memoisation O(n*totalSum)
class Solution {
    int totalSum = 0;

    public int totalWays(int[] nums, int target) {
        for (int num : nums) {
            totalSum += num;
        }

        int dp[][] = new int[nums.length][2 * totalSum + 1];
        for (int row[] : dp) {
            Arrays.fill(row, -1);
        }

        return solve(nums, 0, 0, target, dp);
    }

    public int solve(int nums[], int index, int currentSum, int target, int dp[][]) {
        if (index >= nums.length) {
            return currentSum - target == 0 ? 1 : 0;
        }

        if (dp[index][currentSum + totalSum] != -1) {
            return dp[index][currentSum + totalSum];
        }

        int add = solve(nums, index + 1, currentSum + nums[index], target, dp);
        int subtract = solve(nums, index + 1, currentSum - nums[index], target, dp);

        return dp[index][currentSum + totalSum] = add + subtract;
    }
}

// Approach 2 Tabulation O(n*targetSum)
class Solution {
    public int totalWays(int[] nums, int target) {
        int n = nums.length;
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        if (Math.abs(target) > totalSum) {
            return 0;
        }

        int dp[][] = new int[n + 1][2 * totalSum + 1];
        dp[n][target + totalSum] = 1;

        for (int i = n - 1; i >= 0; i--) {
            for (int currentSum = -totalSum; currentSum <= totalSum; currentSum++) {
                int add = 0;
                int subtract = 0;

                if (currentSum + nums[i] <= totalSum) {
                    add = dp[i + 1][nums[i] + currentSum + totalSum];
                }

                if (currentSum - nums[i] >= -totalSum) {
                    subtract = dp[i + 1][currentSum - nums[i] + totalSum];
                }

                dp[i][currentSum + totalSum] = add + subtract;
            }
        }

        return dp[0][totalSum];
    }
}