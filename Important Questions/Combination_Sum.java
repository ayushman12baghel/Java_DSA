import java.util.*;

public class Combination_Sum {

    // Backtracking O(2^n)
    public static List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        solve(nums, target, new ArrayList<>(), 0, 0, ans);

        return ans;
    }

    public static void solve(int nums[], int target, List<Integer> temp, int sum, int index, List<List<Integer>> ans) {
        if (sum == target) {
            ans.add(new ArrayList(temp));
            return;
        }

        if (sum > target || index >= nums.length) {
            return;
        }

        temp.add(nums[index]);
        solve(nums, target, temp, sum + nums[index], index, ans);
        temp.remove(temp.size() - 1);

        solve(nums, target, temp, sum, index + 1, ans);
    }

    public static void main(String[] args) {
        int nums[] = { 2, 3, 6, 7 }, target = 7;

        System.out.println(combinationSum(nums, target));
    }
}
