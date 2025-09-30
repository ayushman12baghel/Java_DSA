import java.util.*;

//Matrix Chain Multiplication Code O(n^3)
class Solution {
    public int minScoreTriangulation(int[] values) {
        int dp[][] = new int[values.length][values.length];
        for (int row[] : dp) {
            Arrays.fill(row, -1);
        }

        return solve(values, 0, values.length - 1, dp);
    }

    public int solve(int values[], int i, int j, int dp[][]) {
        if (j - i + 1 < 3) {
            return 0;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int result = Integer.MAX_VALUE;

        for (int k = i + 1; k < j; k++) {
            int weight = values[i] * values[k] * values[j] + solve(values, i, k, dp) + solve(values, k, j, dp);
            result = Math.min(result, weight);
        }

        return dp[i][j] = result;
    }
}

// Approach 2 O(n^3) Bottom Up O(n^2) space
class Solution {
    public int minScoreTriangulation(int[] values) {
        int n = values.length;

        int dp[][] = new int[n][n];

        for (int L = 3; L <= n; L++) {
            for (int i = 0; i + L - 1 < n; i++) {
                int j = i + L - 1;
                int result = Integer.MAX_VALUE;

                for (int k = i + 1; k < j; k++) {
                    int weight = values[i] * values[k] * values[j] + dp[i][k] + dp[k][j];
                    result = Math.min(result, weight);
                }

                dp[i][j] = result;
            }
        }

        return dp[0][n - 1];
    }
}