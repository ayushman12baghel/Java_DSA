class Solution {
    static void swapDiagonal(int[][] mat) {
        int size = mat.length;

        for (int i = 0; i < size; i++) {

            // Swap major and minor diagonal elements
            int temp = mat[i][i];
            mat[i][i] = mat[i][size - i - 1];
            mat[i][size - i - 1] = temp;
        }
    }
}