import java.util.*;

public class Find_the_Safest_Path_in_A_Grid {

    // Approach Using MultiSource BFS and Binary Search O(n^2 * log(n))
    static int directions[][] = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

    public static int maximumSafenessFactor(int grid[][]) {
        int n = grid.length;

        if (grid[0][0] == 1) {
            return 0;
        }

        int thief[][] = new int[n][n];
        Queue<int[]> queue = new LinkedList<>();
        boolean visited[][] = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    queue.offer(new int[] { i, j });
                    visited[i][j] = true;
                }
            }
        }

        int level = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int current[] = queue.poll();
                int row = current[0];
                int col = current[1];

                thief[row][col] = level;

                for (int direction[] : directions) {
                    int newRow = direction[0] + row;
                    int newCol = direction[1] + col;

                    if (newRow >= 0 && newCol >= 0 && newRow < n && newCol < n && !visited[newRow][newCol]) {
                        queue.offer(new int[] { newRow, newCol });
                        visited[newRow][newCol] = true;
                    }
                }
            }

            level++;
        }

        int left = 0;
        int right = 2 * n;
        int result = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (isPossible(thief, mid)) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return result;
    }

    public static boolean isPossible(int thief[][], int safe) {
        int n = thief.length;

        if (thief[0][0] < safe) {
            return false;
        }

        Queue<int[]> queue = new LinkedList<>();
        boolean visited[][] = new boolean[n][n];
        queue.offer(new int[] { 0, 0 });
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            int current[] = queue.poll();
            int row = current[0];
            int col = current[1];

            if (row == n - 1 && col == n - 1) {
                return true;
            }

            for (int direction[] : directions) {
                int newRow = direction[0] + row;
                int newCol = direction[1] + col;

                if (newRow >= 0 && newCol >= 0 && newRow < n && newCol < n && !visited[newRow][newCol]
                        && thief[newRow][newCol] >= safe) {
                    queue.offer(new int[] { newRow, newCol });
                    visited[newRow][newCol] = true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int grid[][] = { { 0, 0, 1 }, { 0, 0, 0 }, { 0, 0, 0 } };
        System.out.println(maximumSafenessFactor(grid));
    }
}
