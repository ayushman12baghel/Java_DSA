import java.util.*;

public class Climbing_Stairs {

    // Approach 1 Using Recursion Brute Force -> O(2^n)
    public static int climbStairs(int n) {
        if (n <= 3) {
            return n;
        }

        return climbStairs(n - 1) + climbStairs(n - 2);
    }

    // Approach 2 Using Memoisation
    public static int climbStairs2(int n) {
        int dp[] = new int[n + 1];
        Arrays.fill(dp, -1);

        return solve(n, dp);
    }

    public static int solve(int n, int dp[]) {
        if (n <= 3) {
            return n;
        }

        if (dp[n] != -1) {
            return dp[n];
        }

        return dp[n] = solve(n - 1, dp) + solve(n - 2, dp);
    }

    // Appraoch 3 Using Tabulation
    public static int climbStairs3(int n) {
        if (n <= 3) {
            return n;
        }

        int dp[] = new int[n + 1];

        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }

    // Approach 4 Using constant Space
    public static int climbStairs4(int n) {
        if (n <= 3) {
            return n;
        }

        int prev = 2;
        int morePrev = 1;
        int ans = 0;

        for (int i = 3; i <= n; i++) {
            ans = prev + morePrev;
            morePrev = prev;
            prev = ans;
        }

        return ans;
    }

    public static void main(String args[]) {
        int n = 40;
        System.out.println(climbStairs(n));
        System.out.println(climbStairs4(n));
        System.out.println(climbStairs2(n));
        System.out.println(climbStairs3(n));
    }
}
