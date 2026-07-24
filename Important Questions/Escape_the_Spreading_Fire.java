//Approach Using MultiSource BFS and Binary Search on Ans 
// O(n*m* log(10000000)
class Solution {
    public int maximumMinutes(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        if (grid[0][0] == 1) {
            return -1;
        }

        Queue<int[]> fire = new LinkedList<>();
        int time[][] = new int[n][m];
        for (int row[] : time) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    fire.offer(new int[] { i, j });
                    time[i][j] = 0;
                }
            }
        }

        int directions[][] = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

        while (!fire.isEmpty()) {
            int current[] = fire.poll();
            int row = current[0];
            int col = current[1];

            for (int direction[] : directions) {
                int newRow = row + direction[0];
                int newCol = col + direction[1];

                if (newRow >= 0 && newCol >= 0 && newRow < n && newCol < m && time[newRow][newCol] == Integer.MAX_VALUE
                        && grid[newRow][newCol] != 2) {
                    int newTime = time[row][col] + 1;
                    fire.offer(new int[] { newRow, newCol });
                    time[newRow][newCol] = newTime;
                }
            }
        }

        int left = 0;
        int right = 1000000000;
        int result = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (isPossible(grid, time, mid, n, m)) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return result;
    }

    public boolean isPossible(int grid[][], int fireTime[][], int mid, int n, int m) {
        if (fireTime[0][0] <= mid) {
            return false;
        }

        Queue<int[]> queue = new LinkedList<>();
        boolean visited[][] = new boolean[n][m];
        queue.offer(new int[] { 0, 0 });
        visited[0][0] = true;
        int time = mid;

        int directions[][] = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int current[] = queue.poll();
                int row = current[0];
                int col = current[1];

                if (row == n - 1 && col == m - 1) {
                    return true;
                }

                for (int direction[] : directions) {
                    int newRow = row + direction[0];
                    int newCol = col + direction[1];
                    int newTime = time + 1;

                    if (newRow >= 0 && newCol >= 0 && newRow < n && newCol < m && newTime < fireTime[newRow][newCol]
                            && !visited[newRow][newCol] && grid[newRow][newCol]!=2) {
                        queue.offer(new int[] { newRow, newCol });
                        visited[newRow][newCol] = true;
                    }
                }
            }

            time++;
        }

        return false;
    }
}
