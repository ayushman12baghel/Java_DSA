import java.util.*;

//Approach Using Prefix Sum O(n*m*min(n,m))
class Solution {
    public int countSquare(int[][] grid, int x) {
        int n = grid.length;
        int m = grid[0].length;

        int prefix[][] = new int[n][m];
        prefix[0][0] = grid[0][0];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }

                if (i > 0) {
                    prefix[i][j] += prefix[i - 1][j];
                }

                if (j > 0) {
                    prefix[i][j] += prefix[i][j - 1];
                }

                if (i > 0 && j > 0) {
                    prefix[i][j] -= prefix[i - 1][j - 1];
                }

                prefix[i][j] += grid[i][j];
            }
        }

        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int maxSize = Math.min(n - i, m - j);

                for (int k = 0; k < maxSize; k++) {
                    int r = i + k;
                    int c = j + k;

                    int sum = 0;
                    sum = prefix[r][c];

                    if (i > 0) {
                        sum -= prefix[i - 1][c];
                    }

                    if (j > 0) {
                        sum -= prefix[r][j - 1];
                    }

                    if (i > 0 && j > 0) {
                        sum += prefix[i - 1][j - 1];
                    }

                    if (sum == x) {
                        count++;
                    }
                }
            }
        }

        return count;
    }
}
