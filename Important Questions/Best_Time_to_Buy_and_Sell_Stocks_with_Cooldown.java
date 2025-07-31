import java.util.*;

public class Best_Time_to_Buy_and_Sell_Stocks_with_Cooldown {

    // Memoisation
    public static int maxProfit(int[] prices) {
        int dp[][] = new int[prices.length][2];
        for (int row[] : dp) {
            Arrays.fill(row, -1);
        }

        return solve(prices, 0, true, dp);
    }

    public static int solve(int prices[], int index, boolean canBuy, int dp[][]) {
        if (index >= prices.length) {
            return 0;
        }

        if (dp[index][canBuy ? 1 : 0] != -1) {
            return dp[index][canBuy ? 1 : 0];
        }

        int profit = 0;

        if (canBuy) {
            int take = solve(prices, index + 1, false, dp) - prices[index];
            int notTake = solve(prices, index + 1, true, dp);
            profit = Math.max(take, notTake);
        } else {
            int take = prices[index] + solve(prices, index + 2, true, dp);
            int notTake = solve(prices, index + 1, false, dp);

            profit = Math.max(profit, Math.max(take, notTake));
        }

        return dp[index][canBuy ? 1 : 0] = profit;
    }

    public static void main(String[] args) {
        int prices[] = { 1, 2, 3, 0, 2 };

        System.out.println(maxProfit(prices));
    }
}
