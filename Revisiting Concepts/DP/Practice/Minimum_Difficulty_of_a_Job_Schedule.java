import java.util.*;

public class Minimum_Difficulty_of_a_Job_Schedule {

    // Approach 1 Doing Memoisation O(n*n*d)
    public static int minDifficulty(int jobDifficulty[], int d) {
        if (d > jobDifficulty.length) {
            return -1;
        }

        int dp[][] = new int[jobDifficulty.length][d + 1];
        for (int row[] : dp) {
            Arrays.fill(row, -1);
        }

        return solve(jobDifficulty, 0, d, dp);
    }

    public static int solve(int jobDifficulty[], int index, int d, int dp[][]) {
        if (d == 1) {
            int maxD = Integer.MIN_VALUE;
            for (int i = index; i < jobDifficulty.length; i++) {
                maxD = Math.max(maxD, jobDifficulty[i]);
            }

            return maxD;
        }

        if (dp[index][d] != -1) {
            return dp[index][d];
        }

        int finalResult = Integer.MAX_VALUE;
        int maxD = jobDifficulty[index];

        for (int i = index; i <= jobDifficulty.length - d; i++) {
            maxD = Math.max(maxD, jobDifficulty[i]);
            int result = maxD + solve(jobDifficulty, i + 1, d - 1, dp);
            finalResult = Math.min(finalResult, result);
        }

        return dp[index][d] = finalResult;
    }

    // Approach 2 Doing Tabulation
    public static int minDifficulty2(int jobDifficulty[], int d) {
        int n = jobDifficulty.length;
        if (n < d) {
            return -1;
        }

        int dp[][] = new int[n + 1][d + 1];
        for (int row[] : dp) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        int max = 0;
        for (int i = n - 1; i >= 0; i--) {
            max = Math.max(max, jobDifficulty[i]);
            dp[i][1] = max;
        }

        for (int days = 2; days <= d; days++) {
            for (int i = 0; i <= n - days; i++) {
                int maxD = jobDifficulty[i];

                for (int j = i; j <= n - days; j++) {
                    maxD = Math.max(maxD, jobDifficulty[j]);
                    int result = maxD + dp[j + 1][days - 1];
                    dp[i][days] = Math.min(dp[i][days], result);
                }
            }
        }

        return dp[0][d];
    }

    public static void main(String[] args) {
        int jobDifficulty[] = { 6, 5, 4, 3, 2, 1 }, d = 2;

        System.out.println(minDifficulty(jobDifficulty, d));
        System.out.println(minDifficulty2(jobDifficulty, d));
    }
}
