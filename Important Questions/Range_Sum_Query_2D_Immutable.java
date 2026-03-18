import java.util.*;

// Approach Using Prefix Sum O(n*m)
class NumMatrix {
    int n;
    int m;
    int prefix[][];

    public NumMatrix(int[][] matrix) {
        n = matrix.length;
        m = matrix[0].length;
        prefix = new int[n][m];
        prefix[0][0] = matrix[0][0];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }

                prefix[i][j] = matrix[i][j];
                prefix[i][j] += (i > 0 ? prefix[i - 1][j] : 0);
                prefix[i][j] += (j > 0 ? prefix[i][j - 1] : 0);
                prefix[i][j] -= (i > 0 && j > 0 ? prefix[i - 1][j - 1] : 0);
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int total = prefix[row2][col2];

        int top = (row1 > 0 ? prefix[row1 - 1][col2] : 0);
        int left = (col1 > 0 ? prefix[row2][col1 - 1] : 0);
        int overlap = (row1 > 0 && col1 > 0 ? prefix[row1 - 1][col1 - 1] : 0);

        return total - top - left + overlap;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */