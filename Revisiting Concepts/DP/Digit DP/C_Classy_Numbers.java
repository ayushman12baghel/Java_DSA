import java.io.*;
import java.util.*;

public class C_Classy_Numbers {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            String[] parts = br.readLine().split(" ");
            long left = Long.parseLong(parts[0]);
            long right = Long.parseLong(parts[1]);

            long leftAns = memoise(left - 1);
            long rightAns = memoise(right);

            System.out.println(rightAns - leftAns);
        }
    }

    public static long memoise(long n) {
        char digits[] = String.valueOf(n).toCharArray();
        int length = digits.length;

        long dp[][][] = new long[length][2][length + 1];
        for (long row[][] : dp) {
            for (long col[] : row) {
                Arrays.fill(col, -1);
            }
        }

        return solve(0, 1, 0, digits, dp);
    }

    public static long solve(int pos, int tight, int nonZero, char digits[], long dp[][][]) {
        if (nonZero > 3) {
            return 0;
        }

        if (pos == digits.length) {
            return 1;
        }

        if (dp[pos][tight][nonZero] != -1) {
            return dp[pos][tight][nonZero];
        }

        int limit = (tight == 1 ? digits[pos] - '0' : 9);
        long ans = 0;

        for (int d = 0; d <= limit; d++) {
            int newTight = (tight == 1 && d == limit ? 1 : 0);
            ans += solve(pos + 1, newTight, nonZero + (d == 0 ? 0 : 1), digits, dp);
        }

        return dp[pos][tight][nonZero] = ans;
    }
}
