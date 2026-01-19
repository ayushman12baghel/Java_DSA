import java.util.*;

//Approach O(n*m*min(n,m))
class Solution {
    public int maxSideLength(int[][] grid, int threshold) {
        int n = grid.length;
        int m = grid[0].length;

        int prefix[][] = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int leftSum = (j > 0 ? prefix[i][j - 1] : 0);
                int topSum = (i > 0 ? prefix[i - 1][j] : 0);
                int diagonal = (i - 1 > 0 && j - 1 > 0 ? prefix[i - 1][j - 1] : 0);

                prefix[i][j] = grid[i][j] + leftSum + topSum - diagonal;
            }
        }

        int ans = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int size = 1; size <= Math.min(n - i, m - j); size++) {
                    int endRow = i + size - 1;
                    int endCol = j + size - 1;

                    int total = prefix[endRow][endCol];
                    int subtractTop = (i > 0 ? prefix[i - 1][endCol] : 0);
                    int subtractLeft = (j > 0 ? prefix[endRow][j - 1] : 0);
                    int addDiagonal = (i > 0 && j > 0 ? prefix[i - 1][j - 1] : 0);

                    int sum = total - subtractTop - subtractLeft + addDiagonal;

                    if (sum <= threshold) {
                        ans = Math.max(size, ans);
                    } else {
                        break;
                    }
                }
            }
        }

        return ans;
    }
}

// Approach 2 Using Sliding Window O(n*m)
class Solution {
    public int maxSideLength(int[][] grid, int threshold) {
        int n = grid.length;
        int m = grid[0].length;

        int prefix[][] = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int leftSum = (j > 0 ? prefix[i][j - 1] : 0);
                int topSum = (i > 0 ? prefix[i - 1][j] : 0);
                int diagonal = (i > 0 && j > 0 ? prefix[i - 1][j - 1] : 0);

                prefix[i][j] = grid[i][j] + leftSum + topSum - diagonal;
            }
        }

        int maxSize = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int size = maxSize + 1;

                if (i - size + 1 >= 0 && j - size + 1 >= 0) {
                    int startRow = i - size + 1;
                    int startCol = j - size + 1;

                    int total = prefix[i][j];
                    int subtractTop = (startRow > 0 ? prefix[startRow - 1][j] : 0);
                    int subtractLeft = (startCol > 0 ? prefix[i][startCol - 1] : 0);
                    int addDiagonal = (startRow > 0 && startCol > 0 ? prefix[startRow - 1][startCol - 1] : 0);

                    int sum = total - subtractTop - subtractLeft + addDiagonal;

                    if (sum <= threshold) {
                        maxSize = size;
                    }
                }
            }
        }

        return maxSize;
    }
}