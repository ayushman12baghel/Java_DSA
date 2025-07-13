import java.util.Arrays;

public class Count_of_Integers {

    static int mod = 1000000007;

    public static int count(String num1, String num2, int min_sum, int max_sum) {
        long rightAns = memoise(num2, min_sum, max_sum);
        long leftAns = memoise(decrementByOne(num1), min_sum, max_sum);

        return (int) ((rightAns - leftAns + mod) % mod);
    }

    // Helper function to decrement a number string by 1
    private static String decrementByOne(String num) {
        char[] digits = num.toCharArray();
        int i = digits.length - 1;

        // Handle the decrement
        while (i >= 0 && digits[i] == '0') {
            digits[i] = '9';
            i--;
        }

        if (i >= 0) {
            digits[i]--;
        }

        // Remove leading zeros
        String result = new String(digits);
        int start = 0;
        while (start < result.length() && result.charAt(start) == '0') {
            start++;
        }

        return start == result.length() ? "0" : result.substring(start);
    }

    public static long memoise(String n, int minSum, int maxSum) {
        char digits[] = n.toCharArray();
        int length = digits.length;

        long dp[][][] = new long[length][2][length * 9 + 1];
        for (long row[][] : dp) {
            for (long col[] : row) {
                Arrays.fill(col, -1);
            }
        }

        return solve(0, 1, 0, minSum, maxSum, digits, dp);
    }

    public static long solve(int pos, int tight, int sum, int minSum, int maxSum, char digits[], long dp[][][]) {
        if (pos == digits.length) {
            return (sum >= minSum && sum <= maxSum ? 1 : 0);
        }

        if (dp[pos][tight][sum] != -1) {
            return dp[pos][tight][sum];
        }

        int limit = (tight == 1 ? digits[pos] - '0' : 9);
        long ans = 0;

        for (int d = 0; d <= limit; d++) {
            int newTight = (tight == 1 && d == limit ? 1 : 0);
            ans = (ans + solve(pos + 1, newTight, sum + d, minSum, maxSum, digits, dp)) % mod;
        }

        return dp[pos][tight][sum] = ans;
    }

    public static void main(String[] args) {
        String num1 = "1", num2 = "12";
        int min_sum = 1, max_sum = 8;

        System.out.println(count(num1, num2, min_sum, max_sum));
    }
}
