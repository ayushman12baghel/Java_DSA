import java.util.*;

// Approach Using Difference Array 2D O(n^2)
class Solution {
    public int[][] rangeAddQueries(int n, int[][] queries) {
        int diff[][] = new int[n][n];
        for (int query[] : queries) {
            int row1 = query[0];
            int col1 = query[1];
            int row2 = query[2];
            int col2 = query[3];

            diff[row1][col1] += 1;

            if (row2 + 1 < n)
                diff[row2 + 1][col1] -= 1;
            if (col2 + 1 < n)
                diff[row1][col2 + 1] -= 1;

            if (row2 + 1 < n && col2 + 1 < n)
                diff[row2 + 1][col2 + 1] += 1;
        }

        int ans[][] = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                ans[i][j] = diff[i][j];
                if (i > 0)
                    ans[i][j] += ans[i - 1][j];
                if (j > 0)
                    ans[i][j] += ans[i][j - 1];
                if (i > 0 && j > 0)
                    ans[i][j] -= ans[i - 1][j - 1];
            }
        }

        return ans;
    }
}

// Approach 2 Using 1d Difference Array
class Solution {
    public int[][] rangeAddQueries(int n, int[][] queries) {
        int diff[][] = new int[n][n];
        for (int query[] : queries) {
            int row1 = query[0];
            int col1 = query[1];
            int row2 = query[2];
            int col2 = query[3];

            for (int i = row1; i <= row2; i++) {
                diff[i][col1] += 1;

                if (col2 + 1 < n)
                    diff[i][col2 + 1] -= 1;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 1; j < n; j++) {
                diff[i][j] += diff[i][j - 1];
            }
        }

        return diff;
    }
}