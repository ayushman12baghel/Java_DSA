package Contest;

import java.util.Scanner;

public class Main {
    static final int MOD = 1000000007;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        long totalSum = (long) n * (n + 1) / 2;

        if (totalSum % 2 == 1) {
            System.out.println(0);
            sc.close();
            return;
        }

        long target = totalSum / 2;

        long[] dp = new long[(int) target + 1];
        dp[0] = 1;

        for (int num = 1; num <= n; num++) {
            for (int sum = (int) target; sum >= num; sum--) {
                dp[sum] = (dp[sum] + dp[sum - num]) % MOD;
            }
        }

        long result = dp[(int) target];

        long inv2 = modularInverse(2, MOD);
        result = (result * inv2) % MOD;

        System.out.println(result);
        sc.close();
    }

    static long modularInverse(long a, long mod) {
        return power(a, mod - 2, mod);
    }

    static long power(long base, long exp, long mod) {
        long result = 1;
        base %= mod;
        while (exp > 0) {
            if (exp % 2 == 1) {
                result = (result * base) % mod;
            }
            base = (base * base) % mod;
            exp /= 2;
        }

        return result;
    }
}
