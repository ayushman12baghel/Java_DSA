import java.util.*;

public class Minimum_Ascii_Delete_Sum_for_Two_Strings {

    // Approach 1 Using Memoisation O(n^2)
    public static int minimumDeleteSum(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int dp[][] = new int[n][m];
        for (int row[] : dp) {
            Arrays.fill(row, -1);
        }

        return solve(s1, s2, 0, 0, dp);
    }

    public static int solve(String str1, String str2, int i, int j, int dp[][]) {
        if (i == str1.length()) {
            int sum = 0;
            while (j < str2.length()) {
                sum += str2.charAt(j++);
            }

            return sum;
        }
        if (j == str2.length()) {
            int sum = 0;
            while (i < str1.length()) {
                sum += str1.charAt(i++);
            }

            return sum;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        if (str1.charAt(i) == str2.charAt(j)) {
            return dp[i][j] = solve(str1, str2, i + 1, j + 1, dp);
        } else {
            int delete1 = str1.charAt(i) + solve(str1, str2, i + 1, j, dp);
            int delete2 = str2.charAt(j) + solve(str1, str2, i, j + 1, dp);

            return dp[i][j] = Math.min(delete1, delete2);
        }
    }

    // Approach 2 Using Tabulation O(n^2)
    public static int minimumDeleteSum2(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();
        int dp[][] = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            dp[i][0] = str1.charAt(i - 1) + dp[i - 1][0];
        }
        for (int j = 1; j <= m; j++) {
            dp[0][j] = str2.charAt(j - 1) + dp[0][j - 1];
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    int delete1 = str1.charAt(i - 1) + dp[i - 1][j];
                    int delete2 = str2.charAt(j - 1) + dp[i][j - 1];
                    dp[i][j] = Math.min(delete1, delete2);
                }
            }
        }

        return dp[n][m];
    }

    public static void main(String[] args) {
        String s1 = "sea";
        String s2 = "eat";

        System.out.println(minimumDeleteSum(s1, s2));
        System.out.println(minimumDeleteSum2(s1, s2));
    }
}
