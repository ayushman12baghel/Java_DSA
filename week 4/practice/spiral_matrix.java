public class spiral_matrix {
    public static void spiral_matrix(int matrix[][]) {
        int start_col = 0;
        int start_row = 0;
        int end_row = matrix.length - 1;
        int end_col = matrix[0].length - 1;

        while (start_col <= end_col && start_row <= end_row) {
            for (int j = start_col; j <= end_col; j++) {
                System.out.print(matrix[start_row][j] + " ");
            }
            for (int j = start_row + 1; j <= end_row; j++) {
                if (start_row == end_row) {
                    break;
                }
                System.out.print(matrix[end_col][j] + " ");
            }
            for (int j = end_col - 1; j >= start_col; j--) {
                if (start_row == end_row) {
                    break;
                }
                System.out.print(matrix[end_row][j] + " ");
            }
            for (int j = end_row - 1; j >= start_row + 1; j--) {
                if (start_row == end_row) {
                    break;
                }
                System.out.print(matrix[start_col][j] + " ");
            }
            start_col++;
            start_row++;
            end_col--;
            end_row--;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int matrix[][] = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
        spiral_matrix(matrix);
    }
}
