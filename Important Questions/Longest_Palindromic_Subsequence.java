import java.util.Arrays;

public class Longest_Palindromic_Subsequence {

    public static int longestPalindromicSubsequence(String str1) {
        StringBuilder sb = new StringBuilder(str1);
        String str2 = sb.reverse().toString();
        int n = str1.length();
        int m = str2.length();
        int dp[][] = new int[n + 1][m + 1];

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    int ans1 = dp[i][j - 1];
                    int ans2 = dp[i - 1][j];
                    dp[i][j] = Math.max(ans1, ans2);
                }
            }
        }

        return dp[n][m];
    }

    public static int longestPalindromeSubseq(String str1) {
        int dp[][] = new int[str1.length() + 1][str1.length() + 1];
        for (int i = 0; i < str1.length() + 1; i++) {
            Arrays.fill(dp[i], -1);
        }
        StringBuilder sb = new StringBuilder(str1);
        String str2 = sb.reverse().toString();
        return lps(str1, str2, str1.length(), str1.length(), dp);
    }

    public static int lps(String str1, String str2, int n, int m, int dp[][]) {
        if (n == 0 || m == 0) {
            return 0;
        }
        if (dp[n][m] != -1) {
            return dp[n][m];
        }

        if (str1.charAt(n - 1) == str2.charAt(m - 1)) {
            return dp[n][m] = lps(str1, str2, n - 1, m - 1, dp) + 1;
        } else {
            int ans1 = lps(str1, str2, n - 1, m, dp);
            int ans2 = lps(str1, str2, n, m - 1, dp);
            return dp[n][m] = Math.max(ans1, ans2);
        }
    }

    public static void main(String[] args) {
        String str1 = "bbbab";

        System.out.println(longestPalindromicSubsequence(str1));
        System.out.println(longestPalindromeSubseq(str1));
    }
}
