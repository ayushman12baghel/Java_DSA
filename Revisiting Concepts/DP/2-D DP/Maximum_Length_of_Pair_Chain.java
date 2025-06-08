import java.util.*;

public class Maximum_Length_of_Pair_Chain {

    // Using Sorting and Memoisation
    public static int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (a, b) -> a[0] - b[0]);
        int dp[][] = new int[pairs.length][pairs.length + 1];
        for (int row[] : dp) {
            Arrays.fill(row, -1);
        }

        return solve(pairs, 0, -1, dp);
    }

    public static int solve(int pairs[][], int index, int lastTookIndex, int dp[][]) {
        if (index >= pairs.length) {
            return 0;
        }

        if (dp[index][lastTookIndex + 1] != -1) {
            return dp[index][lastTookIndex + 1];
        }

        int take = 0;
        if (lastTookIndex == -1 || pairs[index][0] > pairs[lastTookIndex][1]) {
            take = solve(pairs, index + 1, index, dp) + 1;
        }

        int notTake = solve(pairs, index + 1, lastTookIndex, dp);

        return dp[index][lastTookIndex + 1] = Math.max(take, notTake);
    }

    // Approach 2 Using Sorting and Tabulation
    public static int findLongestChain2(int[][] pairs) {
        Arrays.sort(pairs, (a, b) -> a[0] - b[0]);
        int n = pairs.length;
        int dp[] = new int[n];
        Arrays.fill(dp, 1);
        int max = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (pairs[i][0] > pairs[j][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    max = Math.max(dp[i], max);
                }
            }
        }

        return max;
    }

    public static void main(String args[]) {
        int pairs[][] = { { 1, 2 }, { 7, 8 }, { 4, 5 } };

        System.out.println(findLongestChain(pairs));
        System.out.println(findLongestChain2(pairs));
    }
}
