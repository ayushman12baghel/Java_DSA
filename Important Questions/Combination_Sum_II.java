import java.util.*;

//Approach O(2^n)
class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        solve(candidates, 0, target, new ArrayList<>(), ans);

        return ans;
    }

    public void solve(int nums[], int index, int target, List<Integer> temp, List<List<Integer>> ans) {
        if (target == 0) {
            ans.add(new ArrayList<>(temp));
            return;
        }

        for (int i = index; i < nums.length; i++) {
            if (i > index && nums[i - 1] == nums[i])
                continue;
            if (nums[i] > target) {
                return;
            }
            temp.add(nums[i]);
            solve(nums, i + 1, target - nums[i], temp, ans);
            temp.remove(temp.size() - 1);
        }
    }
}