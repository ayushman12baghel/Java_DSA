public class Count_Unguarded_Cells_in_Grid {

    public static void marksAsDone(int row, int col, int grid[][]) {
        for (int i = row - 1; i >= 0; i--) {
            if (grid[i][col] == 2 || grid[i][col] == 3) {
                break;
            }

            grid[i][col] = 1;
        }

        for (int i = row + 1; i < grid.length; i++) {
            if (grid[i][col] == 2 || grid[i][col] == 3) {
                break;
            }

            grid[i][col] = 1;
        }

        for (int i = col - 1; i >= 0; i--) {
            if (grid[row][i] == 2 || grid[row][i] == 3) {
                break;
            }

            grid[row][i] = 1;
        }

        for (int i = col + 1; i < grid[0].length; i++) {
            if (grid[row][i] == 2 || grid[row][i] == 3) {
                break;
            }

            grid[row][i] = 1;
        }
    }

    public static int unGuardedCells(int guards[][], int walls[][], int m, int n) {
        int grid[][] = new int[m][n];
        int count = 0;

        for (int guard[] : guards) {
            int i = guard[0];
            int j = guard[1];

            grid[i][j] = 2;
        }

        for (int wall[] : walls) {
            int i = wall[0];
            int j = wall[1];

            grid[i][j] = 3;
        }

        for (int guard[] : guards) {
            int row = guard[0];
            int col = guard[1];

            marksAsDone(row, col, grid);
        }

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    count++;
                }
            }
        }

        return count;

    }

    public static void main(String[] args) {
        int guards[][] = { { 0, 0 }, { 1, 1 }, { 2, 3 } };
        int walls[][] = { { 0, 1 }, { 2, 2 }, { 1, 4 } };
        int m = 4;
        int n = 6;

        System.out.println(unGuardedCells(guards, walls, m, n));
    }
}
