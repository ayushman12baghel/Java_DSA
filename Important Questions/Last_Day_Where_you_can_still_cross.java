import java.util.*;

// Approach Binary Search and BFS O(row*col *(log(n)))
class Solution {
    public int latestDayToCross(int row, int col, int[][] cells) {
        int left = 0;
        int right = cells.length - 1;
        int result = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (isPossible(cells, mid, row, col)) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return result + 1;
    }

    public boolean isPossible(int cells[][], int day, int row, int col) {
        int grid[][] = new int[row][col];

        for (int i = 0; i <= day; i++) {
            int r = cells[i][0] - 1;
            int c = cells[i][1] - 1;

            grid[r][c] = 1;
        }

        Queue<int[]> queue = new LinkedList<>();
        boolean visited[][] = new boolean[grid.length][grid[0].length];

        for (int j = 0; j < col; j++) {
            if (grid[0][j] == 0) {
                queue.offer(new int[] { 0, j });
                visited[0][j] = true;
            }
        }

        int directions[][] = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

        while (!queue.isEmpty()) {
            int current[] = queue.poll();
            int r = current[0];
            int c = current[1];

            if (r == grid.length - 1) {
                return true;
            }

            for (int direction[] : directions) {
                int newRow = direction[0] + r;
                int newCol = direction[1] + c;

                if (newRow >= 0 && newCol >= 0 && newRow < grid.length && newCol < grid[0].length
                        && !visited[newRow][newCol] && grid[newRow][newCol] == 0) {
                    visited[newRow][newCol] = true;
                    queue.offer(new int[] { newRow, newCol });
                }
            }
        }

        return false;
    }
}

// Approach 2 DSU + Binary Search O(row * col * log(n) * @(n))
class DSU {
    int parent[];
    int size[];

    public DSU(int n) {
        this.parent = new int[n];
        this.size = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    public int find(int i) {
        if (parent[i] == i) {
            return i;
        }

        return parent[i] = find(parent[i]);
    }

    public void union(int x, int y) {
        int parentX = find(x);
        int parentY = find(y);

        if (parentX == parentY) {
            return;
        }

        if (size[parentX] > size[parentY]) {
            parent[parentY] = parentX;
            size[parentX] += size[parentY];
        } else {
            parent[parentX] = parentY;
            size[parentY] += size[parentX];
        }
    }
}

class Solution {
    public int latestDayToCross(int row, int col, int[][] cells) {
        int left = 0;
        int right = cells.length - 1;
        int result = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (isPossible(cells, mid, row, col)) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return result + 1;
    }

    public boolean isPossible(int cells[][], int day, int row, int col) {
        int grid[][] = new int[row][col];
        int total = row * col;
        int top = total;
        int bottom = total + 1;

        DSU dsu = new DSU(total + 2);

        for (int i = 0; i <= day; i++) {
            int r = cells[i][0] - 1;
            int c = cells[i][1] - 1;

            grid[r][c] = 1;
        }

        int directions[][] = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                if (grid[r][c] == 1) {
                    continue;
                }

                int currId = r * col + c;

                if (r == 0) {
                    dsu.union(currId, top);
                }

                if (r == row - 1) {
                    dsu.union(currId, bottom);
                }

                for (int direction[] : directions) {
                    int nr = r + direction[0];
                    int nc = c + direction[1];

                    if (nr >= 0 && nc >= 0 && nr < row && nc < col && grid[nr][nc] == 0) {
                        int newId = nr * col + nc;
                        dsu.union(newId, currId);
                    }
                }
            }
        }

        return dsu.find(top) == dsu.find(bottom);
    }
}

// Approach 3 DSU Using Time Travel in Reverse O(row*col)
class DSU {
    int parent[];
    int size[];

    public DSU(int n) {
        this.parent = new int[n];
        this.size = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    public int find(int i) {
        if (parent[i] == i) {
            return i;
        }

        return parent[i] = find(parent[i]);
    }

    public void union(int x, int y) {
        int parentX = find(x);
        int parentY = find(y);

        if (parentX == parentY) {
            return;
        }

        if (size[parentX] > size[parentY]) {
            parent[parentY] = parentX;
            size[parentX] += size[parentY];
        } else {
            parent[parentX] = parentY;
            size[parentY] += size[parentX];
        }
    }
}

class Solution {
    public int latestDayToCross(int row, int col, int[][] cells) {
        int grid[][] = new int[row][col];
        int total = row * col;
        int top = total;
        int bottom = total + 1;

        DSU dsu = new DSU(total + 2);

        for (int i = 0; i < cells.length; i++) {
            int r = cells[i][0] - 1;
            int c = cells[i][1] - 1;

            grid[r][c] = 1;
        }

        int directions[][] = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                if (grid[r][c] == 1) {
                    continue;
                }

                int currId = r * col + c;

                if (r == 0) {
                    dsu.union(currId, top);
                }

                if (r == row - 1) {
                    dsu.union(currId, bottom);
                }

                for (int direction[] : directions) {
                    int nr = r + direction[0];
                    int nc = c + direction[1];

                    if (nr >= 0 && nc >= 0 && nr < row && nc < col && grid[nr][nc] == 0) {
                        int newId = nr * col + nc;
                        dsu.union(newId, currId);
                    }
                }
            }
        }
        if (dsu.find(top) == dsu.find(bottom)) {
            return cells.length;
        }

        for (int i = cells.length - 1; i >= 0; i--) {
            int r = cells[i][0] - 1;
            int c = cells[i][1] - 1;

            grid[r][c] = 0;
            int currId = r * col + c;

            if (r == 0) {
                dsu.union(currId, top);
            }

            if (r == row - 1) {
                dsu.union(currId, bottom);
            }

            for (int direction[] : directions) {
                int nr = direction[0] + r;
                int nc = direction[1] + c;

                if (nr >= 0 && nc >= 0 && nr < row && nc < col && grid[nr][nc] == 0) {
                    int newId = nr * col + nc;
                    dsu.union(newId, currId);
                }
            }

            if (dsu.find(top) == dsu.find(bottom)) {
                return i;
            }
        }

        return 0;
    }
}