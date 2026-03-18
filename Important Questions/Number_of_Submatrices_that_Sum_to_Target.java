import java.util.*;

// Approach 1 Brute Force With PrefixSum O(n^2*m^2)
class Solution {
    class NumMatrix {
        int n;
        int m;
        int prefix[][];

        public NumMatrix(int matrix[][]) {
            n = matrix.length;
            m = matrix[0].length;
            prefix = new int[n][m];
            prefix[0][0] = matrix[0][0];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (i == 0 && j == 0) {
                        continue;
                    }

                    prefix[i][j] = matrix[i][j];
                    prefix[i][j] += (i > 0 ? prefix[i - 1][j] : 0);
                    prefix[i][j] += (j > 0 ? prefix[i][j - 1] : 0);
                    prefix[i][j] -= (i > 0 && j > 0 ? prefix[i - 1][j - 1] : 0);
                }
            }
        }

        public int getSum(int row1, int col1, int row2, int col2) {
            int total = prefix[row2][col2];

            int top = (row1 > 0 ? prefix[row1 - 1][col2] : 0);
            int left = (col1 > 0 ? prefix[row2][col1 - 1] : 0);
            int overlap = (row1 > 0 && col1 > 0 ? prefix[row1 - 1][col1 - 1] : 0);

            return total - top - left + overlap;
        }
    }

    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;

        int count = 0;
        NumMatrix numMatrix = new NumMatrix(matrix);

        for (int startRow = 0; startRow < n; startRow++) {
            for (int startCol = 0; startCol < m; startCol++) {
                for (int endRow = startRow; endRow < n; endRow++) {
                    for (int endCol = startCol; endCol < m; endCol++) {
                        int sum = numMatrix.getSum(startRow, startCol, endRow, endCol);

                        if (sum == target) {
                            count++;
                        }
                    }
                }
            }
        }

        return count;
    }
}

// Approach 2 Using HashMap and Prefix Sum O(n*m^2)
class Solution {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;

        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 1; j < m; j++) {
                matrix[i][j] += matrix[i][j - 1];
            }
        }

        for (int startCol = 0; startCol < m; startCol++) {
            for (int endCol = startCol; endCol < m; endCol++) {
                Map<Integer, Integer> map = new HashMap<>();
                map.put(0, 1);
                int sum = 0;

                for (int row = 0; row < n; row++) {
                    int rowSum = (matrix[row][endCol] - (startCol > 0 ? matrix[row][startCol - 1] : 0));
                    sum += rowSum;

                    if (map.containsKey(sum - target)) {
                        count += map.get(sum - target);
                    }

                    map.put(sum, map.getOrDefault(sum, 0) + 1);
                }
            }
        }

        return count;
    }
}