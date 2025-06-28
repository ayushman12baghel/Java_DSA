import java.util.*;

public class Minimum_Insertions_Steps_To_Make_String_Palindrome {

    // Approach 1 Using Memoisation O(n^2)
    public static int minInsertions(String s) {
        int n = s.length();
        int dp[][] = new int[n][n];
        for (int row[] : dp) {
            Arrays.fill(row, -1);
        }

        return solve(s, 0, s.length() - 1, dp);
    }

    public static int solve(String str1, int i, int j, int dp[][]) {
        if (i >= j) {
            return 0;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        if (str1.charAt(i) == str1.charAt(j)) {
            return dp[i][j] = solve(str1, i + 1, j - 1, dp);
        } else {
            return dp[i][j] = 1 + Math.min(solve(str1, i + 1, j, dp), solve(str1, i, j - 1, dp));
        }
    }

    // Tabulation O(n^2)
    public static int minInsertions2(String s) {
        int n = s.length();
        int dp[][] = new int[n][n];

        for (int L = 1; L <= n; L++) {
            for (int i = 0; i + L - 1 < n; i++) {
                int j = i + L - 1;

                if (i >= j) {
                    dp[i][j] = 0;
                } else if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1];
                } else {
                    dp[i][j] = 1 + Math.min(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[0][n - 1];
    }

    // Approach 2 Using LCS Code
    public static int minInsertions3(String s) {
        int n = s.length();
        int dp[][] = new int[n][n];
        for (int row[] : dp) {
            Arrays.fill(row, -1);
        }
        return s.length() - solve(s, new StringBuilder(s).reverse().toString(), 0, 0, dp);
    }

    // LCS Code
    public static int solve(String str1, String str2, int i, int j, int dp[][]) {
        if (i >= str1.length() || j >= str1.length()) {
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

    // LCS Tabulation
    public static int minInsertions4(String str1) {
        int n = str1.length();
        String str2 = new StringBuilder(str1).reverse().toString();
        int dp[][] = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return n - dp[n][n];
    }

    public static void main(String[] args) {
        String str = "leetcode";

        System.out.println(minInsertions(str));
        System.out.println(minInsertions2(str));
        System.out.println(minInsertions3(str));
        System.out.println(minInsertions4(str));
    }
}
