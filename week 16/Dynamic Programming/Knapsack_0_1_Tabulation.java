public class Knapsack_0_1_Tabulation {

    public static int knapsack(int val[], int wt[], int W) {
        int dp[][] = new int[val.length + 1][W + 1];
        int n = val.length;
        for (int i = 0; i < dp.length; i++) {// 0th col
            dp[i][0] = 0;
        }
        for (int i = 0; i < dp[0].length; i++) {// 0th row
            dp[0][i] = 0;
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < W + 1; j++) {
                int v = val[i - 1];// ith item val
                int w = wt[i - 1];// ith item wt
                if (w <= j) {// valid
                    int incProfit = v + dp[i - 1][j - w];
                    int excProfit = dp[i - 1][j];
                    dp[i][j] = Math.max(incProfit, excProfit);
                } else {// invalid
                    int excProfit = dp[i - 1][j];
                    dp[i][j] = excProfit;
                }
            }
        }

        return dp[n][W];
    }

    public static void main(String args[]) {
        int val[] = { 15, 14, 10, 45, 30 };
        int wt[] = { 2, 5, 1, 3, 4 };
        int W = 7;

        System.out.println(knapsack(val, wt, W));
    }
}
