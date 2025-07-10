import java.util.*;

public class Matrix_Chain_Multiplication {

    // Approach 1 Doing Recursion + Memoisation O(n^2)
    static int matrixMultiplication(int arr[]) {
        int dp[][] = new int[arr.length][arr.length];
        for (int row[] : dp) {
            Arrays.fill(row, -1);
        }

        return mcm(arr, 1, arr.length - 1, dp);
    }

    static int mcm(int nums[], int i, int j, int dp[][]) {
        if (i >= j) {
            return 0;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int ans = Integer.MAX_VALUE;

        for (int k = i; k < j; k++) {
            int cost = mcm(nums, i, k, dp) + mcm(nums, k + 1, j, dp) + nums[i - 1] * nums[k] * nums[j];

            ans = Math.min(ans, cost);
        }

        return dp[i][j] = ans;
    }

    // Approach 2 Tabulation O(n^3)
    static int matrixMultiplication2(int nums[]) {
        int n = nums.length;
        int dp[][] = new int[n][n];

        for (int L = 2; L <= n; L++) {
            for (int i = 1; i + L - 1 < n; i++) {
                int j = i + L - 1;

                int ans = Integer.MAX_VALUE;
                for (int k = i; k < j; k++) {
                    int cost = dp[i][k] + dp[k + 1][j] + nums[i - 1] * nums[k] * nums[j];
                    ans = Math.min(ans, cost);
                }

                dp[i][j] = ans;
            }
        }

        return dp[1][n - 1];
    }

    public static void main(String[] args) {
        int nums[] = { 2, 1, 3, 4 };

        System.out.println(matrixMultiplication(nums));
        System.out.println(matrixMultiplication2(nums));
    }
}
