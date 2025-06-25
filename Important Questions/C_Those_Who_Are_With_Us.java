import java.util.*;

public class C_Those_Who_Are_With_Us {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();

            int grid[][] = new int[n][m];
            int max = Integer.MIN_VALUE;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    grid[i][j] = sc.nextInt();
                    max = Math.max(max, grid[i][j]);
                }
            }

            int rowCount[] = new int[n];
            int colCount[] = new int[m];
            int totalCount = 0;
            boolean isCovered = false;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (grid[i][j] == max) {
                        rowCount[i]++;
                        colCount[j]++;
                        totalCount++;
                    }
                }
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    int total = rowCount[i] + colCount[j] - (grid[i][j] == max ? 1 : 0);

                    if (totalCount == total) {
                        isCovered = true;
                    }
                }
            }

            if (isCovered) {
                System.out.println(max - 1);
            } else {
                System.out.println(max);
            }
        }

    }
}