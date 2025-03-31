import java.util.Arrays;

public class Minimum_Cost_Climbing_Stairs {

    // Approach 1 Using Memoisation
    public static int minCostClimbingStairs(int costs[]) {
        int dp[] = new int[costs.length];
        Arrays.fill(dp, -1);

        return Math.min(solve(costs, 0, dp), solve(costs, 1, dp));
    }

    public static int solve(int costs[], int i, int dp[]) {
        if (i >= costs.length) {
            return 0;
        }

        if (dp[i] != -1) {
            return dp[i];
        }

        int oneJump = costs[i] + solve(costs, i + 1, dp);
        int twoJump = costs[i] + solve(costs, i + 2, dp);

        return dp[i] = Math.min(oneJump, twoJump);
    }

    // Approach 2 Using Tabulation
    public static int minCostClimbingStairs2(int[] cost) {
        int dp[] = new int[cost.length];
        dp[0] = cost[0];
        dp[1] = cost[1];

        for (int i = 2; i < cost.length; i++) {
            int oneJump = dp[i - 1];
            int twoJump = dp[i - 2];

            dp[i] = cost[i] + Math.min(oneJump, twoJump);
        }

        return Math.min(dp[cost.length - 1], dp[cost.length - 2]);
    }

    public static void main(String args[]) {
        int costs[] = { 1, 100, 1, 1, 1, 100, 1, 1, 100, 1 };

        System.out.println(minCostClimbingStairs(costs));
        System.out.println(minCostClimbingStairs2(costs));
    }
}
