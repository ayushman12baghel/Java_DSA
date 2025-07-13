import java.util.*;

public class Number_Of_Beautiful_Integers_in_Range {

    // Approach Using Digit DP Memoised
    public static int numberOfBeautifulIntegers(int low, int high, int k) {
        int leftAns = memoise(low - 1, k);
        int rightAns = memoise(high, k);

        return rightAns - leftAns;
    }

    public static int memoise(int n, int k) {
        char digits[] = String.valueOf(n).toCharArray();
        int length = digits.length;

        int dp[][][][][] = new int[length][2][k][9 * length + 1][9 * length + 1];
        for (int row[][][][] : dp) {
            for (int col[][][] : row) {
                for (int temp[][] : col) {
                    for (int temp2[] : temp) {
                        Arrays.fill(temp2, -1);
                    }
                }
            }
        }

        return solve(0, 1, 0, 0, 0, k, digits, dp);
    }

    public static int solve(int pos, int tight, int mod, int oddCount, int evenCount, int k, char digits[],
            int dp[][][][][]) {
        if (pos == digits.length) {
            return (oddCount == evenCount && oddCount > 0 && mod == 0) ? 1 : 0;
        }

        if (dp[pos][tight][mod][oddCount][evenCount] != -1) {
            return dp[pos][tight][mod][oddCount][evenCount];
        }

        int limit = (tight == 1 ? digits[pos] - '0' : 9);
        int ans = 0;

        for (int d = 0; d <= limit; d++) {
            int newTight = (tight == 1 && d == limit ? 1 : 0);
            int newOddCount = oddCount;
            int newEvenCount = evenCount;

            if (d != 0 || oddCount != 0 || evenCount != 0) {
                if (d % 2 == 0) {
                    newEvenCount++;
                } else {
                    newOddCount++;
                }
            }

            int newMod = (mod * 10 + d) % k;
            ans += solve(pos + 1, newTight, newMod, newOddCount, newEvenCount, k, digits, dp);
        }

        return dp[pos][tight][mod][oddCount][evenCount] = ans;
    }

    public static void main(String[] args) {
        int low = 10, high = 20, k = 3;

        System.out.println(numberOfBeautifulIntegers(low, high, k));
    }
}
