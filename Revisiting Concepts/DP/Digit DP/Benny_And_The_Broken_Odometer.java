import java.util.*;
import java.io.*;

public class Benny_And_The_Broken_Odometer {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            long right = Long.parseLong(br.readLine());

            System.out.println(right - memoise(right));
        }
    }

    public static long memoise(long n) {
        char digits[] = String.valueOf(n).toCharArray();
        int length = digits.length;

        long dp[][][] = new long[length][2][2]; // length,tight,flag -> seen 3 ? 1 : 0
        for (long row[][] : dp) {
            for (long col[] : row) {
                Arrays.fill(col, -1);
            }
        }

        return solve(0, 1, 0, digits, dp);
    }

    public static long solve(int pos, int tight, int flag, char digits[], long dp[][][]) {
        if (pos == digits.length) {
            return flag;
        }

        if (dp[pos][tight][flag] != -1) {
            return dp[pos][tight][flag];
        }

        int limit = (tight == 1 ? digits[pos] - '0' : 9);
        long ans = 0;

        for (int d = 0; d <= limit; d++) {
            int newFlag = (flag == 1 || d == 3 ? 1 : 0);
            int newTight = (tight == 1 && d == limit ? 1 : 0);

            ans += solve(pos + 1, newTight, newFlag, digits, dp);
        }

        return dp[pos][tight][flag] = ans;
    }
}
