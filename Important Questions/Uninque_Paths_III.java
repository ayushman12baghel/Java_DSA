public class Uninque_Paths_III {

    public static int uniquePathsIII(int grid[][]) {
        int m = grid.length;
        int n = grid[0].length;
        int emptySquares = 0;
        int start[] = new int[2];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    start[0] = i;
                    start[1] = j;
                } else if (grid[i][j] == 0) {
                    emptySquares++;
                }
            }
        }
        return backtrack(grid, new boolean[m][n], start[0], start[1], m, n, emptySquares);
    }

    public static int backtrack(int grid[][], boolean visited[][], int row, int col, int m, int n, int emptySquares) {
        if (row < 0 || col < 0 || row >= m || col >= n || visited[row][col] || grid[row][col] == -1) {
            return 0;
        }
        if (grid[row][col] == 2) {
            return emptySquares == 0 ? 1 : 0;
        }

        visited[row][col] = true;
        if (grid[row][col] == 0) {
            emptySquares--;
        }

        int up = backtrack(grid, visited, row - 1, col, m, n, emptySquares);
        int down = backtrack(grid, visited, row + 1, col, m, n, emptySquares);
        int left = backtrack(grid, visited, row, col - 1, m, n, emptySquares);
        int right = backtrack(grid, visited, row, col + 1, m, n, emptySquares);

        visited[row][col] = false;
        if (grid[row][col] == 0) {
            emptySquares++;
        }

        return up + down + left + right;
    }

    public static void main(String args[]) {
        int grid[][] = { { 1, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 2, -1 } };

        System.out.println(uniquePathsIII(grid));
    }
}
