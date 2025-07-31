import java.util.*;

public class Best_Time_to_Buy_or_Sell_Stocks_With_Transaction_Fee {

    // Approach 1 Memoisation O(n)
    public static int maxProfit(int[] prices, int fee) {
        int dp[][] = new int[prices.length][2];
        for (int row[] : dp) {
            Arrays.fill(row, -1);
        }

        return solve(prices, fee, 0, true, dp);
    }

    public static int solve(int prices[], int fee, int index, boolean canBuy, int dp[][]) {
        if (index >= prices.length) {
            return 0;
        }

        if (dp[index][canBuy ? 1 : 0] != -1) {
            return dp[index][canBuy ? 1 : 0];
        }

        int profit = 0;

        if (canBuy) {
            int take = solve(prices, fee, index + 1, false, dp) - prices[index] - fee;
            int notTake = solve(prices, fee, index + 1, true, dp);

            profit = Math.max(take, notTake);
        } else {
            int take = solve(prices, fee, index + 1, true, dp) + prices[index];
            int notTake = solve(prices, fee, index + 1, false, dp);

            profit = Math.max(take, notTake);
        }

        return dp[index][canBuy ? 1 : 0] = profit;
    }

    // Approach 2 Tabulation O(n)
    public static int maxProfit2(int[] prices, int fee) {
        int n = prices.length;
        int dp[][] = new int[n][2];

        dp[0][0] = -prices[0] - fee;
        dp[0][1] = 0;

        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] - prices[i] - fee);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i]);
        }

        return dp[n - 1][1];
    }

    // Approach 3 Greedy O(n)
    public static int maxProfit3(int[] prices, int fee) {
        int buy = Integer.MIN_VALUE;
        int sell = 0;

        for (int price : prices) {
            buy = Math.max(buy, sell - price);
            sell = Math.max(sell, buy + price - fee);
        }

        return sell;
    }

    public static void main(String[] args) {
        int prices[] = { 1, 3, 2, 8, 4, 9 };
        int fee = 2;
    }
}
