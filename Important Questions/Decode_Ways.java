import java.util.Arrays;

public class Decode_Ways {

    // Approach 1 Using Mameoisation
    public static int numDecodings(String s) {
        if (s.length() == 1) {
            return s.charAt(0) == '0' ? 0 : 1;
        }

        int dp[] = new int[s.length()];
        Arrays.fill(dp, -1);
        return solve(s, 0, dp);
    }

    public static int solve(String s, int index, int dp[]) {
        if (index >= s.length()) {
            return 1;
        }

        if (s.charAt(index) == '0') {
            return 0;
        }

        if (dp[index] != -1) {
            return dp[index];
        }

        int take = 0;
        if (index + 1 < s.length()) {
            int num = Integer.parseInt(s.substring(index, index + 2));
            if (num >= 10 && num <= 26) {
                take = solve(s, index + 2, dp);
            }
        }

        int notTake = solve(s, index + 1, dp);

        return dp[index] = take + notTake;
    }

    // Approach 2 Using Tabulation
    public static int numDecodings2(String s) {
        int n = s.length();
        if (n == 0 || s.charAt(0) == '0') {
            return 0;
        }

        int dp[] = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            char one = s.charAt(i - 1);

            if (one != '0') {
                dp[i] += dp[i - 1];
            }

            int two = Integer.parseInt(s.substring(i - 2, i));

            if (two >= 10 && two <= 26) {
                dp[i] += dp[i - 2];
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        String s = "226";

        System.out.println(numDecodings(s));

        System.out.println(numDecodings2(s));
    }
}
