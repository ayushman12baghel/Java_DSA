import java.util.*;

// Approach 1 O(n) time and O(n) space
class Solution {
    public int[] leftRightDifference(int[] nums) {
        int n = nums.length;

        if (n == 1) {
            return new int[] { 0 };
        }

        int left[] = new int[n];
        int right[] = new int[n];
        int ans[] = new int[n];

        for (int i = 1; i < n; i++) {
            int rightIndex = n - 1 - i;
            left[i] = left[i - 1] + nums[i - 1];
            right[rightIndex] = right[rightIndex + 1] + nums[rightIndex + 1];
        }

        for (int i = 0; i < n; i++) {
            ans[i] = Math.abs(left[i] - right[i]);
        }

        return ans;
    }
}

// Approach 2 O(n) time with O(1) space
class Solution {
    public int[] leftRightDifference(int[] nums) {
        int n = nums.length;

        if (n == 1) {
            return new int[] { 0 };
        }

        int totalSum = 0;
        int ans[] = new int[n];
        for (int num : nums) {
            totalSum += num;
        }

        int leftSum = 0;
        for (int i = 0; i < n; i++) {
            int rightSum = totalSum - leftSum - nums[i];
            ans[i] = Math.abs(leftSum - rightSum);
            leftSum += nums[i];
        }

        return ans;
    }
}