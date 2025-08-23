import java.util.*;

public class Spiral_Matrix_II {

    public static int[][] generateMatrix(int n) {
        int startRow = 0;
        int startCol = 0;
        int endRow = n - 1;
        int endCol = n - 1;

        int ans[][] = new int[n][n];
        int num = 1;

        while (startRow <= endRow && startCol <= endCol) {
            // top
            for (int i = startCol; i <= endCol; i++) {
                ans[startRow][i] = num++;
            }

            // right
            for (int i = startRow + 1; i <= endRow; i++) {
                ans[i][endCol] = num++;
            }

            // bottom
            if (startRow < endRow) {
                for (int i = endCol - 1; i >= startCol; i--) {
                    ans[endRow][i] = num++;
                }
            }

            // left
            if (startCol < endCol) {
                for (int i = endRow - 1; i >= startCol + 1; i--) {
                    ans[i][startCol] = num++;
                }
            }

            startRow++;
            startCol++;
            endRow--;
            endCol--;
        }

        return ans;
    }

    public static void main(String[] args) {
        int n = 3;

        int ans[][] = generateMatrix(n);
        for (int i = 0; i < ans.length; i++) {
            for (int j = 0; j < ans[0].length; j++) {
                System.out.print(ans[i][j] + " ");
            }

            System.out.println();
        }
    }
}
