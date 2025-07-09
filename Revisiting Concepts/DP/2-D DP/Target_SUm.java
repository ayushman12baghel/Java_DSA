import java.util.*;

public class Target_SUm {

    // Aproach 1 Using Memoisation
    public static int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        int dp[][] = new int[n][totalSum * 2 + 1];
        for (int row[] : dp) {
            Arrays.fill(row, Integer.MIN_VALUE);
        }

        return solve(nums, 0, target, totalSum, 0, dp);
    }

    public static int solve(int nums[], int index, int target, int totalSum, int sum, int dp[][]) {
        if (index >= nums.length) {
            return sum == target ? 1 : 0;
        }

        if (dp[index][totalSum + sum] != Integer.MIN_VALUE) {
            return dp[index][totalSum + sum];
        }

        int add = solve(nums, index + 1, target, totalSum, sum + nums[index], dp);
        int substract = solve(nums, index + 1, target, totalSum, sum - nums[index], dp);

        return dp[index][totalSum + sum] = add + substract;
    }

    // Approach 2 By Tabulation
    public static int findTargetSumWays2(int[] nums, int target) {
        int totalSum = 0;
        for (int i = 0; i < nums.length; i++) {
            totalSum += nums[i];
        }

        int dp[][] = new int[nums.length][2 * totalSum + 1];
        dp[0][nums[0] + totalSum] = 1;
        dp[0][-nums[0] + totalSum] += 1;

        for (int i = 1; i < nums.length; i++) {
            for (int j = -totalSum; j <= totalSum; j++) {
                if (dp[i - 1][j + totalSum] > 0) {
                    dp[i][j + nums[i] + totalSum] += dp[i - 1][j + totalSum];
                    dp[i][j - nums[i] + totalSum] += dp[i - 1][j + totalSum];
                }
            }
        }

        return Math.abs(target) > totalSum ? 0 : dp[nums.length - 1][target + totalSum];
    }

    public static void main(String[] args) {
        int nums[] = { 1, 1, 1, 1, 1 };
        int target = 3;

        System.out.println(findTargetSumWays(nums, target));
    }
}
