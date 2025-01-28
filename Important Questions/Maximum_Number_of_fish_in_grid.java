import java.util.*;

public class Maximum_Number_of_fish_in_grid {

    static int directions[][] = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

    // BFS
    public static int findMaxFish(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int maxCount = 0;

        int directions[][] = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] != 0) {
                    maxCount = Math.max(maxCount, bfs(i, j, grid));
                }
            }
        }

        return maxCount;
    }

    public static int bfs(int i, int j, int grid[][]) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] { i, j });
        int count = grid[i][j];
        grid[i][j] = 0;

        while (!queue.isEmpty()) {
            int current[] = queue.poll();
            int row = current[0];
            int col = current[1];

            for (int direction[] : directions) {
                int newRow = direction[0] + row;
                int newCol = direction[1] + col;

                if (newRow >= 0 && newCol >= 0 && newRow < grid.length && newCol < grid[0].length
                        && grid[newRow][newCol] != 0) {
                    queue.offer(new int[] { newRow, newCol });
                    count += grid[newRow][newCol];
                    grid[newRow][newCol] = 0;
                }
            }
        }

        return count;
    }

    // DFS
    public static int dfs(int i, int j, int grid[][]) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0) {
            return 0;
        }

        int count = 0;
        count += grid[i][j];
        grid[i][j] = 0;

        for (int direction[] : directions) {
            int newRow = direction[0] + i;
            int newCol = direction[1] + j;

            count += dfs(newRow, newCol, grid);
        }

        return count;
    }

    public static void main(String args[]) {
        int grid[][] = { { 0, 2, 1, 0 }, { 4, 0, 0, 3 }, { 1, 0, 0, 4 }, { 0, 3, 2, 0 } };

        System.out.println(findMaxFish(grid));
    }
}
