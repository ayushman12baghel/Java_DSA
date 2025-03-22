import java.util.LinkedList;
import java.util.Queue;

public class Max_area_of_Islands {

    // Approach 1 Using BFS
    public static int maxAreaOfIsland(int[][] grid) {
        int ans = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    ans = Math.max(ans, bfs(grid, i, j));
                }
            }
        }

        return ans;
    }

    static int directions[][] = { { 0, 1 }, { 0, -1 }, { -1, 0 }, { 1, 0 } };

    public static int bfs(int grid[][], int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] { x, y });
        int ans = 1;
        grid[x][y] = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int current[] = queue.poll();
                int row = current[0];
                int col = current[1];

                for (int direction[] : directions) {
                    int newRow = direction[0] + row;
                    int newCol = direction[1] + col;

                    if (newRow >= 0 && newCol >= 0 && newRow < grid.length && newCol < grid[0].length
                            && grid[newRow][newCol] == 1) {
                        ans++;
                        queue.offer(new int[] { newRow, newCol });
                        grid[newRow][newCol] = 0;
                    }
                }
            }
        }

        return ans;
    }

    // Approach 2 Using DFS
    public static int maxAreaOfIsland2(int[][] grid) {
        int ans = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    ans = Math.max(ans, dfs(grid, i, j));
                }
            }
        }

        return ans;
    }

    public static int dfs(int grid[][], int x, int y) {
        int count = 1;
        grid[x][y] = 0;

        for (int direction[] : directions) {
            int row = x + direction[0];
            int col = y + direction[1];

            if (row >= 0 && col >= 0 && row < grid.length && col < grid[0].length && grid[row][col] == 1) {
                count += dfs(grid, row, col);
            }
        }

        return count;
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
                parent[i] = i;
                size[i] = 1;
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

    public static int maxAreaOfIsland3(int grid[][]) {
        int n = grid.length;
        int m = grid[0].length;
        DSU dsu = new DSU(n * m);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    for (int direction[] : directions) {
                        int row = i + direction[0];
                        int col = j + direction[1];

                        if (row >= 0 && col >= 0 && row < n && col < m && grid[row][col] == 1) {
                            dsu.union(i * m + j, row * m + col);
                        }
                    }
                }
            }
        }

        int maxArea = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    int root = dsu.find(i * m + j);
                    maxArea = Math.max(maxArea, dsu.size[root]);
                }
            }
        }

        return maxArea;
    }

    public static void main(String args[]) {
        int grid[][] = { { 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0 },
                { 0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0 },
                { 0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0 } };

        System.out.println(maxAreaOfIsland3(grid));

        System.out.println(maxAreaOfIsland(grid));
        int grid2[][] = { { 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0 },
                { 0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0 },
                { 0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0 } };
        System.out.println(maxAreaOfIsland2(grid2));
    }
}
