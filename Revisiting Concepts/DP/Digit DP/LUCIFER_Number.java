import java.io.*;
import java.util.*;

public class LUCIFER_Number {
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

        long dp[][][][] = new long[length][2][length * 9 + 1][length * 9 + 1];
        for (long row[][][] : dp) {
            for (long col[][] : row) {
                for (long temp[] : col) {
                    Arrays.fill(temp, -1);
                }
            }
        }

        isPrime = new boolean[length * 9 + 1];
        fillPrime(length * 9);

        return solve(0, 1, 0, 0, digits, dp);
    }

    public static long solve(int pos, int tight, int sumOdd, int sumEven, char digits[], long dp[][][][]) {
        if (pos == digits.length) {
            return isPrime[Math.abs(sumEven - sumOdd)] ? 1 : 0;
        }

        if (dp[pos][tight][sumOdd][sumEven] != -1) {
            return dp[pos][tight][sumOdd][sumEven];
        }

        int limit = (tight == 1 ? digits[pos] - '0' : 9);
        long ans = 0;

        for (int d = 0; d <= limit; d++) {
            int newSumOdd = ((pos + 1) % 2 == 1 ? sumOdd + d : sumOdd);
            int newSumEven = ((pos + 1) % 2 == 0 ? sumEven + d : sumEven);

            int newTight = (tight == 1 && d == limit ? 1 : 0);

            ans += solve(pos + 1, newTight, newSumOdd, newSumEven, digits, dp);
        }

        return dp[pos][tight][sumOdd][sumEven] = ans;
    }

    public static void fillPrime(int n) {
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;

        for (int i = 2; i <= n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    isPrime[j] = false;
                }
            }
        }
    }
}