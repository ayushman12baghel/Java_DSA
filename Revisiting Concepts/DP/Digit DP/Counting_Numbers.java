import java.util.*;

public class Counting_Numbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long left = sc.nextLong();
        long right = sc.nextLong();

        long rightAns = memoise(right);
        long leftAns = memoise(left - 1);

        System.out.println(rightAns - leftAns);
    }

    public static long memoise(long n) {
        char digits[] = String.valueOf(n).toCharArray();
        int length = digits.length;

        long dp[][][][] = new long[length][2][2][11];// pos,tight,leadingZeros,prevDigit
        for (long row[][][] : dp) {
            for (long col[][] : row) {
                for (long temp[] : col) {
                    Arrays.fill(temp, -1);
                }
            }
        }

        return solve(0, 1, 1, 10, digits, dp);
    }

    public static long solve(int pos, int tight, int leadingZeros, int prevDigit, char digits[], long dp[][][][]) {
        if (pos == digits.length) {
            return 1;
        }

        if (dp[pos][tight][leadingZeros][prevDigit] != -1) {
            return dp[pos][tight][leadingZeros][prevDigit];
        }

        int limit = (tight == 1 ? digits[pos] - '0' : 9);
        long ans = 0;

        for (int d = 0; d <= limit; d++) {
            if (leadingZeros == 0 && d == prevDigit) {
                continue;
            }

            int newLeadZero = (leadingZeros == 1 && d == 0 ? 1 : 0);
            int newTight = (tight == 1 && d == limit ? 1 : 0);
            int newPrev = (newLeadZero == 1 ? 10 : d);

            ans += solve(pos + 1, newTight, newLeadZero, newPrev, digits, dp);
        }

        return dp[pos][tight][leadingZeros][prevDigit] = ans;
    }
}