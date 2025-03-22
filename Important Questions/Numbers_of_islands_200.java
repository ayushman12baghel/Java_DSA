import java.util.LinkedList;
import java.util.Queue;

public class Numbers_of_islands_200 {

    // Approach 1 Using DFS
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

    // Approach 2 Using BFS
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

    // Approach 3 Using DSU
    static class DSU {
        int n;
        int parent[];
        int size[];

        public DSU(int n) {
            this.n = n;
            this.parent = new int[n];
            this.size = new int[n];

            for (int i = 0; i < n; i++) {
                size[i] = 1;
                parent[i] = i;
            }
        }

        public int find(int i) {
            if (i == parent[i]) {
                return i;
            }

            return parent[i] = find(parent[i]);
        }

        public void union(int x, int y) {
            int parentX = find(x);
            int parentY = find(y);

            if (parentX == parentY) {
                return;
            }

            if (size[parentX] > size[parentY]) {
                parent[parentY] = parentX;
                size[parentX] += size[parentY];
            } else if (size[parentX] < size[parentY]) {
                parent[parentX] = parentY;
                size[parentY] += size[parentX];
            } else {
                parent[parentX] = parentY;
                size[parentY] += size[parentX];
            }
        }
    }

    public static int numIslands4(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        DSU dsu = new DSU(n * m);

        int directions[][] = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1') {
                    for (int direction[] : directions) {
                        int row = i + direction[0];
                        int col = j + direction[1];

                        if (row >= 0 && col >= 0 && row < n && col < m && grid[row][col] == '1') {
                            dsu.union(i * m + j, row * m + col);
                        }
                    }
                }
            }
        }

        int result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1' && dsu.find(i * m + j) == (i * m + j)) {
                    result++;
                }
            }
        }

        return result;
    }

    public static void main(String args[]) {
        char grid[][] = {
                { '1', '1', '0', '0', '0' },
                { '1', '1', '0', '0', '0' },
                { '0', '0', '1', '0', '0' },
                { '0', '0', '0', '1', '1' }
        };
        System.out.println(numIslands4(grid));
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
