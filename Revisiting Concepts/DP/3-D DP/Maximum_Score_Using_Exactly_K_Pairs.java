import java.util.*;

//Approach 1 Memoisation O(n*n*k)
class Solution {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        long dp[][][] = new long[nums1.length][nums2.length][k + 1];
        for (long plane[][] : dp) {
            for (long row[] : plane) {
                Arrays.fill(row, Long.MIN_VALUE);
            }
        }

        return solve(nums1, nums2, 0, 0, k, dp);
    }

    public long solve(int nums1[], int nums2[], int i, int j, int k, long dp[][][]) {
        if (i >= nums1.length || j >= nums2.length || k <= 0) {
            return k == 0 ? 0 : Long.MIN_VALUE / 2;
        }

        if (dp[i][j][k] != Long.MIN_VALUE) {
            return dp[i][j][k];
        }

        long take = 1L * nums1[i] * nums2[j] + solve(nums1, nums2, i + 1, j + 1, k - 1, dp);
        long skip = Math.max(solve(nums1, nums2, i + 1, j, k, dp), solve(nums1, nums2, i, j + 1, k, dp));

        return dp[i][j][k] = Math.max(take, skip);
    }
}

// Approach 2 Tabulation O(n*n*k)
class Solution {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        int m = nums2.length;

        long dp[][][] = new long[n + 1][m + 1][k + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                for (int x = 1; x <= k; x++) {
                    dp[i][j][x] = Long.MIN_VALUE / 2;
                }
            }
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                for (int x = 1; x <= k; x++) {
                    long take = 1L * nums1[i - 1] * nums2[j - 1] + dp[i - 1][j - 1][x - 1];
                    long skip = Math.max(dp[i - 1][j][x], dp[i][j - 1][x]);

                    dp[i][j][x] = Math.max(take, skip);
                }
            }
        }

        return dp[n][m][k];
    }
}

// Space Optimised Tabulation
class Solution {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        int m = nums2.length;

        long NEG = Long.MIN_VALUE / 2;
        long curr[][] = new long[m + 1][k + 1];
        long prev[][] = new long[m + 1][k + 1];
        for (int i = 0; i <= m; i++) {
            for (int x = 1; x <= k; x++) {
                prev[i][x] = NEG;
            }
        }

        for (int i = 1; i < n + 1; i++) {

            for (int j = 0; j <= m; j++) {
                for (int x = 1; x <= k; x++) {
                    curr[j][x] = NEG;
                }
            }
            for (int j = 1; j < m + 1; j++) {
                for (int x = 1; x <= k; x++) {
                    long take = 1L * nums1[i - 1] * nums2[j - 1] + prev[j - 1][x - 1];
                    long skip = Math.max(prev[j][x], curr[j - 1][x]);

                    curr[j][x] = Math.max(take, skip);
                }
            }

            long temp[][] = prev;
            prev = curr;
            curr = temp;
        }

        return prev[m][k];
    }
}