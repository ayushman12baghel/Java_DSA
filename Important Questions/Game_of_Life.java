import java.util.*;

//Approach 1 Using Extra Space O(n^2)
class Solution {
    public void gameOfLife(int[][] board) {
        int n = board.length;
        int m = board[0].length;

        int temp[][] = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                temp[i][j] = solve(board, i, j);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                board[i][j] = temp[i][j];
            }
        }
    }

    public int solve(int grid[][], int i, int j) {
        int n = grid.length;
        int m = grid[0].length;
        int countLive = 0;
        int directions[][] = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 }, { -1, -1 }, { -1, 1 }, { 1, -1 }, { 1, 1 } };

        for (int direction[] : directions) {
            int newX = i + direction[0];
            int newY = j + direction[1];
            if (newX >= 0 && newY >= 0 && newX < n && newY < m) {
                if (grid[newX][newY] == 1) {
                    countLive++;
                }
            }
        }

        if (grid[i][j] == 1) {
            if (countLive < 2) {
                return 0;
            } else if (countLive > 3) {
                return 0;
            } else {
                return 1;
            }
        } else {
            if (countLive == 3) {
                return 1;
            } else {
                return 0;
            }
        }
    }
}

// Approach 2 Using No Extra Space
class Solution {
    public void gameOfLife(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int directions[][] = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 }, { -1, -1 }, { -1, 1 }, { 1, -1 }, { 1, 1 } };

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int live = 0;

                for (int direction[] : directions) {
                    int newX = i + direction[0];
                    int newY = j + direction[1];
                    if (newX >= 0 && newY >= 0 && newX < n && newY < m) {
                        if (Math.abs(grid[newX][newY]) == 1) {
                            live++;
                        }
                    }
                }

                if (grid[i][j] == 1) {
                    if (live < 2 || live > 3) {
                        grid[i][j] = -1;
                    }
                } else {
                    if (live == 3) {
                        grid[i][j] = -2;
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == -1) {
                    grid[i][j] = 0;
                } else if (grid[i][j] == -2) {
                    grid[i][j] = 1;
                }
            }
        }
    }
}