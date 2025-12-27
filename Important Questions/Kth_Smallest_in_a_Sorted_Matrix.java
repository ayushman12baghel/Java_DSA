import java.util.*;

// Approach Binary Search on Ans O(nlog(n))
class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;

        int left = matrix[0][0];
        int right = matrix[n - 1][n - 1];
        int result = matrix[0][0];

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (countLowerEqual(matrix, mid) >= k) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return result;
    }

    public int countLowerEqual(int matrix[][], int mid) {
        int n = matrix.length;
        int count = 0;
        int row = n - 1;
        int col = 0;

        while (row >= 0 && col < n) {
            if (matrix[row][col] <= mid) {
                count += (row + 1);
                col++;
            } else {
                row--;
            }
        }

        return count;
    }
}