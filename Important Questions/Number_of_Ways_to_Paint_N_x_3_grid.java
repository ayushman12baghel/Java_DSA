import java.util.*;

//Approach Using Memoisation O(n)
class Solution {
    int mod = 1000000007;

    public int numOfWays(int n) {
        long dp[][] = new long[n][2];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        long same = solve(n, 1, 0, dp) * 6L;
        long diff = solve(n, 1, 1, dp) * 6L;

        return (int) ((same + diff) % mod);
    }

    public long solve(int n, int row, int prevType, long dp[][]) {
        if (row == n) {
            return 1;
        }

        if (dp[row][prevType] != -1) {
            return dp[row][prevType];
        }

        long ways = 0;
        if (prevType == 0) { // ABA
            // Same
            ways = (ways + 3L * solve(n, row + 1, 0, dp)) % mod;

            // diff
            ways = (ways + 2L * solve(n, row + 1, 1, dp)) % mod;
        } else {
            // same
            ways = (ways + 2L * solve(n, row + 1, 0, dp)) % mod;
            // diff
            ways = (ways + 2L * solve(n, row + 1, 1, dp)) % mod;
        }

        return dp[row][prevType] = ways % mod;
    }
}

// Approach 2 Tabulation O(n) and O(1) space
class Solution {
    public int numOfWays(int n) {
        int mod = 1000000007;

        long two = 6;
        long three = 6;
        n--;

        while (n > 0) {
            long nextTwo = (3L * two + 2L * three) % mod;
            three = (2L * two + 2L * three) % mod;
            two = nextTwo;
            n--;
        }

        return (int) ((two + three) % mod);
    }
}