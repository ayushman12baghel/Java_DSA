import java.util.*;

public class Last_Day_When_You_Can_Still_Cross {

    public static int latestDayToCross(int row, int col, int[][] cells) {
        int left = 0;
        int right = cells.length - 1;
        int lastDay = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (canCross(row, col, mid, cells)) {
                lastDay = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return lastDay + 1;
    }

    public static boolean canCross(int row, int col, int day, int cells[][]) {
        int grid[][] = new int[row][col];
        for (int i = 0; i <= day; i++) {
            int r = cells[i][0] - 1;
            int c = cells[i][1] - 1;

            grid[r][c] = 1;
        }

        for (int j = 0; j < col; j++) {
            if (grid[0][j] == 0 && bfs(grid, 0, j)) {
                return true;
            }
        }

        return false;
    }

    public static boolean bfs(int[][] grid, int startRow, int startCol) {
        int row = grid.length;
        int col = grid[0].length;
        boolean[][] visited = new boolean[row][col];
        int[][] dirs = { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] { startRow, startCol });
        visited[startRow][startCol] = true;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int r = curr[0];
            int c = curr[1];

            // Reached bottom row
            if (r == row - 1)
                return true;

            for (int[] d : dirs) {
                int nr = r + d[0];
                int nc = c + d[1];

                if (nr >= 0 && nr < row && nc >= 0 && nc < col && !visited[nr][nc] && grid[nr][nc] == 0) {
                    visited[nr][nc] = true;
                    queue.offer(new int[] { nr, nc });
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int row = 2, col = 2;
        int cells[][] = { { 1, 1 }, { 2, 1 }, { 1, 2 }, { 2, 2 } };

        System.out.println(latestDayToCross(row, col, cells));
    }
}
