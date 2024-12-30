import java.util.*;

public class Number_of_ways_to_form_Target_String_from_dictionary {

    // Memoisation
    public static int numWays(String words[], String target) {
        int n = words[0].length();
        int m = target.length();

        int freq[][] = new int[n][26];
        for (String word : words) {
            for (int i = 0; i < n; i++) {
                int character = word.charAt(i) - 'a';
                freq[i][character]++;
            }
        }

        int dp[][] = new int[n][m];
        for (int row[] : dp) {
            Arrays.fill(row, -1);
        }

        return (int) solve(words, target, 0, 0, freq, dp);
    }

    public static long solve(String words[], String target, int i, int j, int freq[][], int dp[][]) {
        if (i == target.length()) {
            return 1;
        }
        if (j == words[0].length()) {
            return 0;
        }
        if (dp[j][i] != -1) {
            return dp[j][i];
        }

        long count = 0;

        // taken
        count += freq[j][target.charAt(i) - 'a'] * solve(words, target, i + 1, j + 1, freq, dp);
        // not taken
        count += solve(words, target, i, j + 1, freq, dp);

        dp[j][i] = (int) (count % 1000000007);

        return dp[j][i];
    }

    // Tabulation
    public static int numWays2(String words[], String target) {
        int n = words[0].length();
        int m = target.length();
        int mod = 1000000007;

        int freq[][] = new int[n][26];
        for (String word : words) {
            for (int i = 0; i < n; i++) {
                int character = word.charAt(i) - 'a';
                freq[i][character]++;
            }
        }

        int dp[][] = new int[n + 1][m + 1];

        dp[0][0] = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= m; j++) {
                dp[i + 1][j] = (dp[i + 1][j] + dp[i][j]) % mod;
                if (j < m) {
                    dp[i + 1][j
                            + 1] = (dp[i + 1][j + 1] + (int) ((long) dp[i][j] * freq[i][target.charAt(j) - 'a'] % mod))
                                    % mod;
                }
            }
        }

        return dp[n][m];
    }

    public static void main(String args[]) {
        String words[] = { "acca", "bbbb", "caca" };
        String target = "aba";

        System.out.println(numWays(words, target));
        System.out.println(numWays2(words, target));
    }
}
