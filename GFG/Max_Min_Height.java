import java.util.*;

// Approach Using BinarySearch and Difference Array O(nlogn)
class Solution {
    public int maxMinHeight(int[] nums, int k, int w) {
        int left = 0;
        int right = Integer.MIN_VALUE;

        for (int num : nums) {
            right = Math.max(right, num + k);
        }

        int result = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (isPossible(nums, k, w, mid)) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return result;
    }

    public boolean isPossible(int nums[], int k, int w, int height) {
        int diff[] = new int[nums.length + 1];

        int currSum = 0;
        for (int i = 0; i < nums.length; i++) {
            currSum += diff[i];
            int current = nums[i] + currSum;

            if (current < height) {
                int required = height - current;

                if (required > k) {
                    return false;
                } else {
                    k -= required;
                    if (i + w < nums.length) {
                        diff[i + w] -= required;
                    }
                    currSum += required;
                }
            }
        }

        return true;
    }
}