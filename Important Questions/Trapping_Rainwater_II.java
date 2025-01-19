import java.util.*;

public class Trapping_Rainwater_II {

    // Using PriorityQueue and BFS
    public static int trappedRainwater(int heightMap[][]) {
        int n = heightMap.length;
        int m = heightMap[0].length;
        PriorityQueue<int[]> boundaryCells = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        boolean visited[][] = new boolean[n][m];
        int water = 0;

        for (int i = 0; i < n; i++) {
            boundaryCells.offer(new int[] { i, 0, heightMap[i][0] });
            visited[i][0] = true;

            boundaryCells.offer(new int[] { i, m - 1, heightMap[i][m - 1] });
            visited[i][m - 1] = true;
        }

        for (int i = 0; i < m; i++) {
            boundaryCells.offer(new int[] { 0, i, heightMap[0][i] });
            visited[0][i] = true;

            boundaryCells.offer(new int[] { n - 1, i, heightMap[n - 1][i] });
            visited[n - 1][i] = true;
        }

        int directions[][] = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

        while (!boundaryCells.isEmpty()) {
            int current[] = boundaryCells.poll();
            int row = current[0];
            int col = current[1];
            int height = current[2];

            for (int direction[] : directions) {
                int newRow = direction[0] + row;
                int newCol = direction[1] + col;

                if (newRow >= 0 && newCol >= 0 && newRow < n && newCol < m && !visited[newRow][newCol]) {
                    water += Math.max(height - heightMap[newRow][newCol], 0);
                    boundaryCells.offer(new int[] { newRow, newCol, Math.max(height, heightMap[newRow][newCol]) });
                    visited[newRow][newCol] = true;
                }
            }
        }

        return water;
    }

    // Using Dynamic Relaxation
    public static int trappedRainwater2(int heightMap[][]) {
        int n = heightMap.length;
        int m = heightMap[0].length;
        int ans[][] = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                ans[i][j] = heightMap[i][j];
            }
        }

        boolean updated = true;
        boolean initPasss = true;

        while (updated) {
            updated = false;

            for (int i = 1; i < n - 1; i++) {
                for (int j = 1; j < m - 1; j++) {
                    int potentialWater = Math.max(heightMap[i][j], Math.min(ans[i - 1][j], ans[i][j - 1]));
                    if (initPasss || ans[i][j] > potentialWater) {
                        ans[i][j] = potentialWater;
                        updated = true;
                    }
                }
            }

            initPasss = false;

            for (int i = n - 2; i >= 1; i--) {
                for (int j = m - 2; j >= 1; j--) {
                    int potentialWater = Math.max(heightMap[i][j], Math.min(ans[i + 1][j], ans[i][j + 1]));
                    if (ans[i][j] > potentialWater) {
                        ans[i][j] = potentialWater;
                        updated = true;
                    }
                }
            }
        }

        int trappedWater = 0;
        for (int i = 1; i < n - 1; i++) {
            for (int j = 1; j < m - 1; j++) {
                trappedWater += ans[i][j] - heightMap[i][j];
            }
        }

        return trappedWater;
    }

    public static void main(String args[]) {
        int heightMap[][] = { { 1, 4, 3, 1, 3, 2 }, { 3, 2, 1, 3, 2, 4 }, { 2, 3, 3, 2, 3, 1 } };

        System.out.println(trappedRainwater(heightMap));
        System.out.println(trappedRainwater2(heightMap));
    }
}
