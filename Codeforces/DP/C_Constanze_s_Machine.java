import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class C_Constanze_s_Machine {
    static int mod = 1000000007;

    // Approach 1 Using Memoisation
    public static int memoisation(String input) {
        if (input.contains("m") || input.contains("w")) {
            return 0;
        }

        int dp[] = new int[input.length()];
        Arrays.fill(dp, -1);

        return solve(input, 0, dp) % mod;
    }

    public static int solve(String s, int i, int dp[]) {
        if (i >= s.length()) {
            return 1;
        }

        if (dp[i] != -1) {
            return dp[i];
        }

        int take = 0;
        if (i + 1 < s.length()) {
            if (s.substring(i, i + 2).equals("nn") || s.substring(i, i + 2).equals("uu")) {
                take = (solve(s, i + 2, dp)) % mod;
            }
        }

        int notTake = (solve(s, i + 1, dp)) % mod;

        return dp[i] = (take + notTake) % mod;
    }

    // Approach 2 Tabulation
    public static int tabulation(String input) {
        if (input.contains("m") || input.contains("w")) {
            return 0;
        }

        int n = input.length();
        int dp[] = new int[n + 1];
        dp[0] = 1;

        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i - 1];

            if (i >= 2) {
                String lastTwo = input.substring(i - 2, i);
                if (lastTwo.equals("nn") || lastTwo.equals("uu")) {
                    dp[i] = (dp[i] + dp[i - 2]) % mod;
                }
            }
        }

        return dp[n];
    }

    public static void main(String[] args) throws IOException {
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // String input = br.readLine();

        String str = "ouuokarinn";

        System.out.println(memoisation(str));
        System.out.println(tabulation(str));
    }
}
