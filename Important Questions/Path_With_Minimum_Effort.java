import java.util.*;

//Approach 1 Best Using Dijkstra Algo O(n*m(log(n*m)))
class Solution {
    public int minCostPath(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        pq.offer(new int[] { 0, 0, 0 });
        int directions[][] = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

        int dist[][] = new int[n][m];
        for (int row[] : dist) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        dist[0][0] = 0;

        while (!pq.isEmpty()) {
            int current[] = pq.poll();
            int row = current[0];
            int col = current[1];
            int cost = current[2];

            if (row == n - 1 && col == m - 1) {
                return cost;
            }

            if (cost > dist[row][col]) {
                continue;
            }

            for (int direction[] : directions) {
                int newRow = direction[0] + row;
                int newCol = direction[1] + col;

                if (newRow >= 0 && newCol >= 0 && newRow < n && newCol < m) {
                    int newCost = Math.max(cost, Math.abs(grid[row][col] - grid[newRow][newCol]));

                    if (newCost < dist[newRow][newCol]) {
                        dist[newRow][newCol] = newCost;
                        pq.offer(new int[] { newRow, newCol, newCost });
                    }
                }
            }
        }

        return -1;
    }
}

// Approach 2 Using BinarySearch and Traversal
class Solution {
    public int minCostPath(int[][] mat) {
        int left = 0;
        int right = 1000000;
        int result = right;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (isPossible(mat, mid)) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return result;
    }

    public boolean isPossible(int grid[][], int limit) {
        int n = grid.length;
        int m = grid[0].length;
        ;

        Queue<int[]> queue = new LinkedList<>();
        boolean visited[][] = new boolean[n][m];
        queue.offer(new int[] { 0, 0, 0 });
        visited[0][0] = true;

        int directions[][] = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

        while (!queue.isEmpty()) {
            int current[] = queue.poll();
            int row = current[0];
            int col = current[1];
            int cost = current[2];

            if (row == n - 1 && col == m - 1) {
                return true;
            }

            for (int direction[] : directions) {
                int newRow = direction[0] + row;
                int newCol = direction[1] + col;

                if (newRow >= 0 && newCol >= 0 && newRow < n && newCol < m && !visited[newRow][newCol]) {
                    int newCost = Math.abs(grid[newRow][newCol] - grid[row][col]);

                    if (newCost <= limit) {
                        visited[newRow][newCol] = true;
                        queue.offer(new int[] { newRow, newCol, newCost });
                    }
                }
            }
        }

        return false;
    }
}
