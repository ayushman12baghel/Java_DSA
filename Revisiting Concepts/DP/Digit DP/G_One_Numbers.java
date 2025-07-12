import java.io.*;
import java.util.*;

public class G_One_Numbers {
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

    static boolean isPrime[];

    public static long memoise(long n) {
        char digits[] = String.valueOf(n).toCharArray();
        int length = digits.length;

        long dp[][][] = new long[length][2][9 * length + 1];
        isPrime = new boolean[9 * length + 1];
        fillPrime(9 * length);

        for (long row[][] : dp) {
            for (long col[] : row) {
                Arrays.fill(col, -1);
            }
        }

        return solve(0, 1, 0, digits, dp);
    }

    public static long solve(int pos, int tight, int sum, char digits[], long dp[][][]) {
        if (pos == digits.length) {
            return isPrime[sum] ? 1 : 0;
        }

        if (dp[pos][tight][sum] != -1) {
            return dp[pos][tight][sum];
        }

        int limit = (tight == 1 ? digits[pos] - '0' : 9);
        long ans = 0;

        for (int d = 0; d <= limit; d++) {
            int newTight = (tight == 1 && d == limit ? 1 : 0);
            ans += solve(pos + 1, newTight, sum + d, digits, dp);
        }

        return dp[pos][tight][sum] = ans;
    }

    public static void fillPrime(int n) {
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;

        for (int i = 2; i <= n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    isPrime[j] = false;
                }
            }
        }
    }
}