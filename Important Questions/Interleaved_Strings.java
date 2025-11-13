import java.util.*;

class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }

        Boolean dp[][] = new Boolean[s1.length() + 1][s2.length() + 1];

        return solve(s1, s2, s3, 0, 0, dp);
    }

    public boolean solve(String s1, String s2, String s3, int i, int j, Boolean dp[][]) {
        int k = i + j;

        if (i == s1.length() && j == s2.length() && k == s3.length()) {
            return true;
        }

        if (dp[i][j] != null) {
            return dp[i][j];
        }

        boolean match1 = (i < s1.length() && s1.charAt(i) == s3.charAt(k) && solve(s1, s2, s3, i + 1, j, dp));
        boolean match2 = (j < s2.length() && s2.charAt(j) == s3.charAt(k) && solve(s1, s2, s3, i, j + 1, dp));

        return dp[i][j] = match1 || match2;
    }
}