import java.util.*;

public class Shortest_Path_in_Binary_Matrix {

    // By Using BFS
    public static int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1) {
            return -1;
        }

        int count = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] { 0, 0 });
        int directions[][] = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 }, { 1, 1 }, { 1, -1 }, { -1, 1 }, { -1, -1 } };

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int current[] = queue.poll();
                int row = current[0];
                int col = current[1];

                if (row == n - 1 && col == n - 1) {
                    return count + 1;
                }

                for (int direction[] : directions) {
                    int newRow = row + direction[0];
                    int newCol = col + direction[1];

                    if (newRow >= 0 && newCol >= 0 && newRow < n && newCol < n && grid[newRow][newCol] == 0) {
                        grid[newRow][newCol] = 1;
                        queue.offer(new int[] { newRow, newCol });
                    }
                }
            }

            count++;
        }

        return -1;
    }

    // By Using Dijkstra Algorithm
    public static int shortestPathBinaryMatrix2(int[][] grid) {
        int n = grid.length;
        if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1) {
            return -1;
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        pq.offer(new int[] { 0, 0, 1 });
        int directions[][] = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 }, { 1, 1 }, { 1, -1 }, { -1, 1 }, { -1, -1 } };

        while (!pq.isEmpty()) {
            int current[] = pq.poll();
            int row = current[0];
            int col = current[1];
            int weight = current[2];

            if (row == n - 1 && col == n - 1) {
                return weight;
            }

            for (int direction[] : directions) {
                int newRow = row + direction[0];
                int newCol = col + direction[1];
                int newWeight = weight + 1;

                if (newRow >= 0 && newCol >= 0 && newRow < n && newCol < n && grid[newRow][newCol] == 0) {
                    grid[newRow][newCol] = 1;
                    pq.offer(new int[] { newRow, newCol, newWeight });
                }
            }
        }

        return -1;
    }

    public static void main(String args[]) {
        int grid[][] = { { 0, 0, 0 }, { 1, 1, 0 }, { 1, 1, 0 } };
        System.out.println(shortestPathBinaryMatrix(grid));
        System.out.println(shortestPathBinaryMatrix2(grid));
    }
}
