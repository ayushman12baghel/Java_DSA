import java.util.*;

public class Shortest_Common_Subsequence {

    // Recursion + Memoization
    public static String shortestCommonSupersequence(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();
        int dp[][] = new int[n + 1][m + 1];

        for (int row[] : dp) {
            Arrays.fill(row, -1);
        }

        solve(str1, str2, n, m, dp);

        StringBuilder sb = new StringBuilder();
        int i = n;
        int j = m;

        while (i > 0 && j > 0) {
            if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                sb.append(str1.charAt(i - 1));
                i--;
                j--;
            } else if (solve(str1, str2, i - 1, j, dp) > solve(str1, str2, i, j - 1, dp)) {
                sb.append(str2.charAt(j - 1));
                j--;
            } else {
                sb.append(str1.charAt(i - 1));
                i--;
            }
        }

        while (i > 0) {
            sb.append(str1.charAt(i - 1));
            i--;
        }

        while (j > 0) {
            sb.append(str2.charAt(j - 1));
            j--;
        }

        return sb.reverse().toString();
    }

    public static int solve(String str1, String str2, int i, int j, int dp[][]) {
        if (i == 0 || j == 0) {
            return i + j;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
            return dp[i][j] = 1 + solve(str1, str2, i - 1, j - 1, dp);
        } else {
            int ans1 = solve(str1, str2, i - 1, j, dp);
            int ans2 = solve(str1, str2, i, j - 1, dp);
            return dp[i][j] = 1 + Math.min(ans1, ans2);
        }
    }

    // Tabulation
    public static String shortestCommonSupersequence2(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();
        int dp[][] = new int[n + 1][m + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = i + j;
                } else if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        int i = n;
        int j = m;

        while (i > 0 && j > 0) {
            if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                sb.append(str1.charAt(i - 1));
                i--;
                j--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                sb.append(str2.charAt(j - 1));
                j--;
            } else {
                sb.append(str1.charAt(i - 1));
                i--;
            }
        }

        while (i > 0) {
            sb.append(str1.charAt(i - 1));
            i--;
        }

        while (j > 0) {
            sb.append(str2.charAt(j - 1));
            j--;
        }

        return sb.reverse().toString();
    }

    // Using LCS Memoization
    public static String shortestCommonSupersequence3(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();
        int dp[][] = new int[n + 1][m + 1];
        for (int row[] : dp) {
            Arrays.fill(row, -1);
        }

        solve2(str1, str2, n, m, dp);

        StringBuilder sb = new StringBuilder();
        int i = n;
        int j = m;

        while (i > 0 && j > 0) {
            if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                sb.append(str1.charAt(i - 1));
                i--;
                j--;
            } else if (dp[i - 1][j] < dp[i][j - 1]) {
                sb.append(str2.charAt(j - 1));
                j--;
            } else {
                sb.append(str1.charAt(i - 1));
                i--;
            }
        }

        while (i > 0) {
            sb.append(str1.charAt(i - 1));
            i--;
        }

        while (j > 0) {
            sb.append(str2.charAt(j - 1));
            j--;
        }

        return sb.reverse().toString();
    }

    public static int solve2(String str1, String str2, int i, int j, int dp[][]) {
        if (i == 0 || j == 0) {
            return 0;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
            return dp[i][j] = solve2(str1, str2, i - 1, j - 1, dp) + 1;
        } else {
            return dp[i][j] = Math.max(solve2(str1, str2, i - 1, j, dp), solve2(str1, str2, i, j - 1, dp));
        }
    }

    // Using LCS Tabulation
    public static String shortestCommonSupersequence4(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();
        int dp[][] = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        int i = n;
        int j = m;

        while (i > 0 && j > 0) {
            if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                sb.append(str1.charAt(i - 1));
                i--;
                j--;
            } else if (dp[i - 1][j] < dp[i][j - 1]) {
                sb.append(str2.charAt(j - 1));
                j--;
            } else {
                sb.append(str1.charAt(i - 1));
                i--;
            }
        }

        while (i > 0) {
            sb.append(str1.charAt(i - 1));
            i--;
        }

        while (j > 0) {
            sb.append(str2.charAt(j - 1));
            j--;
        }

        return sb.reverse().toString();
    }

    public static void main(String args[]) {
        String str1 = "abac", str2 = "cab";

        System.out.println(shortestCommonSupersequence(str1, str2));
        System.out.println(shortestCommonSupersequence2(str1, str2));
        System.out.println(shortestCommonSupersequence3(str1, str2));
        System.out.println(shortestCommonSupersequence4(str1, str2));
    }
}
