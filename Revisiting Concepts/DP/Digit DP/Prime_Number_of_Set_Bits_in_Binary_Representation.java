import java.util.*;

// Approach Using Digit Dp O(log(n)^2)
class Solution {
    public int countPrimeSetBits(int left, int right) {
        return count(right) - count(left - 1);
    }

    public int count(int n) {
        String binary = Integer.toBinaryString(n);
        int dp[][][] = new int[binary.length()][2][binary.length() + 1];

        for (int plane[][] : dp) {
            for (int row[] : plane) {
                Arrays.fill(row, -1);
            }
        }

        return solve(0, 1, 0, binary, dp);
    }

    public int solve(int pos, int tight, int bits, String binary, int dp[][][]) {
        if (pos == binary.length()) {
            return isPrime(bits) ? 1 : 0;
        }

        if (dp[pos][tight][bits] != -1) {
            return dp[pos][tight][bits];
        }

        int limit = (tight == 1 ? binary.charAt(pos) - '0' : 1);

        int count = 0;
        for (int d = 0; d <= limit; d++) {
            int newTight = (tight == 1 && d == limit ? 1 : 0);
            count += solve(pos + 1, newTight, bits + d, binary, dp);
        }

        return dp[pos][tight][bits] = count;
    }

    public boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }

        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }
}