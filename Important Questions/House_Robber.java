import java.util.Arrays;

public class House_Robber {

    // Approach 1 Using Memoisation O(n)
    public static int rob(int[] nums) {
        int dp[] = new int[nums.length];
        Arrays.fill(dp, -1);
        return solve(nums, 0, dp);
    }

    public static int solve(int nums[], int i, int dp[]) {
        if (i >= nums.length) {
            return 0;
        }

        if (dp[i] != -1) {
            return dp[i];
        }

        int taken = nums[i] + solve(nums, i + 2, dp);
        int notTaken = solve(nums, i + 1, dp);

        return dp[i] = Math.max(taken, notTaken);
    }

    // Approach 2 Using Tabulation O(n)
    public static int rob2(int nums[]) {
        if (nums.length < 2) {
            return nums[0];
        }
        int dp[] = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(nums[i] + dp[i - 2], dp[i - 1]);
        }

        return dp[nums.length - 1];
    }

    public static void main(String args[]) {
        int nums[] = { 2, 1, 1, 2 };

        System.out.println(rob(nums));
        System.out.println(rob2(nums));
    }
}
