import java.util.*;

//Approach Using Memoisation O(n^2)
class Solution {
    public int maxJumps(int[] nums, int d) {
        int ans = 0;
        int dp[] = new int[nums.length];
        Arrays.fill(dp, -1);

        for (int i = 0; i < nums.length; i++) {
            ans = Math.max(ans, solve(nums, i, d, dp));
        }

        return ans;
    }

    public int solve(int nums[], int index, int d, int dp[]) {
        if (index < 0 || index >= nums.length) {
            return 0;
        }

        if (dp[index] != -1) {
            return dp[index];
        }

        int ans = 1;

        for (int i = index + 1; i <= Math.min(nums.length - 1, index + d); i++) {
            if (nums[i] >= nums[index]) {
                break;
            }

            ans = Math.max(ans, 1 + solve(nums, i, d, dp));
        }

        for (int i = index - 1; i >= Math.max(0, index - d); i--) {
            if (nums[i] >= nums[index]) {
                break;
            }

            ans = Math.max(ans, 1 + solve(nums, i, d, dp));
        }

        return dp[index] = ans;
    }
}