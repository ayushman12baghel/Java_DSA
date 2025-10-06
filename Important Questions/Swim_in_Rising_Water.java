import java.util.*;

//O(logn*(n^2))
class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        boolean visited[][] = new boolean[n][m];
        pq.offer(new int[] { 0, 0, grid[0][0] });
        visited[0][0] = true;
        int directions[][] = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

        while (!pq.isEmpty()) {
            int current[] = pq.poll();
            int row = current[0];
            int col = current[1];
            int height = current[2];

            if (row == n - 1 && col == m - 1) {
                return height;
            }

            for (int direction[] : directions) {
                int newRow = row + direction[0];
                int newCol = col + direction[1];

                if (newRow >= 0 && newCol >= 0 && newRow < n && newCol < m && !visited[newRow][newCol]) {
                    int newHeight = Math.max(height, grid[newRow][newCol]);
                    visited[newRow][newCol] = true;
                    pq.offer(new int[] { newRow, newCol, newHeight });
                }
            }
        }

        return Integer.MAX_VALUE;
    }
}