import java.util.*;

public class Shortest_Common_Supersequence {

    // Memoisation O(n^2)
    public static int shortestCommonSupersequence(String str1, String str2) {
        int dp[][] = new int[str1.length()][str2.length()];
        for (int row[] : dp) {
            Arrays.fill(row, -1);
        }

        return solve(str1, str2, 0, 0, dp);
    }

    public static int solve(String str1, String str2, int i, int j, int dp[][]) {
        if (i >= str1.length()) {
            return str2.length() - j;
        }
        if (j >= str2.length()) {
            return str1.length() - i;
        }

        if (str1.charAt(i) == str2.charAt(j)) {
            return dp[i][j] = 1 + solve(str1, str2, i + 1, j + 1, dp);
        } else {
            return dp[i][j] = Math.min(solve(str1, str2, i + 1, j, dp), solve(str1, str2, i, j + 1, dp)) + 1;
        }
    }

    // Tabulation O(n^2)
    public static int shortestCommonSupersequence2(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();

        int dp[][] = new int[n + 1][m + 1];

        for (int i = 0; i <= n; i++) {
            dp[i][0] = i;
        }

        for (int j = 0; j <= m; j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[n][m];
    }

    public static void main(String args[]) {
        String str1 = "abac";
        String str2 = "cab";

        System.out.println(shortestCommonSupersequence(str1, str2));
        System.out.println(shortestCommonSupersequence2(str1, str2));
    }
}
