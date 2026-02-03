import java.util.*;

// Approach Using Memoisation O(n*n)
class Solution {
    public int cutRod(int[] price) {
        int dp[][] = new int[price.length][price.length + 1];
        for (int row[] : dp) {
            Arrays.fill(row, -1);
        }

        return solve(price.length, price, 0, dp);
    }

    public int solve(int n, int price[], int index, int dp[][]) {
        if (n == 0) {
            return 0;
        }

        if (index >= price.length) {
            return 0;
        }

        if (dp[index][n] != -1) {
            return dp[index][n];
        }

        int skip = solve(n, price, index + 1, dp);

        int rodLength = index + 1;
        int take = 0;

        if (n >= rodLength) {
            take = solve(n - rodLength, price, index, dp) + price[index];
        }

        return dp[index][n] = Math.max(take, skip);
    }
}

// Approach 2 Tabulation O(n*n)
class Solution {
    public int cutRod(int[] price) {
        int n = price.length;
        int dp[][] = new int[price.length + 1][price.length + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                int skip = dp[i - 1][j];
                int rodLength = i;
                int take = 0;
                if (j >= rodLength) {
                    take = dp[i][j - rodLength] + price[i - 1];
                }

                dp[i][j] = Math.max(take, skip);
            }
        }

        return dp[n][n];
    }
}

// Approach 3 Space Optimised Tabulation
class Solution {
    public int cutRod(int[] price) {
        int n = price.length;

        int dp[] = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                int rodLength = i;
                if (j >= rodLength) {
                    dp[j] = Math.max(dp[j], dp[j - rodLength] + price[i - 1]);
                }
            }
        }

        return dp[n];
    }
}