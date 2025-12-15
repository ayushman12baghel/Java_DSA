import java.util.*;

// Approach Doign Memoisation O(n*m)
class Solution {
    public int subseqCount(String txt, String pat) {
        int dp[][] = new int[txt.length()][pat.length()];
        for (int row[] : dp) {
            Arrays.fill(row, -1);
        }

        return solve(txt, pat, 0, 0, dp);
    }

    public int solve(String str, String pattern, int i, int j, int dp[][]) {
        if (i >= str.length() || j >= pattern.length()) {
            return (j >= pattern.length() ? 1 : 0);
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        if (str.charAt(i) == pattern.charAt(j)) {
            return dp[i][j] = solve(str, pattern, i + 1, j + 1, dp) + solve(str, pattern, i + 1, j, dp);
        } else {
            return dp[i][j] = solve(str, pattern, i + 1, j, dp);
        }
    }
}