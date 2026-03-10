import java.util.*;

//Approach Using Memoisation O(one*zero)
class Solution {
    int mod = 1000000007;
    int zero;
    int one;
    int limit;

    public int numberOfStableArrays(int zero, int one, int limit) {
        this.zero = zero;
        this.one = one;
        this.limit = limit;
        int dp[][][] = new int[zero + 1][one + 1][2];
        for (int plane[][] : dp) {
            for (int row[] : plane) {
                Arrays.fill(row, -1);
            }
        }

        return (solve(0, 0, 0, dp) + solve(0, 0, 1, dp)) % mod;
    }

    public int solve(int zeroCount, int oneCount, int nextDigit, int dp[][][]) {
        if (zeroCount > zero || oneCount > one) {
            return 0;
        }

        if (nextDigit == 0) {
            if (zeroCount == zero) {
                return 0;
            }

            if (oneCount == one) {
                return (zero - zeroCount <= limit ? 1 : 0);
            }
        } else {
            if (oneCount == one) {
                return 0;
            }

            if (zeroCount == zero) {
                return (one - oneCount <= limit ? 1 : 0);
            }
        }

        if (dp[zeroCount][oneCount][nextDigit] != -1) {
            return dp[zeroCount][oneCount][nextDigit];
        }

        int total = 0;

        if (nextDigit == 0) {
            total = (total + solve(zeroCount + 1, oneCount, 0, dp) + solve(zeroCount + 1, oneCount, 1, dp)) % mod;

            if (zeroCount + limit + 1 <= zero) {
                total = (total - solve(zeroCount + limit + 1, oneCount, 1, dp) + mod) % mod;
            }
        } else {
            total = (total + solve(zeroCount, oneCount + 1, 0, dp) + solve(zeroCount, oneCount + 1, 1, dp)) % mod;

            if (oneCount + limit + 1 <= one) {
                total = (total - solve(zeroCount, oneCount + limit + 1, 0, dp) + mod) % mod;
            }
        }

        return dp[zeroCount][oneCount][nextDigit] = total;
    }
}

// Approach 2 Tabulation O(one*zero)
class Solution {
    public int numberOfStableArrays(int zero, int one, int limit) {
        int mod = 1000000007;
        int dp[][][] = new int[zero + 1][one + 1][2];

        for (int z = 0; z <= zero; z++) {
            if (z < zero) {
                dp[z][one][0] = (zero - z <= limit ? 1 : 0);
            }
        }

        for (int o = 0; o <= one; o++) {
            if (o < one) {
                dp[zero][o][1] = (one - o <= limit ? 1 : 0);
            }
        }

        for (int zeroCount = zero - 1; zeroCount >= 0; zeroCount--) {
            for (int oneCount = one - 1; oneCount >= 0; oneCount--) {
                int totalZero = (dp[zeroCount + 1][oneCount][0] + dp[zeroCount + 1][oneCount][1]) % mod;
                if (zeroCount + limit + 1 <= zero) {
                    totalZero = (totalZero - dp[zeroCount + limit + 1][oneCount][1] + mod) % mod;
                }

                dp[zeroCount][oneCount][0] = totalZero;

                int totalOne = (dp[zeroCount][oneCount + 1][0] + dp[zeroCount][oneCount + 1][1]) % mod;
                if (oneCount + limit + 1 <= one) {
                    totalOne = (totalOne - dp[zeroCount][oneCount + limit + 1][0] + mod) % mod;
                }

                dp[zeroCount][oneCount][1] = totalOne;
            }
        }

        return (dp[0][0][0] + dp[0][0][1]) % mod;
    }
}