import java.util.*;

//Approach 1 O(2^(n*m))
class Solution {
    public ArrayList<ArrayList<Integer>> shortestDist(int[][] grid) {
        int n = grid.length;

        int ans[][] = new int[n][n];

        if (solve(grid, 0, 0, ans)) {
            ArrayList<ArrayList<Integer>> temp = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                temp.add(new ArrayList<>());
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    temp.get(i).add(ans[i][j]);
                }
            }

            return temp;
        }

        ArrayList<ArrayList<Integer>> temp = new ArrayList<>();
        temp.add(new ArrayList<>());
        temp.get(0).add(-1);

        return temp;
    }

    public boolean solve(int grid[][], int i, int j, int ans[][]) {
        int n = grid.length;

        if (i == n - 1 && j == n - 1) {
            ans[i][j] = 1;
            return true;
        }

        if (i >= n || j >= n || grid[i][j] == 0) {
            return false;
        }

        ans[i][j] = 1;
        int steps = grid[i][j];

        for (int k = 1; k <= steps; k++) {
            if (j + k < n && solve(grid, i, j + k, ans)) {
                return true;
            }

            if (i + k < n && solve(grid, i + k, j, ans)) {
                return true;
            }
        }

        ans[i][j] = 0;

        return false;
    }
}

// Approach 2 O(n*n*max(element))
class Solution {
    public ArrayList<ArrayList<Integer>> shortestDist(int[][] grid) {
        int n = grid.length;

        int ans[][] = new int[n][n];
        boolean deadEnd[][] = new boolean[n][n];

        if (solve(grid, 0, 0, ans, deadEnd)) {
            ArrayList<ArrayList<Integer>> temp = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                temp.add(new ArrayList<>());
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    temp.get(i).add(ans[i][j]);
                }
            }

            return temp;
        }

        ArrayList<ArrayList<Integer>> temp = new ArrayList<>();
        temp.add(new ArrayList<>());
        temp.get(0).add(-1);

        return temp;
    }

    public boolean solve(int grid[][], int i, int j, int ans[][], boolean deadEnd[][]) {
        int n = grid.length;

        if (i == n - 1 && j == n - 1) {
            ans[i][j] = 1;
            return true;
        }

        if (i >= n || j >= n || grid[i][j] == 0 || deadEnd[i][j]) {
            return false;
        }

        ans[i][j] = 1;
        int steps = grid[i][j];

        for (int k = 1; k <= steps; k++) {
            if (j + k < n && solve(grid, i, j + k, ans, deadEnd)) {
                return true;
            }

            if (i + k < n && solve(grid, i + k, j, ans, deadEnd)) {
                return true;
            }
        }

        ans[i][j] = 0;
        deadEnd[i][j] = true;

        return false;
    }
}