import java.util.*;

public class Maximum_Sum_Rectangle {

    // Using Kadane's Algorithm O(row^2*col)
    public static int maxRectSum(int matrix[][]) {
        int n = matrix.length;
        int m = matrix[0].length;

        int maxSum = Integer.MIN_VALUE;

        for (int top = 0; top < n; top++) {
            int temp[] = new int[m];

            for (int bottom = top; bottom < n; bottom++) {

                for (int col = 0; col < m; col++) {
                    temp[col] += matrix[bottom][col];
                }

                maxSum = Math.max(kadane(temp), maxSum);
            }
        }

        return maxSum;
    }

    public static int kadane(int nums[]) {
        int maxSum = nums[0];
        int currentMax = nums[0];

        for (int i = 1; i < nums.length; i++) {
            currentMax = Math.max(currentMax + nums[i], nums[i]);
            maxSum = Math.max(maxSum, currentMax);
        }

        return maxSum;
    }

    public static void main(String[] args) {
        int matrix[][] = { { 1, 2, -1, -4, -20 }, { -8, -3, 4, 2, 1 }, { 3, 8, 10, 1, 3 }, { -4, -1, 1, 7, -6 } };

        System.out.println(maxRectSum(matrix));
    }
}
