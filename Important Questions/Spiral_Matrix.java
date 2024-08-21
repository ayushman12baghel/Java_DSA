import java.util.ArrayList;
import java.util.List;

public class Spiral_Matrix {

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        int startRow = 0;
        int startCol = 0;
        int endRow = matrix.length - 1;
        int endCol = matrix[0].length - 1;

        while (startRow <= endRow && startCol <= endCol) {
            // top
            for (int i = startCol; i <= endCol; i++) {
                list.add(matrix[startRow][i]);
            }
            // right
            for (int i = startRow + 1; i <= endRow; i++) {
                list.add(matrix[i][endCol]);
            }
            // bottom
            for (int i = endCol - 1; i >= startCol; i--) {
                if (startRow == endRow)
                    break;
                list.add(matrix[endRow][i]);
            }
            // left
            for (int i = endRow - 1; i >= startRow + 1; i--) {
                if (startCol == endCol)
                    break;
                list.add(matrix[i][startCol]);
            }
            startCol++;
            endCol--;
            startRow++;
            endRow--;
        }

        return list;
    }

    public static void main(String args[]) {
        int matrix[][] = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        List<Integer> list = spiralOrder(matrix);

        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
    }
}
