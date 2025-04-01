import java.util.*;

public class Solving_Questions_with_Brainpower {

    // By Memoisation
    public static long mostPoints(int questions[][]) {
        long dp[] = new long[questions.length];
        Arrays.fill(dp, -1);

        return solve(questions, 0, dp);
    }

    public static long solve(int questions[][], int i, long dp[]) {
        if (i >= questions.length) {
            return 0;
        }

        if (dp[i] != -1) {
            return dp[i];
        }

        long taken = questions[i][0] + solve(questions, questions[i][1] + 1 + i, dp);
        long notTaken = solve(questions, i + 1, dp);

        return dp[i] = Math.max(taken, notTaken);
    }

    // By Tabulation
    public static long mostPoints2(int questions[][]) {
        int n = questions.length;
        long dp[] = new long[n];
        dp[n - 1] = questions[n - 1][0];

        for (int i = n - 2; i >= 0; i--) {
            long taken = questions[i][0] + ((i + questions[i][1] + 1) < n ? dp[i + questions[i][1] + 1] : 0);
            long notTaken = dp[i + 1];
            dp[i] = Math.max(taken, notTaken);
        }

        return dp[0];
    }

    public static void main(String args[]) {
        int questions[][] = { { 1, 1 }, { 2, 2 }, { 3, 3 }, { 4, 4 }, { 5, 5 } };

        System.out.println(mostPoints(questions));
        System.out.println(mostPoints2(questions));
    }
}
