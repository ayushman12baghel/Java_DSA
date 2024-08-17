import java.util.*;

public class Catalan_number_memoization {
    public static int catalanMemoization(int n, int dp[]) {
        if (n == 0 || n == 1) {
            return 1;
        }
        if (dp[n] != -1) {
            return dp[n];
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans += catalanMemoization(i, dp) * catalanMemoization(n - i - 1, dp);
        }
        return dp[n] = ans;
    }

    public static void main(String[] args) {
        int n = 30;
        int dp[] = new int[n + 1];
        Arrays.fill(dp, -1);

        System.out.println(catalanMemoization(n, dp));
    }
}
