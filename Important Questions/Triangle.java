import java.util.*;

//Approach Using Memoisation O(n^2)
// O(n^2) space
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int dp[][] = new int[n][n];
        for (int row[] : dp) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        return triangle.get(0).get(0) + Math.min(solve(triangle, 1, 0, dp), solve(triangle, 1, 1, dp));
    }

    public int solve(List<List<Integer>> triangle, int rowIndex, int colIndex, int dp[][]) {
        int n = triangle.size();
        if (rowIndex >= n || colIndex >= triangle.get(rowIndex).size()) {
            return 0;
        }

        if (dp[rowIndex][colIndex] != Integer.MAX_VALUE) {
            return dp[rowIndex][colIndex];
        }

        return dp[rowIndex][colIndex] = triangle.get(rowIndex).get(colIndex) + Math
                .min(solve(triangle, rowIndex + 1, colIndex, dp), solve(triangle, rowIndex + 1, colIndex + 1, dp));
    }
}

// Approach 2 Tabulation O(n^2)
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();

        int dp[][] = new int[n][n];
        dp[0][0] = triangle.get(0).get(0);

        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                int value = triangle.get(i).get(j);
                if (j == 0) {
                    dp[i][j] = dp[i - 1][j] + value;
                } else if (i == j) {
                    dp[i][j] = dp[i - 1][j - 1] + value;
                } else {
                    dp[i][j] = value + Math.min(dp[i - 1][j - 1], dp[i - 1][j]);
                }
            }
        }

        int minValue = Integer.MAX_VALUE;
        for (int j = 0; j < n; j++) {
            minValue = Math.min(minValue, dp[n - 1][j]);
        }

        return minValue;
    }
}

// Approach 3 Storing previous Row O(n) space
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();

        int current[] = new int[n];
        int prev[] = new int[n];
        prev[0] = triangle.get(0).get(0);

        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                int val = triangle.get(i).get(j);
                if (j == 0) {
                    current[j] = prev[j] + val;
                } else if (i == j) {
                    current[j] = prev[j - 1] + val;
                } else {
                    current[j] = val + Math.min(prev[j], prev[j - 1]);
                }
            }

            for (int k = 0; k < n; k++) {
                prev[k] = current[k];
            }
        }

        int minValue = Integer.MAX_VALUE;
        for (int j = 0; j < n; j++) {
            minValue = Math.min(minValue, prev[j]);
        }

        return minValue;
    }
}