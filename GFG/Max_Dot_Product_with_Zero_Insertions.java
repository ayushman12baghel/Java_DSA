import java.util.*;

// Approach 1 Using Memoisation O(n*m)
class Solution {
    public int maxDotProduct(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;

        int dp[][] = new int[n][m];
        for (int row[] : dp) {
            Arrays.fill(row, -1);
        }

        return solve(nums1, nums2, 0, 0, dp);
    }

    public int solve(int nums1[], int nums2[], int i, int j, int dp[][]) {
        if (i >= nums1.length || j >= nums2.length) {
            return j >= nums2.length ? 0 : Integer.MIN_VALUE / 2;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int take = solve(nums1, nums2, i + 1, j + 1, dp) + (nums1[i] * nums2[j]);
        int skip = solve(nums1, nums2, i + 1, j, dp);

        return dp[i][j] = Math.max(skip, take);
    }
}

// Approach 2 Tabulation O(n*m)
class Solution {
    public int maxDotProduct(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;

        int dp[][] = new int[n + 1][m + 1];

        for (int i = 0; i <= m; i++) {
            dp[n][i] = i == m ? 0 : Integer.MIN_VALUE / 2;
        }

        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                int take = dp[i + 1][j + 1] + (nums1[i] * nums2[j]);
                int skip = dp[i + 1][j];

                dp[i][j] = Math.max(take, skip);
            }
        }

        return dp[0][0];
    }
}

// More Space Optimised O(n*m)
class Solution {
    public int maxDotProduct(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;

        int curr[] = new int[m + 1];
        int next[] = new int[m + 1];

        for (int i = 0; i <= m; i++) {
            next[i] = i == m ? 0 : Integer.MIN_VALUE / 2;
        }

        for (int i = n - 1; i >= 0; i--) {
            curr[m] = 0;
            for (int j = m - 1; j >= 0; j--) {
                int take = next[j + 1] + (nums1[i] * nums2[j]);
                int skip = next[j];

                curr[j] = Math.max(take, skip);
            }

            int temp[] = next;
            next = curr;
            curr = temp;
        }

        return next[0];
    }
}