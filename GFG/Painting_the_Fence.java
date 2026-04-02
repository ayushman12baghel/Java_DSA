import java.util.*;

//Approach 1 Using Memoisation O(n)
class Solution {
    int countWays(int n, int k) {
        // code here.
        int dp[] = new int[n + 1];
        Arrays.fill(dp, -1);

        return solve(n, k, dp);
    }

    public int solve(int n, int k, int dp[]) {
        if (n == 1) {
            return k;
        } else if (n == 2) {
            return k * k;
        }

        if (dp[n] != -1) {
            return dp[n];
        }

        int count1 = solve(n - 1, k, dp) * (k - 1);
        int count2 = solve(n - 2, k, dp) * (k - 1);

        return dp[n] = count1 + count2;
    }
}

// Approach 2 Using Tabulation O(n)
class Solution {
    int countWays(int n, int k) {
        if (n == 1) {
            return k;
        } else if (n == 2) {
            return k * k;
        }

        int dp[] = new int[n + 1];
        dp[1] = k;
        dp[2] = k * k;

        for (int i = 3; i <= n; i++) {
            int count1 = dp[i - 1] * (k - 1);
            int count2 = dp[i - 2] * (k - 1);
            dp[i] = count1 + count2;
        }

        return dp[n];
    }

}

// Approach 3 Optimal Without Space O(n)
class Solution {
    int countWays(int n, int k) {
        if (n == 1) {
            return k;
        } else if (n == 2) {
            return k * k;
        }

        int prev1 = k;
        int prev2 = k * k;

        for (int i = 3; i <= n; i++) {
            int count1 = prev1 * (k - 1);
            int count2 = prev2 * (k - 1);

            prev1 = prev2;
            prev2 = count1 + count2;
        }

        return prev2;
    }

}
