import java.util.*;

//Approach 1 Brute Force O(n*m*n*m)
class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;
        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (bfs(heights, i, j)) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(i);
                    temp.add(j);
                    ans.add(new ArrayList<>(temp));
                }
            }
        }

        return ans;
    }

    public boolean bfs(int heights[][], int i, int j) {
        int n = heights.length;
        int m = heights[0].length;

        Queue<int[]> queue = new LinkedList<>();
        boolean visited[][] = new boolean[n][m];
        boolean canReachP = false;
        boolean canReachA = false;
        queue.offer(new int[] { i, j });
        visited[i][j] = true;

        int directions[][] = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

        while (!queue.isEmpty()) {
            int current[] = queue.poll();
            int row = current[0];
            int col = current[1];

            if (row == 0 || col == 0) {
                canReachP = true;
            }

            if (col == m - 1 || row == n - 1) {
                canReachA = true;
            }

            if (canReachA && canReachP) {
                return true;
            }

            for (int direction[] : directions) {
                int newRow = direction[0] + row;
                int newCol = direction[1] + col;

                if (newRow >= 0 && newCol >= 0 && newRow < n && newCol < m && !visited[newRow][newCol]
                        && heights[newRow][newCol] <= heights[row][col]) {
                    visited[newRow][newCol] = true;
                    queue.offer(new int[] { newRow, newCol });
                }
            }
        }

        return false;
    }
}

// Approach 2 Precomputing canReach O(n*m)
class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;

        List<List<Integer>> ans = new ArrayList<>();
        boolean pacific[][] = new boolean[n][m];
        boolean atlantic[][] = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            bfs(heights, i, 0, pacific);
            bfs(heights, i, m - 1, atlantic);
        }

        for (int j = 0; j < m; j++) {
            bfs(heights, 0, j, pacific);
            bfs(heights, n - 1, j, atlantic);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(i);
                    temp.add(j);
                    ans.add(temp);
                }
            }
        }

        return ans;
    }

    int directions[][] = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

    public void bfs(int heights[][], int i, int j, boolean canVisit[][]) {
        int n = heights.length;
        int m = heights[0].length;

        if (canVisit[i][j]) {
            return;
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] { i, j });
        canVisit[i][j] = true;

        while (!queue.isEmpty()) {
            int current[] = queue.poll();
            int row = current[0];
            int col = current[1];

            for (int direction[] : directions) {
                int newRow = direction[0] + row;
                int newCol = direction[1] + col;

                if (newRow >= 0 && newCol >= 0 && newRow < n && newCol < m && !canVisit[newRow][newCol]
                        && heights[newRow][newCol] >= heights[row][col]) {
                    canVisit[newRow][newCol] = true;
                    queue.offer(new int[] { newRow, newCol });
                }
            }
        }
    }
}