import java.util.*;
import java.util.LinkedList;

public class Matrix_01 {

    public static int[][] updateMatrix(int matrix[][]) {
        int n = matrix.length;
        int m = matrix[0].length;
        int ans[][] = new int[n][m];
        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0) {
                    queue.offer(new int[] { i, j });
                } else {
                    ans[i][j] = -1;
                }
            }
        }

        int directions[][] = { { 0, 1 }, { 0, -1 }, { -1, 0 }, { 1, 0 } };

        while (!queue.isEmpty()) {
            int cell[] = queue.poll();
            int row = cell[0];
            int col = cell[1];

            for (int direction[] : directions) {
                int newRow = row + direction[0];
                int newCol = col + direction[1];

                if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < m && ans[newRow][newCol] == -1) {
                    ans[newRow][newCol] = ans[row][col] + 1;
                    queue.offer(new int[] { newRow, newCol });
                }
            }
        }

        return ans;
    }

    public static void main(String args[]) {
        int matrix[][] = { { 0, 0, 0 }, { 0, 1, 0 }, { 1, 1, 1 } };

        int ans[][] = updateMatrix(matrix);

        for (int i = 0; i < ans.length; i++) {
            for (int j = 0; j < ans[0].length; j++) {
                System.out.print(ans[i][j] + " ");
            }
            System.out.println();
        }
    }
}
