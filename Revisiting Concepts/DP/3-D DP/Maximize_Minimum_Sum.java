import java.util.*;

/*
    * Problem Statement
    * You are given two integer arrays A and B, both of length n. You need to
    * select exactly k indices (the same indices in both arrays). Your goal is to
    * maximize the smaller value between the total sum from A and the total sum
    * from B for the selected indices.
    * 
    * In other words, when you pick k positions, you calculate:
    * 
    * sumA = sum of selected elements from A
    * 
    * sumB = sum of selected elements from B
    * 
    * Then you take the smaller of these two sums. You need to make that smaller
    * value as large as possible.
    * 
    * Example
    * A = [6, 3, 6, 5, 1] B = [1, 4, 5, 9, 2] k = 3
    * 
    * If you pick indices (0, 2, 3): sumA = 6 + 6 + 5 = 17 sumB = 1 + 5 + 9 = 15
    * The smaller value is 15.
 */

// Approach Using Memoisation
public class MaximizeMinSum {

    public int maximizeMinSum(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        int maxValue = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            maxValue = Math.max(maxValue, nums1[i]);
            maxValue = Math.max(maxValue, nums2[i]);
        }
        int maxDiff = maxValue * n;
        int offset = maxDiff;

        int dp[][][] = new int[n + 1][k + 1][2 * maxDiff + 1];
        for (int plane[][] : dp) {
            for (int row[] : plane) {
                Arrays.fill(row, Integer.MIN_VALUE);
            }
        }

        int ans = Integer.MIN_VALUE;

        for (int diff = -maxDiff; diff <= maxDiff; diff++) {
            int sumB = solve(nums1, nums2, n, k, diff, dp, offset, maxDiff);

            if (sumB != Integer.MIN_VALUE) {
                int sumA = sumB + diff;
                ans = Math.max(ans, Math.min(sumA, sumB));
            }
        }

        return ans;
    }

    public int solve(int nums1[], int nums2[], int i, int k, int diff, int dp[][][], int offset, int maxDiff) {
        if (k == 0) {
            return diff == 0 ? 0 : Integer.MIN_VALUE;
        }

        if (i == 0) {
            return Integer.MIN_VALUE;
        }

        if (dp[i][k][diff + offset] != Integer.MIN_VALUE) {
            return dp[i][k][diff + offset];
        }

        int notTake = solve(nums1, nums2, i - 1, k, diff, dp, offset, maxDiff);

        int take = Integer.MIN_VALUE;
        int d_i = nums1[i - 1] - nums2[i - 1];
        int newDiff = diff - d_i;

        if (newDiff >= -maxDiff && newDiff <= maxDiff) {
            int prev = solve(nums1, nums2, i - 1, k - 1, newDiff, dp, offset, maxDiff);

            if (prev != Integer.MIN_VALUE) {
                take = prev + nums2[i - 1];
            }
        }

        dp[i][k][diff + offset] = Math.max(take, notTake);

        return dp[i][k][diff + offset];
    }

    public static void main(String[] args) {
        MaximizeMinSum solution = new MaximizeMinSum();

        int[] A = { 6, 3, 6, 5, 1 };
        int[] B = { 1, 4, 5, 9, 2 };
        int k = 3;

        int result = solution.maximizeMinSum(A, B, k);

        System.out.println("A = " + Arrays.toString(A));
        System.out.println("B = " + Arrays.toString(B));
        System.out.println("k = " + k);
        System.out.println("Maximized minimum sum: " + result);
    }
}