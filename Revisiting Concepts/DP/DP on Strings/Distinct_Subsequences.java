import java.util.*;

public class Distinct_Subsequences {

    // Approach 1 Using Mwemoisation
    public static int numDistinct(String s, String t) {
        int dp[][] = new int[s.length()][t.length()];
        for (int row[] : dp) {
            Arrays.fill(row, -1);
        }

        return solve(s, t, 0, 0, dp);
    }

    public static int solve(String str, String pattern, int i, int j, int dp[][]) {
        if (i >= str.length()) {
            return j >= pattern.length() ? 1 : 0;
        } else if (j >= pattern.length()) {
            return 1;
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

    // Approach 2 Tabulation O(n^2)
    public static int numDistinct2(String str, String pattern) {
        int n = str.length();
        int m = pattern.length();

        int dp[][] = new int[n + 1][m + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (str.charAt(i - 1) == pattern.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[n][m];
    }

    public static void main(String[] args) {
        String str = "rabbbit";
        String pattern = "rabbit";

        System.out.println(numDistinct(str, pattern));
        System.out.println(numDistinct2(str, pattern));
    }
}
