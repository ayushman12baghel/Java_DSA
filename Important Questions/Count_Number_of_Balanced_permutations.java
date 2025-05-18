import java.util.Arrays;

public class Count_Number_of_Balanced_permutations {
    static int n;
    static int totalSum;
    static int M = 1000000007;
    static int totalPermutationPossible = 0;

    public static int countBalancedPermutations(String num) {
        n = num.length();
        totalSum = 0;

        int freq[] = new int[10];

        for (char c : num.toCharArray()) {
            totalSum += c - '0';
            freq[c - '0']++;
        }

        if (totalSum % 2 != 0) {
            return 0;
        }

        // PreCompute Factorial;
        long fact[] = new long[n + 1];
        fact[0] = 1;
        fact[1] = 1;
        for (int i = 2; i <= n; i++) {
            fact[i] = (fact[i - 1] * i) % M;
        }

        // PreCompute Fermat's Factorial
        long fermatFact[] = new long[n + 1];
        for (int i = 0; i <= n; i++) {
            fermatFact[i] = findPower(fact[i], M - 2) % M;
        }

        totalPermutationPossible = (int) ((fact[(n + 1) / 2] * fact[n / 2]) % M);

        int digit = 0;
        int evenIndexDigitsCount = 0;
        int currSum = 0;

        int dp[][][] = new int[10][(n + 1) / 2 + 1][totalSum + 1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        return solve(digit, evenIndexDigitsCount, currSum, freq, fermatFact, dp);
    }

    public static int solve(int digit, int evenIndexDigitsCount, int currSum, int freq[], long fermatFact[],
            int dp[][][]) {
        if (digit == 10) {
            if (currSum == totalSum / 2 && evenIndexDigitsCount == (n + 1) / 2) {
                return totalPermutationPossible;
            }
            return 0;
        }

        if (dp[digit][evenIndexDigitsCount][currSum] != -1) {
            return dp[digit][evenIndexDigitsCount][currSum];
        }

        long ways = 0;

        for (int count = 0; count <= Math.min(freq[digit], (n + 1) / 2 - evenIndexDigitsCount); count++) {
            int evenPosCount = count;
            int oddPosCount = freq[digit] - evenPosCount;

            long div = (fermatFact[evenPosCount] * fermatFact[oddPosCount]) % M;

            int val = solve(digit + 1, evenIndexDigitsCount + evenPosCount, currSum + digit * count, freq, fermatFact,
                    dp);

            ways = (ways + (val * div) % M) % M;
        }

        return dp[digit][evenIndexDigitsCount][currSum] = (int) ways;
    }

    // Binary Exponentiation
    public static long findPower(long a, long b) {
        if (b == 0) {
            return 1;
        }

        long half = findPower(a, b / 2);
        long result = (half * half) % M;
        if (b % 2 != 0) {
            result = (result * a) % M;
        }

        return result;
    }

    public static void main(String args[]) {
        String num = "123";

        System.out.println(countBalancedPermutations(num));
    }
}
