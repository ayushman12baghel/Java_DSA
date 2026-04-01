import java.util.*;

// Approach 1 Using Tabulation O(n)
class Solution {
    int countStrings(int n) {
        if (n == 1) {
            return 2;
        } else if (n == 2) {
            return 3;
        }

        int dp[] = new int[n + 1];
        dp[1] = 2;
        dp[2] = 3;

        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }
}

// Approach 2 Optimal O(n)
class Solution {
    int countStrings(int n) {
        if (n == 1) {
            return 2;
        } else if (n == 2) {
            return 3;
        }

        int prev1 = 2;
        int prev2 = 3;

        for (int i = 3; i <= n; i++) {
            int temp = prev2;
            prev2 = prev2 + prev1;
            prev1 = temp;
        }

        return prev2;
    }
}