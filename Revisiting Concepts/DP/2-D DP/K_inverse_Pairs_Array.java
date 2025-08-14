import java.util.*;

public class K_inverse_Pairs_Array {

    // Approach 1 Memoisation O(n*n*k) T.L.E
    static int mod = 1000000007;

    public static int kInversePairs(int n, int k) {
        int dp[][] = new int[n + 1][k + 1];
        for (int row[] : dp) {
            Arrays.fill(row, -1);
        }

        return solve(n, k, dp);
    }

    public static int solve(int n, int k, int dp[][]) {
        if (n == 0) {
            return 0;
        }

        if (k == 0) {
            return 1;
        }

        if (dp[n][k] != -1) {
            return dp[n][k];
        }

        int result = 0;
        for (int inv = 0; inv <= Math.min(k, n - 1); inv++) {
            result = (result + solve(n - 1, k - inv, dp)) % mod;
        }

        return dp[n][k] = result;
    }

    // Approach 2 Bottom Up
    public static int kInversePairs2(int n, int k) {
        int dp[][] = new int[n + 1][k + 1];
        for (int i = 1; i <= n; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k; j++) {
                int result = 0;
                for (int inv = 0; inv <= Math.min(i - 1, j); inv++) {
                    result = (result + dp[i - 1][j - inv]) % mod;
                }

                dp[i][j] = result;
            }
        }

        return dp[n][k];
    }

    // Approach 3 Optimised Bottom Up O(n*k)
    public static int kInversePairs3(int n, int k) {
        int mod = 1000000007;
        int dp[][] = new int[n + 1][k + 1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= n; i++) {
            long cumSum = 1;
            for (int j = 1; j <= k; j++) {
                cumSum += dp[i - 1][j];

                if (j >= i) {
                    cumSum -= dp[i - 1][j - i];
                }

                dp[i][j] = (int) (cumSum % mod);
            }
        }

        return dp[n][k];
    }

    public static void main(String[] args) {
        int n = 3, k = 1;

        System.out.println(kInversePairs(n, k));
        System.out.println(kInversePairs2(n, k));
        System.out.println(kInversePairs3(n, k));
    }
}