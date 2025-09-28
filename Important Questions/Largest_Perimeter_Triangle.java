import java.util.*;

//Approach Sorting + two pointer O(n^2)
class Solution {
    public int largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        int ans = 0;

        for (int i = 0; i <= nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                if (nums[i] + nums[left] > nums[right]) {
                    ans = Math.max(ans, nums[i] + nums[left] + nums[right]);
                    left++;
                } else {
                    right--;
                }
            }
        }

        return ans;
    }
}

// Approach 2 Sorting O(nlogn)
class Solution {
    public int largestPerimeter(int[] nums) {
        Arrays.sort(nums);

        for (int i = nums.length - 1; i >= 2; i--) {
            if (nums[i - 1] + nums[i - 2] > nums[i]) {
                return nums[i - 1] + nums[i] + nums[i - 2];
            }
        }

        return 0;
    }
}