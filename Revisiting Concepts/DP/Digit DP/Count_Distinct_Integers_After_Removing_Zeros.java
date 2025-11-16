import jva.util.*;

//Approach Using Digit DP
// O(log(n))
class Solution {
    public long countDistinct(long n) {
        char digits[] = String.valueOf(n).toCharArray();
        int length = digits.length;

        long dp[][][] = new long[length + 1][2][2];
        for (long plane[][] : dp) {
            for (long row[] : plane) {
                Arrays.fill(row, -1);
            }
        }

        return solve(digits, 0, 1, 0, dp);
    }

    public long solve(char digits[], int pos, int tight, int notZero, long dp[][][]) {
        if (pos == digits.length) {
            return notZero;
        }

        if (dp[pos][tight][notZero] != -1) {
            return dp[pos][tight][notZero];
        }

        int limit = (tight == 1 ? digits[pos] - '0' : 9);
        long count = 0;

        for (int d = 0; d <= limit; d++) {
            int newTight = (tight == 1 && d == limit ? 1 : 0);
            if (notZero == 0) {
                if (d == 0) {
                    count += solve(digits, pos + 1, 0, notZero, dp);
                } else {
                    count += solve(digits, pos + 1, newTight, 1, dp);
                }
            } else {
                if (d > 0) {
                    count += solve(digits, pos + 1, newTight, 1, dp);
                }
            }
        }

        return dp[pos][tight][notZero] = count;
    }
}