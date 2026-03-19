import java.util.*;

//Approach 1 Using Prefix Sum But Object Creation Bottleneck O(n*m)
class Solution {
    class Pair {
        int countX;
        int countY;

        public Pair(int countX, int countY) {
            this.countX = countX;
            this.countY = countY;
        }
    }

    public int numberOfSubmatrices(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        Pair prefix[][] = new Pair[n][m];
        if (grid[0][0] == 'X') {
            prefix[0][0] = new Pair(1, 0);
        } else if (grid[0][0] == 'Y') {
            prefix[0][0] = new Pair(0, 1);
        } else {
            prefix[0][0] = new Pair(0, 0);
        }

        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }

                if (grid[i][j] == 'X') {
                    prefix[i][j] = new Pair(1, 0);
                } else if (grid[i][j] == 'Y') {
                    prefix[i][j] = new Pair(0, 1);
                } else {
                    prefix[i][j] = new Pair(0, 0);
                }

                if (i > 0) {
                    prefix[i][j].countX += prefix[i - 1][j].countX;
                    prefix[i][j].countY += prefix[i - 1][j].countY;
                }

                if (j > 0) {
                    prefix[i][j].countX += prefix[i][j - 1].countX;
                    prefix[i][j].countY += prefix[i][j - 1].countY;
                }

                if (i > 0 && j > 0) {
                    prefix[i][j].countX -= prefix[i - 1][j - 1].countX;
                    prefix[i][j].countY -= prefix[i - 1][j - 1].countY;
                }

                if (prefix[i][j].countX == prefix[i][j].countY && prefix[i][j].countX > 0) {
                    count++;
                }
            }
        }

        return count;
    }
}

// Approach 2 O(n*m) Using Array as PrefixSum
class Solution {
    public int numberOfSubmatrices(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int countX[][] = new int[n][m];
        int countY[][] = new int[n][m];
        if (grid[0][0] == 'X') {
            countX[0][0] = 1;
        } else if (grid[0][0] == 'Y') {
            countY[0][0] = 1;
        }

        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }

                if (grid[i][j] == 'X') {
                    countX[i][j] = 1;
                } else if (grid[i][j] == 'Y') {
                    countY[i][j] = 1;
                }

                if (i > 0) {
                    countX[i][j] += countX[i - 1][j];
                    countY[i][j] += countY[i - 1][j];
                }

                if (j > 0) {
                    countX[i][j] += countX[i][j - 1];
                    countY[i][j] += countY[i][j - 1];
                }

                if (i > 0 && j > 0) {
                    countX[i][j] -= countX[i - 1][j - 1];
                    countY[i][j] -= countY[i - 1][j - 1];
                }

                if (countX[i][j] == countY[i][j] && countX[i][j] > 0) {
                    count++;
                }
            }
        }

        return count;
    }
}

// Approach 3 Optimal O(n*m) WIth O(m) Space
class Solution {
    public int numberOfSubmatrices(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int countX[] = new int[m];
        int countY[] = new int[m];

        int count = 0;

        for (int i = 0; i < n; i++) {
            int rowX = 0;
            int rowY = 0;
            for (int j = 0; j < m; j++) {

                if (grid[i][j] == 'X') {
                    rowX++;
                } else if (grid[i][j] == 'Y') {
                    rowY++;
                }

                countX[j] += rowX;
                countY[j] += rowY;

                if (countX[j] > 0 && countX[j] == countY[j]) {
                    count++;
                }
            }
        }

        return count;
    }
}