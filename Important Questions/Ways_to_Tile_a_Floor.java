import java.util.*;

// Using Dynamic Programming Tabulation O(n) same as Fibonacci
class Solution {
    public int numberOfWays(int n) {
        if (n <= 3) {
            return n;
        }
        // code here
        int dp[] = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }
};