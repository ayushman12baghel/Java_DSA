import java.util.*;

public class Predict_The_Winner {

    // Approach 1 Recursion O(2^n)
    public static boolean predictTheWinner(int nums[]) {
        return solve(nums, 0, nums.length - 1, true, 0, 0);
    }

    public static boolean solve(int nums[], int left, int right, boolean canTake, int sum1, int sum2) {
        if (left > right) {
            return sum1 >= sum2;
        }

        if (canTake) {
            boolean option1 = solve(nums, left + 1, right, false, sum1 + nums[left], sum2);
            boolean option2 = solve(nums, left, right - 1, false, sum1 + nums[right], sum2);

            return option1 || option2;
        } else {
            boolean option1 = solve(nums, left + 1, right, true, sum1, sum2 + nums[left]);
            boolean option2 = solve(nums, left, right - 1, true, sum1, sum2 + nums[right]);

            return option1 && option2;
        }
    }

    // Approach 3
    public static boolean predictTheWinner3(int[] nums) {
        int n = nums.length;
        Integer dp[][] = new Integer[n][n];
        return solve(nums, 0, n - 1, dp) >= 0;
    }

    public static int solve(int nums[], int left, int right, Integer dp[][]) {
        if (left == right) {
            return nums[left];
        }

        if (dp[left][right] != null) {
            return dp[left][right];
        }

        int takeLeft = nums[left] - solve(nums, left + 1, right, dp);
        int takeRight = nums[right] - solve(nums, left, right - 1, dp);

        return dp[left][right] = Math.max(takeLeft, takeRight);
    }

    public static void main(String args[]) {
        int nums[] = { 1, 5, 233, 7 };
        System.out.println(predictTheWinner(nums));
        System.out.println(predictTheWinner3(nums));
    }
}
