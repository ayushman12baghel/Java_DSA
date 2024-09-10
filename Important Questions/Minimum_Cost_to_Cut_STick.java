import java.util.*;

public class Minimum_Cost_to_Cut_STick {

    public static int cost(int start, int end, int rodStart, int rodEnd, int cuts[], int dp[][]) {
        if (start > end) {
            return 0;
        }
        if (dp[start][end] != -1) {
            return dp[start][end];
        }

        int ans = Integer.MAX_VALUE;

        for (int i = start; i <= end; i++) {
            int cost = rodEnd - rodStart + cost(start, i - 1, rodStart, cuts[i], cuts, dp)
                    + cost(i + 1, end, cuts[i], rodEnd, cuts, dp);

            ans = Math.min(ans, cost);
        }

        return dp[start][end] = ans;
    }

    public static int minCost(int n, int cuts[]) {
        Arrays.sort(cuts);
        int m = cuts.length;
        int dp[][] = new int[m][m];
        for (int i = 0; i < m; i++) {
            Arrays.fill(dp[i], -1);
        }

        return cost(0, cuts.length - 1, 0, n, cuts, dp);
    }

    public static void main(String args[]) {
        int cuts[] = { 1, 3, 4, 5 };
        int n = 7;

        System.out.println(minCost(n, cuts));
    }
}
