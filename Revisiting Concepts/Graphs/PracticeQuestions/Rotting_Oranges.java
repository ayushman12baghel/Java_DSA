import java.util.*;

public class Rotting_Oranges {

    public static int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();
        int fresh = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[] { i, j });
                } else if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }

        if (fresh == 0) {
            return 0;
        }

        int directions[][] = { { 1, 0 }, { 0, 1 }, { 0, -1 }, { -1, 0 } };
        int minutes = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean rotten = false;

            for (int i = 0; i < size; i++) {
                int current[] = queue.poll();
                int row = current[0];
                int col = current[1];

                for (int direction[] : directions) {
                    int newRow = direction[0] + row;
                    int newCol = direction[1] + col;

                    if (newRow >= 0 && newCol >= 0 && newRow < n && newCol < m && grid[newRow][newCol] == 1) {
                        grid[newRow][newCol] = 2;
                        queue.offer(new int[] { newRow, newCol });
                        rotten = true;
                        fresh--;
                    }
                }
            }

            if (rotten) {
                minutes++;
            }
        }

        return fresh == 0 ? minutes : -1;
    }

    public static void main(String args[]) {
        int grid[][] = { { 2, 1, 1 }, { 1, 1, 0 }, { 0, 1, 1 } };
        System.out.println(orangesRotting(grid));
    }
}
