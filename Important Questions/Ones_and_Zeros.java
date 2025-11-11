import java.util.*;

//Approach 1 Using Memoisation O(n*m*k)
class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int dp[][][] = new int[strs.length][m + 1][n + 1];
        for (int plane[][] : dp) {
            for (int row[] : plane) {
                Arrays.fill(row, -1);
            }
        }

        return solve(strs, 0, m, n, dp);
    }

    public int solve(String strs[], int index, int m, int n, int dp[][][]) {
        if (index >= strs.length) {
            return 0;
        }

        if (dp[index][m][n] != -1) {
            return dp[index][m][n];
        }

        int countOne = 0;
        int countZero = 0;

        for (int i = 0; i < strs[index].length(); i++) {
            if (strs[index].charAt(i) == '0') {
                countZero++;
            } else if (strs[index].charAt(i) == '1') {
                countOne++;
            }
        }

        int take = 0;
        if (countOne <= n && countZero <= m) {
            take = 1 + solve(strs, index + 1, m - countZero, n - countOne, dp);
        }

        int notTake = solve(strs, index + 1, m, n, dp);

        return dp[index][m][n] = Math.max(take, notTake);
    }
}

// Approach 2 Tabulation O(n*m*k)
class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int dp[][][] = new int[strs.length + 1][m + 1][n + 1];

        for (int i = 1; i <= strs.length; i++) {
            int countOne = 0;
            int countZero = 0;
            String str = strs[i - 1];

            for (char c : str.toCharArray()) {
                if (c == '0') {
                    countZero++;
                } else {
                    countOne++;
                }
            }

            for (int j = 0; j <= m; j++) {
                for (int k = 0; k <= n; k++) {
                    dp[i][j][k] = dp[i - 1][j][k];

                    if (countZero <= j && countOne <= k) {
                        dp[i][j][k] = Math.max(dp[i][j][k], 1 + dp[i - 1][j - countZero][k - countOne]);
                    }
                }
            }
        }

        return dp[strs.length][m][n];
    }
}

// Approach 3 Using 2d DP
class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int dp[][] = new int[m + 1][n + 1];

        for (int i = 1; i <= strs.length; i++) {
            int countOne = 0;
            int countZero = 0;
            String str = strs[i - 1];

            for (char c : str.toCharArray()) {
                if (c == '0') {
                    countZero++;
                } else {
                    countOne++;
                }
            }

            for (int j = m; j >= countZero; j--) {
                for (int k = n; k >= countOne; k--) {

                    if (countZero <= j && countOne <= k) {
                        dp[j][k] = Math.max(dp[j][k], 1 + dp[j - countZero][k - countOne]);
                    }
                }
            }
        }

        return dp[m][n];
    }
}