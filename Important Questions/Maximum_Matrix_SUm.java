public class Maximum_Matrix_SUm {

    public static long maxMatrixSum(int matrix[][]) {
        long total = 0;
        int negative = 0;
        int min = Integer.MAX_VALUE;

        for (int row[] : matrix) {
            for (int num : row) {
                total += Math.abs(num);
                if (num < 0) {
                    negative++;
                }
                min = Math.min(min, Math.abs(num));
            }
        }

        if (negative % 2 != 0) {
            total -= 2 * min;
        }

        return total;
    }

    public static void main(String args[]) {
        int matrix[][] = { { 1, 2, 3 }, { -1, -2, -3 }, { 1, 2, 3 } };

        System.out.println(maxMatrixSum(matrix));
    }
}
