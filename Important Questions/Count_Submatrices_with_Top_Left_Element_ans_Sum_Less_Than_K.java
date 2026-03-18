import java.util.*;

// Approach Using Prefix Sum O(n*m)
class Solution {
    public int countSubmatrices(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;

        int prefix[][] = new int[n][m];
        prefix[0][0] = grid[0][0];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }

                prefix[i][j] = grid[i][j];
                prefix[i][j] += (i > 0 ? prefix[i - 1][j] : 0);
                prefix[i][j] += (j > 0 ? prefix[i][j - 1] : 0);
                prefix[i][j] -= (i > 0 && j > 0 ? prefix[i - 1][j - 1] : 0);
            }
        }

        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (prefix[i][j] <= k) {
                    count++;
                }
            }
        }

        return count;
    }
}

// Approach 2 More Optimised O(n*m)
class Solution {
    public int countSubmatrices(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;

        int prefix[] = new int[m];
        int count = 0;

        for (int i = 0; i < n; i++) {
            int rows = 0;

            for (int j = 0; j < m; j++) {
                prefix[j] += grid[i][j];
                rows += prefix[j];

                if (rows <= k) {
                    count++;
                }
            }
        }

        return count;
    }
}