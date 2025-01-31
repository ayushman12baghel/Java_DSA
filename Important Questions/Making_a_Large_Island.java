import java.util.*;
import java.util.LinkedList;

public class Making_a_Large_Island {

    // TLE Brute Force
    public static int largestIsland(int[][] grid) {
        int largest = 0;
        int n = grid.length;
        int m = grid[0].length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 0) {
                    grid[i][j] = 1;
                    boolean visited[][] = new boolean[n][m];
                    largest = Math.max(largest, bfs1(grid, i, j, visited));
                    grid[i][j] = 0;
                }
            }
        }

        return largest == 0 ? (n * m) : largest;
    }

    public static int bfs1(int grid[][], int i, int j, boolean visited[][]) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] { i, j });
        visited[i][j] = true;
        int largest = 0;
        int directions[][] = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int k = 0; k < size; k++) {
                int current[] = queue.poll();
                int row = current[0];
                int col = current[1];
                if (grid[row][col] == 1) {
                    largest++;
                }

                for (int direction[] : directions) {
                    int newRow = row + direction[0];
                    int newCol = col + direction[1];

                    if (newRow >= 0 && newCol >= 0 && newRow < grid.length && newCol < grid[0].length
                            && grid[newRow][newCol] == 1 && !visited[newRow][newCol]) {
                        queue.offer(new int[] { newRow, newCol });
                        visited[newRow][newCol] = true;
                    }
                }
            }
        }

        return largest;
    }

    // Optimised Soln O(n2)
    public static int largestIsland2(int grid[][]) {
        int n = grid.length;
        int m = grid[0].length;
        Map<Integer, Integer> map = new HashMap<>();
        int uniqueId = 2;
        int ans = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    map.put(uniqueId, bfs(grid, i, j, uniqueId));
                    uniqueId++;
                }
            }
        }

        int directions[][] = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 0) {
                    Set<Integer> set = new HashSet<>();

                    for (int direction[] : directions) {
                        int newRow = direction[0] + i;
                        int newCol = direction[1] + j;

                        if (newRow >= 0 && newCol >= 0 && newRow < n && newCol < m && grid[newRow][newCol] != 0) {
                            set.add(grid[newRow][newCol]);
                        }
                    }

                    int sum = 1;
                    for (int id : set) {
                        sum += map.get(id);
                    }
                }
            }
        }

        return ans == 0 ? n * m : ans;
    }

    public static int bfs(int grid[][], int i, int j, int uniqueId) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] { i, j });
        grid[i][j] = uniqueId;
        int sum = 1;

        int directions[][] = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int k = 0; k < size; k++) {
                int current[] = queue.poll();
                int row = current[0];
                int col = current[1];

                for (int direction[] : directions) {
                    int newRow = row + direction[0];
                    int newCol = col + direction[1];

                    if (newRow >= 0 && newCol >= 0 && newRow < grid.length && newCol < grid[0].length
                            && grid[newRow][newCol] == 1) {
                        sum += 1;
                        queue.offer(new int[] { newRow, newCol });
                        grid[newRow][newCol] = uniqueId;
                    }
                }
            }
        }

        return sum;
    }

    public static void main(String args[]) {
        int grid[][] = { { 1, 1 }, { 1, 0 } };

        System.out.println(largestIsland(grid));
        System.out.println(largestIsland2(grid));
    }
}
