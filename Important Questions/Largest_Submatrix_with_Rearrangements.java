import java.util.*;

//Approach 1 O(n*m*logn)
class Solution {
    public int largestSubmatrix(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int maxArea = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i > 0 && matrix[i][j] == 1) {
                    matrix[i][j] += matrix[i - 1][j];
                }
            }

            int heights[] = matrix[i].clone();
            Arrays.sort(heights);

            for (int k = m - 1; k >= 0; k--) {
                int base = m - k;
                int height = heights[k];

                maxArea = Math.max(maxArea, height * base);
            }
        }

        return maxArea;
    }
}

// Approach 2 Without Modifying Input O(n*m*log(n))
class Solution {
    public int largestSubmatrix(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int heights[] = new int[m];
        int maxArea = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 1) {
                    heights[j] += 1;
                } else {
                    heights[j] = 0;
                }
            }

            int current[] = heights.clone();
            Arrays.sort(current);

            for (int k = m - 1; k >= 0; k--) {
                int base = m - k;
                int height = current[k];

                maxArea = Math.max(maxArea, height * base);
            }
        }

        return maxArea;
    }
}