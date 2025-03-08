import java.util.*;

public class Minimum_Insertions_to_Make_String_Palindrome {

    // Approach 1 T.L.E
    public static int minInsertions(String s) {
        return solve(s, 0, s.length() - 1);
    }

    public static int solve(String str, int i, int j) {
        if (i >= j) {
            return 0;
        }

        if (str.charAt(i) == str.charAt(j)) {
            return solve(str, i + 1, j - 1);
        }

        int takeni = solve(str, i + 1, j) + 1;
        int takenj = solve(str, i, j - 1) + 1;

        return Math.min(takeni, takenj);
    }

    // Approach 2 Using Memoisation T.C O(n^2)
    public static int minInsertions2(String s) {
        int dp[][] = new int[s.length()][s.length()];
        for (int row[] : dp) {
            Arrays.fill(row, -1);
        }
        return solve(s, 0, s.length() - 1, dp);
    }

    public static int solve(String str, int i, int j, int dp[][]) {
        if (i >= j) {
            return 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        if (str.charAt(i) == str.charAt(j)) {
            return dp[i][j] = solve(str, i + 1, j - 1, dp);
        }

        int takeni = solve(str, i + 1, j, dp) + 1;
        int takenj = solve(str, i, j - 1, dp) + 1;

        return dp[i][j] = Math.min(takeni, takenj);
    }

    // Approach 3 Using Tabulation T.C O(n^2)
    public static int minInsertions3(String s) {
        int dp[][] = new int[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = 0;
        }

        for (int L = 2; L <= s.length(); L++) {
            for (int i = 0; i <= s.length() - L; i++) {
                int j = i + L - 1;
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i + 1][j], dp[i][j - 1]) + 1;
                }
            }
        }

        return dp[0][s.length() - 1];
    }

    // Approach 4 Using LCS T.C O(n^2) Memoisation
    public static int minInsertions4(String s) {
        int dp[][] = new int[s.length()][s.length()];
        for (int row[] : dp) {
            Arrays.fill(row, -1);
        }
        int length = lcs(s, new StringBuilder(s).reverse().toString(), 0, 0, dp);

        return s.length() - length;
    }

    public static int lcs(String str, String str2, int i, int j, int dp[][]) {
        if (i >= str.length() || j >= str.length()) {
            return 0;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        if (str.charAt(i) == str2.charAt(j)) {
            return dp[i][j] = lcs(str, str2, i + 1, j + 1, dp) + 1;
        } else {
            return dp[i][j] = Math.max(lcs(str, str2, i + 1, j, dp), lcs(str, str2, i, j + 1, dp));
        }
    }

    // Approach 5 Using LCS T.C O(n^2) Tabulation
    public static int minInsertions5(String s) {
        int length = lcs(s, new StringBuilder(s).reverse().toString());

        return s.length() - length;
    }

    public static int lcs(String str, String str2) {
        int dp[][] = new int[str.length() + 1][str.length() + 1];

        for (int i = 1; i <= str.length(); i++) {
            for (int j = 1; j <= str.length(); j++) {
                if (str.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[str.length()][str.length()];
    }

    public static void main(String args[]) {
        String str = "mbadm";
        System.out.println(minInsertions(str));
        System.out.println(minInsertions2(str));
        System.out.println(minInsertions3(str));
        System.out.println(minInsertions4(str));
        System.out.println(minInsertions5(str));
    }
}
