import java.util.*;

//Approach using Memoisation O(n^3)
class Solution {
    public int strangePrinter(String s) {
        int n = s.length();
        int dp[][] = new int[n][n];
        for (int row[] : dp) {
            Arrays.fill(row, -1);
        }

        return solve(s, 0, n - 1, dp);
    }

    public int solve(String s, int l, int r, int dp[][]) {
        if (l == r) {
            return 1;
        }

        if (l > r) {
            return 0;
        }

        if (dp[l][r] != -1) {
            return dp[l][r];
        }

        int i = l + 1;

        while (i <= r && s.charAt(i) == s.charAt(l)) {
            i++;
        }

        if (i >= r + 1) {
            return 1;
        }

        int basic = 1 + solve(s, i, r, dp);

        int lalach = Integer.MAX_VALUE;

        for (int j = i; j <= r; j++) {
            if (s.charAt(l) == s.charAt(j)) {
                int x = solve(s, l, j - 1, dp) + solve(s, j + 1, r, dp);

                lalach = Math.min(x, lalach);
            }
        }

        return dp[l][r] = Math.min(lalach, basic);
    }
}