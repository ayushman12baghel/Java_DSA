import java.util.*;

class Solution {
    public long minimumOperations(int[] nums, int[] target) {
        int n = target.length;
        int current = 0;
        int prev = 0;
        long result = 0;

        for (int i = 0; i < n; i++) {
            current = target[i] - nums[i];

            if ((current < 0 && prev > 0) || (current > 0 && prev < 0)) {
                result += Math.abs(current);
            } else if (Math.abs(current) > Math.abs(prev)) {
                result += Math.abs(current) - Math.abs(prev);
            }

            prev = current;
        }

        return result;
    }
}