import java.util.*;

// Approach 1 Using Memoisation O(n*x*m)
class Solution {
    static int noOfWays(int m, int n, int x) {
        int dp[][] = new int[n][x + 1];
        for (int row[] : dp) {
            Arrays.fill(row, -1);
        }

        return solve(n, m, x, 0, 0, dp);
    }

    static int solve(int n, int m, int x, int i, int sum, int dp[][]) {
        if (i >= n) {
            return sum == x ? 1 : 0;
        }

        if (dp[i][sum] != -1) {
            return dp[i][sum];
        }

        int count = 0;

        for (int face = 1; face <= m; face++) {
            if (sum + face <= x) {
                count += solve(n, m, x, i + 1, sum + face, dp);
            }
        }

        return dp[i][sum] = count;
    }
};

// Approach 2 Tabulation O(n*m*x)
class Solution {
    static int noOfWays(int m, int n, int x) {
        int dp[][] = new int[n + 1][x + 1];
        dp[n][x] = 1;

        for (int i = n - 1; i >= 0; i--) {
            for (int face = 1; face <= m; face++) {
                for (int sum = 0; sum < x; sum++) {
                    if (sum + face > x) {
                        break;
                    }

                    dp[i][sum] += dp[i + 1][sum + face];
                }
            }
        }

        return dp[0][0];
    }
};

// Approach 3 More Optimised O(n*m*x)
class Solution {
    static int noOfWays(int m, int n, int x) {
        int dp[] = new int[x + 1];
        dp[x] = 1;

        for (int i = n - 1; i >= 0; i--) {
            for (int sum = 0; sum <= x; sum++) {
                int currentWays = 0;
                for (int face = 1; face <= m; face++) {
                    if (sum + face <= x) {
                        currentWays += dp[sum + face];
                    }
                }

                dp[sum] = currentWays;
            }
        }

        return dp[0];
    }
};