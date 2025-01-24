import java.util.*;
import java.util.LinkedList;

public class Detect_Cycles_in_2D_Grid {

    // DFS
    public static boolean containsCycle(char grid[][]) {
        int n = grid.length;
        int m = grid[0].length;
        boolean visited[][] = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && isCycle(grid, visited, i, j, -1, -1, grid[i][j])) {
                    return true;
                }
            }
        }

        return false;
    }

    public static boolean isCycle(char grid[][], boolean visited[][], int row, int col, int parentRow, int parentCol,
            char target) {
        visited[row][col] = true;

        int directions[][] = { { 1, 0 }, { -1, 0 }, { 0, -1 }, { 0, 1 } };

        for (int direction[] : directions) {
            int newRow = row + direction[0];
            int newCol = col + direction[1];

            if (newRow >= 0 && newCol >= 0 && newRow < grid.length && newCol < grid[0].length
                    && grid[newRow][newCol] == target) {
                if (visited[newRow][newCol] && (newRow != parentRow || newCol != parentCol)) {
                    return true;
                } else if (!visited[newRow][newCol] && isCycle(grid, visited, newRow, newCol, row, col, target)) {
                    return true;
                }
            }
        }

        return false;
    }

    // BFS
    public static boolean containsCycle2(char grid[][]) {
        int n = grid.length;
        int m = grid[0].length;
        boolean visited[][] = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && isCycle(grid, visited, i, j, grid[i][j])) {
                    return true;
                }
            }
        }

        return false;
    }

    public static boolean isCycle(char grid[][], boolean visited[][], int i, int j, char target) {
        int n = grid.length;
        int m = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] { i, j, -1, -1 });
        visited[i][j] = true;

        int directions[][] = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

        while (!queue.isEmpty()) {
            int current[] = queue.poll();
            int row = current[0];
            int col = current[1];
            int parentRow = current[2];
            int parentCol = current[3];

            for (int direction[] : directions) {
                int newRow = row + direction[0];
                int newCol = col + direction[1];

                if (newRow >= 0 && newCol >= 0 && newRow < n && newCol < m && grid[newRow][newCol] == target) {
                    if (visited[newRow][newCol]) {
                        if (newRow != parentRow || newCol != parentCol) {
                            return true;
                        }
                    } else {
                        visited[newRow][newCol] = true;
                        queue.offer(new int[] { newRow, newCol, row, col });
                    }
                }
            }
        }

        return false;
    }

    public static void main(String args[]) {
        char grid[][] = { { 'a', 'a', 'a', 'a' }, { 'a', 'b', 'b', 'a' }, { 'a', 'b', 'b', 'a' },
                { 'a', 'a', 'a', 'a' } };

        System.out.println(containsCycle(grid));
        System.out.println(containsCycle2(grid));
    }
}
