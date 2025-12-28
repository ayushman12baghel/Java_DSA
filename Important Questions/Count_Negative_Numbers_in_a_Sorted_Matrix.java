import java.util.*;

//Approach 1 BinarySearch O(nlogm)
class Solution {
    public int countNegatives(int[][] grid) {
        int count = 0;

        for (int i = 0; i < grid.length; i++) {
            count += binarySearch(grid[i]);
        }

        return count;
    }

    public int binarySearch(int nums[]) {
        int left = 0;
        int right = nums.length - 1;
        int result = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] < 0) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return result == -1 ? 0 : nums.length - result;
    }
}

// Approach 2 Two Pointer O(n+m)
class Solution {
    public int countNegatives(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int count = 0;
        int row = 0;
        int col = m - 1;

        while (row < n && col >= 0) {
            if (grid[row][col] < 0) {
                count += (n - row);
                col--;
            } else {
                row++;
            }
        }

        return count;
    }
}