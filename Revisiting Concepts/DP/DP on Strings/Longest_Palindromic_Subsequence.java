import java.util.*;

public class Longest_Palindromic_Subsequence {

    // Approach 1 Using LCS Memoisation O(n^2)
    public static int longestPalindromeSubseq(String s) {
        int n = s.length();
        StringBuilder sb = new StringBuilder(s);
        sb = sb.reverse();
        int dp[][] = new int[n][n];

        for (int row[] : dp) {
            Arrays.fill(row, -1);
        }

        return solve(s, sb.toString(), 0, 0, dp);
    }

    public static int solve(String str1, String str2, int i, int j, int dp[][]) {
        if (i >= str1.length() || j >= str2.length()) {
            return 0;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        if (str1.charAt(i) == str2.charAt(j)) {
            return dp[i][j] = 1 + solve(str1, str2, i + 1, j + 1, dp);
        } else {
            return dp[i][j] = Math.max(solve(str1, str2, i + 1, j, dp), solve(str1, str2, i, j + 1, dp));
        }
    }

    // Tabulation
    public static int longestPalindromeSubseq2(String str1) {
        int n = str1.length();
        int dp[][] = new int[n + 1][n + 1];
        String str2 = new StringBuilder(str1).reverse().toString();

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[n][n];
    }

    public static void main(String args[]) {
        String str = "bbbab";

        System.out.println(longestPalindromeSubseq(str));
        System.out.println(longestPalindromeSubseq2(str));
    }
}
