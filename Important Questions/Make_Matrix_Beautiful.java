public class Make_Matrix_Beautiful {

    public static int balanceSums(int[][] matrix) {
        // code here
        int n = matrix.length;
        int m = matrix[0].length;
        int maxSum = 0;

        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = 0; j < m; j++) {
                sum += matrix[i][j];
            }

            maxSum = Math.max(maxSum, sum);
        }

        for (int i = 0; i < m; i++) {
            int sum = 0;
            for (int j = 0; j < n; j++) {
                sum += matrix[j][i];
            }

            maxSum = Math.max(maxSum, sum);
        }

        int operations = 0;

        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = 0; j < m; j++) {
                sum += matrix[i][j];
            }

            operations += (maxSum - sum);
        }

        return operations;
    }

    public static void main(String[] args) {
        int matrix[][] = { { 1, 2, 3 },
                { 4, 2, 3 },
                { 3, 2, 1 } };

        System.out.println(balanceSums(matrix));
    }
}
