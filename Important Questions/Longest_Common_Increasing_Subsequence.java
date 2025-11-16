import java.util.*;

//Approach Using Memoisation O(n*m*n) -> T.L.E
class Solution {
    public int LCIS(int[] nums1, int[] nums2) {
        int dp[][][] = new int[nums1.length][nums2.length][nums1.length + 1];
        for (int plane[][] : dp) {
            for (int row[] : plane) {
                Arrays.fill(row, -1);
            }
        }

        return solve(nums1, nums2, 0, 0, -1, dp);
    }

    public int solve(int nums1[], int nums2[], int i, int j, int prevIndex, int dp[][][]) {
        if (i >= nums1.length || j >= nums2.length) {
            return 0;
        }

        if (dp[i][j][prevIndex + 1] != -1) {
            return dp[i][j][prevIndex + 1];
        }

        int take = 0;
        if (nums1[i] == nums2[j] && (prevIndex == -1 || nums1[i] > nums1[prevIndex])) {
            take = 1 + solve(nums1, nums2, i + 1, j + 1, i, dp);
        }

        int notTake = Math.max(solve(nums1, nums2, i + 1, j, prevIndex, dp),
                solve(nums1, nums2, i, j + 1, prevIndex, dp));

        return dp[i][j][prevIndex + 1] = Math.max(take, notTake);
    }
}

// Approach 2 Tabulation O(n*m)
class Solution {
    public int LCIS(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;

        int result = 0;
        int dp[][] = new int[n][m];

        for (int i = 0; i < n; i++) {
            int currentLength = 0;
            for (int j = 0; j < m; j++) {
                if (i > 0) {
                    dp[i][j] = dp[i - 1][j];
                }

                if (nums1[i] == nums2[j]) {
                    dp[i][j] = Math.max(dp[i][j], currentLength + 1);
                    result = Math.max(result, dp[i][j]);
                } else if (nums1[i] > nums2[j]) {
                    currentLength = Math.max(currentLength, dp[i][j]);
                }
            }
        }

        return result;
    }
}

// Approach 3 O(n) SPace
class Solution {
    public int LCIS(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;

        int result = 0;
        int dp[] = new int[m];

        for (int i = 0; i < n; i++) {
            int currentLength = 0;
            for (int j = 0; j < m; j++) {
                if (nums1[i] == nums2[j]) {
                    dp[j] = Math.max(dp[j], currentLength + 1);
                    result = Math.max(result, dp[j]);
                } else if (nums1[i] > nums2[j]) {
                    currentLength = Math.max(currentLength, dp[j]);
                }
            }
        }

        return result;
    }
}