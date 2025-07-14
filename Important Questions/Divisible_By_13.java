import java.util.*;

public class Divisible_By_13 {

    // Memoisation
    public static boolean divby13(String s) {
        char digits[] = s.toCharArray();
        int length = digits.length;

        int dp[][] = new int[length][13];
        for (int row[] : dp) {
            Arrays.fill(row, -1);
        }

        return solve(0, 0, 13, digits, dp) == 1;
    }

    public static int solve(int pos, int mod, int k, char digits[], int dp[][]) {
        if (pos == digits.length) {
            return mod == 0 ? 1 : 0;
        }

        if (dp[pos][mod] != -1) {
            return dp[pos][mod];
        }

        int d = digits[pos] - '0';
        int newMod = (mod * 10 + d) % k;

        return dp[pos][mod] = solve(pos + 1, newMod, k, digits, dp);
    }

    public static void main(String[] args) {
        String s = "2911285";

        System.out.println(divby13(s));
    }
}
