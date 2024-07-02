import java.util.*;

public class Best_time_to_buy_or_sell_stocks {

    public static int maxProfit(int prices[]) {
        int buy = Integer.MAX_VALUE;
        int max = 0;

        for (int i = 0; i < prices.length; i++) {
            if (buy < prices[i]) {
                int profit = prices[i] - buy;
                max = Math.max(max, profit);
            } else {
                buy = prices[i];
            }
        }

        return max;
    }

    public static void main(String args[]) {
        int prices[] = { 7, 1, 5, 3, 6, 4 };

        System.out.println(maxProfit(prices));
    }
}
