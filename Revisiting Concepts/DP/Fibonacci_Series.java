import java.util.*;

public class Fibonacci_Series {

    // Approach 1 Using Brute Force O(2^n)
    public static int fib(int n) {
        if (n <= 1) {
            return n;
        }

        return fib(n - 1) + fib(n - 2);
    }

    // Approach 2 By Memoising Approach 1
    public static int fib2(int n) {
        int dp[] = new int[n + 1];
        Arrays.fill(dp, -1);

        return solve(n, dp);
    }

    public static int solve(int n, int dp[]) {
        if (n <= 1) {
            return n;
        }

        if (dp[n] != -1) {
            return dp[n];
        }

        return dp[n] = solve(n - 1, dp) + solve(n - 2, dp);
    }

    // Approach 3 Using Tabulation
    public static int fib3(int n) {
        if (n <= 1) {
            return n;
        }

        int dp[] = new int[n + 1];
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }

    // Constant Space
    public static int fib4(int n) {
        if (n <= 1) {
            return n;
        }

        int prev = 1;
        int morePrev = 0;
        int ans = 0;

        for (int i = 2; i <= n; i++) {
            ans = prev + morePrev;
            morePrev = prev;
            prev = ans;
        }

        return ans;
    }

    public static void main(String args[]) {
        int n = 8;
        System.out.println(fib(n));
        System.out.println(fib2(n));
        System.out.println(fib3(n));
        System.out.println(fib4(n));
    }
}
