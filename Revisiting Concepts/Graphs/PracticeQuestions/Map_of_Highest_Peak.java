import java.util.*;

public class Map_of_Highest_Peak {

    // Multi-Source BFS
    public static int[][] highestPeak(int[][] isWater) {
        int n = isWater.length;
        int m = isWater[0].length;

        int ans[][] = new int[n][m];
        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (isWater[i][j] == 1) {
                    queue.offer(new int[] { i, j });
                    ans[i][j] = 0;
                } else {
                    ans[i][j] = -1;
                }
            }
        }

        int directions[][] = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int current[] = queue.poll();
                int row = current[0];
                int col = current[1];

                for (int direction[] : directions) {
                    int newRow = direction[0] + row;
                    int newCol = direction[1] + col;

                    if (newRow >= 0 && newCol >= 0 && newRow < n && newCol < m && ans[newRow][newCol] == -1) {
                        ans[newRow][newCol] = ans[row][col] + 1;
                        queue.offer(new int[] { newRow, newCol });
                    }
                }
            }
        }

        return ans;
    }

    public static void main(String args[]) {
        int isWater[][] = { { 0, 1 }, { 0, 0 } };

        int ans[][] = highestPeak(isWater);

        for (int i = 0; i < ans.length; i++) {
            for (int j = 0; j < ans[0].length; j++) {
                System.out.print(ans[i][j] + " ");
            }
            System.out.println();
        }
    }
}
