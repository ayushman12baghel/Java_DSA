import java.util.*;

//Approach Using prefix and suffic array O(n)
class Solution {
    public int partitionDisjoint(int[] nums) {
        int n = nums.length;

        int leftMax[] = new int[n];
        leftMax[0] = nums[0];

        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], nums[i]);
        }

        int rightMin[] = new int[n];
        rightMin[n - 1] = nums[n - 1];

        for (int i = n - 2; i >= 0; i--) {
            rightMin[i] = Math.min(rightMin[i + 1], nums[i]);
        }

        for (int i = 0; i < nums.length - 1; i++) {
            if (leftMax[i] <= rightMin[i + 1]) {
                return i + 1;
            }
        }

        return n;
    }
}