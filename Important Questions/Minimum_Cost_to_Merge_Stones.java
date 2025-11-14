import java.util.*;

// Approach Using Memoisation O(n*n*k)
class Solution {
    public int mergeStones(int[] stones, int k) {
        int n = stones.length;

        if ((n - 1) % (k - 1) != 0) {
            return -1;
        }

        int prefixSum[] = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + stones[i];
        }

        int dp[][] = new int[n][n];
        for (int row[] : dp) {
            Arrays.fill(row, -1);
        }

        return solve(stones, 0, n - 1, k, prefixSum, dp);
    }

    public int solve(int stones[], int i, int j, int k, int prefixSum[], int dp[][]) {
        if (i >= j) {
            return 0;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        int minCost = Integer.MAX_VALUE;

        for (int index = i; index < j; index += k - 1) {
            int cost = solve(stones, i, index, k, prefixSum, dp) + solve(stones, index + 1, j, k, prefixSum, dp);
            minCost = Math.min(minCost, cost);
        }

        if ((j - i) % (k - 1) == 0) {
            minCost += prefixSum[j + 1] - prefixSum[i];
        }

        return dp[i][j] = minCost;
    }
}