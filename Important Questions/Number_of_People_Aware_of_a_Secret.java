import java.util.*;

//Approach Doing Memoisation O(n*forget)
class Solution {
    int mod = 1000000007;

    public int peopleAwareOfSecret(int n, int delay, int forget) {
        int total = 0;
        int dp[] = new int[n + 1];
        Arrays.fill(dp, -1);

        for (int day = n - forget + 1; day <= n; day++) {
            if (day > 0) {
                total = (total + solve(day, delay, forget, dp)) % mod;
            }
        }

        return total;
    }

    public int solve(int day, int delay, int forget, int dp[]) {
        if (day == 1) {
            return 1;
        }
        if (day <= 0) {
            return 0;
        }

        if (dp[day] != -1) {
            return dp[day];
        }

        int result = 0;
        for (int prev = day - forget + 1; prev <= day - delay; prev++) {
            result = (result + solve(prev, delay, forget, dp)) % mod;
        }

        return dp[day] = result;
    }
}

// Approach 2 Bottom Up O(n*forget)
class Solution {
    public int peopleAwareOfSecret(int n, int delay, int forget) {
        int mod = 1000000007;
        int dp[] = new int[n + 1];
        dp[1] = 1;

        for (int day = 2; day <= n; day++) {
            int count = 0;
            for (int prev = day - forget + 1; prev <= day - delay; prev++) {
                if (prev > 0) {
                    count = (count + dp[prev]) % mod;
                }

                dp[day] = count;
            }
        }

        int total = 0;
        for (int day = n - forget + 1; day <= n; day++) {
            total = (total + dp[day]) % mod;
        }

        return total;
    }
}

// Approach 3 O(n)
class Solution {
    public int peopleAwareOfSecret(int n, int delay, int forget) {
        int mod = 1000000007;
        int dp[] = new int[n + 1];
        dp[1] = 1;
        int count = 0;

        for (int day = 2; day <= n; day++) {
            if (day - delay > 0) {
                count = (count + dp[day - delay]) % mod;
            }

            if (day - forget > 0) {
                count = (count - dp[day - forget] + mod) % mod;
            }

            dp[day] = count;
        }

        int total = 0;
        for (int day = n - forget + 1; day <= n; day++) {
            total = (total + dp[day]) % mod;
        }

        return total;
    }
}