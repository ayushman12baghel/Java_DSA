import java.util.*;

public class Digit_DP_Template {

    public static int countNumbersWithSumDivBy3(int num) {
        char digits[] = String.valueOf(num).toCharArray();
        int n = digits.length;

        int dp[][][] = new int[n][2][20];// Length,Tight,Sum
        for (int row[][] : dp) {
            for (int col[] : row) {
                Arrays.fill(col, -1);
            }
        }

        return solve(0, 1, 0, digits, dp);
    }

    public static int solve(int pos, int tight, int sum, char digits[], int dp[][][]) {
        if (pos == digits.length) {
            return sum % 3 == 0 ? 1 : 0;
        }

        if (dp[pos][tight][sum] != -1) {
            return dp[pos][tight][sum];
        }

        int limit = (tight == 1 ? digits[pos] - '0' : 9);
        int count = 0;

        for (int d = 0; d <= limit; d++) {
            int newTight = (tight == 1 && d == limit ? 1 : 0);
            count += solve(pos + 1, newTight, sum + d, digits, dp);
        }

        return dp[pos][tight][sum] = count;
    }

    public static void main(String[] args) {
        int num = 15;

        System.out.println(countNumbersWithSumDivBy3(num));
    }
}
