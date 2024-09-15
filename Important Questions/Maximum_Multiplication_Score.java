import java.util.*;

public class Maximum_Multiplication_Score {

    public static long maxScore(int a[], int b[]) {
        long dp[][] = new long[a.length][b.length];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        return helper(a, b, 0, 0, dp);
    }

    public static long helper(int a[], int b[], int index1, int index2, long dp[][]) {
        if (a.length == index1) {
            return 0;
        }
        if (b.length <= index2) {
            return Integer.MIN_VALUE;
        }
        if (dp[index1][index2] != -1) {
            return dp[index1][index2];
        }

        long take = (long) a[index1] * b[index2] + helper(a, b, index1 + 1, index2 + 1, dp);
        long notTake = helper(a, b, index1, index2 + 1, dp);

        return dp[index1][index2] = Math.max(notTake, take);
    }

    public static void main(String args[]) {
        int a[] = { 3, 2, 5, 6 };
        int b[] = { 2, -6, 4, -5, -3, 2, -7 };
        System.out.println(maxScore(a, b));
    }
}
