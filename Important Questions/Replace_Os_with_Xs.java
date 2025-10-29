import java.util.*;

//Approach 1 Using DSU O(n*m*@) @=constant
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
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        int size = n * m + 1;

        DSU dsu = new DSU(size);
        int dummyNode = n * m;
        int directions[][] = { { 1, 0 }, { -1, 0 }, { 0, -1 }, { 0, 1 } };

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'O') {
                    if (i == 0 || j == 0 || i == n - 1 || j == m - 1) {
                        dsu.union(i * m + j, dummyNode);
                    } else {
                        for (int direction[] : directions) {
                            int newRow = direction[0] + i;
                            int newCol = direction[1] + j;

                            if (board[newRow][newCol] == 'O') {
                                dsu.union(newRow * m + newCol, i * m + j);
                            }
                        }
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'O' && dsu.find(i * m + j) != dsu.find(dummyNode)) {
                    board[i][j] = 'X';
                }
            }
        }
    }
}

// Approach 2 Using BFS O(n*m)
class Solution {
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;

        // Boundary COL
        for (int i = 0; i < n; i++) {
            if (board[i][0] == 'O') {// left First Col
                bfs(board, i, 0);
            }
            if (board[i][m - 1] == 'O') {// right Last Col
                bfs(board, i, m - 1);
            }
        }

        // Boundary Row
        for (int i = 0; i < m; i++) {
            if (board[0][i] == 'O') {// left First Row
                bfs(board, 0, i);
            }
            if (board[n - 1][i] == 'O') {// right Last Row
                bfs(board, n - 1, i);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == 'S') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    public void bfs(char board[][], int i, int j) {
        int n = board.length;
        int m = board[0].length;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] { i, j });
        board[i][j] = 'S';

        int directions[][] = { { 1, 0 }, { -1, 0 }, { 0, -1 }, { 0, 1 } };

        while (!queue.isEmpty()) {
            int current[] = queue.poll();
            int row = current[0];
            int col = current[1];

            for (int direction[] : directions) {
                int newRow = direction[0] + row;
                int newCol = direction[1] + col;

                if (newRow >= 0 && newCol >= 0 && newRow < n && newCol < m && board[newRow][newCol] == 'O') {
                    queue.offer(new int[] { newRow, newCol });
                    board[newRow][newCol] = 'S';
                }
            }
        }
    }
}