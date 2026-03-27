import java.util.*;

// Approach O(n^2)
class Solution {
    public boolean areSimilar(int[][] mat, int k) {
        int m = mat.length;
        int n = mat[0].length;

        k = k % n;
        if (k == 0)
            return true;

        // Copy matrix
        int[][] temp = new int[m][n];
        for (int i = 0; i < m; i++) {
            temp[i] = mat[i].clone();
        }

        for (int i = 0; i < m; i++) {
            if (i % 2 == 0) {
                // even : left shift
                rotateLeft(mat[i], k); // you can write your own logic as well
            } else {
                // odd : right shift
                rotateRight(mat[i], k); // you can write your own logic as well
            }
        }

        // Compare
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] != temp[i][j]) {
                    return false;
                }
            }
        }

        return true;
    }

    private void rotateLeft(int[] row, int k) {
        reverse(row, 0, k - 1);
        reverse(row, k, row.length - 1);
        reverse(row, 0, row.length - 1);
    }

    private void rotateRight(int[] row, int k) {
        int n = row.length;
        rotateLeft(row, n - k);
    }

    private void reverse(int[] row, int l, int r) {
        while (l < r) {
            int temp = row[l];
            row[l] = row[r];
            row[r] = temp;
            l++;
            r--;
        }
    }
}
