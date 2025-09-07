import java.util.*;

class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        boolean areEqual = true;

        for (int i = 1; i < n; i++) {
            if (nums[i] != nums[i - 1]) {
                areEqual = false;
                break;
            }
        }

        return areEqual ? 0 : 1;
    }
}