import java.util.*;

public class Matrix_0_1 {

    // Multi-Source BFS
    public static int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        int ans[][] = new int[n][m];
        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 0) {
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
        int mat[][] = { { 0, 0, 0 }, { 0, 1, 0 }, { 1, 1, 1 } };
        int ans[][] = updateMatrix(mat);

        for (int i = 0; i < ans.length; i++) {
            for (int j = 0; j < ans[0].length; j++) {
                System.out.print(ans[i][j] + " ");
            }

            System.out.println();
        }
    }
}
