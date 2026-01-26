import java.util.*;

// Approach Sorting O(nlogn)
class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] nums) {
        Arrays.sort(nums);

        int minDiff = Integer.MAX_VALUE;

        for (int i = 1; i < nums.length; i++) {
            minDiff = Math.min(minDiff, nums[i] - nums[i - 1]);
        }

        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] == minDiff) {
                List<Integer> temp = new ArrayList<>();
                temp.add(nums[i - 1]);
                temp.add(nums[i]);
                ans.add(temp);
            }
        }

        return ans;
    }
}