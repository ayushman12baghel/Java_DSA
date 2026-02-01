import java.util.*;

public class Minimum_Subset_Differences {

    // Approach 1 Using Memoisation
    public static int solve(int[] nums) {
        int n = nums.length;
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        int target = totalSum / 2;
        int[][] dp = new int[n][target + 1];
        for (int[] row : dp)
            Arrays.fill(row, -1);

        int sum = memoise(nums, 0, target, dp);
        return Math.abs(totalSum - 2 * sum);
    }

    public static int memoise(int[] nums, int index, int target, int[][] dp) {
        if (index >= nums.length)
            return 0;
        if (dp[index][target] != -1)
            return dp[index][target];

        int take = 0;
        if (nums[index] <= target) {
            take = nums[index] + memoise(nums, index + 1, target - nums[index], dp);
        }

        int notTake = memoise(nums, index + 1, target, dp);

        return dp[index][target] = Math.max(take, notTake);
    }

    public static void main(String[] args) {
        int nums[] = { 1, 6, 11, 5 };
        System.out.println(solve(nums));
    }
}
