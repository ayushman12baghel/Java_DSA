import java.util.*;

// Approach 1 Using Memoisation O(n) LIS
class Solution {
    public int minimumDeletions(String s) {
        int dp[][] = new int[s.length()][3];
        for (int row[] : dp) {
            Arrays.fill(row, -1);
        }

        return s.length() - solve(s, 0, -1, dp);
    }

    public int solve(String s, int index, int prevChar, int dp[][]) {
        if (index >= s.length()) {
            return 0;
        }

        if (dp[index][prevChar + 1] != -1) {
            return dp[index][prevChar + 1];
        }

        int skip = solve(s, index + 1, prevChar, dp);
        int take = 0;
        int current = (int) (s.charAt(index) - 'a');

        if (prevChar == -1 || current >= prevChar) {
            take = 1 + solve(s, index + 1, current, dp);
        }

        return dp[index][prevChar + 1] = Math.max(take, skip);
    }
}

// Approach 2 Tabulation O(n)
class Solution {
    public int minimumDeletions(String s) {
        int n = s.length();

        int dp[][] = new int[n + 1][3];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j <= 2; j++) {
                int skip = dp[i + 1][j];
                int take = 0;
                int current = (s.charAt(i) - 'a') + 1;

                if (j == 0 || current >= j) {
                    take = 1 + dp[i + 1][current];
                }

                dp[i][j] = Math.max(take, skip);
            }
        }

        return n - Math.max(dp[0][0], Math.max(dp[0][1], dp[0][2]));
    }
}

// Approach 3 Space Optimised O(n)
class Solution {
    public int minimumDeletions(String s) {
        int n = s.length();

        int dp[] = new int[3];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j <= 2; j++) {
                int skip = dp[j];
                int take = 0;
                int current = (s.charAt(i) - 'a') + 1;

                if (j == 0 || current >= j) {
                    take = 1 + dp[current];
                }

                dp[j] = Math.max(take, skip);
            }
        }

        return n - Math.max(dp[0], Math.max(dp[1], dp[2]));
    }
}

// Approach 4 Greedy O(n)
class Solution {
    public int minimumDeletions(String s) {
        int n = s.length();

        int bCount = 0;
        int minDeletion = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'b') {
                bCount++;
            } else {
                minDeletion = Math.min(minDeletion + 1, bCount);
            }
        }

        return minDeletion;
    }
}