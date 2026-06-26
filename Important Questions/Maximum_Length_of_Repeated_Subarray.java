import java.util.*;

//Approach 1 Memoisation O(n*m)
class Solution {
    int maxLength = 0;

    public int findLength(int[] nums1, int[] nums2) {
        int dp[][] = new int[nums1.length][nums2.length];
        for (int row[] : dp) {
            Arrays.fill(row, -1);
        }

        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                solve(nums1, nums2, i, j, dp);
            }
        }

        return maxLength;
    }

    public int solve(int nums1[], int nums2[], int i, int j, int dp[][]) {
        if (i >= nums1.length || j >= nums2.length) {
            return 0;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int ans = 0;

        if (nums1[i] == nums2[j]) {
            ans = 1 + solve(nums1, nums2, i + 1, j + 1, dp);
        }

        maxLength = Math.max(maxLength, ans);

        return dp[i][j] = ans;
    }
}

// Approach 2 Tabulation O(n*m)
class Solution {
    public int findLength(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;

        int maxLength = 0;
        int dp[][] = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    maxLength = Math.max(maxLength, dp[i][j]);
                }
            }
        }

        return maxLength;
    }
}