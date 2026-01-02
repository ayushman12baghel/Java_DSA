import java.util.*;

// Approach Using HashSet O(n)
class Solution {
    public int repeatedNTimes(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                return nums[i];
            }

            set.add(nums[i]);
        }

        return -1;
    }
}

// Approach Using constant space O(n)
class Solution {
    public int repeatedNTimes(int[] nums) {
        for (int i = 2; i < nums.length; i++) {
            if (nums[i - 2] == nums[i] || nums[i - 1] == nums[i]) {
                return nums[i];
            }
        }

        return nums[nums.length - 1];
    }
}