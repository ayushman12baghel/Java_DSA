import java.util.*;

public class N_Slimes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int nums[] = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        // long prefixSum[] = new long[n];
        // prefixSum[0] = nums[0];

        // for (int i = 1; i < n; i++) {
        // prefixSum[i] = prefixSum[i - 1] + nums[i];
        // }

        // long dp[][] = new long[n][n];
        // for (long row[] : dp) {
        // Arrays.fill(row, -1);
        // }

        // System.out.println(solve(nums, 0, n - 1, dp, prefixSum));
        System.out.println(tabulation(nums));
    }

    public static long solve(int nums[], int i, int j, long dp[][], long prefixSum[]) {
        if (i == j) {
            return 0;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        long minCost = Long.MAX_VALUE;

        for (int k = i; k < j; k++) {
            long cost = solve(nums, i, k, dp, prefixSum) + solve(nums, k + 1, j, dp, prefixSum) + prefixSum[j]
                    - (i > 0 ? prefixSum[i - 1] : 0);
            minCost = Math.min(minCost, cost);
        }

        return dp[i][j] = minCost;
    }

    public static long tabulation(int nums[]) {
        int n = nums.length;
        long prefixSum[] = new long[n];
        prefixSum[0] = nums[0];

        for (int i = 1; i < n; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i];
        }

        long dp[][] = new long[n][n];

        for (int L = 2; L <= n; L++) {
            for (int i = 0; i + L - 1 < n; i++) {
                int j = i + L - 1;
                dp[i][j] = Long.MAX_VALUE;

                for (int k = i; k < j; k++) {
                    long cost = dp[i][k] + dp[k + 1][j] + prefixSum[j] - (i > 0 ? prefixSum[i - 1] : 0);
                    dp[i][j] = Math.min(dp[i][j], cost);
                }
            }
        }

        return dp[0][n - 1];
    }
}