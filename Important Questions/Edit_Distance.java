import java.util.Arrays;

public class Edit_Distance {

    // Using Recursion+Memoization starting from 0,0
    public static int minDistance2(String word1, String word2) {
        int dp[][] = new int[word1.length()][word2.length()];
        for (int row[] : dp) {
            Arrays.fill(row, -1);
        }
        return solve(word1, word2, 0, 0, dp);
    }

    public static int solve(String str1, String str2, int i, int j, int dp[][]) {
        if (j == str2.length()) {
            return str1.length() - i;
        } else if (i == str1.length()) {
            return str2.length() - j;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        if (str1.charAt(i) == str2.charAt(j)) {
            return dp[i][j] = solve(str1, str2, i + 1, j + 1, dp);
        }

        int insert = solve(str1, str2, i, j + 1, dp) + 1;
        int delete = solve(str1, str2, i + 1, j, dp) + 1;
        int replace = solve(str1, str2, i + 1, j + 1, dp) + 1;

        return dp[i][j] = Math.min(insert, Math.min(delete, replace));
    }

    // Using Recursion + Memoization starting from end
    public static int minDistance3(String word1, String word2) {
        int dp[][] = new int[word1.length() + 1][word2.length() + 1];
        for (int row[] : dp) {
            Arrays.fill(row, -1);
        }
        return solve2(word1, word2, word1.length(), word2.length(), dp);
    }

    public static int solve2(String str1, String str2, int i, int j, int dp[][]) {
        if (i == 0 || j == 0) {
            return i + j;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
            return dp[i][j] = solve2(str1, str2, i - 1, j - 1, dp);
        }

        int insert = solve2(str1, str2, i, j - 1, dp) + 1;
        int delete = solve2(str1, str2, i - 1, j, dp) + 1;
        int replace = solve2(str1, str2, i - 1, j - 1, dp) + 1;

        return dp[i][j] = Math.min(insert, Math.min(delete, replace));
    }

    // Using Tabulation
    public static int minDistance4(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();
        int dp[][] = new int[n + 1][m + 1];

        for (int i = n; i > 0; i--) {
            for (int j = m; j > 0; j--) {
                if (i == 0 || j == 0) {
                    dp[i][j] = i + j;
                } else if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    int delete = dp[i - 1][j] + 1;
                    int insert = dp[i][j - 1] + 1;
                    int replace = dp[i - 1][j - 1] + 1;
                    dp[i][j] = Math.min(delete, Math.min(insert, replace));
                }
            }
        }

        return dp[0][0];
    }

    // Using Tabulation
    public static int minDistance(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();
        int dp[][] = new int[n + 1][m + 1];

        for (int i = 1; i < n + 1; i++) {
            dp[i][0] = i;
        }
        for (int i = 1; i < m + 1; i++) {
            dp[0][i] = i;
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    int add = dp[i][j - 1] + 1;
                    int delete = dp[i - 1][j] + 1;
                    int replace = dp[i - 1][j - 1] + 1;
                    dp[i][j] = Math.min(add, Math.min(delete, replace));
                }
            }
        }

        return dp[n][m];
    }

    public static void main(String[] args) {
        String str1 = "intention";
        String str2 = "execution";

        System.out.println(minDistance(str1, str2));
        System.out.println(minDistance2(str1, str2));
        System.out.println(minDistance3(str1, str2));
        System.out.println(minDistance4(str1, str2));
    }
}
