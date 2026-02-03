import java.util.*;

//Approach 1 Using Dijkstra Algo O(nm*log(n*m))
class Solution {
    // Function to return the minimum cost to react at bottom
    // right cell from top left cell.
    public int minimumCostPath(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        boolean visited[][] = new boolean[n][m];
        pq.offer(new int[] { 0, 0, grid[0][0] });
        int directions[][] = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

        while (!pq.isEmpty()) {
            int current[] = pq.poll();
            int row = current[0];
            int col = current[1];
            int cost = current[2];

            if (row == n - 1 && col == m - 1) {
                return cost;
            }

            if (visited[row][col]) {
                continue;
            }

            visited[row][col] = true;

            for (int direction[] : directions) {
                int newRow = row + direction[0];
                int newCol = col + direction[1];

                if (newRow >= 0 && newCol >= 0 && newRow < n && newCol < m && !visited[newRow][newCol]) {
                    pq.offer(new int[] { newRow, newCol, cost + grid[newRow][newCol] });
                }
            }
        }

        return -1;
    }
}

// Approach 2 Standard and Recommended
class Solution {
    // Function to return the minimum cost to react at bottom
    // right cell from top left cell.
    public int minimumCostPath(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        int dist[][] = new int[n][m];

        for (int row[] : dist) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        pq.offer(new int[] { 0, 0, grid[0][0] });
        dist[0][0] = grid[0][0];
        int directions[][] = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

        while (!pq.isEmpty()) {
            int current[] = pq.poll();
            int row = current[0];
            int col = current[1];
            int cost = current[2];

            if (row == n - 1 && col == m - 1) {
                return cost;
            }

            if (dist[row][col] < cost) {
                continue;
            }

            for (int direction[] : directions) {
                int newRow = row + direction[0];
                int newCol = col + direction[1];

                if (newRow >= 0 && newCol >= 0 && newRow < n && newCol < m) {
                    int newCost = cost + grid[newRow][newCol];

                    if (newCost < dist[newRow][newCol]) {
                        pq.offer(new int[] { newRow, newCol, newCost });
                        dist[newRow][newCol] = newCost;
                    }
                }
            }
        }

        return -1;
    }
}