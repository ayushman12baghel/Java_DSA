import java.util.*;

// Approach Using Digit DP O(length)
class Solution {
    static long jumpingNums(long n) {
        char digits[] = String.valueOf(n).toCharArray();
        int length = digits.length;

        long dp[][][][] = new long[length + 1][2][10][2];
        for (long cube[][][] : dp) {
            for (long plane[][] : cube) {
                for (long row[] : plane) {
                    Arrays.fill(row, -1);
                }
            }
        }

        return solve(0, 1, 0, 1, digits, dp);
    }

    static long solve(int pos, int tight, int prev, int leadingZeros, char digits[], long dp[][][][]) {
        if (pos == digits.length) {
            return 0;
        }

        if (dp[pos][tight][prev][leadingZeros] != -1) {
            return dp[pos][tight][prev][leadingZeros];
        }

        int limit = (tight == 1 ? digits[pos] - '0' : 9);

        long maxNum = -1;

        for (int d = limit; d >= 0; d--) {
            int newTight = (tight == 1 && d == limit ? 1 : 0);
            int newLeadingZeros = (leadingZeros == 1 && d == 0 ? 1 : 0);
            long suffix = -1;

            if (leadingZeros == 1) {
                suffix = solve(pos + 1, newTight, d, newLeadingZeros, digits, dp);
            } else {
                if (Math.abs(prev - d) == 1) {
                    suffix = solve(pos + 1, newTight, d, newLeadingZeros, digits, dp);
                }
            }

            if (suffix != -1) {
                if (newLeadingZeros == 1) {
                    maxNum = Math.max(maxNum, suffix);
                } else {
                    long placeValue = (long) Math.pow(10, digits.length - 1 - pos);
                    maxNum = Math.max(maxNum, d * placeValue + suffix);
                }
            }
        }

        return dp[pos][tight][prev][leadingZeros] = maxNum;
    }
};

// Approach 2 Using BFS O(k) Where K is the total number of Jumping Numbers
// less than or equal to $n$

class Solution {
    static long jumpingNums(long n) {
        if (n <= 9) {
            return n;
        }

        Queue<Long> queue = new ArrayDeque<>();

        for (int i = 1; i <= 9; i++) {
            queue.offer(i * 1L);
        }

        long maxNum = -1;

        while (!queue.isEmpty()) {
            long current = queue.poll();
            maxNum = Math.max(maxNum, current);

            // Checking for -1;
            long lastDigit = current % 10;

            if (lastDigit > 0) {
                long smallNum = current * 10 + (lastDigit - 1);
                if (smallNum <= n) {
                    queue.offer(smallNum);
                }
            }

            if (lastDigit < 9) {
                long bigNum = current * 10 + (lastDigit + 1);
                if (bigNum <= n) {
                    queue.offer(bigNum);
                }
            }
        }

        return maxNum;
    }
};