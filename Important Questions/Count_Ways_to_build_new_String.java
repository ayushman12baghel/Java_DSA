import java.util.*;

public class Count_Ways_to_build_new_String {

    // Memoisation
    public static int countGoodStrings(int low, int high, int zero, int one) {
        int dp[] = new int[high + 1];
        Arrays.fill(dp, -1);
        return solve(low, high, zero, one, 0, dp);
    }

    static int mod = 1000000007;

    public static int solve(int low, int high, int zero, int one, int length, int dp[]) {
        if (length > high) {
            return 0;
        }

        if (dp[length] != -1) {
            return dp[length];
        }

        boolean add = false;
        if (length >= low && length <= high) {
            add = true;
        }

        int appendOne = solve(low, high, zero, one, length + one, dp);
        int appendZero = solve(low, high, zero, appendOne, length + zero, dp);

        return dp[length] = ((add == true ? 1 : 0) + appendOne + appendZero) % mod;
    }

    // Tabulation
    public static int countGoodStrings2(int low, int high, int zero, int one) {
        int dp[] = new int[high + 1];
        dp[0] = 1;

        for (int i = 1; i < high + 1; i++) {
            if (i - zero >= 0) {
                dp[i] = (dp[i] + dp[i - zero]) % mod;
            }
            if (i - one >= 0) {
                dp[i] = (dp[i] + dp[i - one]) % mod;
            }
        }

        int count = 0;
        for (int i = low; i <= high; i++) {
            count = (count + dp[i]) % mod;
        }

        return count;
    }

    public static void main(String args[]) {
        int low = 3, high = 3, zero = 1, one = 1;
        System.out.println(countGoodStrings(low, high, zero, one));
        System.out.println(countGoodStrings2(low, high, zero, one));
    }
}
