import java.util.*;

public class HouseRobber_II {

    // Approach 1-> Using Memoisation
    public static int rob(int nums[]) {
        if (nums.length == 1) {
            return nums[0];
        }

        int dp1[] = new int[nums.length];
        int dp2[] = new int[nums.length];
        Arrays.fill(dp1, -1);
        Arrays.fill(dp2, -1);

        return Math.max(solve(nums, 0, nums.length - 1, dp1), solve(nums, 1, nums.length, dp2));
    }

    public static int solve(int nums[], int index, int lastIndex, int dp[]) {
        if (index >= lastIndex) {
            return 0;
        }

        if (dp[index] != -1) {
            return dp[index];
        }

        return dp[index] = Math.max(solve(nums, index + 1, lastIndex, dp),
                nums[index] + solve(nums, index + 2, lastIndex, dp));
    }

    // Approach 2 Using Tabulation
    public static int rob2(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2)
            return Math.max(nums[0], nums[1]);

        return Math.max(solve(nums, 0, nums.length - 1), solve(nums, 1, nums.length));
    }

    public static int solve(int nums[], int start, int end) {
        int dp[] = new int[nums.length];
        dp[start] = nums[start];
        dp[start + 1] = Math.max(dp[start], nums[start + 1]);

        for (int i = start + 2; i < end; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }

        return dp[end - 1];
    }

    public static void main(String args[]) {
        int nums[] = { 1, 2, 3, 1 };

        System.out.println(rob(nums));
        System.out.println(rob2(nums));
    }
}
