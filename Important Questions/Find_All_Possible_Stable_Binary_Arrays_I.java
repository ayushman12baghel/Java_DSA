import java.util.*;

// Approach 1 Using Memoisation O(zero*one*limit)
class Solution {
    int mod = 1000000007;

    public int numberOfStableArrays(int zero, int one, int limit) {
        int dp[][][][] = new int[zero + 1][one + 1][3][limit + 1];
        for (int cube[][][] : dp) {
            for (int plane[][] : cube) {
                for (int row[] : plane) {
                    Arrays.fill(row, -1);
                }
            }
        }

        return solve(0, 0, 0, 2, zero, one, limit, dp);
    }

    public int solve(int zeroCount, int oneCount, int limitCount, int prev, int zero, int one, int limit,
            int dp[][][][]) {
        if (zeroCount > zero || oneCount > one || limitCount > limit) {
            return 0;
        }

        if (zeroCount == zero && oneCount == one) {
            return 1;
        }

        if (dp[zeroCount][oneCount][prev][limitCount] != -1) {
            return dp[zeroCount][oneCount][prev][limitCount];
        }

        int totalCount = 0;

        if (zeroCount < zero) {
            int nextLimit = (prev == 0 ? limitCount + 1 : 1);
            if (nextLimit <= limit) {
                totalCount = (totalCount + solve(zeroCount + 1, oneCount, nextLimit, 0, zero, one, limit, dp)) % mod;
            }
        }

        if (oneCount < one) {
            int nextLimit = (prev == 1 ? limitCount + 1 : 1);
            if (nextLimit <= limit) {
                totalCount = (totalCount + solve(zeroCount, oneCount + 1, nextLimit, 1, zero, one, limit, dp)) % mod;
            }
        }

        return dp[zeroCount][oneCount][prev][limitCount] = totalCount;
    }
}

// Approach 2 Tabulation O(zero*one*limit)
class Solution {
    public int numberOfStableArrays(int zero, int one, int limit) {
        int mod = 1000000007;
        int dp[][][][] = new int[zero + 1][one + 1][3][limit + 1];
        for (int i = 0; i <= limit; i++) {
            for (int j = 0; j < 3; j++) {
                dp[zero][one][j][i] = 1;
            }
        }

        for (int zeroCount = zero; zeroCount >= 0; zeroCount--) {
            for (int oneCount = one; oneCount >= 0; oneCount--) {
                if (zeroCount == zero && oneCount == one) {
                    continue;
                }

                for (int prev = 0; prev < 3; prev++) {
                    for (int limitCount = 0; limitCount <= limit; limitCount++) {
                        int totalCount = 0;

                        if (zeroCount < zero) {
                            int nextLimit = (prev == 0 ? limitCount + 1 : 1);
                            if (nextLimit <= limit) {
                                totalCount = (totalCount
                                        + dp[zeroCount + 1][oneCount][0][nextLimit]) % mod;
                            }
                        }

                        if (oneCount < one) {
                            int nextLimit = (prev == 1 ? limitCount + 1 : 1);
                            if (nextLimit <= limit) {
                                totalCount = (totalCount
                                        + dp[zeroCount][oneCount + 1][1][nextLimit]) % mod;
                            }
                        }

                        dp[zeroCount][oneCount][prev][limitCount] = totalCount;
                    }
                }
            }
        }

        return dp[0][0][2][0];
    }
}