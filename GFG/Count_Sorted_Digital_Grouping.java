import java.util.*;

// Approach 1 Using Memoisation O(n^3)  and O(n^2) Space
class Solution {
    public int validGroups(String s) {
        int dp[][] = new int[s.length()][s.length() * 10 + 1];
        for (int row[] : dp) {
            Arrays.fill(row, -1);
        }

        return solve(s, 0, 0, dp);
    }

    public int solve(String s, int index, int prevSum, int dp[][]) {
        if (index >= s.length()) {
            return 1;
        }

        if (dp[index][prevSum] != -1) {
            return dp[index][prevSum];
        }

        int currentSum = 0;
        int ans = 0;

        for (int j = index; j < s.length(); j++) {
            currentSum += s.charAt(j) - '0';

            if (currentSum >= prevSum) {
                ans += solve(s, j + 1, currentSum, dp);
            }
        }

        return dp[index][prevSum] = ans;
    }
}

// Approach 2 Tabulation
class Solution {
    public int validGroups(String s) {
        int n = s.length();
        int maxSum = n * 9;
        int dp[][] = new int[n + 1][maxSum + 1];
        for (int i = 0; i <= maxSum; i++) {
            dp[n][i] = 1;
        }

        for (int i = n - 1; i >= 0; i--) {
            for (int prevSum = 0; prevSum <= maxSum; prevSum++) {
                int currentSum = 0;
                int ans = 0;

                for (int j = i; j < s.length(); j++) {
                    currentSum += s.charAt(j) - '0';

                    if (currentSum >= prevSum) {
                        ans += dp[j + 1][currentSum];
                    }
                }

                dp[i][prevSum] = ans;
            }
        }

        return dp[0][0];
    }
}