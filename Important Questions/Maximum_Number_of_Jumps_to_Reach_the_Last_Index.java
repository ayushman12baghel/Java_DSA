import java.util.*;

//Approach 1 Memoisation O(n^2)
class Solution {
    public int maximumJumps(int[] nums, int target) {
        int dp[] = new int[nums.length];
        Arrays.fill(dp, -1);
        int ans = solve(nums, target, 0, dp);

        return ans < 0 ? -1 : ans;
    }

    public int solve(int nums[], int target, int index, int dp[]) {
        if (index >= nums.length) {
            return Integer.MIN_VALUE / 2;
        }

        if (index == nums.length - 1) {
            return 0;
        }

        if (dp[index] != -1) {
            return dp[index];
        }

        int ans = Integer.MIN_VALUE / 2;
        for (int j = index + 1; j < nums.length; j++) {
            if (Math.abs(nums[index] - nums[j]) <= target) {
                ans = Math.max(ans, solve(nums, target, j, dp) + 1);
            }
        }

        return dp[index] = ans;
    }
}

// Approach 2 Tabulation O(n^2)
class Solution {
    public int maximumJumps(int[] nums, int target) {
        int n = nums.length;
        int dp[] = new int[n];
        Arrays.fill(dp, Integer.MIN_VALUE);
        dp[n - 1] = 0;

        for (int i = n - 2; i >= 0; i--) {
            int ans = Integer.MIN_VALUE;
            for (int j = i + 1; j < n; j++) {
                if (Math.abs(nums[i] - nums[j]) <= target) {
                    ans = Math.max(ans, dp[j] + 1);
                }
            }

            dp[i] = ans;
        }

        return dp[0] < 0 ? -1 : dp[0];
    }
}