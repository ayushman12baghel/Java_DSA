import java.util.*;

// O(n*n)
class Solution {
    static ArrayList<Integer> diagView(int mat[][]) {
        int n = mat.length;
        ArrayList<Integer> result = new ArrayList<>();

        for (int s = 0; s <= 2 * (n - 1); s++) {
            for (int i = 0; i < n; i++) {
                int j = s - i;

                if (j >= 0 && j < n) {
                    result.add(mat[i][j]);
                }
            }
        }

        return result;
    }
}