import java.util.*;

public class Coin_Change {

    // Memoisation
    public static int coinChange(int coins[], int amount) {
        int dp[] = new int[amount + 1];
        Arrays.fill(dp, -1);
        int ans = coinCount(coins, amount, dp);
        return (ans == Integer.MAX_VALUE) ? -1 : ans;
    }

    public static int coinCount(int coins[], int amount, int dp[]) {
        if (amount < 0) {
            return Integer.MAX_VALUE;
        }
        if (amount == 0) {
            return 0;
        }
        if (dp[amount] != -1) {
            return dp[amount];
        }

        int minCount = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
            int ans = coinCount(coins, amount - coins[i], dp);
            if (ans != Integer.MAX_VALUE) {
                minCount = Math.min(ans + 1, minCount);
            }
        }
        dp[amount] = minCount;

        return minCount;
    }

    // Tabulation
    public static int coinChange2(int coins[], int amount) {
        int dp[] = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (i - coins[j] >= 0 && dp[i - coins[j]] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], 1 + dp[i - coins[j]]);
                }
            }
        }

        return (dp[amount] == Integer.MAX_VALUE) ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        int coins[] = { 1, 2, 5 };
        int amount = 11;

        System.out.println(coinChange(coins, amount));
        System.out.println(coinChange2(coins, amount));
    }
}
