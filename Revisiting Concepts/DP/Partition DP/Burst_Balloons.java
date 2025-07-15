import java.util.*;

public class Burst_Balloons {

    // Approach 1 Doing Memoisation O(n^3)
    public static int maxCoin(int nums[]) {
        int n = nums.length;
        int nums2[] = new int[n + 2];
        nums2[0] = 1;

        for (int i = 0; i < n; i++) {
            nums2[i + 1] = nums[i];
        }

        nums2[n + 1] = 1;

        int dp[][] = new int[n + 1][n + 1];
        for (int row[] : dp) {
            Arrays.fill(row, -1);
        }

        return solve(nums2, 1, n, dp);
    }

    public static int solve(int nums[], int i, int j, int dp[][]) {
        if (i > j) {
            return 0;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int max = Integer.MIN_VALUE;
        for (int k = i; k <= j; k++) {
            int cost = nums[i - 1] * nums[k] * nums[j + 1] + solve(nums, i, k - 1, dp) + solve(nums, k + 1, j, dp);
            max = Math.max(max, cost);
        }

        return dp[i][j] = max;
    }

    // Approach 2 Doing Tabulation O(n^3)
    public static int maxCoins2(int[] nums) {
        int n = nums.length;
        int nums2[] = new int[n + 2];
        nums2[0] = 1;
        nums2[n + 1] = 1;
        for (int i = 0; i < n; i++) {
            nums2[i + 1] = nums[i];
        }

        int dp[][] = new int[n + 2][n + 2];

        for (int L = 1; L <= n; L++) {
            for (int i = 1; i + L - 1 <= n; i++) {
                int j = i + L - 1;

                for (int k = i; k <= j; k++) {
                    int coins = nums2[i - 1] * nums2[k] * nums2[j + 1];
                    coins += dp[i][k - 1];
                    coins += dp[k + 1][j];

                    dp[i][j] = Math.max(dp[i][j], coins);
                }
            }
        }

        return dp[1][n];
    }

    public static void main(String[] args) {
        int nums[] = { 3, 1, 5, 8 };

        System.out.println(maxCoin(nums));
        System.out.println(maxCoins2(nums));
    }
}
