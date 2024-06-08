
public class Best_Time_To_Buy_Stocks {

    public static int MaxProfit(int prices[], int n) {
        int buy = prices[0];
        int maxProfit = 0;
        for (int i = 1; i < n; i++) {
            if (buy > prices[i]) {
                buy = prices[i];
            } else if (prices[i] - buy > maxProfit) {
                maxProfit = prices[i] - buy;
            }
        }
        return maxProfit;
    }

    public static void main(String args[]) {
        int prices[] = { 7, 1, 5, 3, 6, 4 };
        int n = prices.length;
        System.out.println(MaxProfit(prices, n));
    }
}
