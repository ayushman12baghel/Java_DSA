import java.util.*;

public class _2_D_Difference_Array {

    // 2D Difference Array with preficSum
    public static ArrayList<ArrayList<Integer>> applyDiff2D(int[][] matrix, int[][] operations) {
        int n = matrix.length;
        int m = matrix[0].length;

        int diff[][] = new int[n][m];

        for (int operation[] : operations) {
            int value = operation[0];
            int x1 = operation[1];
            int y1 = operation[2];
            int x2 = operation[3];
            int y2 = operation[4];

            diff[x1][y1] += value;

            if (x2 + 1 < n)
                diff[x2 + 1][y1] -= value;
            if (y2 + 1 < m)
                diff[x1][y2 + 1] -= value;
            if (x2 + 1 < n && y2 + 1 < m)
                diff[x2 + 1][y2 + 1] += value;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 1; j < m; j++) {
                diff[i][j] += diff[i][j - 1];
            }
        }

        for (int j = 0; j < m; j++) {
            for (int i = 1; i < n; i++) {
                diff[i][j] += diff[i - 1][j];
            }
        }

        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ArrayList<Integer> temp = new ArrayList<>();
            for (int j = 0; j < m; j++) {
                temp.add(diff[i][j] + matrix[i][j]);
            }

            ans.add(new ArrayList<>(temp));
        }

        return ans;
    }

    public static void main(String[] args) {
        int matrix[][] = { { 1, 2, 3 }, { 1, 1, 0 }, { 4, -2, 2 } };
        int operations[][] = { { 2, 0, 0, 1, 1 }, { -1, 1, 0, 2, 2 } };

        System.out.println(applyDiff2D(matrix, operations));
    }
}
