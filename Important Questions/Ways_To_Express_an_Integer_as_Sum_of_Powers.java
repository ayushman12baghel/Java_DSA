import java.util.*;

public class Ways_To_Express_an_Integer_as_Sum_of_Powers {

    static int mod = 1000000007;

    // Approach Using DP Memoisation O(n^2)
    public static int numberOfWays(int n, int x) {
        int dp[][] = new int[n + 1][n + 1];
        for (int row[] : dp) {
            Arrays.fill(row, -1);
        }

        return solve(n, 1, x, dp);
    }

    public static int solve(int n, int num, int x, int dp[][]) {
        if (n == 0) {
            return 1;
        }

        if (n < 0) {
            return 0;
        }

        int currentValue = (int) Math.pow(num, x);
        if (currentValue > n) {
            return 0;
        }

        if (dp[n][num] != -1) {
            return dp[n][num];
        }

        int take = solve(n - currentValue, num + 1, x, dp);
        int skip = solve(n, num + 1, x, dp);

        return dp[n][num] = (take + skip) % mod;
    }

    public static void main(String[] args) {
        int n = 10, x = 2;

        System.out.println(numberOfWays(n, x));
    }
}
