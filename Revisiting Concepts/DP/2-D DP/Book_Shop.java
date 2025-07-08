import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Book_Shop {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] firstLine = br.readLine().split(" ");
        int n = Integer.parseInt(firstLine[0]);
        int money = Integer.parseInt(firstLine[1]);

        int[] prices = new int[n];
        String[] priceLine = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            prices[i] = Integer.parseInt(priceLine[i]);
        }

        int[] pages = new int[n];
        String[] pageLine = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            pages[i] = Integer.parseInt(pageLine[i]);
        }

        sy
    }

    // Approach 1 Using Memoisation
    public static int memoise(int prices[], int pages[], int money) {
        int n = prices.length;
        int dp[][] = new int[n][money + 1];
        for (int row[] : dp) {
            Arrays.fill(row, -1);
        }

        return solve(prices, pages, 0, money, dp);
    }

    public static int solve(int prices[], int pages[], int index, int money, int dp[][]) {
        if (index >= prices.length) {
            return 0;
        }

        if (money <= 0) {
            return 0;
        }

        if (dp[index][money] != -1) {
            return dp[index][money];
        }

        int take = 0;
        if (money - prices[index] >= 0) {
            take = pages[index] + solve(prices, pages, index + 1, money - prices[index], dp);
        }

        int notTake = solve(prices, pages, index + 1, money, dp);

        return dp[index][money] = Math.max(take, notTake);
    }
   
    // Approa c h 2 Tabulation
    public static int tabulation(int prices[],int pages[],int money){
        int n=prices.length;
        int dp[] = new int[money + 1];

        for (int i = 0; i < n; i++) {
            for (int j = money; j >= prices[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - prices[i]] + pages[i]);
            }
        }

        System.out.println(dp[money]);
    }
}