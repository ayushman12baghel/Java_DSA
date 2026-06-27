class Solution {
    public int countWays(int n, int m) {
        int MOD = 1000000007;

        if (n < m) return 1;

        long[] dp = new long[n + 1];

        for (int i = 0; i < m; i++) {
            dp[i] = 1;
        }

        dp[m] = 2;

        for (int i = m + 1; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - m]) % MOD;
        }

        return (int) dp[n];
    }
}
