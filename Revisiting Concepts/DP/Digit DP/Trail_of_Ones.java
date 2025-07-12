import java.util.*;

public class Trail_of_Ones {

    public static int countConsec(int n) {
        int dp[][][] = new int[n + 1][2][2];
        for (int row[][] : dp) {
            for (int col[] : row) {
                Arrays.fill(col, -1);
            }
        }

        return solve(0, 0, 0, n, dp);
    }

    public static int solve(int pos, int prev, int hasBit, int n, int dp[][][]) {
        if (pos == n) {
            return hasBit;
        }

        if (dp[pos][prev][hasBit] != -1) {
            return dp[pos][prev][hasBit];
        }

        int count = 0;

        // zero
        count += solve(pos + 1, 0, hasBit, n, dp);

        // one
        int newHas = (prev == 1 ? 1 : hasBit);
        count += solve(pos + 1, 1, newHas, n, dp);

        return dp[pos][prev][hasBit] = count;
    }

    public static void main(String[] args) {
        int n = 3;
        System.out.println(countConsec(n));
    }
}
