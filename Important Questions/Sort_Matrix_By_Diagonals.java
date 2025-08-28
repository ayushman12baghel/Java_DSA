import java.util.*;

//Approach 1 Using HashMap and Sorting O(n^2*logn)
// O(n^2) space
class Solution {
    public int[][] sortMatrix(int[][] grid) {
        int n = grid.length;
        HashMap<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map.putIfAbsent(i - j, new ArrayList<>());
                map.get(i - j).add(grid[i][j]);
            }
        }

        int ans[][] = new int[n][n];
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            int key = entry.getKey();
            List<Integer> diag = entry.getValue();

            if (key >= 0) {
                Collections.sort(diag);
            } else {
                Collections.sort(diag, Collections.reverseOrder());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int key = i - j;

                List<Integer> diag = map.get(key);
                ans[i][j] = diag.get(diag.size() - 1);
                diag.remove(diag.size() - 1);
            }
        }

        return ans;
    }
}

// Approach 2 With O(n) space
class Solution {
    public int[][] sortMatrix(int[][] grid) {
        int n = grid.length;

        for (int row = 0; row < n; row++) {
            sortDiagonal(grid, row, 0, false);
        }

        for (int col = 1; col < n; col++) {
            sortDiagonal(grid, 0, col, true);
        }

        return grid;
    }

    public void sortDiagonal(int grid[][], int r, int c, boolean ascending) {
        int n = grid.length;
        List<Integer> diag = new ArrayList<>();
        int i = r;
        int j = c;

        while (i < n && j < n) {
            diag.add(grid[i][j]);
            i++;
            j++;
        }

        if (ascending) {
            Collections.sort(diag);
        } else {
            Collections.sort(diag, Collections.reverseOrder());
        }

        i = r;
        j = c;

        for (int num : diag) {
            grid[i][j] = num;
            i++;
            j++;
        }
    }
}