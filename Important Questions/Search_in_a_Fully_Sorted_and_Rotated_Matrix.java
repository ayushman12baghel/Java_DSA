public class Search_in_a_Fully_Sorted_and_Rotated_Matrix {

    // Approach Using Binary Search O(log(n*m))
    public static boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;
        int pivotIndex = findPivot(matrix);

        boolean searchFirst = binarySearch(matrix, 0, pivotIndex - 1, target);
        if (searchFirst) {
            return true;
        }

        return binarySearch(matrix, pivotIndex, n * m - 1, target);
    }

    public static int findPivot(int matrix[][]) {
        int n = matrix.length;
        int m = matrix[0].length;

        int left = 0;
        int right = n * m - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;
            int row = mid / m;
            int col = mid % m;
            int rightRow = right / m;
            int rightCol = right % m;

            if (matrix[row][col] > matrix[rightRow][rightCol]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }

    public static boolean binarySearch(int matrix[][], int left, int right, int target) {
        int n = matrix.length;
        int m = matrix[0].length;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int row = mid / m;
            int col = mid % m;

            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int matrix[][] = { { 7, 8, 9, 10 },
                { 11, 12, 13, 1 },
                { 2, 3, 4, 5 } };

        System.out.println(searchMatrix(matrix, 3));
    }
}
