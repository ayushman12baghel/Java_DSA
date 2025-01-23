public class Count_Servers_that_Communicate {

    // Brute force O(n^3)
    public static int countServers(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    boolean possible = false;

                    for (int col = 0; col < m; col++) {
                        if (col != j && grid[i][col] == 1) {
                            possible = true;
                            break;
                        }
                    }
                    for (int col = 0; col < n; col++) {
                        if (col != i && grid[col][j] == 1) {
                            possible = true;
                            break;
                        }
                    }

                    if (possible) {
                        count++;
                    }
                }
            }
        }

        return count;
    }

    // Optimized O(n^2) using 2 arrays
    public static int countServers2(int grid[][]) {
        int n = grid.length;
        int m = grid[0].length;
        int rowCount[] = new int[m];
        int colCount[] = new int[n];
        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    rowCount[j]++;
                    colCount[i]++;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1 && (rowCount[j] > 1 || colCount[i] > 1)) {
                    count++;
                }
            }
        }

        return count;
    }

    public static void main(String args[]) {
        int grid[][] = { { 1, 1, 0, 0 }, { 0, 0, 1, 0 }, { 0, 0, 1, 0 }, { 0, 0, 0, 1 } };

        System.out.println(countServers(grid));
        System.out.println(countServers2(grid));
    }
}
