import java.util.*;

class Solution {
    public ArrayList<Integer> findMean(int[] nums, int[][] queries) {
        ArrayList<Integer> ans = new ArrayList<>();
        int prefix[] = new int[nums.length];

        prefix[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            prefix[i] = nums[i] + prefix[i - 1];
        }

        for (int query[] : queries) {
            int sum = prefix[query[1]] - (query[0] - 1 > 0 ? prefix[query[0] - 1] : 0);

            ans.add(sum / (query[1] - query[0] + 1));
        }

        return ans;
    }
}