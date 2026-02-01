import java.util.*;

//Approach Using Memoisation O(n)
class Solution {
    public int minimumCost(int[] nums) {
        int dp[][] = new int[nums.length][3];
        for (int row[] : dp) {
            Arrays.fill(row, -1);
        }

        return nums[0] + solve(nums, 1, 1, dp);
    }

    public int solve(int nums[], int index, int count, int dp[][]) {
        if (index >= nums.length || count >= 3) {
            return count >= 3 ? 0 : Integer.MAX_VALUE / 4;
        }

        if (dp[index][count] != -1) {
            return dp[index][count];
        }

        int take = solve(nums, index + 1, count + 1, dp) + nums[index];
        int skip = solve(nums, index + 1, count, dp);

        return dp[index][count] = Math.min(take, skip);
    }
}

// Approach 2 Greedy O(n)
class Solution {
    public int minimumCost(int[] nums) {
        int ans = nums[0];
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;

        for (int i = 1; i < nums.length; i++) {
            if (min1 > nums[i]) {
                min2 = min1;
                min1 = nums[i];
            } else {
                min2 = Math.min(min2, nums[i]);
            }
        }

        return ans + min1 + min2;
    }
}