import java.util.*;

// Approach 1 Using DFS O(n*n)
class Solution {
    int directions[][] = { { -2, -1 }, { -2, 1 }, { -1, 2 }, { 1, 2 }, { 2, 1 }, { 2, -1 }, { 1, -2 }, { -1, -2 } };

    public boolean checkValidGrid(int[][] grid) {
        return solve(grid, 0, 0, 0);
    }

    public boolean solve(int grid[][], int row, int col, int current) {
        int n = grid.length;

        if (row >= n || col >= n || row < 0 || col < 0 || grid[row][col] != current) {
            return false;
        }

        if (current == n * n - 1) {
            return true;
        }

        for (int direction[] : directions) {
            if (solve(grid, direction[0] + row, direction[1] + col, current + 1)) {
                return true;
            }
        }

        return false;
    }
}

// Approach 2 BFS O(n*n)
class Solution {
    public boolean checkValidGrid(int[][] grid) {
        if (grid[0][0] != 0) {
            return false;
        }
        int n = grid.length;
        int exp = n * n - 1;

        Queue<int[]> queue = new ArrayDeque<>();
        int directions[][] = { { -2, -1 }, { -2, 1 }, { -1, 2 }, { 1, 2 }, { 2, 1 }, { 2, -1 }, { 1, -2 }, { -1, -2 } };
        queue.offer(new int[] { 0, 0, 0 });

        while (!queue.isEmpty()) {
            int current[] = queue.poll();
            int row = current[0];
            int col = current[1];
            int value = current[2];

            if (value == exp) {
                return true;
            }

            for (int direction[] : directions) {
                int newRow = row + direction[0];
                int newCol = col + direction[1];

                if (newRow >= 0 && newCol >= 0 && newRow < n && newCol < n && grid[newRow][newCol] == value + 1) {
                    queue.offer(new int[] { newRow, newCol, value + 1 });
                }
            }
        }

        return false;
    }
}