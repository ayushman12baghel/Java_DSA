import java.util.*;

//Approach 1
class Solution {
    public int findFinalValue(int[] nums, int original) {
        Set<Integer> set = new HashSet<>();

        for (int num : nums) {
            set.add(num);
        }

        while (set.contains(original)) {
            original = original * 2;
        }

        return original;
    }
}

// Approach 2
class Solution {
    public int findFinalValue(int[] nums, int original) {
        Arrays.sort(nums);

        while (binarySearch(nums, original)) {
            original = original * 2;
        }

        return original;
    }

    public boolean binarySearch(int nums[], int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return true;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return false;
    }
}

// Approach 3
class Solution {
    public int findFinalValue(int[] nums, int original) {
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (original == nums[i]) {
                original *= 2;
            }
        }

        return original;
    }
}