import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Coin_Combinations_II {

    static int mod = 1000000007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] firstLine = br.readLine().split(" ");
        int n = Integer.parseInt(firstLine[0]);
        int target = Integer.parseInt(firstLine[1]);

        int[] coins = new int[n];
        String[] priceLine = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            coins[i] = Integer.parseInt(priceLine[i]);
        }

        int dp[][] = new int[n][target + 1];
        for (int row[] : dp) {
            Arrays.fill(row, -1);
        }

        // System.out.println(solve(coins, 0, target, dp));
        System.out.println(tabulation(coins, target));
    }

    // Tabulation
    public static int tabulation(int coins[], int target) {
        int n = coins.length;
        int dp[] = new int[target + 1];
        dp[0] = 1;

        for (int i = 0; i < n; i++) {
            for (int j = coins[i]; j <= target; j++) {
                dp[j] = (dp[j] + dp[j - coins[i]]) % mod;
            }
        }

        return dp[target] % mod;
    }

    // Memoisation
    public static int solve(int coins[], int index, int target, int dp[][]) {
        if (index >= coins.length) {
            return 0;
        }

        if (target == 0) {
            return 1;
        }

        if (dp[index][target] != -1) {
            return dp[index][target];
        }

        int take = 0;
        if (target - coins[index] >= 0) {
            take = (solve(coins, index, target - coins[index], dp)) % mod;
        }

        int notTake = (solve(coins, index + 1, target, dp)) % mod;

        return dp[index][target] = (take + notTake) % mod;
    }
}