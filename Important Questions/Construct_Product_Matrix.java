import java.util.*;

// Approach 1 O(n*m)
class Solution {
    public int[][] constructProductMatrix(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int nums[] = new int[n * +m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int index = i * m + j;
                nums[index] = grid[i][j];
            }
        }

        long product[] = findProduct(nums);

        int ans[][] = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int index = i * m + j;
                ans[i][j] = (int) (product[index] % 12345);
            }
        }

        return ans;
    }

    public long[] findProduct(int nums[]) {
        int n = nums.length;

        long left[] = new long[n];
        left[0] = 1;

        for (int i = 1; i < n; i++) {
            left[i] = (left[i - 1] * nums[i - 1]) % 12345;
        }

        long right[] = new long[n];
        right[n - 1] = 1;

        for (int i = n - 2; i >= 0; i--) {
            right[i] = (right[i + 1] * nums[i + 1]) % 12345;
        }

        long ans[] = new long[n];
        for (int i = 0; i < n; i++) {
            ans[i] = (left[i] * right[i]) % 12345;
        }

        return ans;
    }
}

// Approach 2 More Optimised O(n*m)
class Solution {
    int mod = 12345;

    public int[][] constructProductMatrix(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int nums[] = new int[n * +m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int index = i * m + j;
                nums[index] = grid[i][j];
            }
        }

        long product[] = findProduct(nums);

        int ans[][] = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int index = i * m + j;
                ans[i][j] = (int) (product[index] % mod);
            }
        }

        return ans;
    }

    public long[] findProduct(int nums[]) {
        int n = nums.length;

        long ans[] = new long[n];
        ans[0] = 1;

        for (int i = 1; i < n; i++) {
            ans[i] = (ans[i - 1] * nums[i - 1]) % mod;
        }

        long right = 1;
        for (int i = n - 1; i >= 0; i--) {
            ans[i] = (ans[i] * right) % mod;
            right = (right * nums[i]) % mod;
        }

        return ans;
    }
}

// Approach 3 Optimal Approach
class Solution {
    public int[][] constructProductMatrix(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int mod = 12345;

        int ans[][] = new int[n][m];
        int prefix = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                ans[i][j] = prefix;
                prefix = (int) (1L * prefix * (grid[i][j] % mod)) % mod;
            }
        }

        int suffix = 1;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                ans[i][j] = (int) (1L * ans[i][j] * suffix) % mod;
                suffix = (int) (1L * suffix * (grid[i][j] % mod)) % mod;
            }
        }

        return ans;
    }
}