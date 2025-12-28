import java.util.*;

//Approach Digit DP O(L*S*S) -> O(1)
class Solution {
    public long countBalanced(long low, long high) {
        long leftCount = count(low - 1);
        long rightCount = count(high);

        return rightCount - leftCount;
    }

    public long count(long n) {
        char digits[] = String.valueOf(n).toCharArray();
        int length = digits.length;

        long dp[][][][] = new long[length + 1][2][200][200];
        for (long x[][][] : dp) {
            for (long plane[][] : x) {
                for (long row[] : plane) {
                    Arrays.fill(row, -1);
                }
            }
        }

        return solve(0, 1, 0, 0, digits, dp);
    }

    public long solve(int pos, int tight, int oddSum, int evenSum, char digits[], long dp[][][][]) {
        if (pos == digits.length) {
            return oddSum == evenSum ? 1 : 0;
        }

        if (dp[pos][tight][oddSum][evenSum] != -1) {
            return dp[pos][tight][oddSum][evenSum];
        }

        long ans = 0;
        int limit = (tight == 1 ? digits[pos] - '0' : 9);

        for (int digit = 0; digit <= limit; digit++) {
            int newTight = (digit == limit && tight == 1 ? 1 : 0);
            int nextOddSum = oddSum;
            int nextEvenSum = evenSum;

            if (pos % 2 == 0) {
                nextEvenSum += digit;
            } else {
                nextOddSum += digit;
            }

            ans += solve(pos + 1, newTight, nextOddSum, nextEvenSum, digits, dp);
        }

        return dp[pos][tight][oddSum][evenSum] = ans;
    }
}