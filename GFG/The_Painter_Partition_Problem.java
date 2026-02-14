import java.util.*;

//Approach Using Binary Search on Ans O(nlog(sum(nums)))
class Solution {
    public int minTime(int[] nums, int k) {
        int left = Integer.MIN_VALUE;
        int right = 0;
        for (int num : nums) {
            left = Math.max(left, num);
            right += num;
        }

        int result = right;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (isPossible(nums, k, mid)) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return result;
    }

    public boolean isPossible(int nums[], int k, int time) {
        int count = 1;
        int currentTime = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > time) {
                return false;
            }

            if (currentTime + nums[i] > time) {
                count++;
                currentTime = nums[i];
            } else {
                currentTime += nums[i];
            }
        }

        return count <= k;
    }
}
