import java.util.*;

//Approach 1 Using Memoisation O(n*26*26)
class Solution {
    public int minimumDistance(String word) {
        int dp[][][] = new int[word.length()][27][27];
        for (int plane[][] : dp) {
            for (int row[] : plane) {
                Arrays.fill(row, -1);
            }
        }

        return solve(word, 0, -1, -1, dp);
    }

    public int solve(String word, int index, int finger1, int finger2, int dp[][][]) {
        if (index >= word.length()) {
            return 0;
        }

        if (dp[index][finger1 + 1][finger2 + 1] != -1) {
            return dp[index][finger1 + 1][finger2 + 1];
        }

        int current = (int) (word.charAt(index) - 'A');
        int currentX = current / 6;
        int currentY = current % 6;

        int fig1X = finger1 == -1 ? currentX : finger1 / 6;
        int fig1Y = finger1 == -1 ? currentY : finger1 % 6;

        int fig2X = finger2 == -1 ? currentX : finger2 / 6;
        int fig2Y = finger2 == -1 ? currentY : finger2 % 6;
        int result = Integer.MAX_VALUE;

        result = solve(word, index + 1, current, finger2, dp) + Math.abs(fig1X - currentX) + Math.abs(fig1Y - currentY);
        result = Math.min(result,
                solve(word, index + 1, finger1, current, dp) + Math.abs(fig2X - currentX) + Math.abs(fig2Y - currentY));

        return dp[index][finger1 + 1][finger2 + 1] = result;
    }
}

// Approach 2 Tabulation
class Solution {
    public int minimumDistance(String word) {
        int n = word.length();
        int dp[][][] = new int[n + 1][27][27];

        for (int index = n - 1; index >= 0; index--) {
            for (int finger1 = -1; finger1 < 26; finger1++) {
                for (int finger2 = -1; finger2 < 26; finger2++) {
                    int current = (int) (word.charAt(index) - 'A');
                    int currentX = current / 6;
                    int currentY = current % 6;

                    int fig1X = finger1 == -1 ? currentX : finger1 / 6;
                    int fig1Y = finger1 == -1 ? currentY : finger1 % 6;

                    int fig2X = finger2 == -1 ? currentX : finger2 / 6;
                    int fig2Y = finger2 == -1 ? currentY : finger2 % 6;
                    int result = Integer.MAX_VALUE;

                    result = dp[index + 1][current + 1][finger2 + 1] + Math.abs(fig1X - currentX)
                            + Math.abs(fig1Y - currentY);
                    result = Math.min(result, dp[index + 1][finger1 + 1][current + 1] + Math.abs(fig2X - currentX)
                            + Math.abs(fig2Y - currentY));

                    dp[index][finger1 + 1][finger2 + 1] = result;
                }
            }
        }

        return dp[0][0][0];
    }
}