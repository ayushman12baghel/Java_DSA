import java.util.*;

//Approach Using BFS O(n^2)
class Solution {
    public int shortestBridge(int[][] grid) {
        int n = grid.length;

        int components[][] = new int[n][n];
        boolean first = true;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (components[i][j] == 0 && grid[i][j] == 1) {
                    if (first) {
                        bfs(components, grid, i, j, 1);
                        first = false;
                    } else {
                        bfs(components, grid, i, j, 2);
                    }
                }
            }
        }

        return bfs2(components, grid);
    }

    public void bfs(int components[][], int grid[][], int i, int j, int value) {
        int n = grid.length;

        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] { i, j });
        components[i][j] = value;
        int directions[][] = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

        while (!queue.isEmpty()) {
            int current[] = queue.poll();
            int row = current[0];
            int col = current[1];

            for (int direction[] : directions) {
                int newRow = direction[0] + row;
                int newCol = direction[1] + col;

                if (newRow >= 0 && newCol >= 0 && newRow < n && newCol < n && grid[newRow][newCol] == 1
                        && components[newRow][newCol] == 0) {
                    components[newRow][newCol] = value;
                    queue.offer(new int[] { newRow, newCol });
                }
            }
        }
    }

    public int bfs2(int components[][], int grid[][]) {
        int n = grid.length;

        Queue<int[]> queue = new ArrayDeque<>();
        boolean visited[][] = new boolean[n][n];
        int directions[][] = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (components[i][j] == 1) {
                    queue.offer(new int[] { i, j, 0 });
                    visited[i][j] = true;
                }
            }
        }

        while (!queue.isEmpty()) {
            int current[] = queue.poll();
            int row = current[0];
            int col = current[1];
            int cost = current[2];

            if (components[row][col] == 2) {
                return cost - 1;
            }

            for (int direction[] : directions) {
                int newRow = direction[0] + row;
                int newCol = direction[1] + col;

                if (newRow >= 0 && newCol >= 0 && newRow < n && newCol < n && !visited[newRow][newCol]) {
                    queue.offer(new int[] { newRow, newCol, cost + 1 });
                    visited[newRow][newCol] = true;
                }
            }
        }

        return Integer.MAX_VALUE;
    }
}

// Some Modifications O(n^2)
class Solution {
    public int shortestBridge(int[][] grid) {
        int n = grid.length;

        int components[][] = new int[n][n];
        boolean first = true;

        for (int i = 0; i < n && first; i++) {
            for (int j = 0; j < n && first; j++) {
                if (components[i][j] == 0 && grid[i][j] == 1) {
                    if (first) {
                        markComponent(components, grid, i, j, 2);
                        first = false;
                    }
                }
            }
        }

        return bfs2(components, grid);
    }

    public void markComponent(int components[][], int grid[][], int i, int j, int value) {
        int n = grid.length;

        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] { i, j });
        components[i][j] = value;
        int directions[][] = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

        while (!queue.isEmpty()) {
            int current[] = queue.poll();
            int row = current[0];
            int col = current[1];

            for (int direction[] : directions) {
                int newRow = direction[0] + row;
                int newCol = direction[1] + col;

                if (newRow >= 0 && newCol >= 0 && newRow < n && newCol < n && grid[newRow][newCol] == 1
                        && components[newRow][newCol] == 0) {
                    components[newRow][newCol] = value;
                    queue.offer(new int[] { newRow, newCol });
                }
            }
        }
    }

    public int bfs2(int components[][], int grid[][]) {
        int n = grid.length;

        Queue<int[]> queue = new ArrayDeque<>();
        boolean visited[][] = new boolean[n][n];
        int directions[][] = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (components[i][j] == 2) {
                    queue.offer(new int[] { i, j, 0 });
                    visited[i][j] = true;
                }
            }
        }

        while (!queue.isEmpty()) {
            int current[] = queue.poll();
            int row = current[0];
            int col = current[1];
            int cost = current[2];

            if (components[row][col] == 0 && grid[row][col] == 1) {
                return cost - 1;
            }

            for (int direction[] : directions) {
                int newRow = direction[0] + row;
                int newCol = direction[1] + col;

                if (newRow >= 0 && newCol >= 0 && newRow < n && newCol < n && !visited[newRow][newCol]) {
                    queue.offer(new int[] { newRow, newCol, cost + 1 });
                    visited[newRow][newCol] = true;
                }
            }
        }

        return Integer.MAX_VALUE;
    }
}