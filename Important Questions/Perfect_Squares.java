import java.util.*;

public class Perfect_Squares {

    // APproach 1 Doing Memoisation O(n*sqrt(n))
    public static int numSquares(int n) {
        int dp[] = new int[n + 1];
        Arrays.fill(dp, -1);
        return solve(n, dp);
    }

    public static int solve(int n, int dp[]) {
        if (n == 0) {
            return 0;
        }

        if (n < 0) {
            return Integer.MAX_VALUE;
        }

        if (dp[n] != -1) {
            return dp[n];
        }

        int ans = Integer.MAX_VALUE;

        for (int i = 1; i * i <= n; i++) {
            ans = Math.min(ans, 1 + solve(n - i * i, dp));
        }

        return dp[n] = ans;
    }

    // Approach 2 Doing Tabulation
    public static int numSquares2(int n) {
        int dp[] = new int[n + 1];
        dp[0] = 0;

        for (int i = 1; i <= n; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        int n = 12;

        System.out.println(numSquares(n));
        System.out.println(numSquares2(n));
    }
}