import java.util.*;

public class Number_Of_Digit_One {

    // Using Digit DP Memoisation
    public static int countDigitOne(int n) {
        char digits[] = String.valueOf(n).toCharArray();
        int length = digits.length;

        int dp[][][] = new int[length][2][length + 1];
        for (int row[][] : dp) {
            for (int col[] : row) {
                Arrays.fill(col, -1);
            }
        }

        return solve(0, 1, 0, digits, dp);
    }

    public static int solve(int pos, int tight, int count, char digits[], int dp[][][]) {
        if (pos == digits.length) {
            return count;
        }

        if (dp[pos][tight][count] != -1) {
            return dp[pos][tight][count];
        }

        int limit = (tight == 1 ? digits[pos] - '0' : 9);
        int ans = 0;

        for (int d = 0; d <= limit; d++) {
            int newTight = (tight == 1 && d == limit ? 1 : 0);

            ans += solve(pos + 1, newTight, count + (d == 1 ? 1 : 0), digits, dp);
        }

        return dp[pos][tight][count] = ans;
    }

    public static void main(String[] args) {
        int n = 13;

        System.out.println(countDigitOne(n));
    }
}
