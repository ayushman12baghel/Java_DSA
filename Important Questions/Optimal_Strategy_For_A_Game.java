import java.util.*;

//O(n^2)
class Solution {
    public int maximumAmount(int arr[]) {
        // code here
        int dp[][] = new int[arr.length][arr.length];
        for (int row[] : dp) {
            Arrays.fill(row, -1);
        }

        return solve(arr, 0, arr.length - 1, dp);
    }

    public int solve(int nums[], int i, int j, int dp[][]) {
        if (i > j) {
            return 0;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int take1 = nums[i] + Math.min(solve(nums, i + 2, j, dp), solve(nums, i + 1, j - 1, dp));
        int take2 = nums[j] + Math.min(solve(nums, i + 1, j - 1, dp), solve(nums, i, j - 2, dp));

        return dp[i][j] = Math.max(take1, take2);
    }
}
