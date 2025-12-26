import java.util.*;

// Approach 1 O(n)
class Solution {
    public int kthMissing(int[] nums, int k) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > k + i) {
                return k + i;
            }
        }

        return k + nums.length;
    }
}

// Approach 2 Using BinarySearch O(logn)
class Solution {
    public int kthMissing(int[] nums, int k) {
        int left = 0;
        int right = nums.length - 1;
        int result = nums.length + k;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] > mid + k) {
                result = mid + k;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return result;
    }
}