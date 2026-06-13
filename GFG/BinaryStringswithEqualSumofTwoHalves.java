class Solution {
    static final long MOD = 1000000007L;

    long power(long a, long b) {
        long res = 1;
        a %= MOD;

        while (b > 0) {
            if ((b & 1) == 1)
                res = (res * a) % MOD;

            a = (a * a) % MOD;
            b >>= 1;
        }
        return res;
    }

    public int computeValue(int n) {
        int m = 2 * n;

        long[] fact = new long[m + 1];
        fact[0] = 1;

        for (int i = 1; i <= m; i++) {
            fact[i] = (fact[i - 1] * i) % MOD;
        }

        long denom = (fact[n] * fact[n]) % MOD;
        long ans = (fact[m] * power(denom, MOD - 2)) % MOD;

        return (int) ans;
    }
}
