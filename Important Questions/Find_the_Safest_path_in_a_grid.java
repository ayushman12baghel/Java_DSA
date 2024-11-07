import java.util.*;
import java.util.LinkedList;

public class Find_the_Safest_path_in_a_grid {

    public static int distances[][] = { { 0, 1 }, { 0, -1 }, { -1, 0 }, { 1, 0 } };

    public static int maximumSafenessFactor(int grid[][]) {
        int n = grid.length;
        Queue<int[]> queue = new LinkedList<>();
        int distNearestThief[][] = new int[n][n];
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

            while (size-- > 0) {
                int temp[] = queue.poll();
                int curr_i = temp[0];
                int curr_j = temp[1];
                distNearestThief[curr_i][curr_j] = level;

                for (int distance[] : distances) {
                    int new_i = distance[0] + curr_i;
                    int new_j = distance[1] + curr_j;

                    if (new_i < 0 || new_i >= n || new_j < 0 || new_j >= n || visited[new_i][new_j]) {
                        continue;
                    }

                    queue.offer(new int[] { new_i, new_j });
                    visited[new_i][new_j] = true;
                }
            }
            level++;
        }

        int left = 0;
        int right = 2 * n - 1;
        int result = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (check(distNearestThief, mid)) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return result;

    }

    public static boolean check(int distNearestThief[][], int sf) {
        int n = distNearestThief.length;
        Queue<int[]> queue = new LinkedList<>();
        boolean visited[][] = new boolean[n][n];
        queue.offer(new int[] { 0, 0 });

        if (distNearestThief[0][0] < sf) {
            return false;
        }

        while (!queue.isEmpty()) {
            int temp[] = queue.poll();
            int curr_i = temp[0];
            int curr_j = temp[1];

            if (curr_i == n - 1 && curr_j == n - 1) {
                return true;
            }

            for (int distance[] : distances) {
                int new_i = distance[0] + curr_i;
                int new_j = distance[1] + curr_j;

                if (new_i >= 0 && new_i < n && new_j >= 0 && new_j < n && !visited[new_i][new_j]) {
                    if (distNearestThief[new_i][new_j] < sf) {
                        continue;
                    }
                    visited[new_i][new_j] = true;
                    queue.offer(new int[] { new_i, new_j });
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int grid[][] = { { 0, 0, 0, 1 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 1, 0, 0, 0 } };

        System.out.println(maximumSafenessFactor(grid));
    }
}
