import java.util.*;

// Approach Using BinarySearch O(nlog(max(height)))
class Solution {
    public int minCost(int[] heights, int[] costs) {
        int n = heights.length;
        int left = Integer.MAX_VALUE;
        int right = Integer.MIN_VALUE;

        for (int height : heights) {
            left = Math.min(left, height);
            right = Math.max(height, right);
        }

        int ans = Integer.MAX_VALUE;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            int costAtMid = getTotalCost(heights, costs, mid);
            ans = Math.min(ans, costAtMid);

            if (costAtMid > getTotalCost(heights, costs, mid + 1)) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return ans;
    }

    public int getTotalCost(int heights[], int costs[], int target) {
        int total = 0;

        for (int i = 0; i < heights.length; i++) {
            total += Math.abs(target - heights[i]) * costs[i];
        }

        return total;
    }
}
