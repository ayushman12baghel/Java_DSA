import java.util.*;

// Approach 1 Using HashSet O(n + (high-low))
class Solution {
    public ArrayList<Integer> missingRange(int[] nums, int low, int high) {
        ArrayList<Integer> missing = new ArrayList<>();

        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        for (int i = low; i <= high; i++) {
            if (!set.contains(i)) {
                missing.add(i);
            }
        }

        return missing;
    }
}

// Approach 2 Using Sorting O(nlogn)
class Solution {
    public ArrayList<Integer> missingRange(int[] nums, int low, int high) {
        ArrayList<Integer> missing = new ArrayList<>();

        Arrays.sort(nums);
        int i = 0;

        for (int current = low; current <= high; current++) {
            while (i < nums.length && nums[i] < current) {
                i++;
            }

            if (i < nums.length && nums[i] == current) {
                i++;
            } else {
                missing.add(current);
            }
        }

        return missing;
    }
}