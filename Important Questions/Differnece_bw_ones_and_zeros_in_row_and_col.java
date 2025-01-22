import java.util.*;

public class Differnece_bw_ones_and_zeros_in_row_and_col {

    public static int[][] oneMinusZeros(int grid[][]) {
        int n = grid.length;
        int m = grid[0].length;
        int row[] = new int[n];
        int col[] = new int[m];
        int ans[][] = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    row[i]++;
                    col[j]++;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int zeros1 = m - row[i];
                int zeros2 = n - col[j];

                ans[i][j] = row[i] + col[j] - zeros1 - zeros2;
            }
        }

        return ans;
    }

    public static void main(String args[]) {
        int grid[][] = { { 0, 1, 1 }, { 1, 0, 1 }, { 0, 0, 1 } };

        int ans[][] = oneMinusZeros(grid);
        for (int i = 0; i < ans.length; i++) {
            for (int j = 0; j < ans[0].length; j++) {
                System.out.print(ans[i][j] + " ");
            }
        }
    }
}
