import java.util.*;

//Approach 1 Using Memoisation O(n*m)
class Solution {
    public boolean isMatch(String s, String p) {
        int dp[][] = new int[s.length() + 1][p.length() + 1];
        for (int row[] : dp) {
            Arrays.fill(row, -1);
        }

        return solve(s, p, 0, 0, dp);
    }

    public boolean solve(String s, String p, int i, int j, int dp[][]) {
        if (j == p.length()) {
            return i == s.length();
        }

        if (dp[i][j] != -1) {
            return dp[i][j] == 1 ? true : false;
        }

        if (i == s.length()) {
            for (int k = j; k < p.length(); k++) {
                if (p.charAt(k) != '*') {
                    dp[i][j] = 0;
                    return false;
                }
            }
            dp[i][j] = 1;
            return true;
        }

        boolean ans;

        if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?') {
            ans = solve(s, p, i + 1, j + 1, dp);
        } else if (p.charAt(j) == '*') {
            ans = solve(s, p, i, j + 1, dp) || solve(s, p, i + 1, j, dp);
        } else {
            ans = false;
        }

        dp[i][j] = (ans ? 1 : 0);
        return ans;
    }
}

// Approach 2 Tabulation O(n*m)
class Solution {
    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();

        boolean dp[][] = new boolean[n + 1][m + 1];
        dp[0][0] = true;

        for (int i = 1; i <= n; i++) {
            dp[i][0] = false;
        }

        for (int j = 1; j <= m; j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 1];
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                }
            }
        }

        return dp[n][m];
    }
}