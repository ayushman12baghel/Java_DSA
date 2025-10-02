import java.util.*;

//O(2^n * k)
class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        solve(n, k, 0, new ArrayList<>(), ans);

        return ans;
    }

    public void solve(int n, int k, int index, List<Integer> temp, List<List<Integer>> ans) {
        if (n == 0 && temp.size() == k) {
            ans.add(new ArrayList<>(temp));
            return;
        }

        for (int i = index + 1; i <= 9 && i <= n; i++) {
            temp.add(i);
            solve(n - i, k, i, temp, ans);

            temp.remove(temp.size() - 1);
        }
    }
}