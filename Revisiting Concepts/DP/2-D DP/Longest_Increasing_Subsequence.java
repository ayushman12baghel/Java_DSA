import java.util.*;

public class Longest_Increasing_Subsequence {

    // Approach 1 Using Recursion T.L.E
    public static int lengthOfLIS(int nums[]) {
        return solve(nums, 0, -1);
    }

    public static int solve(int nums[], int index, int prevIndex) {
        if (index >= nums.length) {
            return 0;
        }

        int take = 0;
        if (prevIndex == -1 || nums[index] > nums[prevIndex]) {
            take = solve(nums, index + 1, index) + 1;
        }

        int notTake = solve(nums, index + 1, prevIndex);

        return Math.max(take, notTake);
    }

    // Approach 2 Using Memoisation O(n^2)
    public static int lengthOfLIS2(int nums[]) {
        int n = nums.length;
        int dp[][] = new int[n][n + 1];

        for (int row[] : dp) {
            Arrays.fill(row, -1);
        }

        return solve(nums, 0, -1, dp);
    }

    public static int solve(int nums[], int index, int prevIndex, int dp[][]) {
        if (index >= nums.length) {
            return 0;
        }

        if (dp[index][prevIndex + 1] != -1) {
            return dp[index][prevIndex + 1];
        }

        int take = 0;
        if (prevIndex == -1 || nums[index] > nums[prevIndex]) {
            take = solve(nums, index + 1, index, dp) + 1;
        }

        int notTake = solve(nums, index + 1, prevIndex, dp);

        return dp[index][prevIndex + 1] = Math.max(take, notTake);
    }

    // Tabulation
    public static int lengthOfLIS3(int nums[]) {
        int n = nums.length;
        int dp[] = new int[n];

        Arrays.fill(dp, 1);
        int max = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    max = Math.max(dp[i], max);
                }
            }
        }

        return max;
    }

    public static void main(String args[]) {
        int nums[] = { 10, 9, 2, 5, 3, 7, 101, 18 };

        System.out.println(lengthOfLIS(nums));
        System.out.println(lengthOfLIS2(nums));

        System.out.println(lengthOfLIS3(nums));
    }
}
