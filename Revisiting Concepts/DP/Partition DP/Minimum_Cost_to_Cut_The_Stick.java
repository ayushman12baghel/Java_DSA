import java.util.*;

public class Minimum_Cost_to_Cut_The_Stick {

    // Approach 1 Doing Recursion + Memoisation
    public static int minCost(int n, int cuts[]) {
        int m = cuts.length;
        int newCuts[] = new int[m + 2];

        newCuts[0] = 0;
        for (int i = 0; i < m; i++) {
            newCuts[i + 1] = cuts[i];
        }
        newCuts[m + 1] = n;

        Arrays.sort(newCuts);

        int size = m + 2;
        int dp[][] = new int[size][size];
        for (int row[] : dp) {
            Arrays.fill(row, -1);
        }

        return solve(newCuts, 0, size - 1, dp);
    }

    public static int solve(int cuts[], int left, int right, int dp[][]) {
        if (right - left < 2) {
            return 0;
        }

        if (dp[left][right] != -1) {
            return dp[left][right];
        }

        int ans = Integer.MAX_VALUE;
        for (int i = left + 1; i < right; i++) {
            int cost = solve(cuts, left, i, dp) + solve(cuts, i, right, dp) + cuts[right] - cuts[left];
            ans = Math.min(ans, cost);
        }

        return dp[left][right] = ans;
    }

    // Approach 2 DOing Tabulation
    public static int minCost2(int n, int[] cuts) {
        int m = cuts.length;
        int size = m + 2;
        int newCuts[] = new int[size];

        newCuts[0] = 0;
        for (int i = 0; i < m; i++) {
            newCuts[i + 1] = cuts[i];
        }
        newCuts[size - 1] = n;

        Arrays.sort(newCuts);

        int dp[][] = new int[size][size];

        for (int L = 2; L < size; L++) {
            for (int i = 0; i + L < size; i++) {
                int j = i + L;

                int ans = Integer.MAX_VALUE;
                for (int k = i + 1; k < j; k++) {
                    int cost = dp[i][k] + dp[k][j] + newCuts[j] - newCuts[i];
                    ans = Math.min(ans, cost);
                }

                dp[i][j] = ans;
            }
        }

        return dp[0][size - 1];
    }

    public static void main(String[] args) {
        int cuts[] = { 1, 3, 4, 5 };
        int n = 7;

        System.out.println(minCost(n, cuts));
        System.out.println(minCost2(n, cuts));
    }
}
