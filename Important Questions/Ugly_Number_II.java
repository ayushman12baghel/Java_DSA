public class Ugly_Number_II {

    // Approach 1 Using DP
    public static int nthUglyNumber(int n) {
        int dp[] = new int[n];
        dp[0] = 1;

        int i2 = 0;
        int i3 = 0;
        int i5 = 0;

        for (int i = 1; i < n; i++) {
            int next2 = dp[i2] * 2;
            int next3 = dp[i3] * 3;
            int next5 = dp[i5] * 5;

            int current = Math.min(next2, Math.min(next3, next5));
            dp[i] = current;

            if (current == next2)
                i2++;
            if (current == next3)
                i3++;
            if (current == next5)
                i5++;
        }

        return dp[n - 1];
    }

    // Approach 2 Using PriorityQueue

    public static void main(String[] args) {
        int n = 10;

        System.out.println(nthUglyNumber(n));
    }
}
