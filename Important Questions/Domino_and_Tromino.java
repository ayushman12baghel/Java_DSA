import java.util.*;

public class Domino_and_Tromino {

    // Tabulation
    public static int numTilings(int n) {
        if (n <= 1) {
            return n;
        }
        if (n == 2) {
            return 2;
        }
        int dp[] = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 5;

        for (int i = 4; i < n + 1; i++) {
            dp[i] = (2 * dp[i - 1] % mod + dp[i - 3] % mod) % mod;
        }

        return dp[n];
    }

    // Memoisation
    static int mod = 1000000007;

    public static int numTilings2(int n) {
        int dp[] = new int[n + 1];
        Arrays.fill(dp, -1);
        return solve(n, dp);
    }

    public static int solve(int n, int dp[]) {
        if (n == 1 || n == 2) {
            return n;
        }
        if (n == 3) {
            return 5;
        }

        if (dp[n] != -1) {
            return dp[n];
        }

        return dp[n] = (int) (2 * solve(n - 1, dp) % mod + solve(n - 3, dp) % mod) % mod;
    }

    public static void main(String args[]) {
        int n = 5;
        System.out.println(numTilings(n));
        System.out.println(numTilings2(n));
    }
}
