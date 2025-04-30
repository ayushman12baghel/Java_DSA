public class Floyd_Warshall {
    public static void floydWarshall(int[][] grid) {
        // Code here
        int n = grid.length;

        for (int via = 0; via < n; via++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][via] != 100000000 && grid[via][j] != 100000000
                            && grid[i][j] > grid[i][via] + grid[via][j]) {
                        grid[i][j] = grid[i][via] + grid[via][j];
                    }
                }
            }
        }
    }
}
