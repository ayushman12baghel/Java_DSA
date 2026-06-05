
// Using Digit DP O(logN)
class Solution {
    public long totalWaviness(long num1, long num2) {
        return solve(num2) - solve(num1 - 1);
    }

    public long solve(long num) {
        if (num < 0) {
            return 0;
        }

        char digits[] = String.valueOf(num).toCharArray();
        int length = digits.length;

        long dp[][][][][][] = new long[length + 1][2][2][11][11][];

        return solve2(0, 1, 1, 10, 10, digits, dp)[1];
    }

    public long[] solve2(int index, int tight, int leadingZero, int prev, int morePrev, char digits[],
            long dp[][][][][][]) {
        if (index == digits.length) {
            return new long[] { 1, 0 };
        }

        if (dp[index][tight][leadingZero][prev][morePrev] != null) {
            return dp[index][tight][leadingZero][prev][morePrev];
        }

        long ways = 0;
        long waviness = 0;
        int limit = (tight == 1 ? digits[index] - '0' : 9);

        for (int d = 0; d <= limit; d++) {
            int newTight = (tight == 1 && d == limit ? 1 : 0);
            int newLeadingZero = (leadingZero == 1 && d == 0 ? 1 : 0);

            boolean wavy = false;
            if (prev != 10 && morePrev != 10) {
                boolean isPeak = (morePrev < prev && prev > d);
                boolean isValley = (morePrev > prev && prev < d);

                if (isPeak || isValley) {
                    wavy = true;
                }
            }

            int newPrev = (newLeadingZero == 1 ? 10 : d);
            int newMorePrev = (newLeadingZero == 1 ? 10 : prev);

            long child[] = solve2(index + 1, newTight, newLeadingZero, newPrev, newMorePrev, digits, dp);
            long childWays = child[0];
            long childWaviness = child[1];

            ways += childWays;
            if (wavy) {
                waviness += childWaviness + childWays;
            } else {
                waviness += childWaviness;
            }
        }

        long[] result = new long[] { ways, waviness };
        dp[index][tight][leadingZero][prev][morePrev] = result;
        return result;
    }
}