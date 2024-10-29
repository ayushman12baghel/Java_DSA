public class Maximum_Number_of_moves_in_a_grid {

    // backtrack failed 4 test cases
    public static int maxMoves(int grid[][]) {
        int maxCount = 0;
        for (int row = 0; row < grid.length; row++) {
            maxCount = Math.max(maxCount, backtrack(grid, row, 0, 0));
        }

        return maxCount;
    }

    public static int backtrack(int grid[][], int row, int col, int count) {
        if (row < 0 || row >= grid.length || col >= grid[0].length) {
            return count;
        }

        int directions[][] = { { -1, 1 }, { 0, 1 }, { 1, 1 } };
        int maxMoves = count;

        for (int direction[] : directions) {
            int newRow = row + direction[0];
            int newCol = col + direction[1];

            if (newRow >= 0 && newRow < grid.length && newCol < grid[0].length
                    && grid[row][col] < grid[newRow][newCol]) {
                maxMoves = Math.max(maxMoves, backtrack(grid, newRow, newCol, count + 1));
            }
        }

        return maxMoves;
    }

    public static int maxMoves2(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int dp[][] = new int[n][m];
        int maxMoves = 0;

        for (int col = m - 2; col >= 0; col--) {
            for (int row = 0; row < n; row++) {
                // Check up-right cell
                if (row > 0 && grid[row][col] < grid[row - 1][col + 1]) {
                    dp[row][col] = Math.max(dp[row][col], 1 + dp[row - 1][col + 1]);
                }
                // Check right cell
                if (grid[row][col] < grid[row][col + 1]) {
                    dp[row][col] = Math.max(dp[row][col], 1 + dp[row][col + 1]);
                }
                // Check down-right cell
                if (row < n - 1 && grid[row][col] < grid[row + 1][col + 1]) {
                    dp[row][col] = Math.max(dp[row][col], 1 + dp[row + 1][col + 1]);
                }
            }
        }

        for (int row = 0; row < n; row++) {
            maxMoves = Math.max(maxMoves, dp[row][0]);
        }

        return maxMoves;
    }

    public static void main(String args[]) {
        int grid[][] = { { 2, 4, 3, 5 }, { 5, 4, 9, 3 }, { 3, 4, 2, 11 }, { 10, 9, 13, 15 } };

        System.out.println(maxMoves(grid));
        System.out.println(maxMoves2(grid));
    }
}
