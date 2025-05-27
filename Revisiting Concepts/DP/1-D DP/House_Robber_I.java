import java.util.Arrays;

public class House_Robber_I {

    // Approach 1 Using Brute Force : O(2^n) -> T.L.E
    public static int rob(int[] nums) {
        return solve(nums, 0);
    }

    public static int solve(int nums[], int index) {
        if (index >= nums.length) {
            return 0;
        }

        return Math.max(nums[index] + solve(nums, index + 2), solve(nums, index + 1));
    }

    // Approach 2 By Memoisation
    public static int rob2(int[] nums) {
        int dp[] = new int[nums.length + 1];
        Arrays.fill(dp, -1);
        return solve(nums, 0, dp);
    }

    public static int solve(int nums[], int index, int dp[]) {
        if (index >= nums.length) {
            return 0;
        }

        if (dp[index] != -1) {
            return dp[index];
        }

        return dp[index] = Math.max(nums[index] + solve(nums, index + 2, dp), solve(nums, index + 1, dp));
    }

    // By Tabulation
    public static int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        int dp[] = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(dp[0], nums[1]);

        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], nums[i] + dp[i - 2]);
        }

        return dp[nums.length - 1];
    }

    public static void main(String args[]) {
        int nums[] = { 2, 7, 9, 3, 1 };

        System.out.println(rob(nums));
        System.out.println(rob2(nums));
    }
}
