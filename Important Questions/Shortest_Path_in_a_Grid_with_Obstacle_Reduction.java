import java.util.*;
import java.util.LinkedList;

public class Shortest_Path_in_a_Grid_with_Obstacle_Reduction {

    public static int shortestPath(int grid[][], int k) {
        int n = grid.length;
        int m = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        boolean visited[][][] = new boolean[n][m][n * m];

        queue.offer(new int[] { 0, 0, k });
        visited[0][0][k] = true;

        int directions[][] = { { 0, 1 }, { 0, -1 }, { -1, 0 }, { 1, 0 } };
        int steps = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int current[] = queue.poll();
                int row = current[0];
                int col = current[1];
                int obs = current[2];

                if (row == n - 1 && col == m - 1) {
                    return steps;
                }

                for (int direction[] : directions) {
                    int newRow = direction[0] + row;
                    int newCol = direction[1] + col;

                    if (newRow < 0 || newCol < 0 || newCol >= m || newRow >= n) {
                        continue;
                    }

                    if (grid[newRow][newCol] == 0 && !visited[newRow][newCol][obs]) {
                        queue.offer(new int[] { newRow, newCol, obs });
                        visited[newRow][newCol][obs] = true;
                    } else if (grid[newRow][newCol] == 1 && obs > 0 && !visited[newRow][newCol][obs - 1]) {
                        queue.offer(new int[] { newRow, newCol, obs - 1 });
                        visited[newRow][newCol][obs - 1] = true;
                    }
                }
            }
            steps++;
        }

        return -1;
    }

    public static void main(String args[]) {
        int grid[][] = { { 0, 0, 0 }, { 1, 1, 0 }, { 0, 0, 0 }, { 0, 1, 1 }, { 0, 0, 0 } };
        int k = 1;

        System.out.println(shortestPath(grid, k));
    }
}
