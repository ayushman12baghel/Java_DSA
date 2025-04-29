import java.util.*;

public class Path_with_Minimum_Effort {

    public static int minimumEffortPath(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;
        int result[][] = new int[n][m];
        for (int row[] : result) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        pq.offer(new int[] { 0, 0, 0 });
        result[0][0] = 0;

        int directions[][] = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

        while (!pq.isEmpty()) {
            int current[] = pq.poll();
            int row = current[0];
            int col = current[1];
            int diff = current[2];

            if (diff > result[row][col]) {
                continue;
            }

            if (row == n - 1 && col == m - 1) {
                return diff;
            }

            for (int direction[] : directions) {
                int newRow = direction[0] + row;
                int newCol = direction[1] + col;

                if (newRow >= 0 && newCol >= 0 && newRow < n && newCol < m) {
                    int newDiff = Math.max(diff, Math.abs(heights[row][col] - heights[newRow][newCol]));

                    if (result[newRow][newCol] > newDiff) {
                        result[newRow][newCol] = newDiff;
                        pq.offer(new int[] { newRow, newCol, newDiff });
                    }
                }
            }
        }

        return result[n - 1][m - 1];
    }

    public static void main(String args[]) {
        int heights[][] = { { 1, 2, 2 }, { 3, 8, 2 }, { 5, 3, 5 } };

        System.out.println(minimumEffortPath(heights));
    }
}
