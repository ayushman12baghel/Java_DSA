class Solution {
    static final int MOD = 1000000007;

    public int findWays(int[][] matrix, int k) {
        int n = matrix.length;
        int m = matrix[0].length;

        int[][] sum = new int[n + 1][m + 1];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                sum[i][j] = matrix[i][j] + sum[i + 1][j]
                        + sum[i][j + 1] - sum[i + 1][j + 1];
            }
        }

        int[][] prev = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (sum[i][j] > 0) {
                    prev[i][j] = 1;
                }
            }
        }

        for (int pieces = 2; pieces <= k; pieces++) {
            int[][] down = new int[n + 1][m];
            int[][] right = new int[n][m + 1];

            for (int j = 0; j < m; j++) {
                for (int i = n - 1; i >= 0; i--) {
                    down[i][j] = (down[i + 1][j] + prev[i][j]) % MOD;
                }
            }

            for (int i = 0; i < n; i++) {
                for (int j = m - 1; j >= 0; j--) {
                    right[i][j] = (right[i][j + 1] + prev[i][j]) % MOD;
                }
            }

            int[][] cur = new int[n][m];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (sum[i][j] == 0) {
                        continue;
                    }

                    int lo = i + 1, hi = n - 1, row = n;

                    while (lo <= hi) {
                        int mid = lo + (hi - lo) / 2;

                        if (sum[mid][j] < sum[i][j]) {
                            row = mid;
                            hi = mid - 1;
                        } else {
                            lo = mid + 1;
                        }
                    }

                    lo = j + 1;
                    hi = m - 1;
                    int col = m;

                    while (lo <= hi) {
                        int mid = lo + (hi - lo) / 2;

                        if (sum[i][mid] < sum[i][j]) {
                            col = mid;
                            hi = mid - 1;
                        } else {
                            lo = mid + 1;
                        }
                    }

                    long ways = 0;

                    if (row < n) {
                        ways += down[row][j];
                    }

                    if (col < m) {
                        ways += right[i][col];
                    }

                    cur[i][j] = (int) (ways % MOD);
                }
            }

            prev = cur;
        }

        return prev[0][0];
    }
}
