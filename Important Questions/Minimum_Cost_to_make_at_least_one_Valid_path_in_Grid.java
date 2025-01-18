import java.sql.Time;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.PriorityQueue;

public class Minimum_Cost_to_make_at_least_one_Valid_path_in_Grid {

    // Time Limit Exceded -> Backtracking Brute Force
    public static int minCost(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        return backtrack(grid, 0, 0, 0, visited);
    }

    static int[][] directions = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

    public static int backtrack(int[][] grid, int i, int j, int cost, boolean[][] visited) {
        if (i == grid.length - 1 && j == grid[0].length - 1) {
            return cost;
        }
        visited[i][j] = true;

        int minCost = Integer.MAX_VALUE;
        for (int k = 0; k < 4; k++) {
            int row = i + directions[k][0];
            int col = j + directions[k][1];

            if (row >= 0 && col >= 0 && row < grid.length && col < grid[0].length && !visited[row][col]) {
                int newCost = cost + (grid[i][j] == k + 1 ? 0 : 1);
                minCost = Math.min(minCost, backtrack(grid, row, col, newCost, visited));
            }
        }

        visited[i][j] = false; // Backtrack
        return minCost;
    }

    // Using Dijkstra Algo
    // Time Complexity: O(n⋅m⋅log(n⋅m)) Space Complexity: O(n⋅m)
    public static int minCost2(int[][] grid) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        int ans[][] = new int[grid.length][grid[0].length];
        for (int row[] : ans) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        ans[0][0] = 0;
        pq.offer(new int[] { 0, 0, 0 });

        while (!pq.isEmpty()) {
            int current[] = pq.poll();
            int row = current[0];
            int col = current[1];
            int cost = current[2];
            if (row == grid.length - 1 && col == grid[0].length - 1) {
                return cost;
            }
            if (ans[row][col] < cost) {
                continue;
            }

            for (int k = 0; k < 4; k++) {
                int newRow = row + directions[k][0];
                int newCol = col + directions[k][1];

                if (newRow >= 0 && newCol >= 0 && newRow < grid.length && newCol < grid[0].length) {
                    int newCost = cost + (k != (grid[row][col] - 1) ? 1 : 0);
                    if (newCost < ans[newRow][newCol]) {
                        ans[newRow][newCol] = newCost;
                        pq.offer(new int[] { newRow, newCol, newCost });
                    }
                }
            }
        }

        return ans[grid.length - 1][grid[0].length - 1];
    }

    // By 0-1 BFS
    // Time Complexity: O(n⋅m) Space Complexity: O(n⋅m)
    public static int minCost3(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int ans[][] = new int[n][m];

        for (int row[] : ans) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        Deque<int[]> deque = new ArrayDeque<>();
        deque.offerFirst(new int[] { 0, 0 });
        ans[0][0] = 0;

        while (!deque.isEmpty()) {
            int current[] = deque.pollFirst();
            int row = current[0];
            int col = current[1];

            for (int i = 0; i < 4; i++) {
                int direction[] = directions[i];
                int newRow = row + direction[0];
                int newCol = col + direction[1];
                int cost = (grid[row][col] != (i + 1) ? 1 : 0);

                if (newRow >= 0 && newCol >= 0 && newRow < n && newCol < m) {
                    int newCost = ans[row][col] + cost;
                    if (ans[newRow][newCol] > newCost) {
                        ans[newRow][newCol] = newCost;

                        if (cost == 1) {
                            deque.offerLast(new int[] { newRow, newCol });
                        } else {
                            deque.offerFirst(new int[] { newRow, newCol });
                        }
                    }
                }
            }
        }

        return ans[n - 1][m - 1];
    }

    public static void main(String args[]) {
        int grid[][] = { { 1, 1, 1, 1 }, { 2, 2, 2, 2 }, { 1, 1, 1, 1 }, { 2, 2, 2, 2 } };
        System.out.println(minCost(grid));
        System.out.println(minCost2(grid));
        System.out.println(minCost3(grid));
    }
}
