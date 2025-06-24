import java.util.*;

public class Printing_Shortest_Common_Supersequence {

    // Approach 1 Memoisation
    // from 0 to n filling
    public static String shortestCommonSupersequence(String str1, String str2) {

        if (str1.length() == 0) {
            return str2;
        }
        if (str2.length() == 0) {
            return str1;
        }

        int dp[][] = new int[str1.length() + 1][str2.length() + 1];
        for (int row[] : dp) {
            Arrays.fill(row, -1);
        }

        solve(str1, str2, 0, 0, dp);

        StringBuilder sb = new StringBuilder();
        int i = 0;
        int j = 0;

        while (i < str1.length() && j < str2.length()) {
            if (str1.charAt(i) == str2.charAt(j)) {
                sb.append(str1.charAt(i));
                i++;
                j++;
            } else if (solve(str1, str2, i + 1, j, dp) > solve(str1, str2, i, j + 1, dp)) {
                sb.append(str2.charAt(j));
                j++;
            } else {
                sb.append(str1.charAt(i));
                i++;
            }
        }

        while (i < str1.length()) {
            sb.append(str1.charAt(i++));
        }

        while (j < str2.length()) {
            sb.append(str2.charAt(j++));
        }

        return sb.toString();
    }

    public static int solve(String str1, String str2, int i, int j, int dp[][]) {
        if (i >= str1.length()) {
            return str2.length() - j;
        }
        if (j >= str2.length()) {
            return str1.length() - i;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        if (str1.charAt(i) == str2.charAt(j)) {
            return dp[i][j] = 1 + solve(str1, str2, i + 1, j + 1, dp);
        } else {
            return dp[i][j] = 1 + Math.min(solve(str1, str2, i + 1, j, dp), solve(str1, str2, i, j + 1, dp));
        }
    }

    // from n to 0 filling
    public static String shortestCommonSupersequence2(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();
        if (n == 0) {
            return str2;
        }
        if (m == 0) {
            return str1;
        }

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
            } else if (solve2(str1, str2, i - 1, j, dp) < solve2(str1, str2, i, j - 1, dp)) {
                sb.append(str1.charAt(i - 1));
                i--;
            } else {
                sb.append(str2.charAt(j - 1));
                j--;
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
            return i + j;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
            return dp[i][j] = 1 + solve2(str1, str2, i - 1, j - 1, dp);
        } else {
            return dp[i][j] = 1 + Math.min(solve2(str1, str2, i - 1, j, dp), solve2(str1, str2, i, j - 1, dp));
        }
    }

    // Tabulation
    public static String shortestCommonSupersequence3(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();

        if (n == 0) {
            return str2;
        }
        if (m == 0) {
            return str1;
        }

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

    // Approach 2 By LCS
    public static String shortestCommonSupersequence4(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();
        if (n == 0) {
            return str2;
        }
        if (m == 0) {
            return str1;
        }

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
            } else if (solve(str1, str2, i - 1, j, dp) < solve(str1, str2, i, j - 1, dp)) {
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

    // LCS
    public static int solve(String str1, String str2, int i, int j, int dp[][]) {
        if (i == 0 || j == 0) {
            return 0;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
            return dp[i][j] = 1 + solve(str1, str2, i - 1, j - 1, dp);
        } else {
            return dp[i][j] = Math.max(solve(str1, str2, i - 1, j, dp), solve(str1, str2, i, j - 1, dp));
        }
    }

    // Using LCS Tabulation
    public static String shortestCommonSupersequence5(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();
        if (n == 0) {
            return str2;
        }
        if (m == 0) {
            return str1;
        }

        int dp[][] = new int[n + 1][m + 1];
        for (int row[] : dp) {
            Arrays.fill(row, -1);
        }

        // LCS
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
    }
}
