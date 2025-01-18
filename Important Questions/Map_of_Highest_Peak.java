import java.util.*;
import java.util.LinkedList;

public class Map_of_Highest_Peak {

    // MultiSource BFS using visited array
    public static int[][] highestPeak(int[][] isWater) {
        int n = isWater.length;
        int m = isWater[0].length;
        int ans[][] = new int[n][m];
        Queue<int[]> queue = new LinkedList<>();
        boolean visited[][] = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (isWater[i][j] == 1) {
                    queue.offer(new int[] { i, j });
                    visited[i][j] = true;
                }
            }
        }

        int directions[][] = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int current[] = queue.poll();
                int row = current[0];
                int col = current[1];

                for (int direction[] : directions) {
                    int newRow = row + direction[0];
                    int newCol = col + direction[1];

                    if (newRow >= 0 && newCol >= 0 && newRow < n && newCol < m && !visited[newRow][newCol]) {
                        queue.offer(new int[] { newRow, newCol });
                        visited[newRow][newCol] = true;
                        if (Math.abs(isWater[newRow][newCol] - isWater[row][col]) != 1) {
                            ans[newRow][newCol] = ans[row][col] + 1;
                        } else {
                            ans[newRow][newCol] = 1;
                        }
                    }
                }
            }
        }

        return ans;
    }

    // Without visited array
    public static int[][] highestPeak2(int[][] isWater) {
        int n = isWater.length;
        int m = isWater[0].length;
        int ans[][] = new int[n][m];
        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (isWater[i][j] == 1) {
                    queue.offer(new int[] { i, j });
                } else {
                    ans[i][j] = -1;
                }
            }
        }

        int directions[][] = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int current[] = queue.poll();
                int row = current[0];
                int col = current[1];

                for (int direction[] : directions) {
                    int newRow = row + direction[0];
                    int newCol = col + direction[1];

                    if (newRow >= 0 && newCol >= 0 && newRow < n && newCol < m && ans[newRow][newCol] == -1) {
                        queue.offer(new int[] { newRow, newCol });
                        ans[newRow][newCol] = ans[row][col] + 1;
                    }
                }
            }
        }

        return ans;
    }

    public static void main(String args[]) {
        int isWater[][] = { { 0, 0, 1 }, { 1, 0, 0 }, { 0, 0, 0 } };
        int height[][] = highestPeak(isWater);
        for (int i = 0; i < height.length; i++) {
            for (int j = 0; j < height[0].length; j++) {
                System.out.print(height[i][j] + " ");
            }
            System.out.println();
        }
        int height2[][] = highestPeak2(isWater);
        for (int i = 0; i < height2.length; i++) {
            for (int j = 0; j < height2[0].length; j++) {
                System.out.print(height2[i][j] + " ");
            }
            System.out.println();
        }
    }
}
