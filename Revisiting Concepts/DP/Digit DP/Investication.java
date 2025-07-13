import java.util.Scanner;
import java.util.*;

//here some of digits should be divisible by k and number is also divisible ny k in range left to right

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int tc = 1; tc <= T; tc++) {
            int A = sc.nextInt();
            int B = sc.nextInt();
            int K = sc.nextInt();
            int answer = memoise(B, K) - memoise(A - 1, K);

            // Print the result
            System.out.println("Case " + tc + ": " + answer);
        }

        sc.close();
    }

    public static int memoise(int n, int k) {
        char digits[] = String.valueOf(n).toCharArray();
        int length = digits.length;

        int dp[][][][] = new int[length][2][k][length * 9 + 1];
        for (int row[][][] : dp) {
            for (int col[][] : row) {
                for (int temp[] : col) {
                    Arrays.fill(temp, -1);
                }
            }
        }

        return solve(0, 1, 0, 0, k, digits, dp);
    }

    public static int solve(int pos, int tight, int mod, int sum, int k, char digits[], int dp[][][][]) {
        if (pos == digits.length) {
            return (sum % k == 0 && mod == 0) ? 1 : 0;
        }

        if (dp[pos][tight][mod][sum] != -1) {
            return dp[pos][tight][mod][sum];
        }

        int limit = (tight == 1 ? digits[pos] - '0' : 9);
        int ans = 0;

        for (int d = 0; d <= limit; d++) {
            int newTight = (tight == 1 && d == limit ? 1 : 0);
            int newMod = (mod * 10 + d) % k;

            ans += solve(pos + 1, newTight, newMod, sum + d, k, digits, dp);
        }

        return dp[pos][tight][mod][sum] = ans;
    }
}
