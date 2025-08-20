import java.util.*;

public class Count_Squrare_Submatrixes_With_All_One {

    // Approach Doing Recursion + Memoisation O(n*m)
    public static int countSquares(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int dp[][] = new int[n][m];
        for (int row[] : dp) {
            Arrays.fill(row, -1);
        }

        int ans = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                ans += solve(matrix, i, j, dp);
            }
        }

        return ans;
    }

    public static int solve(int matrix[][], int i, int j, int dp[][]) {
        if (i >= matrix.length || j >= matrix[0].length) {
            return 0;
        }

        if (matrix[i][j] == 0) {
            return dp[i][j] = 0;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        return dp[i][j] = 1 + Math.min(solve(matrix, i + 1, j, dp),
                Math.min(solve(matrix, i, j + 1, dp), solve(matrix, i + 1, j + 1, dp)));
    }

    public static int countSquares2(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int dp[][] = new int[n][m];

        int ans = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0) {
                    dp[i][j] = 0;
                } else if (i == 0 || j == 0) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1]));
                }

                ans += dp[i][j];
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int matrix[][] = {
                { 0, 1, 1, 1 },
                { 1, 1, 1, 1 },
                { 0, 1, 1, 1 }
        };

        System.out.println(countSquares(matrix));
        System.out.println(countSquares2(matrix));
    }
}
