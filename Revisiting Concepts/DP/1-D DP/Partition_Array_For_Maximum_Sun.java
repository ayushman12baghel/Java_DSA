import java.util.Arrays;

public class Partition_Array_For_Maximum_Sun {

    // Approach 1 Using Memoisation
    public static int maxSumAfterPartitioning(int[] nums, int k) {
        int n = nums.length;
        int dp[] = new int[n];
        Arrays.fill(dp, -1);

        return solve(nums, 0, k, dp);
    }

    public static int solve(int nums[], int i, int k, int dp[]) {
        if (i >= nums.length) {
            return 0;
        }

        if (dp[i] != -1) {
            return dp[i];
        }

        int result = 0;
        int currentMax = -1;

        for (int j = i; j < nums.length && j - i + 1 <= k; j++) {
            currentMax = Math.max(currentMax, nums[j]);

            result = Math.max(result, ((j - i + 1) * currentMax) + solve(nums, j + 1, k, dp));
        }

        return dp[i] = result;
    }

    public static void main(String[] args) {

    }
}
