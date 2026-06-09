import java.util.*;

// Approach Simulation O(n)
class Solution {
    public long maxTotalValue(int[] nums, int k) {
        long minValue = Integer.MAX_VALUE;
        long maxValue = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            minValue = Math.min(minValue, nums[i]);
            maxValue = Math.max(maxValue, nums[i]);
        }

        return (1L * (maxValue - minValue)) * k;
    }
}