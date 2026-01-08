import java.util.*;

//Approach Using Recursion+Memoisation O(n*m)
class Solution {
    public int maxDotProduct(int[] nums1, int[] nums2) {
        long dp[][][] = new long[nums1.length][nums2.length][2];
        for (long plane[][] : dp) {
            for (long row[] : plane) {
                Arrays.fill(row, Long.MIN_VALUE);
            }
        }

        return (int) solve(nums1, nums2, 0, 0, 0, dp);
    }

    public long solve(int nums1[], int nums2[], int i, int j, int took, long dp[][][]) {
        if (i >= nums1.length || j >= nums2.length) {
            return took == 1 ? 0 : Long.MIN_VALUE;
        }

        if (dp[i][j][took] != Long.MIN_VALUE) {
            return dp[i][j][took];
        }

        long skip = Math.max(solve(nums1, nums2, i + 1, j + 1, took, dp),
                Math.max(solve(nums1, nums2, i + 1, j, took, dp), solve(nums1, nums2, i, j + 1, took, dp)));

        long take = (1L * nums1[i] * nums2[j]) + solve(nums1, nums2, i + 1, j + 1, 1, dp);

        return dp[i][j][took] = Math.max(take, skip);
    }
}

// Approach 2 Doing Tabulation O(n*m)
class Solution {
    public int maxDotProduct(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;

        long dp[][][] = new long[nums1.length + 1][nums2.length + 1][2];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                dp[i][j][0] = Long.MIN_VALUE / 2;
            }
        }

        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                for (int k = 0; k < 2; k++) {
                    long skip = Math.max(dp[i + 1][j][k], dp[i][j + 1][k]);
                    long take = (1L * nums1[i] * nums2[j]) + dp[i + 1][j + 1][1];

                    dp[i][j][k] = Math.max(take, skip);
                }
            }
        }

        return (int) dp[0][0][0];
    }
}