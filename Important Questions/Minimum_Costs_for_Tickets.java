import java.util.*;

public class Minimum_Costs_for_Tickets {

    public static int minCosts(int days[], int costs[]) {
        int dp[] = new int[days[days.length - 1]];
        Arrays.fill(dp, -1);

        return solve(days, costs, 0, dp);
    }

    public static int solve(int days[], int costs[], int i, int dp[]) {
        if (i >= days.length) {
            return 0;
        }

        if (dp[i] != -1) {
            return dp[i];
        }

        int cost_0 = costs[0] + solve(days, costs, i + 1, dp);

        int maxDays = days[i] + 7;
        int j = i;
        while (j < days.length && days[j] < maxDays) {
            j++;
        }

        int cost_1 = costs[1] + solve(days, costs, j, dp);

        maxDays = days[i] + 30;
        j = i;
        while (j < days.length && days[j] < maxDays) {
            j++;
        }

        int cost_2 = costs[2] + solve(days, costs, j, dp);

        return dp[i] = Math.min(cost_0, Math.min(cost_1, cost_2));
    }

    public static void main(String args[]) {
        int days[] = { 1, 4, 6, 7, 8, 20 };
        int costs[] = { 2, 7, 15 };

        System.out.println(minCosts(days, costs));
    }
}