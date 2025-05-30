import java.util.*;

public class Maximum_Alternating_Subsequence_Sum {

    // Approach 1 Using Memoisation O(n)
    public static long maxAlternatingSum(int nums[]) {
        long dp[][] = new long[nums.length][2];

        for (long row[] : dp) {
            Arrays.fill(row, -1);
        }

        return solve(nums, 0, 0, dp);
    }

    public static long solve(int nums[], int index, int pivot, long dp[][]) {
        if (index >= nums.length) {
            return 0;
        }

        if (dp[index][pivot] != -1) {
            return dp[index][pivot];
        }

        long result;
        if (pivot == 0) {
            long take = nums[index] + solve(nums, index + 1, 1, dp);
            long notTake = solve(nums, index + 1, 0, dp);
            result = Math.max(take, notTake);
        } else {
            long take = solve(nums, index + 1, 0, dp) - nums[index];
            long notTake = solve(nums, index + 1, 1, dp);
            result = Math.max(take, notTake);
        }

        return dp[index][pivot] = result;
    }

    // Approach 2 Using Tabulation
    public static long maxAlternatingSum2(int nums[]) {
        int n = nums.length;
        long dp[][] = new long[n][2];
        dp[0][0] = nums[0];
        dp[0][1] = 0;

        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + nums[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - nums[i]);
        }

        return dp[n - 1][0];
    }

    public static void main(String args[]) {
        int nums[] = { 4, 2, 5, 3 };

        System.out.println(maxAlternatingSum(nums));
        System.out.println(maxAlternatingSum2(nums));
    }
}
