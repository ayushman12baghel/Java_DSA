import java.util.HashMap;
import java.util.Map;

public class First_Completely_Painted_Row_or_Column {

    // Brute Force
    public static int firstCompleteIndex(int[] arr, int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        Map<Integer, int[]> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map.put(mat[i][j], new int[] { i, j });
            }
        }

        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];
            int current[] = map.get(num);
            int row = current[0];
            int col = current[1];
            mat[row][col] = -1;

            if (checkRow(mat, row) || checkCol(mat, col)) {
                return i;
            }
        }

        return -1;
    }

    public static boolean checkRow(int mat[][], int row) {
        for (int i = 0; i < mat[0].length; i++) {
            if (mat[row][i] > 0) {
                return false;
            }
        }

        return true;
    }

    public static boolean checkCol(int mat[][], int col) {
        for (int i = 0; i < mat.length; i++) {
            if (mat[i][col] > 0) {
                return false;
            }
        }

        return true;
    }

    // Somewhat Optimised
    public static int firstCompleteIndex2(int[] arr, int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        Map<Integer, int[]> map = new HashMap<>();
        int rowCount[] = new int[n];
        int colCount[] = new int[m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map.put(mat[i][j], new int[] { i, j });
            }
        }

        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];
            int current[] = map.get(num);
            int row = current[0];
            int col = current[1];
            mat[row][col] = -1;
            colCount[col]++;
            rowCount[row]++;

            if (rowCount[row] == m || colCount[col] == n) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String args[]) {
        int arr[] = { 2, 8, 7, 4, 1, 3, 5, 6, 9 };
        int mat[][] = { { 3, 2, 5 }, { 1, 4, 6 }, { 8, 7, 9 } };
        int mat2[][] = { { 3, 2, 5 }, { 1, 4, 6 }, { 8, 7, 9 } };
        System.out.println(firstCompleteIndex(arr, mat));
        System.out.println(firstCompleteIndex2(arr, mat2));
    }
}
