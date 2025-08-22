import java.util.*;

public class Find_The_Minimum_Area_to_Cover_All_Ones_I {

    public static int minimumArea(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int maxRow = 0;
        int minRow = grid.length;
        int minCol = grid[0].length;
        int maxCol = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    maxRow = Math.max(maxRow, i);
                    minRow = Math.min(minRow, i);
                    minCol = Math.min(minCol, j);
                    maxCol = Math.max(maxCol, j);
                }
            }
        }

        return (maxCol - minCol + 1) * (maxRow - minRow + 1);
    }

    public static void main(String[] args) {

    }
}
