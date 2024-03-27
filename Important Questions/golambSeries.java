
import java.util.*;

class golambSeries {

    public static void printGolomb(int n) {
        int dp[] = new int[n + 1];
        dp[1] = 1;
        System.out.print(dp[1] + " ");
        for (int i = 2; i <= n; i++) {
            dp[i] = 1 + dp[i - dp[dp[i - 1]]];

            System.out.print(dp[i] + " ");
        }
    }

    public static void main(String[] args) {
        int n = 9;

        // printGolomb(n);
        for (int i = 1; i <= n; i++) {
            System.out.print(printGolomb2(i) + " ");
        }
    }

    public static int printGolomb2(int n) {
        if (n == 1) {
            return 1;
        }
        return 1 + printGolomb2(n - printGolomb2(printGolomb2(n - 1)));
    }
}
