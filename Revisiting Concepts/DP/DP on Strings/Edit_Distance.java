import java.util.Arrays;

public class Edit_Distance {

    // Approach 1 By Memoisation
    public static int minDistance(String word1, String word2) {
        int dp[][] = new int[word1.length()][word2.length()];
        for (int row[] : dp) {
            Arrays.fill(row, -1);
        }
        return solve(word1, word2, 0, 0, dp);
    }

    public static int solve(String str1, String str2, int i, int j, int dp[][]) {
        if (i == str1.length()) {
            return str2.length() - j;
        } else if (j == str2.length()) {
            return str1.length() - i;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        if (str1.charAt(i) == str2.charAt(j)) {
            return dp[i][j] = solve(str1, str2, i + 1, j + 1, dp);
        } else {
            int insert = 1 + solve(str1, str2, i, j + 1, dp);
            int delete = 1 + solve(str1, str2, i + 1, j, dp);
            int replace = 1 + solve(str1, str2, i + 1, j + 1, dp);

            return dp[i][j] = Math.min(insert, Math.min(delete, replace));
        }
    }

    // Approach 2 By Tabulation
    public static int minDistance2(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        int dp[][] = new int[n + 1][m + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = i + j;
                } else if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j], Math.min(dp[i - 1][j - 1], dp[i][j - 1]));
                }
            }
        }

        return dp[n][m];
    }

    public static void main(String args[]) {
        String word1 = "intention";
        String word2 = "execution";

        System.out.println(minDistance(word1, word2));
        System.out.println(minDistance2(word1, word2));
    }
}
