import java.util.*;

// Approach 1 Using Memoisation O(n^3)
class Solution {
    public int cherryPickup(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int dp[][][] = new int[n][m][m];
        for (int plane[][] : dp) {
            for (int row[] : plane) {
                Arrays.fill(row, Integer.MIN_VALUE);
            }
        }

        return solve(grid, 0, 0, m - 1, dp);
    }

    public int solve(int grid[][], int r, int c1, int c2, int dp[][][]) {
        int n = grid.length;
        int m = grid[0].length;

        if (r >= n || c1 >= m || c2 >= m || c1 < 0 || c2 < 0) {
            return Integer.MIN_VALUE / 2;
        }

        int curr;
        if (c1 == c2) {
            curr = grid[r][c1];
        } else {
            curr = grid[r][c1] + grid[r][c2];
        }

        if (r == n - 1) {
            return curr;
        }

        if (dp[r][c1][c2] != Integer.MIN_VALUE) {
            return dp[r][c1][c2];
        }

        int bestNext = Integer.MIN_VALUE / 2;
        for (int move1 = -1; move1 <= 1; move1++) {
            for (int move2 = -1; move2 <= 1; move2++) {
                bestNext = Math.max(bestNext, solve(grid, r + 1, c1 + move1, c2 + move2, dp));
            }
        }

        return dp[r][c1][c2] = curr + bestNext;
    }
}

// Approach 2 Bottom Up O(n^3)
class Solution {
    public int cherryPickup(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int dp[][][] = new int[n][m][m];
        for (int plane[][] : dp) {
            for (int row[] : plane) {
                Arrays.fill(row, Integer.MIN_VALUE);
            }
        }

        dp[0][0][m - 1] = (n == 1) ? grid[0][0] : grid[0][0] + grid[0][m - 1];

        for (int row = 1; row < n; row++) {
            for (int c1 = 0; c1 <= Math.min(row, m - 1); c1++) {
                for (int c2 = Math.max(0, m - row - 1); c2 < m; c2++) {

                    int curr = (c1 == c2 ? grid[row][c1] : grid[row][c1] + grid[row][c2]);

                    int prevMax = Integer.MIN_VALUE / 2;
                    for (int move1 = Math.max(0, c1 - 1); move1 <= Math.min(m - 1, c1 + 1); move1++) {
                        for (int move2 = Math.max(0, c2 - 1); move2 <= Math.min(m - 1, c2 + 1); move2++) {
                            prevMax = Math.max(prevMax, dp[row - 1][move1][move2]);
                        }
                    }

                    dp[row][c1][c2] = curr + prevMax;
                }
            }
        }

        int result = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                result = Math.max(result, dp[n - 1][i][j]);
            }
        }

        return result;
    }
}

// Approach 3 Using 2d DP O(n^3)
class Solution {
    public int cherryPickup(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int prev[][] = new int[m][m];

        prev[0][m - 1] = (n == 1) ? grid[0][0] : grid[0][0] + grid[0][m - 1];

        for (int row = 1; row < n; row++) {
            int current[][] = new int[m][m];
            for (int c1 = 0; c1 <= Math.min(row, m - 1); c1++) {
                for (int c2 = Math.max(0, m - row - 1); c2 < m; c2++) {

                    int curr = (c1 == c2 ? grid[row][c1] : grid[row][c1] + grid[row][c2]);

                    int prevMax = Integer.MIN_VALUE / 2;
                    for (int move1 = Math.max(0, c1 - 1); move1 <= Math.min(m - 1, c1 + 1); move1++) {
                        for (int move2 = Math.max(0, c2 - 1); move2 <= Math.min(m - 1, c2 + 1); move2++) {
                            prevMax = Math.max(prevMax, prev[move1][move2]);
                        }
                    }

                    current[c1][c2] = curr + prevMax;
                }
            }

            prev = current;
        }

        int result = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                result = Math.max(result, prev[i][j]);
            }
        }

        return result;
    }
}