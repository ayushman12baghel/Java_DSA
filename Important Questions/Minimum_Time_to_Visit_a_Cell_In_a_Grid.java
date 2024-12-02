import java.util.*;

public class Minimum_Time_to_Visit_a_Cell_In_a_Grid {

    public static int minimumTime(int grid[][]) {
        int n = grid.length;
        int m = grid[0].length;

        if (grid[0][1] > 1 && grid[1][0] > 1) {
            return -1;
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        int result[][] = new int[n][m];
        for (int row[] : result) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        result[0][0] = 0;
        boolean visited[][] = new boolean[n][m];
        pq.offer(new int[] { 0, 0, 0 });

        int directions[][] = { { 1, 0 }, { -1, 0 }, { 0, -1 }, { 0, 1 } };

        while (!pq.isEmpty()) {
            int curr[] = pq.poll();
            int time = curr[0];
            int row = curr[1];
            int col = curr[2];

            if (visited[row][col]) {
                continue;
            }
            visited[row][col] = true;
            if (row == n - 1 && col == m - 1) {
                return result[n - 1][m - 1];
            }

            for (int direction[] : directions) {
                int i = row + direction[0];
                int j = col + direction[1];

                if (i < 0 || i >= n || j < 0 || j >= m) {
                    continue;
                }

                int newTime;
                if (grid[i][j] <= time) {
                    newTime = time + 1;
                } else if ((grid[i][j] - time) % 2 == 0) {
                    newTime = grid[i][j] + 1;
                } else {
                    newTime = grid[i][j];
                }

                if (newTime < result[i][j]) {
                    result[i][j] = newTime;
                    pq.offer(new int[] { newTime, i, j });
                }
            }
        }

        return result[n - 1][m - 1];
    }

    public static void main(String args[]) {
        int grid[][] = { { 0, 1, 3, 2 }, { 5, 1, 2, 5 }, { 4, 3, 8, 6 } };

        System.out.println(minimumTime(grid));
    }
}
