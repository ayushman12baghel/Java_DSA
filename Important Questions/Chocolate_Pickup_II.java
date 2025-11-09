import java.util.*;

//Using Recursion T.L.E O(16^n)
class Solution {
    public int chocolatePickup(int[][] grid) {
        int n = grid.length;

        return Math.max(0, solve(grid, 0, 0, 0, 0));
    }

    public int solve(int grid[][], int r1, int c1, int r2, int c2) {
        int n = grid.length;

        if (r1 >= n || r2 >= n || c1 >= n || c2 >= n) {
            return Integer.MIN_VALUE / 2;
        }

        if (grid[r1][c1] == -1 || grid[r2][c2] == -1) {
            return Integer.MIN_VALUE / 2;
        }
        if (r1 == n - 1 && c1 == n - 1) {
            return grid[r1][c1];
        }

        int curr;
        if (r1 == r2 && c1 == c2) {
            curr = grid[r1][c1];
        } else {
            curr = grid[r1][c1] + grid[r2][c2];
        }

        int bestNext = Integer.MIN_VALUE / 2;

        bestNext = Math.max(bestNext, solve(grid, r1 + 1, c1, r2 + 1, c2));
        bestNext = Math.max(bestNext, solve(grid, r1 + 1, c1, r2, c2 + 1));
        bestNext = Math.max(bestNext, solve(grid, r1, c1 + 1, r2 + 1, c2));
        bestNext = Math.max(bestNext, solve(grid, r1, c1 + 1, r2, c2 + 1));

        return curr + bestNext;
    }
}

// Approach Using Memoisation O(n*n*n)
class Solution {
    public int chocolatePickup(int[][] grid) {
        int n = grid.length;
        int dp[][][] = new int[n][n][n];

        for (int plane[][] : dp) {
            for (int row[] : plane) {
                Arrays.fill(row, -1);
            }
        }

        return Math.max(0, solve(grid, 0, 0, 0, dp));
    }

    public int solve(int grid[][], int r1, int c1, int r2, int dp[][][]) {
        int n = grid.length;
        int c2 = (r1 + c1) - r2;

        if (r1 >= n || r2 >= n || c1 >= n || c2 >= n || grid[r1][c1] == -1 || grid[r2][c2] == -1) {
            return Integer.MIN_VALUE / 2;
        }

        if (r1 == n - 1 && c1 == n - 1) {
            return grid[r1][c1];
        }

        if (dp[r1][c1][r2] != -1) {
            return dp[r1][c1][r2];
        }

        int curr;
        if (r1 == r2 && c1 == c2) {
            curr = grid[r1][c1];
        } else {
            curr = grid[r1][c1] + grid[r2][c2];
        }

        int bestNext = Integer.MIN_VALUE / 2;

        bestNext = Math.max(bestNext, solve(grid, r1 + 1, c1, r2 + 1, dp));
        bestNext = Math.max(bestNext, solve(grid, r1 + 1, c1, r2, dp));
        bestNext = Math.max(bestNext, solve(grid, r1, c1 + 1, r2 + 1, dp));
        bestNext = Math.max(bestNext, solve(grid, r1, c1 + 1, r2, dp));

        return dp[r1][c1][r2] = curr + bestNext;
    }
}

// Approach 2 Using Tabulation O(n^3)
class Solution {
    public int chocolatePickup(int[][] grid) {
        int n = grid.length;
        if (grid[0][0] == -1 || grid[n - 1][n - 1] == -1) {
            return 0;
        }

        int dp[][][] = new int[n][n][n];
        int NEG_INF = Integer.MIN_VALUE / 2;
        for (int plane[][] : dp) {
            for (int row[] : plane) {
                Arrays.fill(row, Integer.MIN_VALUE);
            }
        }

        dp[0][0][0] = grid[0][0];

        for (int r1 = 0; r1 < n; r1++) {
            for (int c1 = 0; c1 < n; c1++) {
                for (int r2 = 0; r2 < n; r2++) {
                    if (r1 == 0 && c1 == 0) {
                        continue;
                    }

                    int c2 = (r1 + c1 - r2);
                    if (c2 < 0 || c2 >= n || grid[r1][c1] == -1 || grid[r2][c2] == -1) {
                        continue;
                    }

                    int curr;
                    if (r1 == r2 && c1 == c2) {
                        curr = grid[r1][c1];
                    } else {
                        curr = grid[r1][c1] + grid[r2][c2];
                    }

                    int bestNext = NEG_INF;
                    if (r1 > 0 && r2 > 0) {
                        bestNext = Math.max(bestNext, dp[r1 - 1][c1][r2 - 1]);
                    }
                    if (r1 > 0 && c2 > 0) {
                        bestNext = Math.max(bestNext, dp[r1 - 1][c1][r2]);
                    }
                    if (c1 > 0 && r2 > 0) {
                        bestNext = Math.max(bestNext, dp[r1][c1 - 1][r2 - 1]);
                    }
                    if (c1 > 0 && c2 > 0) {
                        bestNext = Math.max(bestNext, dp[r1][c1 - 1][r2]);
                    }

                    dp[r1][c1][r2] = curr + bestNext;
                }
            }
        }

        return Math.max(0, dp[n - 1][n - 1][n - 1]);
    }
}
