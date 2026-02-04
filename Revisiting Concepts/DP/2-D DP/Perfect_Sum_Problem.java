import java.util.*;

// Approach 1 Memoisation O(n*target)
class Solution {
    // Function to calculate the number of subsets with a given sum
    public int perfectSum(int[] nums, int target) {
        int n = nums.length;
        int dp[][] = new int[nums.length][target + 1];

        for (int row[] : dp) {
            Arrays.fill(row, -1);
        }

        return solve(nums, 0, target, dp);
    }

    public int solve(int nums[], int index, int target, int dp[][]) {
        if (target < 0) {
            return 0;
        }
        if (index >= nums.length) {
            return target == 0 ? 1 : 0;
        }

        if (dp[index][target] != -1) {
            return dp[index][target];
        }

        int skip = solve(nums, index + 1, target, dp);
        int take = solve(nums, index + 1, target - nums[index], dp);

        return dp[index][target] = skip + take;
    }
}

// Approach 2 Tabulation O(n*target)
class Solution {
    // Function to calculate the number of subsets with a given sum
    public int perfectSum(int[] nums, int target) {
        int n = nums.length;
        int dp[][] = new int[n + 1][target + 1];

        dp[0][0] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= target; j++) {
                int skip = dp[i - 1][j];
                int take = 0;
                if (nums[i - 1] <= j) {
                    take = dp[i - 1][j - nums[i - 1]];
                }

                dp[i][j] += take + skip;
            }
        }

        return dp[n][target];
    }
}

// Approach 3 Space Optimised O(n*target)
class Solution {
    // Function to calculate the number of subsets with a given sum
    public int perfectSum(int[] nums, int target) {
        int n = nums.length;
        int dp[] = new int[target + 1];

        dp[0] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = target; j >= nums[i - 1]; j--) {
                dp[j] += dp[j - nums[i - 1]];
            }
        }

        return dp[target];
    }
}