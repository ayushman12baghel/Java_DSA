import java.util.*;

public class Diagonal_Traverse {

    // Using O(n*m) SPace
    public static int[] findDiagonalOrder(int matrix[][]) {
        int n = matrix.length;
        int m = matrix[0].length;
        int ans[] = new int[n * m];
        HashMap<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map.computeIfAbsent(i + j, k -> new ArrayList<>()).add(matrix[i][j]);
            }
        }

        int x = 0;
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            int key = entry.getKey();
            List<Integer> value = entry.getValue();

            if (key % 2 != 0) {
                for (int i = 0; i < value.size(); i++) {
                    ans[x++] = value.get(i);
                }
            } else {
                for (int i = value.size() - 1; i >= 0; i--) {
                    ans[x++] = value.get(i);
                }
            }
        }

        return ans;
    }

    // with O(1) space
    public static int[] findDiagonalOrder2(int matrix[][]) {
        int n = matrix.length;
        int m = matrix[0].length;
        int ans[] = new int[n * m];
        int row = 0;
        int col = 0;
        int direction = 1;

        for (int i = 0; i < n * m; i++) {
            ans[i] = matrix[row][col];

            if (direction == 1) {
                if (col == m - 1) {
                    row++;
                    direction = -1;
                } else if (row == 0) {
                    col++;
                    direction = -1;
                } else {
                    row--;
                    col++;
                }
            } else {
                if (row == n - 1) {
                    col++;
                    direction = 1;
                } else if (col == 0) {
                    row++;
                    direction = 1;
                } else {
                    row++;
                    col--;
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int matrix[][] = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        int ans[] = findDiagonalOrder(matrix);
        for (int num : ans) {
            System.out.print(num + " ");
        }
        System.out.println();
        int ans2[] = findDiagonalOrder2(matrix);
        for (int num : ans2) {
            System.out.print(num + " ");
        }
    }
}
