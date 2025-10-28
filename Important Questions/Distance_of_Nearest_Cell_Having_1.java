import java.util.*;

//O(n*m)
class Solution {
    public ArrayList<ArrayList<Integer>> nearest(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();
        boolean visited[][] = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    queue.offer(new int[] { i, j });
                    visited[i][j] = true;
                    grid[i][j] = 0;
                }
            }
        }

        int distance = 1;
        int directions[][] = { { 1, 0 }, { -1, 0 }, { 0, -1 }, { 0, 1 } };

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int current[] = queue.poll();
                int row = current[0];
                int col = current[1];

                for (int direction[] : directions) {
                    int newRow = direction[0] + row;
                    int newCol = direction[1] + col;

                    if (newRow >= 0 && newCol >= 0 && newRow < n && newCol < m && !visited[newRow][newCol]) {
                        queue.offer(new int[] { newRow, newCol });
                        visited[newRow][newCol] = true;
                        grid[newRow][newCol] = distance;
                    }
                }
            }

            distance++;
        }

        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ArrayList<Integer> temp = new ArrayList<>();

            for (int j = 0; j < m; j++) {
                temp.add(grid[i][j]);
            }

            ans.add(temp);
        }

        return ans;
    }
}