import java.util.LinkedList;
import java.util.Queue;

public class Numbers_of_islands_200 {
    public static void dfs(char grid[][], int i, int j) {
        if (i >= 0 && j >= 0 && i < grid.length && j < grid[0].length && grid[i][j] == '1') {
            grid[i][j] = '0';
            dfs(grid, i + 1, j);
            dfs(grid, i - 1, j);
            dfs(grid, i, j + 1);
            dfs(grid, i, j - 1);
        }
    }

    public static int numIslands(char grid[][]) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    public static int numIslands2(char[][] grid) {
        int count = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    dfs2(grid, i, j);
                    count++;
                }
            }
        }

        return count;
    }

    static int directions[][] = { { 0, 1 }, { 0, -1 }, { -1, 0 }, { 1, 0 } };

    public static void dfs2(char board[][], int x, int y) {
        board[x][y] = '0';

        for (int direction[] : directions) {
            int row = direction[0] + x;
            int col = direction[1] + y;

            if (row >= 0 && col >= 0 && row < board.length && col < board[0].length && board[row][col] == '1') {
                dfs2(board, row, col);
            }
        }
    }

    // BFS
    public static int numIslands3(char[][] grid) {
        int count = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    bfs(grid, i, j);
                    count++;
                }
            }
        }

        return count;
    }

    // int directions[][] = { { 0, 1 }, { 0, -1 }, { -1, 0 }, { 1, 0 } };

    public static void bfs(char board[][], int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] { x, y });

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int current[] = queue.poll();
                int row = current[0];
                int col = current[1];

                for (int direction[] : directions) {
                    int newRow = row + direction[0];
                    int newCol = col + direction[1];

                    if (newRow >= 0 && newCol >= 0 && newRow < board.length && newCol < board[0].length
                            && board[newRow][newCol] == '1') {
                        queue.offer(new int[] { newRow, newCol });
                        board[newRow][newCol] = '0';
                    }
                }
            }
        }
    }

    public static void main(String args[]) {
        char grid[][] = {
                { '1', '1', '0', '0', '0' },
                { '1', '1', '0', '0', '0' },
                { '0', '0', '1', '0', '0' },
                { '0', '0', '0', '1', '1' }
        };
        System.out.println(numIslands(grid));
        char grid2[][] = {
                { '1', '1', '0', '0', '0' },
                { '1', '1', '0', '0', '0' },
                { '0', '0', '1', '0', '0' },
                { '0', '0', '0', '1', '1' }
        };
        System.out.println(numIslands2(grid2));
    }
}
