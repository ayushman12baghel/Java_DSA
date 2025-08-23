import java.util.*;

public class Median_on_a_Row_Wise_Sorted_Matrix {

    // Binary Search on Ans and Binary Search O(log(max-min) * n * log(m))
    public static int median(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            min = Math.min(matrix[i][0], min);
            max = Math.max(max, matrix[i][m - 1]);
        }

        int desired = (n * m + 1) / 2;
        int result = -1;

        while (min <= max) {
            int mid = min + (max - min) / 2;

            int count = 0;
            for (int i = 0; i < n; i++) {
                count += countSmallerEqual(matrix[i], mid);
            }

            if (count < desired) {
                min = mid + 1;
            } else {
                result = mid;
                max = mid - 1;
            }
        }

        return result;
    }

    public static int countSmallerEqual(int nums[], int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return left;
    }

    public static void main(String[] args) {
        int matrix[][] = { { 2, 4, 9 },
                { 3, 6, 7 },
                { 4, 7, 1 } };

        System.out.println(median(matrix));
    }
}
